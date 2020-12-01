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
import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class ClsItinerario {
    ConexionBD cn = new ConexionBD();
    Connection conexion = cn.retornarConexion();
    
    
    public void AgregarItinerario(Itinerario Iti){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_Itinerario(?,?,?,?)");
            Statement.setInt("PidAeropuertoDestino", Iti.getIdAeropuertoDestino());
            Statement.setInt("PidAeropuertoOrigen", Iti.getIdAeropuertoOrigen());
            Statement.setDate("Pfecha", new java.sql.Date(Iti.getFecha().getTime()));
            Statement.setString("PHora", Iti.getHora());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void BorrarItinerario(Itinerario Iti) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_D_Itinerario(?)");
            Statement.setInt("IidItinerario", Iti.getIdItinerario());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void ActualizarItinerario(Itinerario Iti) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_U_Itinerario(?,?,?,?,?)");
            Statement.setInt("PidItinerario", Iti.getIdItinerario());
            Statement.setInt("PidAeropuertoDestino", Iti.getIdAeropuertoDestino());
            Statement.setInt("PidAeropuertoOrigen", Iti.getIdAeropuertoOrigen());
            Statement.setDate("Pfecha", new java.sql.Date(Iti.getFecha().getTime()));
            Statement.setString("PHora", Iti.getHora());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public Itinerario SeleccionarIterinario(int idIterinario){
        Itinerario itinerario = new Itinerario();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_1Itinerario(?)");
            Statement.setInt("PidItinerario", idIterinario);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                itinerario.setIdAeropuertoDestino(resultadoDeConsulta.getInt("idAeropuertoDestino"));
                itinerario.setIdAeropuertoOrigen(resultadoDeConsulta.getInt("idAeropuertoOrigen"));
//                itinerario.setFecha(resultadoDeConsulta.getTime("fecha"));
//                itinerario.setFecha(resultadoDeConsulta.getDate("hora"));
            }
        
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return itinerario;
    }
}
