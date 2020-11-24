/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Avion;
import com.unab.edu.Entidades.Itinerario;
import com.unab.edu.conexionmysql.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ClsAvion {
    
    ConexionBD cn = new ConexionBD();
    Connection conexion = cn.retornarConexion();
    
    
    public void AgregarItinerario(Avion Avi){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_Avion(?,?)");
            Statement.setString("PModelo", Avi.getModeloAvion());
            Statement.setString("PCapacidad", Avi.getCapacidad());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void BorrarItinerario(Avion Avi) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_D_Avion(?)");
            Statement.setInt("PidAvion", Avi.getIdAvion());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void ActualizarItinerario(Avion Avi) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_U_Avion(?,?,?)");
            Statement.setInt("PidAvion", Avi.getIdAvion());
            Statement.setString("PModelo", Avi.getModeloAvion());
            Statement.setString("PCapacidad", Avi.getCapacidad());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
