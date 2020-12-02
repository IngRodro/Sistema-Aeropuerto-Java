/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.OperacionesBd;
//import com.unab.edu.DAO.ClsVuelo;

import com.mysql.cj.log.Log;
import com.unab.edu.DAO.ClsCompany;
import com.unab.edu.DAO.ClsAvion;
import com.unab.edu.DAO.ClsItinerario;
import com.unab.edu.DAO.ClsTiposVuelo;
import com.unab.edu.DAO.ClsVuelo;
import com.unab.edu.DAO.Clsaeropuerto;
import com.unab.edu.Entidades.Aeropuerto;
import com.unab.edu.Entidades.Tipos_vuelo;
import com.unab.edu.Entidades.Vuelo;
import com.unab.edu.Entidades.Company;
import com.unab.edu.Entidades.Avion;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import com.unab.edu.DAO.InnerJoinVuelo;
import com.unab.edu.Entidades.Itinerario;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario
 */
public class PnlVuelos extends javax.swing.JPanel {

    /**
     * Creates new form PnlVuelos
     */
    public PnlVuelos() {
        initComponents();
        DisplayMemberCompany();
        DisplayMemberAvion();
        DisplayMemberDestino();
        DisplayMemberOrigen();
        DisplayMemberTipos();
        CargarTabla();
    }

    SimpleDateFormat formato = new SimpleDateFormat("d MMM y");
    
    String valueMemberCompany[];
    String valueMemberAvion[];
    String valueMemberDestino[];
    String valueMemberOrigen[];
    String valueMemberTipos[];
    int contadorCompany = 1;
    int contadorAvion = 1;
    int contadorDestino = 1;
    int contadorOrigen = 1;
    int contadorTipos = 1;

    
    void CargarTabla() {
        String Titulos[] = {"Vuelo", "Compañia", "Aeropuerto Origen", "AeropuertoDestino", "Modelo Avion", "Tipo de Vuelo"};
        DefaultTableModel ModeloT = new DefaultTableModel(null, Titulos);
        ClsVuelo clsVuelos = new ClsVuelo();
        ArrayList<InnerJoinVuelo> Vuelos = clsVuelos.MostrarVuelos();
        String filas[] = new String[7];
        for (var IterarVuelo : Vuelos) {
            filas[0] = String.valueOf(IterarVuelo.getVuelo());
            filas[1] = IterarVuelo.getCompany();
            filas[2] = IterarVuelo.getAeropuertoO();
            filas[3] = IterarVuelo.getAeropuertoD();
            filas[4] = IterarVuelo.getModelo();
            filas[5] = IterarVuelo.getTipo();
            ModeloT.addRow(filas);
        }
        tbVuelos.setModel(ModeloT);
    }
    
    void DisplayMemberDestino() {
        DefaultComboBoxModel cbdefaDefault = new DefaultComboBoxModel();
        Clsaeropuerto claseAeropuerto = new Clsaeropuerto();
        ArrayList<Aeropuerto> aeropuertos = claseAeropuerto.MostrAeropuerto();
        valueMemberDestino = new String[aeropuertos.size() + 1];
        String filas[] = new String[4];
        cbdefaDefault.addElement("");
        for (var IterarDatosAeropuerto : aeropuertos) {
            filas[0] = String.valueOf(IterarDatosAeropuerto.getIdAeropuerto());
            filas[1] = IterarDatosAeropuerto.getNombre();
            valueMemberDestino[contadorDestino] = filas[0];
            cbdefaDefault.addElement(filas[1]);
            contadorDestino++;
        }
        cbDestino.setModel(cbdefaDefault);
    }

    void DisplayMemberOrigen() {
        DefaultComboBoxModel cbdefaDefault = new DefaultComboBoxModel();
        Clsaeropuerto claseAeropuerto = new Clsaeropuerto();
        ArrayList<Aeropuerto> aeropuertos = claseAeropuerto.MostrAeropuerto();
        valueMemberOrigen = new String[aeropuertos.size() + 1];
        String filas[] = new String[3];
        cbdefaDefault.addElement("");
        for (var IterarDatosAeropuerto : aeropuertos) {
            filas[0] = String.valueOf(IterarDatosAeropuerto.getIdAeropuerto());
            filas[1] = IterarDatosAeropuerto.getNombre();
            valueMemberOrigen[contadorOrigen] = filas[0];
            cbdefaDefault.addElement(filas[1]);
            contadorOrigen++;
        }
        cbOrigen.setModel(cbdefaDefault);
    }
    
    void DisplayMemberCompany() {
        DefaultComboBoxModel cbdefaDefault = new DefaultComboBoxModel();
        ClsCompany clsCompany = new ClsCompany();
        ArrayList<Company> aeropuertos = clsCompany.MostrarCompany();
        valueMemberCompany = new String[aeropuertos.size() + 1];
        String filas[] = new String[3];
        cbdefaDefault.addElement("");
        for (var IterarDatosCompany : aeropuertos) {
            filas[0] = String.valueOf(IterarDatosCompany.getIdCompany());
            filas[1] = IterarDatosCompany.getNombre();
            valueMemberCompany[contadorCompany] = filas[0];
            cbdefaDefault.addElement(filas[1]);
            contadorCompany++;
        }
        cbCompany.setModel(cbdefaDefault);
    }

    void DisplayMemberAvion() {
        DefaultComboBoxModel cbdefaDefault = new DefaultComboBoxModel();
        ClsAvion clsAvion = new ClsAvion();
        ArrayList<Avion> aeropuertos = clsAvion.MostrarAvion();
        valueMemberAvion = new String[aeropuertos.size() + 1];
        String filas[] = new String[3];
        cbdefaDefault.addElement("");
        for (var IterarDatosAeropuerto : aeropuertos) {
            filas[0] = String.valueOf(IterarDatosAeropuerto.getIdAvion());
            filas[1] = IterarDatosAeropuerto.getModeloAvion();
            valueMemberAvion[contadorAvion] = filas[0];
            cbdefaDefault.addElement(filas[1]);
            contadorAvion++;
        }
        cbAvion.setModel(cbdefaDefault);
    }
    void DisplayMemberTipos() {
        DefaultComboBoxModel cbdefaDefault = new DefaultComboBoxModel();
        ClsTiposVuelo clsTipos = new ClsTiposVuelo();
        ArrayList<Tipos_vuelo> tipos = clsTipos.MostrarTipos();
        valueMemberTipos = new String[tipos.size() + 1];
        String filas[] = new String[3];
        cbdefaDefault.addElement("");
        for (var IterarDatostipos : tipos) {
            filas[0] = String.valueOf(IterarDatostipos.getIdTipos_vuelo());
            filas[1] = IterarDatostipos.getTipo();
            valueMemberTipos[contadorTipos] = filas[0];
            cbdefaDefault.addElement(filas[1]);
            contadorTipos++;
        }
        cbTipo.setModel(cbdefaDefault);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbPVuelos = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cbCompany = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        cbOrigen = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbDestino = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbAvion = new javax.swing.JComboBox<>();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtVuelo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHora = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVuelos = new javax.swing.JTable();

        setBackground(new java.awt.Color(51, 102, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        cbCompany.setBackground(new java.awt.Color(0, 0, 0));
        cbCompany.setForeground(new java.awt.Color(255, 255, 255));
        cbCompany.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCompany.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vuelos");

        cbTipo.setBackground(new java.awt.Color(0, 0, 0));
        cbTipo.setForeground(new java.awt.Color(255, 255, 255));
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cbOrigen.setBackground(new java.awt.Color(0, 0, 0));
        cbOrigen.setForeground(new java.awt.Color(255, 255, 255));
        cbOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hora:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Avion:");

        cbDestino.setBackground(new java.awt.Color(0, 0, 0));
        cbDestino.setForeground(new java.awt.Color(255, 255, 255));
        cbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de Vuelo:");

        cbAvion.setBackground(new java.awt.Color(0, 0, 0));
        cbAvion.setForeground(new java.awt.Color(255, 255, 255));
        cbAvion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAvion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jdcFecha.setBackground(new java.awt.Color(0, 0, 0));
        jdcFecha.setDateFormatString("d MMM y");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Origen:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Compañia:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Destino:");

        btnGuardar.setBackground(new java.awt.Color(0, 0, 0));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Vuelo:");

        txtVuelo.setBackground(new java.awt.Color(0, 0, 0));
        txtVuelo.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha:");

        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(381, 381, 381))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 287, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(400, 400, 400))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel4))
                            .addComponent(jLabel9))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(cbDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCompany, 0, 500, Short.MAX_VALUE)
                            .addComponent(cbAvion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTipo, 0, 500, Short.MAX_VALUE)
                            .addComponent(txtVuelo, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(txtHora))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(cbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(btnGuardar)
                .addGap(12, 12, 12))
        );

        tbPVuelos.addTab("Registrar Vuelo", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        tbPVuelos.addTab("Lista Vuelos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbPVuelos)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbPVuelos)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ClsVuelo vuelos = new ClsVuelo();
        Itinerario itinerario = new Itinerario();
        Vuelo vuelo = new Vuelo();
        String Hora = txtHora.getText();
        char[] a = Hora.toCharArray();
        String [] c = Hora.split(":");
        String Horas = c[0];
        String Minutos = c[0];
        if(a[0] == ' ' || a[1] == ' ' || a[2] == ' ' || a[3] == ' ' || a[4] == ' ' || Integer.parseInt(Horas)>24 || Integer.parseInt(Minutos)>59)
        {JOptionPane.showMessageDialog(null, "Introduzca la Hora correctamente");}
        else{
            JOptionPane.showMessageDialog(null, Horas);
            itinerario.setHora(Horas);
            itinerario.setMinutos(Minutos);
        }
        
        vuelo.setIdAvion(Integer.parseInt(valueMemberAvion[cbAvion.getSelectedIndex()]));
        vuelo.setIdCompany(Integer.parseInt(valueMemberCompany[cbCompany.getSelectedIndex()]));
        vuelo.setIdTiposVuelo(Integer.parseInt(valueMemberTipos[cbTipo.getSelectedIndex()]));
        itinerario.setIdAeropuertoDestino(Integer.parseInt(valueMemberDestino[cbDestino.getSelectedIndex()]));
        itinerario.setIdAeropuertoOrigen(Integer.parseInt(valueMemberOrigen[cbOrigen.getSelectedIndex()]));
        itinerario.setFecha(jdcFecha.getDate());
        vuelos.AgregarVuelo(vuelo, itinerario);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbVuelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVuelosMouseClicked
       
        Vuelo vuelo = new Vuelo();
        Itinerario itinerario = new Itinerario();
        ClsVuelo clsVuelo = new ClsVuelo();
        ClsItinerario clsItinerario = new ClsItinerario();
        
  
        
        tbPVuelos.setSelectedIndex(tbPVuelos.indexOfComponent(jPanel1));
        int fila = tbVuelos.getSelectedRow();
        int ID = Integer.parseInt(String.valueOf(tbVuelos.getValueAt(fila, 0)));
        
        vuelo = clsVuelo.SeleccionarVuelo(ID);
        itinerario = clsItinerario.SeleccionarIterinario(vuelo.getIdIterinario());
        
        txtVuelo.setText(String.valueOf(vuelo.getIdVuelo()));
        
        
        for(int i=1;i<valueMemberCompany.length;i++){
            int idCompany = Integer.parseInt(valueMemberCompany[i]);
            if(vuelo.getIdCompany() == idCompany){cbCompany.setSelectedIndex(i);
            }
        }
        for(int i=1;i<valueMemberAvion.length;i++){
            int idAvion = Integer.parseInt(valueMemberAvion[i]);
            if(vuelo.getIdAvion() == idAvion){cbAvion.setSelectedIndex(i);}
        }
        for(int i=1;i<valueMemberOrigen.length;i++){
            int idOrigen = Integer.parseInt(valueMemberOrigen[i]);
            if(itinerario.getIdAeropuertoOrigen()== idOrigen){cbOrigen.setSelectedIndex(i);}
        }
        for(int i=1;i<valueMemberDestino.length;i++){
            int idDestino = Integer.parseInt(valueMemberDestino[i]);
            if(itinerario.getIdAeropuertoDestino()== idDestino){cbDestino.setSelectedIndex(i);}
        }
        for(int i=1;i<valueMemberTipos.length;i++){
            int idTipos = Integer.parseInt(valueMemberTipos[i]);
            if(vuelo.getIdTiposVuelo()== idTipos){cbTipo.setSelectedIndex(i);}
        }
        Date castfecha = new Date();
        String Fecha = formato.format(itinerario.getFecha());
        try {
            JOptionPane.showMessageDialog(null, itinerario.getFecha());
            castfecha = formato.parse(Fecha);
            jdcFecha.setDate(castfecha);
        } catch (ParseException ex) {
            Logger.getLogger(PnlVuelos.class.getName()).log(Level.SEVERE, null, ex);
            jdcFecha.setDate(null);
        }
        
        txtHora.setText(itinerario.getHora() + itinerario.getMinutos());
        
    }//GEN-LAST:event_tbVuelosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbAvion;
    private javax.swing.JComboBox<String> cbCompany;
    private javax.swing.JComboBox<String> cbDestino;
    private javax.swing.JComboBox<String> cbOrigen;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTabbedPane tbPVuelos;
    private javax.swing.JTable tbVuelos;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtVuelo;
    // End of variables declaration//GEN-END:variables
}
