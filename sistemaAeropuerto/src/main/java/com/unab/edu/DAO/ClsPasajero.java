/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Pasajero;
import com.unab.edu.conexionmysql.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author PREDATOR
 */
public class ClsPasajero {
    
    ConexionBD cn = new ConexionBD();
    Connection conexion = cn.retornarConexion();
    
    public void AgregarPasajero(Pasajero Pasa){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_Pasajero(?,?,?,?,?,?)");
            Statement.setString("PNombres", Pasa.getNombres());
            Statement.setString("PApellidos", Pasa.getApellidos());
            Statement.setInt("PEdad", Pasa.getEdad());
            Statement.setString("PSexo", Pasa.getSexo());
            Statement.setString("PDocumentoIdentidad", Pasa.getDocumentoIdentidad());
            Statement.setString("PPasaporte", Pasa.getPasaporte());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void BorrarPasajero(Pasajero Pasa){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_D_Pasajero(?)");
            Statement.setInt("PidPasajero", Pasa.getIdPasajero());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void ActualizarPasajero(Pasajero Pasa){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_U_Pasajero(?,?,?,?,?,?,?)");
            Statement.setInt("PidPasajero", Pasa.getIdPasajero());
            Statement.setString("PNombres", Pasa.getNombres());
            Statement.setString("PApellidos", Pasa.getApellidos());
            Statement.setInt("PEdad", Pasa.getEdad());
            Statement.setString("PSexo", Pasa.getSexo());
            Statement.setString("PDocumentoIdentidad", Pasa.getDocumentoIdentidad());
            Statement.setString("PPasaporte", Pasa.getPasaporte());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
