/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.vistas;

import com.unab.edu.DAO.ClsClase;
import com.unab.edu.DAO.ClsEscala;
import com.unab.edu.DAO.ClsPasaje;
import com.unab.edu.DAO.ClsPasajero;
import com.unab.edu.DAO.ClsVuelo;
import com.unab.edu.DAO.InnerJoinVuelo;
import com.unab.edu.Entidades.Clases;
import com.unab.edu.Entidades.Escala;
import com.unab.edu.Entidades.Pasaje;
import com.unab.edu.Entidades.Pasajero;
import com.unab.edu.Entidades.Vuelo;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PREDATOR
 */
public class PnlPasaje extends javax.swing.JPanel {

    /**
     * Creates new form PnlPasaje
     */
    public PnlPasaje() {
        initComponents();
        CargarTabla();
        CargarTablaVuelo();
        DisplayMemberClase();
        CargarTablaVuelos();
    }
    
    String valueMemberPasajero[];
    String valueMemberClase[];
    int contadorPasajero = 1;
    int contadorClase = 1;
    
    
    void DisplayMemberClase() {
        DefaultComboBoxModel cbdefaDefault = new DefaultComboBoxModel();
        ClsClase clase = new ClsClase();
        ArrayList<Clases> claseses = clase.MostrarClase(WIDTH);
        valueMemberClase = new String[claseses.size() + 1];
        String filas[] = new String[4];
        cbdefaDefault.addElement("");
        for (var IterarDatosClase :claseses){
            filas[0] = String.valueOf(IterarDatosClase.getIdAvion());
            filas[1] = String.valueOf(IterarDatosClase.getNombreClase());
            valueMemberClase[contadorClase] = filas[0];
            cbdefaDefault.addElement(filas[1]);
            contadorClase++;
        }
        cbClase.setModel(cbdefaDefault);
    }
    
      ClsEscala clsEscala = new ClsEscala();

    void CargarTablaVuelos() {
        String Titulos[] = {"Vuelo", "Compañia", "AeropuertoDestino", "Precio", "Tipo de Vuelo", "Fecha", "Hora", "Descuento", "Fecha Max Descuento"};
        DefaultTableModel ModeloT = new DefaultTableModel(null, Titulos);
        ClsVuelo clsVuelos = new ClsVuelo();
        ArrayList<InnerJoinVuelo> Vuelos = clsVuelos.MostrarVuelosOrigen(1);
        String filas[] = new String[10];
        Vuelo vuelo = new Vuelo();

        for (var IterarVuelo : Vuelos) {
            vuelo = clsVuelos.SeleccionarVuelo(IterarVuelo.getVuelo());
            ArrayList<Escala> Escalas = clsEscala.MostrarEscala(vuelo.getIdIterinario());
            if (Escalas.size() >= 1) {
                for (var IterarEscala : Escalas) {
                    filas[0] = String.valueOf(IterarVuelo.getVuelo());
                    filas[1] = IterarVuelo.getCompany();
                    filas[2] = IterarEscala.getNombre();
                    filas[3] = String.valueOf(IterarEscala.getPrecio());
                    filas[4] = IterarVuelo.getTipo();
                    filas[5] = String.valueOf(IterarVuelo.getFecha());
                    filas[6] = IterarVuelo.getHora() + ":" + IterarVuelo.getMinutos();
                    filas[7] = String.valueOf(IterarVuelo.getDescuento()) + "%";
                    if (IterarVuelo.getFechaDesc() == null) {
                    filas[8] = "";
                    } else {
                        filas[8] = String.valueOf(IterarVuelo.getFechaDesc());
                    }
                    ModeloT.addRow(filas);
                }
            }

        }
        tbVuelos.setModel(ModeloT);
    }
    
    void CargarTabla() {
        String Titulos[] = {"idPasaje", "idPasajero", "idVuelo", "idClase", "NAsiento", "precioTotal"};
        DefaultTableModel ModeloT = new DefaultTableModel(null, Titulos);
        ClsPasaje clasePasaje = new ClsPasaje();
        ArrayList<Pasaje> pasajes = clasePasaje.MostrarPasajes();
        String filas[] = new String[7];
        for (var Iterar : pasajes){
            filas[0] = String.valueOf(Iterar.getIdPasaje());
            filas[1] = String.valueOf(Iterar.getIdPasajero());
            filas[2] = String.valueOf(Iterar.getIdVuelo());
            filas[3] = String.valueOf(Iterar.getIdClase());
            filas[4] = String.valueOf(Iterar.getNAsiento());
            filas[5] = String.valueOf(Iterar.getPrecionTotal());
            ModeloT.addRow(filas);
        }
        tbPasajes.setModel(ModeloT);
    }
    
    void CargarTablaVuelo() {
        String Titulos[] = {"Vuelo", "Compañia", "Aeropuerto Origen", "AeropuertoDestino", "Modelo Avion", "Tipo de Vuelo", "Fecha", "Hora", "Descuento"};
        DefaultTableModel ModeloT = new DefaultTableModel(null, Titulos);
        ClsVuelo clsVuelos = new ClsVuelo();
        ArrayList<InnerJoinVuelo> Vuelos = clsVuelos.MostrarVuelos();
        String filas[] = new String[9];
        for (var IterarVuelo : Vuelos) {
            filas[0] = String.valueOf(IterarVuelo.getVuelo());
            filas[1] = IterarVuelo.getCompany();
            filas[2] = IterarVuelo.getAeropuertoO();
            filas[3] = IterarVuelo.getAeropuertoD();
            filas[4] = IterarVuelo.getModelo();
            filas[5] = IterarVuelo.getTipo();
            filas[6] = String.valueOf(IterarVuelo.getFecha());
            filas[7] = IterarVuelo.getHora() + ":" + IterarVuelo.getMinutos();
            filas[8] = String.valueOf(IterarVuelo.getDescuento()) + "%";
            ModeloT.addRow(filas);
        }
        tbVuelos.setModel(ModeloT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtpPasaje = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdPasaje = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVuelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbClase = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtAsiento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        bttnGuardar = new javax.swing.JButton();
        bttnActualizar = new javax.swing.JButton();
        bttnEliminar = new javax.swing.JButton();
        txtxPasajero = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVuelos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPasajes = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jtpPasaje.setBackground(new java.awt.Color(51, 102, 255));
        jtpPasaje.setForeground(new java.awt.Color(255, 255, 255));
        jtpPasaje.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pasaje");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id:");

        txtIdPasaje.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DUI:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vuelo:");

        txtVuelo.setBackground(new java.awt.Color(0, 0, 0));
        txtVuelo.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Clase:");

        cbClase.setBackground(new java.awt.Color(0, 0, 0));
        cbClase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Asiento:");

        txtAsiento.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio:");

        txtPrecio.setBackground(new java.awt.Color(0, 0, 0));

        bttnGuardar.setBackground(new java.awt.Color(0, 0, 0));
        bttnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bttnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        bttnGuardar.setText("Guardar");
        bttnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnGuardarActionPerformed(evt);
            }
        });

        bttnActualizar.setBackground(new java.awt.Color(0, 0, 0));
        bttnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bttnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        bttnActualizar.setText("Actualizar");
        bttnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnActualizarActionPerformed(evt);
            }
        });

        bttnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        bttnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bttnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        bttnEliminar.setText("Eliminar");
        bttnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEliminarActionPerformed(evt);
            }
        });

        txtxPasajero.setBackground(new java.awt.Color(0, 0, 0));
        txtxPasajero.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdPasaje)
                                    .addComponent(txtVuelo)
                                    .addComponent(cbClase, 0, 351, Short.MAX_VALUE)
                                    .addComponent(txtAsiento)
                                    .addComponent(txtPrecio)
                                    .addComponent(txtxPasajero)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bttnGuardar)
                                .addGap(59, 59, 59)
                                .addComponent(bttnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(bttnEliminar)))))
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdPasaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtxPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnGuardar)
                    .addComponent(bttnActualizar)
                    .addComponent(bttnEliminar))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jtpPasaje.addTab("Registro Pasaje", jPanel2);

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));

        tbVuelos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbVuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVuelosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbVuelos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpPasaje.addTab("Lista Vuelos", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));

        tbPasajes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPasajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPasajesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPasajes);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpPasaje.addTab("Lista Pasajes", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 881, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jtpPasaje, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jtpPasaje, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 881, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnGuardarActionPerformed
        ClsPasaje pasajes = new ClsPasaje();
        Pasaje pasaje = new Pasaje();
        pasaje.setIdVuelo(Integer.parseInt(txtVuelo.getText()));
        pasaje.setIdClase(Integer.parseInt(valueMemberClase[cbClase.getSelectedIndex()]));
        pasaje.setNAsiento(Integer.parseInt(txtAsiento.getText()));
        pasaje.setPrecionTotal(Float.parseFloat(txtPrecio.getText()));
        pasajes.AgregarPasaje(pasaje);
        CargarTabla();
    }//GEN-LAST:event_bttnGuardarActionPerformed

    private void bttnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnActualizarActionPerformed
        ClsPasaje pasajes = new ClsPasaje();
        Pasaje pasaje = new Pasaje();
        pasaje.setIdPasaje(Integer.parseInt(txtIdPasaje.getText()));
        pasaje.setIdVuelo(Integer.parseInt(txtVuelo.getText()));
        pasaje.setIdClase(Integer.parseInt(valueMemberClase[cbClase.getSelectedIndex()]));
        pasaje.setNAsiento(Integer.parseInt(txtAsiento.getText()));
        pasaje.setPrecionTotal(Float.parseFloat(txtPrecio.getText()));
        pasajes.ActualizarPasaje(pasaje);
        CargarTabla();
    }//GEN-LAST:event_bttnActualizarActionPerformed

    private void bttnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEliminarActionPerformed
        ClsPasaje pasajes = new ClsPasaje();
        Pasaje pasaje = new Pasaje();
        pasaje.setIdPasaje(Integer.parseInt(txtIdPasaje.getText()));
        pasajes.BorrarPasaje(pasaje);
        CargarTabla();
    }//GEN-LAST:event_bttnEliminarActionPerformed

    private void tbVuelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVuelosMouseClicked
        jtpPasaje.setSelectedIndex(jtpPasaje.indexOfComponent(jPanel2));
        int fila = tbVuelos.getSelectedRow();
        
        String idVuelo = String.valueOf(tbVuelos.getValueAt(fila, 0));
        
        txtVuelo.setText(idVuelo);
    }//GEN-LAST:event_tbVuelosMouseClicked

    private void tbPasajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPasajesMouseClicked
        jtpPasaje.setSelectedIndex(jtpPasaje.indexOfComponent(jPanel2));
        int fila = tbPasajes.getSelectedRow();
        
        String idPasaje = String.valueOf(tbPasajes.getValueAt(fila, 0));
        String idPasajero = String.valueOf(tbPasajes.getValueAt(fila, 1));
        String idVuelo = String.valueOf(tbPasajes.getValueAt(fila, 2));
        String idClase = String.valueOf(tbPasajes.getValueAt(fila, 3));
        String NAsiento = String.valueOf(tbPasajes.getValueAt(fila, 4));
        String precioTotal = String.valueOf(tbPasajes.getValueAt(fila, 5));
        
        txtIdPasaje.setText(idPasaje);
        txtVuelo.setText(idVuelo);
        txtAsiento.setText(NAsiento);
        txtPrecio.setText(precioTotal);
        
        int seleccionadordevista = 0;
        for (var iterar : valueMemberPasajero){
            if (idPasajero.equals(iterar)) {
            }
            seleccionadordevista += 1;
        }
        
        int seleccionadordevista2 = 0;
        for (var iterar : valueMemberClase){
            if (idClase.equals(iterar)) {
                cbClase.setSelectedIndex(seleccionadordevista2);
            }
            seleccionadordevista2 += 1;
        }
        
        
    }//GEN-LAST:event_tbPasajesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnActualizar;
    private javax.swing.JButton bttnEliminar;
    private javax.swing.JButton bttnGuardar;
    private javax.swing.JComboBox<String> cbClase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jtpPasaje;
    private javax.swing.JTable tbPasajes;
    private javax.swing.JTable tbVuelos;
    private javax.swing.JTextField txtAsiento;
    private javax.swing.JTextField txtIdPasaje;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtVuelo;
    private javax.swing.JTextField txtxPasajero;
    // End of variables declaration//GEN-END:variables
}
