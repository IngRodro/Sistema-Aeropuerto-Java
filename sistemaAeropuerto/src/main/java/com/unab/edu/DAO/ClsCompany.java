/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Avion;
import com.unab.edu.Entidades.Company;
import com.unab.edu.conexionmysql.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ClsCompany {
        ConexionBD cn = new ConexionBD();
    Connection conexion = cn.retornarConexion();
    
    
    public void AgregarCompany(Company Com){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_Company(?)");
            Statement.setString("PNombre", Com.getNombre());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void BorrarCompany(Company Com) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_D_Company(?)");
            Statement.setInt("PiCompany", Com.getIdCompany());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void ActualizarCompany(Company Com) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_U_Company(?,?)");
            Statement.setInt("PidCompany", Com.getIdCompany());
            Statement.setString("PNombre", Com.getNombre());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
