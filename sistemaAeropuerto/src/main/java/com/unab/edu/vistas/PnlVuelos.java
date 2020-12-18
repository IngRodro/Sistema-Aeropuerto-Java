/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.vistas;
//import com.unab.edu.DAO.ClsVuelo;

import com.unab.edu.DAO.ClsCompany;
import com.unab.edu.DAO.ClsAvion;
import com.unab.edu.DAO.ClsItinerario;
import com.unab.edu.DAO.ClsPasaje;
import com.unab.edu.DAO.ClsPromocion;
import com.unab.edu.DAO.ClsTiposVuelo;
import com.unab.edu.DAO.ClsVuelo;
import com.unab.edu.DAO.Clsaeropuerto;
import com.unab.edu.Entidades.Aeropuerto;
import com.unab.edu.Entidades.Tipos_vuelo;
import com.unab.edu.Entidades.Vuelo;
import com.unab.edu.Entidades.Company;
import com.unab.edu.Entidades.Avion;
import com.unab.edu.Entidades.Pasaje;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import com.unab.edu.DAO.InnerJoinVuelo;
import com.unab.edu.Entidades.Itinerario;
import com.unab.edu.Entidades.Promociones;
import com.unab.edu.sistemaaeropuerto.CambioPanel;
import com.unab.edu.sistemaaeropuerto.frmMenuAdmin;
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
        CargarDatos();
        DisplayMemberAvion();
        DisplayMemberDestino();
        DisplayMemberOrigen();
        DisplayMemberTipos();
        DisplayMemberCompany();
    }

    public frmMenuAdmin menuAdmin;
    CambioPanel cambio = new CambioPanel();

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

    public void LimpiarCajasdeTexto() {
        txtDescuento.setText("0.0");
        txtHora.setText("");
        cbAvion.setSelectedIndex(0);
        cbCompany.setSelectedIndex(0);
        cbDestino.setSelectedIndex(0);
        cbOrigen.setSelectedIndex(0);
        cbTipo.setSelectedIndex(0);
    }

    void CargarDatos() {
        CargarTabla();
    }

    void CargarTabla() {
        String Titulos[] = {"Vuelo", "Compañia", "Aeropuerto Origen", "AeropuertoDestino", "Modelo Avion", "Tipo de Vuelo", "Fecha", "Hora", "Descuento", "Estado"};
        DefaultTableModel ModeloT = new DefaultTableModel(null, Titulos);
        ClsVuelo clsVuelos = new ClsVuelo();
        ArrayList<InnerJoinVuelo> Vuelos = clsVuelos.MostrarVuelos();
        String filas[] = new String[10];
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
            if (IterarVuelo.getEstado() == 1) {
                filas[9] = "Activo";
            } else if (IterarVuelo.getEstado() == 2) {
                filas[9] = "Retrasado";
            } else if (IterarVuelo.getEstado() == 3) {
                filas[9] = "Suspendido";
            }
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
        cbdefaDefault.addElement("Seleccione una opcion");
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
        cbdefaDefault.addElement("Seleccione una opcion");
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
        String filas[] = new String[4];
        cbdefaDefault.addElement("Seleccione una opcion");
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
        contadorAvion = 1;
        DefaultComboBoxModel cbdefaDefault = new DefaultComboBoxModel();
        ClsAvion clsAvion = new ClsAvion();
        ArrayList<Avion> aviones = clsAvion.MostrarAvion();
        valueMemberAvion = new String[aviones.size() + 1];
        String filas[] = new String[3];
        cbdefaDefault.removeAllElements();
        cbdefaDefault.addElement("Seleccione una opcion");
        for (var IterarDatosAeropuerto : aviones) {
            filas[0] = String.valueOf(IterarDatosAeropuerto.getIdAvion());
            filas[1] = IterarDatosAeropuerto.getModeloAvion() + ", " + IterarDatosAeropuerto.getCapacidad() + " Asientos" + " (" + IterarDatosAeropuerto.getEstado() + ")";
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
        cbdefaDefault.addElement("Seleccione una Opcion");
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
        jLabel8 = new javax.swing.JLabel();
        txtHora = new javax.swing.JFormattedTextField();
        BtnActualizar = new javax.swing.JButton();
        btnEscala = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jdcFechaI = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jdcFechaF = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnFinalizado = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVuelos = new javax.swing.JTable();

        setBackground(new java.awt.Color(51, 102, 255));

        tbPVuelos.setBackground(new java.awt.Color(51, 102, 255));
        tbPVuelos.setForeground(new java.awt.Color(255, 255, 255));
        tbPVuelos.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel1KeyTyped(evt);
            }
        });

        cbCompany.setBackground(new java.awt.Color(0, 153, 204));
        cbCompany.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbCompany.setForeground(new java.awt.Color(255, 255, 255));
        cbCompany.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCompany.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Vuelos");

        cbTipo.setBackground(new java.awt.Color(0, 153, 204));
        cbTipo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbTipo.setForeground(new java.awt.Color(255, 255, 255));
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cbOrigen.setBackground(new java.awt.Color(0, 153, 204));
        cbOrigen.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbOrigen.setForeground(new java.awt.Color(255, 255, 255));
        cbOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hora:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Avion:");

        cbDestino.setBackground(new java.awt.Color(0, 153, 204));
        cbDestino.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbDestino.setForeground(new java.awt.Color(255, 255, 255));
        cbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de Vuelo:");

        cbAvion.setBackground(new java.awt.Color(0, 153, 204));
        cbAvion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbAvion.setForeground(new java.awt.Color(255, 255, 255));
        cbAvion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbAvion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jdcFecha.setBackground(new java.awt.Color(0, 153, 204));
        jdcFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha:");

        txtHora.setBackground(new java.awt.Color(0, 153, 204));
        txtHora.setBorder(null);
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setCaretColor(new java.awt.Color(255, 255, 255));
        txtHora.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        BtnActualizar.setBackground(new java.awt.Color(0, 0, 0));
        BtnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        btnEscala.setBackground(new java.awt.Color(0, 0, 0));
        btnEscala.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEscala.setForeground(new java.awt.Color(255, 255, 255));
        btnEscala.setText("Ver Escala");
        btnEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscalaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Descuento(Opcional):");

        txtDescuento.setBackground(new java.awt.Color(0, 153, 204));
        txtDescuento.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(255, 255, 255));
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescuento.setText("0");
        txtDescuento.setBorder(null);
        txtDescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescuentoFocusLost(evt);
            }
        });
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Inicio Desc(Opcional):");

        jdcFechaI.setBackground(new java.awt.Color(0, 153, 204));
        jdcFechaI.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Final Desc(Opcional):");

        jdcFechaF.setBackground(new java.awt.Color(0, 153, 204));
        jdcFechaF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(166, 3));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 166, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("%");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(254, 3));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        btnFinalizado.setBackground(new java.awt.Color(0, 0, 0));
        btnFinalizado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFinalizado.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizado.setText("Marcar como Finalizado");
        btnFinalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizadoActionPerformed(evt);
            }
        });

        lblId.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnActualizar)
                .addGap(113, 113, 113)
                .addComponent(btnEscala)
                .addGap(317, 317, 317))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(424, 424, 424)
                .addComponent(jLabel1)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jdcFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addGap(50, 50, 50))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addGap(87, 87, 87)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbCompany, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(82, 82, 82)
                                            .addComponent(cbAvion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(12, 12, 12)
                                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13)
                                        .addGap(5, 5, 5))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jdcFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jdcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                            .addComponent(cbDestino, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinalizado)))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(8, 8, 8)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cbCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11)
                        .addComponent(jdcFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jdcFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnFinalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        tbPVuelos.addTab("Registrar Vuelo", jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        tbVuelos.setBackground(new java.awt.Color(255, 255, 255));
        tbVuelos.setForeground(new java.awt.Color(0, 0, 0));
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
        tbVuelos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbVuelos.setFocusable(false);
        tbVuelos.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbVuelos.setRowHeight(25);
        tbVuelos.setSelectionBackground(new java.awt.Color(0, 102, 255));
        tbVuelos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tbVuelos.setShowGrid(false);
        tbVuelos.setShowHorizontalLines(true);
        tbVuelos.getTableHeader().setResizingAllowed(false);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
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

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '.')
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void btnEscalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscalaActionPerformed
        PnlEscala Escala = new PnlEscala();
        cambio.ModificarPanel(menuAdmin.PnlContenedor, Escala);
        Escala.idVuelo = Integer.parseInt(lblId.getText());
        Escala.CargarTabla();
    }//GEN-LAST:event_btnEscalaActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
        ClsItinerario clsiti = new ClsItinerario();
        Promociones promo = new Promociones();
        ClsVuelo vuelos = new ClsVuelo();
        Itinerario itinerario = new Itinerario();
        Vuelo vuelo = new Vuelo();
        String Hora = txtHora.getText();
        char[] a = Hora.toCharArray();
        String[] c = Hora.split(":");
        String Horas = c[0];
        String Minutos = c[1];
        if (a[0] == ' ' || a[1] == ' ' || a[2] == ' ' || a[3] == ' ' || a[4] == ' ' || Integer.parseInt(Horas) > 24 || Integer.parseInt(Minutos) > 59) {
            JOptionPane.showMessageDialog(null, "Introduzca la Hora en el formato correcto");
        } else {
            if (cbAvion.getSelectedIndex() == 0 || cbCompany.getSelectedIndex() == 0 || cbDestino.getSelectedIndex() == 0 || cbOrigen.getSelectedIndex() == 0
                    || cbTipo.getSelectedIndex() == 0 || jdcFecha.getDate() == null || lblId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos necesarios para continuar", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                if (cbOrigen.getSelectedIndex() == cbDestino.getSelectedIndex()) {
                    JOptionPane.showMessageDialog(null, "El Aeropuerto de Origen y de Destino no pueden ser el mismo");
                } else {
                    if (Double.parseDouble(txtDescuento.getText()) == 0.0) {
                        try {
                            promo.setDescuento(0.0);
                            promo.setFechaInicio(null);
                            promo.setFechaFinal(null);
                            itinerario.setHora(Horas);
                            itinerario.setMinutos(Minutos);
                            vuelo.setIdVuelo(Integer.parseInt(lblId.getText()));
                            vuelo.setIdAvion(Integer.parseInt(valueMemberAvion[cbAvion.getSelectedIndex()]));
                            vuelo.setIdCompany(Integer.parseInt(valueMemberCompany[cbCompany.getSelectedIndex()]));
                            vuelo.setIdTiposVuelo(Integer.parseInt(valueMemberTipos[cbTipo.getSelectedIndex()]));
                            itinerario.setIdAeropuertoDestino(Integer.parseInt(valueMemberDestino[cbDestino.getSelectedIndex()]));
                            itinerario.setIdAeropuertoOrigen(Integer.parseInt(valueMemberOrigen[cbOrigen.getSelectedIndex()]));
                            itinerario.setFecha(jdcFecha.getDate());
                            promo.setDescuento(Double.parseDouble(txtDescuento.getText()));
                            promo.setFechaInicio(jdcFechaI.getDate());
                            promo.setFechaFinal(jdcFechaF.getDate());
                            ArrayList<Pasaje> pasajes = new ArrayList<>();
                            ClsPasaje clsPasaje = new ClsPasaje();
                            pasajes = clsPasaje.SeleccionarPasajesVuelo(vuelo.getIdVuelo());
                            if (pasajes.size() > 0) {
                                int resp = JOptionPane.showConfirmDialog(null, "Ya hay pasajes Registrados, solo puede Actualizar la Promocion ¿Desea Actualizar la Promocion?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                                if (resp == 0) {
                                    ClsPromocion clsPromocion = new ClsPromocion();
                                    clsPromocion.ActualizarPromo(promo, vuelo);
                                } else {
                                    LimpiarCajasdeTexto();
                                }
                            } else {
                                Avion avion = new Avion();
                                ClsAvion clsAvion = new ClsAvion();
                                avion = clsAvion.SeleccionarAvion(vuelo.getIdAvion());
                                String EstadoAvion = avion.getEstado();
                                if (EstadoAvion.equals("Activo")) {
                                    Vuelo vueloantiguo = new Vuelo();
                                    vueloantiguo = vuelos.SeleccionarVuelo(vuelo.getIdVuelo());
                                    vuelos.ActualizarVuelo(vuelo, itinerario, promo);
                                    clsAvion.EstadoAvion(vueloantiguo.getIdAvion(), "Activo");
                                    clsAvion.EstadoAvion(vuelo.getIdAvion(), "Ocupado");
                                    DisplayMemberAvion();
                                    LimpiarCajasdeTexto();
                                } else {
                                    JOptionPane.showMessageDialog(null, "El Avion al que desea Actualizar esta ocupado intente con otro");
                                    cbAvion.setSelectedIndex(0);
                                }
                            }
                            LimpiarCajasdeTexto();
                        } catch (Exception e) {

                        }

                        CargarTabla();

                    } else {
                        try {
                            itinerario.setHora(Horas);
                            itinerario.setMinutos(Minutos);
                            vuelo.setIdVuelo(Integer.parseInt(lblId.getText()));
                            vuelo.setIdAvion(Integer.parseInt(valueMemberAvion[cbAvion.getSelectedIndex()]));
                            vuelo.setIdCompany(Integer.parseInt(valueMemberCompany[cbCompany.getSelectedIndex()]));
                            vuelo.setIdTiposVuelo(Integer.parseInt(valueMemberTipos[cbTipo.getSelectedIndex()]));
                            itinerario.setIdAeropuertoDestino(Integer.parseInt(valueMemberDestino[cbDestino.getSelectedIndex()]));
                            itinerario.setIdAeropuertoOrigen(Integer.parseInt(valueMemberOrigen[cbOrigen.getSelectedIndex()]));
                            itinerario.setFecha(jdcFecha.getDate());
                            promo.setDescuento(Double.parseDouble(txtDescuento.getText()));
                            promo.setFechaInicio(jdcFechaI.getDate());
                            promo.setFechaFinal(jdcFechaF.getDate());
                            if (promo.getFechaFinal().before(itinerario.getFecha())) {
                                if (promo.getFechaFinal().before(promo.getFechaInicio())) {
                                    JOptionPane.showMessageDialog(null, "La Fecha de Inicio debes ser anterior a la Fecha Final");
                                } else {
                                    ArrayList<Pasaje> pasajes = new ArrayList<>();
                                    ClsPasaje clsPasaje = new ClsPasaje();
                                    pasajes = clsPasaje.SeleccionarPasajesVuelo(vuelo.getIdVuelo());
                                    if (pasajes.size() > 0) {
                                        int resp = JOptionPane.showConfirmDialog(null, "Ya hay pasajes Registrados, solo puede Actualizar la Promocion ¿Desea Actualizar la Promocion?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                                        if (resp == 0) {
                                            ClsPromocion clsPromocion = new ClsPromocion();
                                            clsPromocion.ActualizarPromo(promo, vuelo);
                                            LimpiarCajasdeTexto();
                                        } else {
                                            LimpiarCajasdeTexto();
                                        }
                                    } else {

                                        Avion avion = new Avion();
                                        ClsAvion clsAvion = new ClsAvion();
                                        avion = clsAvion.SeleccionarAvion(vuelo.getIdAvion());
                                        String EstadoAvion = avion.getEstado();
                                        if (EstadoAvion.equals("Activo")) {
                                            Vuelo vueloantiguo = new Vuelo();
                                            vueloantiguo = vuelos.SeleccionarVuelo(vuelo.getIdVuelo());
                                            vuelos.ActualizarVuelo(vuelo, itinerario, promo);
                                            clsAvion.EstadoAvion(vueloantiguo.getIdAvion(), "Activo");
                                            clsAvion.EstadoAvion(vuelo.getIdAvion(), "Ocupado");
                                            DisplayMemberAvion();
                                            LimpiarCajasdeTexto();
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El Avion al que desea Actualizar esta ocupado intente con otro");
                                            cbAvion.setSelectedIndex(0);
                                        }
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "La Promocion no puede durar mas alla de la Fecha del Vuelo");
                            }
                        } catch (Exception e) {

                        }
                    }
                }
            }
        }

        CargarTabla();
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ClsVuelo vuelos = new ClsVuelo();
        ClsPromocion clspromo = new ClsPromocion();
        ClsAvion clsAvion = new ClsAvion();
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
            itinerario.setHora(Horas);
            itinerario.setMinutos(Minutos);

            if (cbCompany.getSelectedIndex() == 0 || cbDestino.getSelectedIndex() == 0
                    || cbOrigen.getSelectedIndex() == 0 || cbTipo.getSelectedIndex() == 0 || jdcFecha.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos necesarios");
            } else {
                if (cbOrigen.getSelectedIndex() == cbDestino.getSelectedIndex()) {
                    JOptionPane.showMessageDialog(null, "El Aeropuerto de Origen y de Destino no pueden ser el mismo");
                } else {
                    if (Double.parseDouble(txtDescuento.getText()) == 0.0) {
                        promo.setDescuento(0.0);
                        promo.setFechaInicio(null);
                        promo.setFechaFinal(null);
                        vuelo.setIdAvion(Integer.parseInt(valueMemberAvion[cbAvion.getSelectedIndex()]));
                        vuelo.setIdCompany(Integer.parseInt(valueMemberCompany[cbCompany.getSelectedIndex()]));
                        vuelo.setIdTiposVuelo(Integer.parseInt(valueMemberTipos[cbTipo.getSelectedIndex()]));
                        itinerario.setIdAeropuertoDestino(Integer.parseInt(valueMemberDestino[cbDestino.getSelectedIndex()]));
                        itinerario.setIdAeropuertoOrigen(Integer.parseInt(valueMemberOrigen[cbOrigen.getSelectedIndex()]));
                        itinerario.setFecha(jdcFecha.getDate());
                        Avion avion = new Avion();
                        avion = clsAvion.SeleccionarAvion(vuelo.getIdAvion());
                        String EstadoAvion = avion.getEstado();
                        if (EstadoAvion.equals("Activo")) {
                            vuelos.AgregarVuelo(vuelo, itinerario);
                            clspromo.AgregarPromo(promo);
                            clsAvion.EstadoAvion(vuelo.getIdAvion(), "Ocupado");
                            LimpiarCajasdeTexto();
                        } else {
                            JOptionPane.showMessageDialog(null, "El Avion con el que desea Registrar esta ocupado intente con otro");
                        }
                    } else {
                        if (jdcFechaI.getDate() == null || jdcFechaF.getDate() == null) {
                            JOptionPane.showMessageDialog(null, "Introduzca las Fechas para agregar el descuento");
                        } else {
                            promo.setDescuento(Double.parseDouble(txtDescuento.getText()));
                            promo.setFechaInicio(jdcFechaI.getDate());
                            promo.setFechaFinal(jdcFechaF.getDate());
                            vuelo.setIdAvion(Integer.parseInt(valueMemberAvion[cbAvion.getSelectedIndex()]));
                            vuelo.setIdCompany(Integer.parseInt(valueMemberCompany[cbCompany.getSelectedIndex()]));
                            vuelo.setIdTiposVuelo(Integer.parseInt(valueMemberTipos[cbTipo.getSelectedIndex()]));
                            itinerario.setIdAeropuertoDestino(Integer.parseInt(valueMemberDestino[cbDestino.getSelectedIndex()]));
                            itinerario.setIdAeropuertoOrigen(Integer.parseInt(valueMemberOrigen[cbOrigen.getSelectedIndex()]));
                            itinerario.setFecha(jdcFecha.getDate());
                            if (promo.getFechaFinal().before(itinerario.getFecha())) {
                                if (promo.getFechaFinal().before(promo.getFechaInicio())) {
                                    JOptionPane.showMessageDialog(null, "La Fecha de Inicio debes ser anterior a la Fecha Final");
                                } else {
                                    Avion avion = new Avion();
                                    avion = clsAvion.SeleccionarAvion(vuelo.getIdAvion());
                                    String EstadoAvion = avion.getEstado();
                                    if (EstadoAvion.equals("Activo")) {
                                        vuelos.AgregarVuelo(vuelo, itinerario);
                                        clspromo.AgregarPromo(promo);
                                        clsAvion.EstadoAvion(vuelo.getIdAvion(), "Ocupado");
                                        LimpiarCajasdeTexto();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "El Avion con el que desea Registrar esta ocupado intente con otro");
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "La Promocion no puede durar mas alla de la Fecha del Vuelo");
                            }
                        }
                    }
                }
            }
        }
        CargarDatos();
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

        lblId.setText(String.valueOf(vuelo.getIdVuelo()));

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
        if (promo.getFechaInicio() == null) {
            jdcFechaI.setDate(null);
        } else {
            Date castfechaI = new Date();
            String FechaI = formato.format(promo.getFechaInicio());
            try {
                castfechaI = formato.parse(FechaI);
                jdcFechaI.setDate(castfechaI);
            } catch (ParseException ex) {
                Logger.getLogger(PnlVuelos.class.getName()).log(Level.SEVERE, null, ex);
                jdcFechaI.setDate(null);
            }
        }

        //Fecha Final Promocion
        if (promo.getFechaInicio() == null) {
            jdcFechaF.setDate(null);
        } else {
            Date castfechaF = new Date();
            String FechaF = formato.format(promo.getFechaFinal());
            try {
                castfechaF = formato.parse(FechaF);
                jdcFechaF.setDate(castfechaF);
            } catch (ParseException ex) {
                Logger.getLogger(PnlVuelos.class.getName()).log(Level.SEVERE, null, ex);
                jdcFechaF.setDate(null);
            }
        }
        txtDescuento.setText(promo.getDescuento().toString());
        txtHora.setText(itinerario.getHora() + itinerario.getMinutos());
    }//GEN-LAST:event_tbVuelosMouseClicked

    private void btnFinalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizadoActionPerformed
        if (lblId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un Vuelo para Marcar como Finalizado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            ClsVuelo clsVuelo = new ClsVuelo();
            ClsAvion clsAvion = new ClsAvion();
            Vuelo vuelo = new Vuelo();
            vuelo.setIdVuelo(Integer.parseInt(lblId.getText()));
            vuelo = clsVuelo.SeleccionarVuelo(vuelo.getIdVuelo());
            clsVuelo.VueloFinalizado(vuelo);
            clsAvion.EstadoAvion(vuelo.getIdAvion(), "Activo");
            LimpiarCajasdeTexto();
        }
        CargarTabla();
    }//GEN-LAST:event_btnFinalizadoActionPerformed

    private void jPanel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_jPanel1KeyTyped

    private void txtDescuentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescuentoFocusLost
        Double Descuento = Double.parseDouble(txtDescuento.getText());
        if(Descuento > 100){
            JOptionPane.showMessageDialog(null, "El Descento no puede ser mayor al 100%", "Errpr", JOptionPane.ERROR_MESSAGE);
            txtDescuento.setText("");
       }
    }//GEN-LAST:event_txtDescuentoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton btnEscala;
    private javax.swing.JButton btnFinalizado;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbAvion;
    private javax.swing.JComboBox<String> cbCompany;
    private javax.swing.JComboBox<String> cbDestino;
    private javax.swing.JComboBox<String> cbOrigen;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private com.toedter.calendar.JDateChooser jdcFechaF;
    private com.toedter.calendar.JDateChooser jdcFechaI;
    private javax.swing.JLabel lblId;
    private javax.swing.JTabbedPane tbPVuelos;
    private javax.swing.JTable tbVuelos;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JFormattedTextField txtHora;
    // End of variables declaration//GEN-END:variables
}
