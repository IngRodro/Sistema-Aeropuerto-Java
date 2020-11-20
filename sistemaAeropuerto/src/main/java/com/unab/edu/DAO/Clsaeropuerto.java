/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Aeropuerto;
import com.unab.edu.conexionmysql.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class Clsaeropuerto {

    ConexionBD cn = new ConexionBD();
    Connection conexion = cn.retornarConexion();

    public ArrayList<Aeropuerto> MostrAeropuerto() {
        ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_Aeropuerto()");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                Aeropuerto aeropuerto = new Aeropuerto();
                aeropuerto.setIdAeropuerto(resultadoDeConsulta.getInt("idAeropuerto"));
                aeropuerto.setNombre(resultadoDeConsulta.getString("nombre"));
                aeropuerto.setPais(resultadoDeConsulta.getString("pais"));
                aeropuerto.setCiudad(resultadoDeConsulta.getString("ciudad"));
                aeropuerto.setPrecioEstimVuelo(resultadoDeConsulta.getFloat("PrecioEstimVuelo"));
                aeropuertos.add(aeropuerto);
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return aeropuertos;
    }
    
    public void AgregarAeropuerto(Aeropuerto Aero){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_Aeropuerto(?,?,?,?)");
            Statement.setString("Anombre", Aero.getNombre());
            Statement.setString("Apais", Aero.getPais());
            Statement.setString("Aciudad", Aero.getCiudad());
            Statement.setFloat("APrecioEstimVuelo", Aero.getPrecioEstimVuelo());
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void ActualizarAeropuerto(Aeropuerto Aero){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_U_Aeropuerto(?,?,?,?,?)");
            Statement.setInt("AidAeropuerto", Aero.getIdAeropuerto());
            Statement.setString("Anombre", Aero.getNombre());
            Statement.setString("Apais", Aero.getPais());
            Statement.setString("Aciudad", Aero.getCiudad());
            Statement.setFloat("APrecioEstimVuelo", Aero.getPrecioEstimVuelo());
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void BorrarAeropuerto(Aeropuerto Aero){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_D_Aeropuerto(?)");
            Statement.setInt("AidAeropuerto", Aero.getIdAeropuerto());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
