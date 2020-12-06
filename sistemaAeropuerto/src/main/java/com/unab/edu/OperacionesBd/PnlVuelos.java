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
import com.unab.edu.DAO.ClsPromocion;
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
import com.unab.edu.Entidades.Promociones;
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
        BtnActualizar = new javax.swing.JButton();
        btnGuardar2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jdcFechaI = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jdcFechaF = new com.toedter.calendar.JDateChooser();
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

        BtnActualizar.setBackground(new java.awt.Color(0, 0, 0));
        BtnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        btnGuardar2.setBackground(new java.awt.Color(0, 0, 0));
        btnGuardar2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar2.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar2.setText("Ver Escala");
        btnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Descuento(Opcional):");

        txtDescuento.setBackground(new java.awt.Color(0, 0, 0));
        txtDescuento.setForeground(new java.awt.Color(255, 255, 255));
        txtDescuento.setText("0");
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Inicio Desc(Opcional):");

        jdcFechaI.setBackground(new java.awt.Color(0, 0, 0));
        jdcFechaI.setDateFormatString("d MMM y");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Final Desc(Opcional):");

        jdcFechaF.setBackground(new java.awt.Color(0, 0, 0));
        jdcFechaF.setDateFormatString("d MMM y");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)))
                                    .addComponent(jLabel9))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnGuardar)
                                    .addGap(53, 53, 53)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGap(218, 218, 218)
                                            .addComponent(jdcFechaF, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))))))
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(400, 400, 400))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnActualizar)
                                .addGap(222, 222, 222)
                                .addComponent(btnGuardar2)
                                .addGap(81, 81, 81))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCompany, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbAvion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtVuelo)
                                    .addComponent(txtHora, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdcFechaI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(81, 81, 81))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel6)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(cbCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(cbAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(cbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jdcFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jdcFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGap(16, 16, 16))
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
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
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
        Promociones promo = new Promociones();
        String Hora = txtHora.getText();
        char[] a = Hora.toCharArray();
        String[] c = Hora.split(":");
        String Horas = c[0];
        String Minutos = c[1];
        if (a[0] == ' ' || a[1] == ' ' || a[2] == ' ' || a[3] == ' ' || a[4] == ' ' || Integer.parseInt(Horas) > 24 || Integer.parseInt(Minutos) > 59) {
            JOptionPane.showMessageDialog(null, "Introduzca la Hora correctamente");
        } else {
            JOptionPane.showMessageDialog(null, Horas);
            itinerario.setHora(Horas);
            itinerario.setMinutos(Minutos);
        }
        if(Double.parseDouble(txtDescuento.getText())== 0.0){
         promo.setDescuento(0.0);
         promo.setFechaInicio(null);
         promo.setFechaFinal(null);
        }else{
         promo.setDescuento(Double.parseDouble(txtDescuento.getText()));
         promo.setFechaInicio(jdcFechaI.getDate());
         promo.setFechaFinal(jdcFechaI.getDate());
        }
        vuelo.setIdAvion(Integer.parseInt(valueMemberAvion[cbAvion.getSelectedIndex()]));
        vuelo.setIdCompany(Integer.parseInt(valueMemberCompany[cbCompany.getSelectedIndex()]));
        vuelo.setIdTiposVuelo(Integer.parseInt(valueMemberTipos[cbTipo.getSelectedIndex()]));
        itinerario.setIdAeropuertoDestino(Integer.parseInt(valueMemberDestino[cbDestino.getSelectedIndex()]));
        itinerario.setIdAeropuertoOrigen(Integer.parseInt(valueMemberOrigen[cbOrigen.getSelectedIndex()]));
        itinerario.setFecha(jdcFecha.getDate());
        vuelos.AgregarVuelo(vuelo, itinerario, promo);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbVuelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVuelosMouseClicked

        Vuelo vuelo = new Vuelo();
        Itinerario itinerario = new Itinerario();
        ClsVuelo clsVuelo = new ClsVuelo();
        ClsItinerario clsItinerario = new ClsItinerario();
        ClsPromocion clsPromo = new ClsPromocion();
        Promociones promo = new Promociones();
        
        tbPVuelos.setSelectedIndex(tbPVuelos.indexOfComponent(jPanel1));
        int fila = tbVuelos.getSelectedRow();
        int ID = Integer.parseInt(String.valueOf(tbVuelos.getValueAt(fila, 0)));

        vuelo = clsVuelo.SeleccionarVuelo(ID);
        itinerario = clsItinerario.SeleccionarIterinario(vuelo.getIdIterinario());
        promo = clsPromo.SeleccionarPromo(ID);

        txtVuelo.setText(String.valueOf(vuelo.getIdVuelo()));

        for (int i = 1; i < valueMemberCompany.length; i++) {
            int idCompany = Integer.parseInt(valueMemberCompany[i]);
            if (vuelo.getIdCompany() == idCompany) {
                cbCompany.setSelectedIndex(i);
            }
        }
        for (int i = 1; i < valueMemberAvion.length; i++) {
            int idAvion = Integer.parseInt(valueMemberAvion[i]);
            if (vuelo.getIdAvion() == idAvion) {
                cbAvion.setSelectedIndex(i);
            }
        }
        for (int i = 1; i < valueMemberOrigen.length; i++) {
            int idOrigen = Integer.parseInt(valueMemberOrigen[i]);
            if (itinerario.getIdAeropuertoOrigen() == idOrigen) {
                cbOrigen.setSelectedIndex(i);
            }
        }
        for (int i = 1; i < valueMemberDestino.length; i++) {
            int idDestino = Integer.parseInt(valueMemberDestino[i]);
            if (itinerario.getIdAeropuertoDestino() == idDestino) {
                cbDestino.setSelectedIndex(i);
            }
        }
        for (int i = 1; i < valueMemberTipos.length; i++) {
            int idTipos = Integer.parseInt(valueMemberTipos[i]);
            if (vuelo.getIdTiposVuelo() == idTipos) {
                cbTipo.setSelectedIndex(i);
            }
        }
        //Fecha Vuelo
        Date castfecha = new Date();
        String Fecha = formato.format(itinerario.getFecha());
        try {
            castfecha = formato.parse(Fecha);
            jdcFecha.setDate(castfecha);
        } catch (ParseException ex) {
            Logger.getLogger(PnlVuelos.class.getName()).log(Level.SEVERE, null, ex);
            jdcFecha.setDate(null);
        }
        
        //Fecha Inicio Promocion
        if(promo.getFechaInicio() == null){ jdcFechaI.setDate(null);}
        else{
        Date castfechaI = new Date();
        String FechaI = formato.format(promo.getFechaInicio());
        try {
            castfecha = formato.parse(FechaI);
            jdcFechaI.setDate(castfechaI);
        } catch (ParseException ex) {
            Logger.getLogger(PnlVuelos.class.getName()).log(Level.SEVERE, null, ex);
            jdcFechaI.setDate(null);
        }
        }
        
        //Fecha Final Promocion
         if(promo.getFechaInicio() == null){ jdcFechaF.setDate(null);}
        else{
        Date castfechaF = new Date();
        String FechaF = formato.format(promo.getFechaFinal());
        try {
            castfecha = formato.parse(FechaF);
            jdcFechaF.setDate(castfechaF);
        } catch (ParseException ex) {
            Logger.getLogger(PnlVuelos.class.getName()).log(Level.SEVERE, null, ex);
            jdcFechaF.setDate(null);
        }
        }
        txtDescuento.setText(promo.getDescuento().toString());
        txtHora.setText(itinerario.getHora() + itinerario.getMinutos());

    }//GEN-LAST:event_tbVuelosMouseClicked

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        ClsVuelo vuelos = new ClsVuelo();
        Itinerario itinerario = new Itinerario();
        Vuelo vuelo = new Vuelo();
        String Hora = txtHora.getText();
        char[] a = Hora.toCharArray();
        String[] c = Hora.split(":");
        String Horas = c[0];
        String Minutos = c[1];
        if (a[0] == ' ' || a[1] == ' ' || a[2] == ' ' || a[3] == ' ' || a[4] == ' ' || Integer.parseInt(Horas) > 24 || Integer.parseInt(Minutos) > 59) {
            JOptionPane.showMessageDialog(null, "Introduzca la Hora correctamente");
        } else {
            itinerario.setHora(Horas);
            itinerario.setMinutos(Minutos);
        }
        vuelo.setIdVuelo(Integer.parseInt(txtVuelo.getText()));
        vuelo.setIdAvion(Integer.parseInt(valueMemberAvion[cbAvion.getSelectedIndex()]));
        vuelo.setIdCompany(Integer.parseInt(valueMemberCompany[cbCompany.getSelectedIndex()]));
        vuelo.setIdTiposVuelo(Integer.parseInt(valueMemberTipos[cbTipo.getSelectedIndex()]));
        itinerario.setIdAeropuertoDestino(Integer.parseInt(valueMemberDestino[cbDestino.getSelectedIndex()]));
        itinerario.setIdAeropuertoOrigen(Integer.parseInt(valueMemberOrigen[cbOrigen.getSelectedIndex()]));
        itinerario.setFecha(jdcFecha.getDate());
        vuelos.ActualizarVuelo(vuelo, itinerario);
        CargarTabla();
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void btnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar2ActionPerformed
           
    }//GEN-LAST:event_btnGuardar2ActionPerformed

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '.')&&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
    }//GEN-LAST:event_txtDescuentoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar2;
    private javax.swing.JComboBox<String> cbAvion;
    private javax.swing.JComboBox<String> cbCompany;
    private javax.swing.JComboBox<String> cbDestino;
    private javax.swing.JComboBox<String> cbOrigen;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private com.toedter.calendar.JDateChooser jdcFechaF;
    private com.toedter.calendar.JDateChooser jdcFechaI;
    private javax.swing.JTabbedPane tbPVuelos;
    private javax.swing.JTable tbVuelos;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JFormattedTextField txtHora;
    private javax.swing.JTextField txtVuelo;
    // End of variables declaration//GEN-END:variables
}
