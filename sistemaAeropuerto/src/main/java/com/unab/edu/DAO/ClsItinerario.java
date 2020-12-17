/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Itinerario;
import com.unab.edu.Entidades.Vuelo;
import com.unab.edu.conexionmysql.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class ClsItinerario {

    public void AgregarItinerario(Itinerario Iti) {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_Itinerario(?,?,?,?,?)");
            Statement.setInt("PidAeropuertoDestino", Iti.getIdAeropuertoDestino());
            Statement.setInt("PidAeropuertoOrigen", Iti.getIdAeropuertoOrigen());
            Statement.setDate("Pfecha", new java.sql.Date(Iti.getFecha().getTime()));
            Statement.setString("Phora", Iti.getHora());
            Statement.setString("Pminutos", Iti.getMinutos());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ActualizarItinerario(Itinerario Iti, Vuelo vuelo) {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        try {
            ClsVuelo clsVuelo = new ClsVuelo();
            Vuelo vueloIti = new Vuelo();
            vueloIti = clsVuelo.SeleccionarVuelo(vuelo.getIdVuelo());
            CallableStatement Statement = conexion.prepareCall("call SP_U_Itinerario(?,?,?,?,?,?)");
            Statement.setInt("PidItinerario", vueloIti.getIdIterinario());
            Statement.setInt("PidAeropuertoDestino", Iti.getIdAeropuertoDestino());
            Statement.setInt("PidAeropuertoOrigen", Iti.getIdAeropuertoOrigen());
            Statement.setDate("Pfecha", new java.sql.Date(Iti.getFecha().getTime()));
            Statement.setString("Phora", Iti.getHora());
            Statement.setString("Pminutos", Iti.getMinutos());
            Statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Itinerario SeleccionarIterinario(int idIterinario) {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        Itinerario itinerario = new Itinerario();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_1Itinerario(?)");
            Statement.setInt("PidItinerario", idIterinario);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                itinerario.setIdAeropuertoDestino(resultadoDeConsulta.getInt("idAeropuertoDestino"));
                itinerario.setIdAeropuertoOrigen(resultadoDeConsulta.getInt("idAeropuertoOrigen"));
                itinerario.setFecha(resultadoDeConsulta.getDate("fecha"));
                itinerario.setHora(resultadoDeConsulta.getString("hora"));
                itinerario.setMinutos(resultadoDeConsulta.getString("minutos"));
            }

            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return itinerario;
    }
}
