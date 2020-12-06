/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Avion;
import com.unab.edu.Entidades.Escala;
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
public class ClsEscala {
    
    
    ConexionBD cn = new ConexionBD();
    Connection conexion = cn.retornarConexion();
    
    
    public ArrayList<Escala> MostrarEscala() {
        ArrayList<Escala> companies = new ArrayList<>();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_Escala(?)");
            Statement.setInt("PidIterinario", 1);
            ResultSet rs = Statement.executeQuery();
            while (rs.next()) {
                Escala esc = new Escala();
                esc.setIdEscala(rs.getInt("idEscala"));
                esc.setNumeroEscala(rs.getInt("numeroEscala"));
                esc.setIdAerouerto(rs.getInt("idAeropuerto"));
                esc.setNPasajerosSuben(rs.getInt("nPasajerosSuben"));
                esc.setNpasajerosBajan(rs.getInt("nPasajerosBajan"));
                esc.setPrecio(rs.getDouble("Precio"));
                companies.add(esc);
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return companies;
    }
    
    public void AgregarEscala(Escala Esc){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_Escala(?,?,?,?)");
            Statement.setInt("PnumeroEscala", 1);
            Statement.setInt("PidAeropuerto", Esc.getIdAerouerto());
            Statement.setInt("PidiIterinario", 1);
            Statement.setDouble("PPrecio", Esc.getPrecio());
            Statement.execute();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void BorrarEscala(Escala Esc) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_D_Avion(?)");
            Statement.setInt("PidEscala", Esc.getIdEscala());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void ActualizarEscala(Escala Esc) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_U_Avion(?,?,?,?,?)");
            Statement.setInt("PidEscala", Esc.getIdEscala());
            Statement.setInt("PnumeroEscala", Esc.getNumeroEscala());
            Statement.setInt("PidAeropuerto", Esc.getIdAerouerto());
            Statement.setInt("PidiIterinario", Esc.getIdItinerario());
            Statement.setDouble("PPrecio", Esc.getPrecio());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
