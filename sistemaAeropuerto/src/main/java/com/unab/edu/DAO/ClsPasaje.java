/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.Entidades.Pasaje;
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
public class ClsPasaje {
    ConexionBD cn = new ConexionBD();
    Connection conexion = cn.retornarConexion();
    
    public ArrayList<Pasaje> MostrarPasajes(){
    ArrayList<Pasaje> pasajes = new ArrayList<>();
        try {
            CallableStatement statement = conexion.prepareCall("call SP_S_Pasaje");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {                
                Pasaje psj = new Pasaje();
                psj.setIdPasaje(rs.getInt("idPasaje"));
                psj.setIdPasajero(rs.getInt("idPasajero"));
                psj.setIdVuelo(rs.getInt("idVuelo"));
                psj.setIdClase(rs.getInt("idClase"));
                psj.setNAsiento(rs.getInt("NAsiento"));
                psj.setPrecionTotal(rs.getFloat("precioTotal"));
                pasajes.add(psj);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return pasajes;
    }
    
    public void AgregarPasaje(Pasaje pasa){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_I_Pasaje(?,?,?,?,?)");
            Statement.setInt("PidPasajero", pasa.getIdPasajero());
            Statement.setInt("PidVuelo", pasa.getIdVuelo());
            Statement.setInt("PidClase", pasa.getIdClase());
            Statement.setInt("PNAsiento",pasa.getNAsiento());
            Statement.setFloat("PprecioTotal", pasa.getPrecionTotal());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Guardado");
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void BorrarPasaje(Pasaje pasa){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_D_Pasaje(?)");
            Statement.setInt("PidPasaje", pasa.getIdPasaje());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void ActualizarPasaje(Pasaje pasa){
        try {
            CallableStatement Statement = conexion.prepareCall("call SP_U_Pasaje(?,?,?,?,?,?)");
            Statement.setInt("PidPasaje", pasa.getIdPasaje());
            Statement.setInt("PidPasajero", pasa.getIdPasajero());
            Statement.setInt("PidVuelo", pasa.getIdVuelo());
            Statement.setInt("PidClase", pasa.getIdClase());
            Statement.setInt("PNAsiento",pasa.getNAsiento());
            Statement.setFloat("PprecioTotal", pasa.getPrecionTotal());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
