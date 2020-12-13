/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexionmysql.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.unab.edu.Entidades.Clases;
import java.sql.ResultSet;
import java.sql.Types;

/**
 *
 * @author Usuario
 */
public class ClsClase {

    public ArrayList<Clases> MostrarClase(int idAvion) {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        ArrayList<Clases> companies = new ArrayList<>();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_Clase(?)");
            Statement.setInt("PidAvion", idAvion);
            ResultSet rs = Statement.executeQuery();
            while (rs.next()) {
                Clases esc = new Clases();
                esc.setIdClase(rs.getInt("idClases"));
                esc.setNAsientos(rs.getInt("nAsientos"));
                esc.setNombreClase(rs.getString("nombreClase"));
                esc.setPorcentajeEPrecio(rs.getInt("porcentajeEPrecio"));
                esc.setIdAvion(rs.getInt("idAvion"));
                companies.add(esc);
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return companies;
    }

    public void AgregarClase(Clases clase) {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_Clase(?,?,?,?)");
            Statement.setString("PnombreClase", clase.getNombreClase());
            Statement.setInt("PnAsientos", clase.getNAsientos());
            Statement.setInt("PidAvion", clase.getIdAvion());
            Statement.setDouble("PPorcentajeEprecio", clase.getPorcentajeEPrecio());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void BorrarClase(Clases clase) {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_D_Clase(?)");
            Statement.setInt("PidClase", clase.getIdClase());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void ActualizarClase(Clases clase) {
        ConexionBD cn = new ConexionBD();
        Connection conexion = cn.retornarConexion();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_U_Clase(?,?,?,?,?)");
            Statement.setString("PnombreClase", clase.getNombreClase());
            Statement.setInt("PnAsientos", clase.getNAsientos());
            Statement.setInt("PidAvion", clase.getIdAvion());
            Statement.setInt("PPorcentajeEprecio", clase.getPorcentajeEPrecio());
            Statement.setDouble("PidClase", clase.getIdClase());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
