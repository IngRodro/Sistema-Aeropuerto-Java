/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.sistemaaeropuerto;

import com.unab.edu.OperacionesBd.PnlAeropuerto;
import com.unab.edu.OperacionesBd.PnlAvion;
import com.unab.edu.OperacionesBd.PnlClases;
import com.unab.edu.OperacionesBd.PnlCompania;
import com.unab.edu.OperacionesBd.PnlEscala;
import com.unab.edu.OperacionesBd.PnlItenirario;
import com.unab.edu.OperacionesBd.PnlPasajero;
import com.unab.edu.OperacionesBd.PnlTiposdeVuelo;
import com.unab.edu.OperacionesBd.PnlVuelos;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Usuario
 */
public class frmMenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form frmMenuAdmin
     */
    public frmMenuAdmin() {
        initComponents();
        this.setLocationRelativeTo(null); 
    }
    
    public frmMenuAdmin menuAdmin;

    CambioPanel CmPanel = new CambioPanel();
    PnlAeropuerto frmAeropuerto = new PnlAeropuerto();
    PnlCompania frmCompania = new PnlCompania();
    PnlAvion frmAvion = new PnlAvion();
    PnlItenirario frmItinerario = new PnlItenirario();
    PnlVuelos frmVuelo = new PnlVuelos();
    PnlTiposdeVuelo frmTipos = new PnlTiposdeVuelo();
    PnlPasajero frmPasa = new PnlPasajero();
    PnlEscala frmEscala = new PnlEscala();
    PnlClases frmClase = new PnlClases();
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        btnCompania = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnTipos = new javax.swing.JButton();
        bttnPasajeros = new javax.swing.JButton();
        btnVuelo = new javax.swing.JButton();
        PnlContenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN");
        setBackground(new java.awt.Color(102, 255, 255));

        panel1.setBackground(new java.awt.Color(51, 102, 255));

        btnCompania.setBackground(new java.awt.Color(51, 102, 255));
        btnCompania.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCompania.setLabel("Compañia");
        btnCompania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompaniaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Aeropuerto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Avion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 102, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Vuelos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flight_30822 - Copy.png"))); // NOI18N

        btnTipos.setBackground(new java.awt.Color(51, 102, 255));
        btnTipos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTipos.setText("Tipos de Vuelos");
        btnTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTiposActionPerformed(evt);
            }
        });

        bttnPasajeros.setBackground(new java.awt.Color(51, 102, 255));
        bttnPasajeros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bttnPasajeros.setText("Pasajeros");
        bttnPasajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnPasajerosActionPerformed(evt);
            }
        });

        btnVuelo.setBackground(new java.awt.Color(51, 102, 255));
        btnVuelo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVuelo.setText("Clase");
        btnVuelo.setToolTipText("");
        btnVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVueloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
            .addComponent(btnCompania, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addComponent(btnTipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bttnPasajeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVuelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCompania, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnTipos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bttnPasajeros, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        PnlContenedor.setBackground(new java.awt.Color(0, 153, 204));
        PnlContenedor.setLayout(new javax.swing.BoxLayout(PnlContenedor, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PnlContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PnlContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompaniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompaniaActionPerformed
        CmPanel.ModificarPanel(PnlContenedor, frmCompania);
    }//GEN-LAST:event_btnCompaniaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CmPanel.ModificarPanel(PnlContenedor, frmAeropuerto);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CmPanel.ModificarPanel(PnlContenedor, frmAvion);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CmPanel.ModificarPanel(PnlContenedor, frmVuelo);
        frmVuelo.menuAdmin = this.menuAdmin;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiposActionPerformed
        CmPanel.ModificarPanel(PnlContenedor, frmTipos);
    }//GEN-LAST:event_btnTiposActionPerformed

    private void bttnPasajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnPasajerosActionPerformed
        CmPanel.ModificarPanel(PnlContenedor, frmPasa);
    }//GEN-LAST:event_bttnPasajerosActionPerformed

    private void btnVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVueloActionPerformed
        CmPanel.ModificarPanel(PnlContenedor, frmClase);
    }//GEN-LAST:event_btnVueloActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel PnlContenedor;
    private javax.swing.JButton btnCompania;
    private javax.swing.JButton btnTipos;
    private javax.swing.JButton btnVuelo;
    private javax.swing.JButton bttnPasajeros;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
