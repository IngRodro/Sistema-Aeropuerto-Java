/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.OperacionesBd;

import com.unab.edu.DAO.ClsAvion;
import com.unab.edu.Entidades.Avion;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class PnlAvion extends javax.swing.JPanel {

    /**
     * Creates new form PnlAvion
     */
    public PnlAvion() {
        initComponents();
        CargarTabla();
    }
    
    void CargarTabla() {
        String Titulos[] = {"ID", "Modelo", "Capacidad"};
        DefaultTableModel ModeloT = new DefaultTableModel(null, Titulos);
        ClsAvion clsAvion = new ClsAvion();
        ArrayList<Avion> Companies = clsAvion.MostrarAvion();
        String filas[] = new String[4];
        for (var IterarCom : Companies) {
            filas[0] = String.valueOf(IterarCom.getIdAvion());
            filas[1] = String.valueOf(IterarCom.getModeloAvion());
            filas[2] = String.valueOf(IterarCom.getCapacidad());
            ModeloT.addRow(filas);
        }
        tbAviones.setModel(ModeloT);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbPAvion = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAviones = new javax.swing.JTable();

        setBackground(new java.awt.Color(51, 102, 255));

        tbPAvion.setBackground(new java.awt.Color(51, 102, 255));
        tbPAvion.setForeground(new java.awt.Color(255, 255, 255));
        tbPAvion.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aviones");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modelo:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Capacidad:");

        txtCapacidad.setBackground(new java.awt.Color(0, 0, 0));

        txtModelo.setBackground(new java.awt.Color(0, 0, 0));

        txtId.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Actualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCapacidad)
                                    .addComponent(txtModelo)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(89, 89, 89)
                                .addComponent(jButton3)
                                .addGap(71, 71, 71)
                                .addComponent(jButton2))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jLabel1)))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(97, 97, 97))
        );

        tbPAvion.addTab("Registro Aviones", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        tbAviones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbAviones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAvionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAviones);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        tbPAvion.addTab("Lista Aviones", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbPAvion, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbPAvion, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ClsAvion avion = new ClsAvion();
        Avion aviones = new Avion();
        aviones.setModeloAvion(txtModelo.getText());
        aviones.setCapacidad(Integer.parseInt(txtCapacidad.getText()));
        avion.AgregarAvion(aviones);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ClsAvion avion = new ClsAvion();
        Avion aviones = new Avion();
        aviones.setIdAvion(Integer.parseInt(txtId.getText()));
        avion.BorrarAvion(aviones);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ClsAvion avion = new ClsAvion();
        Avion aviones = new Avion();
        aviones.setIdAvion(Integer.parseInt(txtId.getText()));
        aviones.setModeloAvion(txtModelo.getText());
        aviones.setCapacidad(Integer.parseInt(txtCapacidad.getText()));
        avion.ActualizarAvion(aviones);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbAvionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAvionesMouseClicked
        tbPAvion.setSelectedIndex(tbPAvion.indexOfComponent(jPanel2));
        int fila = tbAviones.getSelectedRow();

        String ID = String.valueOf(tbAviones.getValueAt(fila, 0));
        String Modelo = String.valueOf(tbAviones.getValueAt(fila, 1));
        String Capacidad = String.valueOf(tbAviones.getValueAt(fila, 2));
        txtId.setText(ID);
        txtModelo.setText(Modelo);
        txtCapacidad.setText(Capacidad);
    }//GEN-LAST:event_tbAvionesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAviones;
    private javax.swing.JTabbedPane tbPAvion;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}
