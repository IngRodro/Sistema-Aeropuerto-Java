/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexionmysql.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.unab.edu.Entidades.Vuelo;
import com.unab.edu.Entidades.Itinerario;
import com.unab.edu.Entidades.Promociones;
import java.sql.Date;

/**
 *
 *
 */
public class ClsVuelo {

    public ArrayList<InnerJoinVuelo> MostrarVuelos() {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        ArrayList<InnerJoinVuelo> Vuelos = new ArrayList<>();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_Vuelos()");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                InnerJoinVuelo InJoin = new InnerJoinVuelo();
                InJoin.setVuelo(resultadoDeConsulta.getInt("Vuelo"));
                InJoin.setCompany(resultadoDeConsulta.getString("Compania"));
                InJoin.setAeropuertoO(resultadoDeConsulta.getString("Aeropuerto_Origen"));
                InJoin.setAeropuertoD(resultadoDeConsulta.getString("Aeropuerto_Destino"));
                InJoin.setModelo(resultadoDeConsulta.getString("Modelo_Avion"));
                InJoin.setTipo(resultadoDeConsulta.getString("Tipo_de_Vuelo"));
                InJoin.setFecha(resultadoDeConsulta.getDate("Fecha"));
                InJoin.setHora(resultadoDeConsulta.getString("Hora"));
                InJoin.setMinutos(resultadoDeConsulta.getString("Minutos"));
                InJoin.setDescuento(resultadoDeConsulta.getDouble("Promo"));
                InJoin.setEstado(resultadoDeConsulta.getInt("Estado"));
                if (InJoin.getEstado() > 0) {
                    Vuelos.add(InJoin);
                }
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Vuelos;
    }

    public void AgregarVuelo(Vuelo vuelo, Itinerario itine, Promociones promo) {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        try {
            ClsItinerario clsItinerario = new ClsItinerario();
            ClsPromocion clsPromo = new ClsPromocion();
            clsItinerario.AgregarItinerario(itine);
            CallableStatement Statement = conexion.prepareCall("call SP_I_Vuelos(?,?,?)");
            Statement.setInt("PidCompany", vuelo.getIdCompany());
            Statement.setInt("PidAvion", vuelo.getIdAvion());
            Statement.setInt("PidTiposvuelo", vuelo.getIdTiposVuelo());
            Statement.execute();
            clsPromo.AgregarPromo(promo);
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public Vuelo SeleccionarVuelo(int idVuelo) {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        Vuelo vuelo = new Vuelo();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_1Vuelo(?)");
            Statement.setInt("PidVuelo", idVuelo);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                vuelo.setIdVuelo(resultadoDeConsulta.getInt("idVuelo"));
                vuelo.setIdCompany(resultadoDeConsulta.getInt("idCompany"));
                vuelo.setIdIterinario(resultadoDeConsulta.getInt("idItinerario"));
                vuelo.setIdTiposVuelo(resultadoDeConsulta.getInt("idAvion"));
                vuelo.setIdAvion(resultadoDeConsulta.getInt("idTiposvuelo"));
            }

            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return vuelo;
    }

    public void ActualizarVuelo(Vuelo vuelo, Itinerario Iti) {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        try {
            ClsItinerario clsItinerario = new ClsItinerario();
            clsItinerario.ActualizarItinerario(Iti, vuelo);
            CallableStatement Statement = conexion.prepareCall("call SP_U_Vuelos(?,?,?,?)");
            Statement.setInt("PidCompany", vuelo.getIdCompany());
            Statement.setInt("PidAvion", vuelo.getIdAvion());
            Statement.setInt("PidTiposvuelo", vuelo.getIdTiposVuelo());
            Statement.setInt("PidVuelo", vuelo.getIdVuelo());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualizado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ArrayList<InnerJoinVuelo> MostrarVuelosOrigen(int idAeropuerto) {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        ArrayList<InnerJoinVuelo> Vuelos = new ArrayList<>();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_VuelosOrigen(?)");
            Statement.setInt("PidCompany", idAeropuerto);
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                InnerJoinVuelo InJoin = new InnerJoinVuelo();
                InJoin.setVuelo(resultadoDeConsulta.getInt("Vuelo"));
                InJoin.setCompany(resultadoDeConsulta.getString("Compania"));
                InJoin.setAeropuertoO(resultadoDeConsulta.getString("Aeropuerto_Origen"));
                InJoin.setAeropuertoD(resultadoDeConsulta.getString("Aeropuerto_Destino"));
                InJoin.setModelo(resultadoDeConsulta.getString("Modelo_Avion"));
                InJoin.setTipo(resultadoDeConsulta.getString("Tipo_de_Vuelo"));
                InJoin.setFecha(resultadoDeConsulta.getDate("Fecha"));
                InJoin.setHora(resultadoDeConsulta.getString("Hora"));
                InJoin.setMinutos(resultadoDeConsulta.getString("Minutos"));
                InJoin.setDescuento(resultadoDeConsulta.getDouble("Promo"));
                InJoin.setFechaDesc(resultadoDeConsulta.getDate("FechaMax"));
                InJoin.setEstado(resultadoDeConsulta.getInt("Estado"));
                if (InJoin.getEstado() > 0) {
                    Vuelos.add(InJoin);
                }
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Vuelos;
    }
    
}
