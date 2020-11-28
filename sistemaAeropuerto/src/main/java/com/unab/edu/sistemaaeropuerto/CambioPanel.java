/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.sistemaaeropuerto;

import java.awt.Panel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class CambioPanel {
    private Panel contenedor;
    private JPanel contenido;
    
    public void ModificarPanel(Panel contenedor, JPanel contenido){
        
        this.contenedor = contenedor;
        this.contenido = contenido;
        this.contenedor.removeAll();
        this.contenedor.revalidate();
        this.contenedor.repaint();
        
        this.contenedor.add(this.contenido);
        this.contenedor.revalidate();
        this.contenedor.repaint();
    }
    
}
