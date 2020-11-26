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
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ClsAvion {
    
    ConexionBD cn = new ConexionBD();
    Connection conexion = cn.retornarConexion();
    
    
    public ArrayList<Avion> MostrarAvion() {
        ArrayList<Avion> companies = new ArrayList<>();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_Company()");
            ResultSet rs = Statement.executeQuery();
            while (rs.next()) {
                Avion com = new Avion();
                com.setIdAvion(rs.getInt("idAvion"));
                com.setModeloAvion(rs.getString("modelo"));
                com.setCapacidad(rs.getInt("capacidad"));
                companies.add(com);
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return companies;
    }
    
    public void AgregarAvion(Avion Avi){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_Avion(?,?)");
            Statement.setString("PModelo", Avi.getModeloAvion());
            Statement.setInt("PCapacidad", Avi.getCapacidad());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void BorrarAvion(Avion Avi) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_D_Avion(?)");
            Statement.setInt("PidAvion", Avi.getIdAvion());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void ActualizarAvion(Avion Avi) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_U_Avion(?,?,?)");
            Statement.setInt("PidAvion", Avi.getIdAvion());
            Statement.setString("PModelo", Avi.getModeloAvion());
            Statement.setInt("PCapacidad", Avi.getCapacidad());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
