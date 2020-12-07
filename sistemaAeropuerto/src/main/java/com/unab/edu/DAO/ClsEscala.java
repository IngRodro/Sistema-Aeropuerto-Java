/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Avion;
import com.unab.edu.Entidades.Escala;
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
public class ClsEscala {
    
    
    ConexionBD cn = new ConexionBD();
    Connection conexion = cn.retornarConexion();
    
    
    public ArrayList<Escala> MostrarEscala(int idIti) {
        ArrayList<Escala> escalas = new ArrayList<>();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_Escala(?)");
            Statement.setInt("PidIterinario", idIti);
            ResultSet rs = Statement.executeQuery();
            while (rs.next()) {
                Escala esc = new Escala();
                esc.setIdEscala(rs.getInt("idEscala"));
                esc.setNumeroEscala(rs.getInt("numeroEscala"));
                esc.setNombre(rs.getString("nombre"));
                esc.setNPasajerosSuben(rs.getInt("nPasajerosSuben"));
                esc.setNpasajerosBajan(rs.getInt("nPasajerosBajan"));
                esc.setPrecio(rs.getDouble("Precio"));
                escalas.add(esc);
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return escalas;
    }
    
    public void AgregarEscala(Escala Esc, int idIti){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_Escala(?,?,?,?)");
            Statement.setInt("PnumeroEscala", Esc.getNumeroEscala());
            Statement.setInt("PidAeropuerto", Esc.getIdAeropuerto());
            Statement.setInt("PidiIterinario", idIti);
            Statement.setDouble("PPrecio", Esc.getPrecio());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void BorrarEscala(Escala Esc) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_D_Escala(?)");
            Statement.setInt("PidEscala", Esc.getIdEscala());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void ActualizarEscala(Escala Esc) {
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_U_Escala(?,?,?)");
            JOptionPane.showMessageDialog(null, Esc.getIdEscala() + "   " + Esc.getIdAeropuerto() + "    " +  "      " + Esc.getPrecio());
            Statement.setInt("PidEscala", Esc.getIdEscala());
            Statement.setInt("PidAeropuerto", Esc.getIdAeropuerto());
            Statement.setDouble("PPrecio", Esc.getPrecio());
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public Escala SeleccionarEscala(int idEsc) {
        Escala esc = new Escala();
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_S_1Escala(?)");
            Statement.setInt("PidEscala", idEsc);
            ResultSet rs = Statement.executeQuery();
            while (rs.next()) {
                esc.setIdEscala(rs.getInt("idEscala"));
                esc.setNumeroEscala(rs.getInt("numeroEscala"));
                esc.setIdAeropuerto(rs.getInt("idAeropuerto"));
                esc.setNPasajerosSuben(rs.getInt("nPasajerosSuben"));
                esc.setNpasajerosBajan(rs.getInt("nPasajerosBajan"));
                esc.setPrecio(rs.getDouble("Precio"));
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return esc;
    }
    
}
