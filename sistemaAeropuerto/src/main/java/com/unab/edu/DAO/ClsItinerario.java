/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Itinerario;
import com.unab.edu.conexionmysql.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
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
            Statement.setInt("IidAeropuertoDestino", Iti.getIdAeropuertoDestino());
            Statement.setInt("IidAeropuertoOrigen", Iti.getIdAeropuertoOrigen());
            Statement.setDate("Ifecha", new java.sql.Date(Iti.getFecha().getTime()));
            Statement.setString("IHora", Iti.getHora());
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
            Statement.setInt("IiidItinerario", Iti.getIdItinerario());
            Statement.setInt("IidAeropuertoDestino", Iti.getIdAeropuertoDestino());
            Statement.setInt("IidAeropuertoOrigen", Iti.getIdAeropuertoOrigen());
            Statement.setDate("Ifecha", new java.sql.Date(Iti.getFecha().getTime()));
            Statement.setString("IHora", Iti.getHora());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
