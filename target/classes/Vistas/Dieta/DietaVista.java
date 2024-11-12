/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas.Dieta;

import Modelo.Alimento;
import Modelo.Dieta;
import Modelo.MenuDiario;
import Modelo.Paciente;
import Modelo.RenglonDeMenu;
import Persistencia.AlimentoData;
import Persistencia.MenuDiarioData;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Persistencia.DietaData;
import Persistencia.RenglonDeMenuData;
import Vistas.ProgresoPaciente;
import Vistas.Principal;
import Vistas.RegistrarPeso;
import javax.swing.DefaultComboBoxModel;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 *
 * @author franco
 */
public class DietaVista extends javax.swing.JPanel {

    private Paciente paciente;
    private DietaData repoDieta;
    private MenuDiarioData repoMenu;
    private AlimentoData repoAlimentos;
    private RenglonDeMenuData repoRenglones;
    private static DietaVista instance;

    /**
     * Creates new form Dieta
     */
    public DietaVista(Paciente paciente) {
        instance = this;
        this.paciente = paciente;
        this.repoDieta = DietaData.getRepo();
        this.repoMenu = MenuDiarioData.getRepo();
        this.repoAlimentos = AlimentoData.getRepo();
        this.repoRenglones = RenglonDeMenuData.getRepo();
        initComponents();

        cargarAlimentos(null);
        labelPaciente.setText("Nombre: " + paciente.getNombre());
        labelDNI.setText("DNI: " + paciente.getDni());
        labelPesoActual.setText("Peso actual: " + paciente.getPesoActual() + "kg");
        labelTalla.setText("Talla: " + paciente.getAltura() + "cm");
        labelEdad.setText("Edad: " + paciente.getEdad());
        labelIMC.setText(String.format("IMC: %.2f", paciente.calcularIMC()));
        llenarTablaDietas(null);

    }

    public static DietaVista getInstance(Paciente paciente) {
        return instance;
    }

    private void crearRenglon() {
        Float cantidad = null;
        var r = jTable2.getSelectedRow();
        if (r < 0) {
            return;
        }
        var menu = (MenuDiario) jComboBox1.getSelectedItem();
        if (menu == null) {
            return;
        }
        var alimento = (Alimento) jTable2.getValueAt(r, 0);
        var horario = (String) jComboBox2.getSelectedItem();
        try {
            cantidad = Float.valueOf(JOptionPane.showInputDialog("Cantidad de gramos: "));
        } catch (Exception ex) {
            return;
        }
        if (cantidad < 1) {
            JOptionPane.showMessageDialog(null, "Cantidad no válida.");
            return;
        }
        var ren = new RenglonDeMenu();
        ren.setMenu(menu);
        ren.setAlimento(alimento);
        ren.setHorario(horario);
        ren.setCantidadGrs(cantidad);
        repoRenglones.agregarRen(ren);
        cargarRenglones();
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTable4.setDefaultEditor(Object.class, null);
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTable2.setDefaultEditor(Object.class, null);
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        agregarA = new javax.swing.JButton();
        eliminarA = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelPesoActual = new javax.swing.JLabel();
        labelIMC = new javax.swing.JLabel();
        labelTalla = new javax.swing.JLabel();
        labelDNI = new javax.swing.JLabel();
        labelPaciente = new javax.swing.JLabel();
        labelEdad = new javax.swing.JLabel();
        jbRegistrarPeso = new javax.swing.JButton();
        jbProgreso = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnBaja = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDietas = new javax.swing.JTable();
        tablaDietas.setDefaultEditor(Object.class, null);
        jLabel11 = new javax.swing.JLabel();
        checkboxActivas = new javax.swing.JCheckBox();

        setMinimumSize(new java.awt.Dimension(600, 750));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alimento", "Gramos", "T. Calorias"
            }
        ));
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jTable4);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel8.setText("Alimentos");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        agregarA.setText("+");
        agregarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAActionPerformed(evt);
            }
        });

        eliminarA.setText("-");
        eliminarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAActionPerformed(evt);
            }
        });

        jLabel10.setText("filtro");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayuno", "Almuerzo", "Merienda", "Cena" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Dia");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregarA, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarA, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(agregarA, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarA, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))
                        .addContainerGap())))
        );

        labelPesoActual.setText("Peso actual");

        labelIMC.setText("IMC");

        labelTalla.setText("Talla");

        labelDNI.setText("DNI");

        labelPaciente.setText("Nombre");

        labelEdad.setText("Edad");

        jbRegistrarPeso.setText("Registrar peso");
        jbRegistrarPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegistrarPesoActionPerformed(evt);
            }
        });

        jbProgreso.setText("Progreso");
        jbProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProgresoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDNI)
                            .addComponent(labelTalla)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jbProgreso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbRegistrarPeso)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIMC)
                    .addComponent(labelEdad)
                    .addComponent(labelPesoActual))
                .addGap(137, 137, 137))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPaciente)
                    .addComponent(labelEdad))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTalla)
                    .addComponent(labelPesoActual))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDNI)
                    .addComponent(labelIMC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbProgreso)
                    .addComponent(jbRegistrarPeso))
                .addContainerGap())
        );

        btnBaja.setText("Eliminar");
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaDietas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaDietas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaDietas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDietasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaDietas);

        jLabel11.setText("Dieta");

        checkboxActivas.setText("Finalizada");
        checkboxActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxActivasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkboxActivas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jButton1)
                    .addComponent(btnBaja)
                    .addComponent(checkboxActivas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        vista_crear_dietas vd = new vista_crear_dietas(this.paciente);
        Principal.showFrame(vd, "Nueva dieta");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkboxActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxActivasActionPerformed
        llenarTablaDietas(null);        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxActivasActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        var dieta = (Dieta) getDietaSeleccionada();
        if (dieta == null || dieta.getBaja() == true) {
            return;
        }

        var res = JOptionPane.showConfirmDialog(null,
                "¿Realmente desea dar de baja la dieta seleccionada?",
                "Confirmar",
                YES_NO_OPTION
        );
        if (res != 0) {
            return;
        }

        dieta.setFechaFinal(LocalDate.now());
        dieta.setBaja(true);
        dieta.setPesoFinal(paciente.getPesoActual());
        repoDieta.update(dieta);
        llenarTablaDietas(null);
        if (tablaDietas.getRowCount() == 0) {
            jButton1.setVisible(true);
        }
        jComboBox1.removeAllItems();

    }//GEN-LAST:event_btnBajaActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        cargarRenglones();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void eliminarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAActionPerformed
        var x = jTable4.getSelectedRow();
        var ren = (RenglonDeMenu) jTable4.getValueAt(x, 0);
        if (ren == null) {
            return;
        }
        repoRenglones.delete(ren.getCodRenglon());
        cargarRenglones();
    }//GEN-LAST:event_eliminarAActionPerformed

    private void tablaDietasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDietasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaDietasMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        cargarRenglones();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jbProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProgresoActionPerformed
        ProgresoPaciente vistaEstadisticas = new ProgresoPaciente(this.paciente);
        Principal.showFrame(vistaEstadisticas, "Progreso del paciente");
    }//GEN-LAST:event_jbProgresoActionPerformed

    private void jbRegistrarPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegistrarPesoActionPerformed
        RegistrarPeso actPaciente = new RegistrarPeso(this.paciente);
        Principal.showFrame(actPaciente, "Registrar peso");
    }//GEN-LAST:event_jbRegistrarPesoActionPerformed

    private void agregarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAActionPerformed
        // TODO add your handling code here:
        crearRenglon();
    }//GEN-LAST:event_agregarAActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            crearRenglon();
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        var pattern = jTextField1.getText().trim().toLowerCase();
        var alimentos = repoAlimentos.listarAlimentos().stream()
                .filter(alimento -> alimento.getNombre().toLowerCase().contains(pattern))
                .toList();
        cargarAlimentos(alimentos);
    }//GEN-LAST:event_jTextField1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarA;
    private javax.swing.JButton btnBaja;
    private javax.swing.JCheckBox checkboxActivas;
    private javax.swing.JButton eliminarA;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<MenuDiario> jComboBox1;
    private javax.swing.JComboBox<Object> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbProgreso;
    private javax.swing.JButton jbRegistrarPeso;
    private javax.swing.JLabel labelDNI;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelIMC;
    private javax.swing.JLabel labelPaciente;
    private javax.swing.JLabel labelPesoActual;
    private javax.swing.JLabel labelTalla;
    private javax.swing.JTable tablaDietas;
    // End of variables declaration//GEN-END:variables

    public void llenarTablaDietas(List<Dieta> dietas) {
        var header = new String[]{"Nombre", "Calorias", "Peso objetivo", "Fecha inicio", "Estado"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        tablaDietas.setModel(model);

        if (dietas == null) {
            dietas = repoDieta.getByPacienteanddieta(paciente.getNroPaciente(), checkboxActivas.isSelected());
            if (!dietas.isEmpty()) {
                jButton1.setVisible(false);
            }
        }
        btnBaja.setVisible(!checkboxActivas.isSelected());

        for (var dieta : dietas) {
            model.addRow(new Object[]{
                dieta,
                dieta.getTotalCalorias(),
                dieta.getPesoObjetivo(),
                dieta.getFechaInicio(),
                dieta.getBaja() ? "Finalizada" : "En curso"
            });
        }
        if (model.getRowCount() > 0) {
            jComboBox1.setModel(new DefaultComboBoxModel(
                    repoMenu.obtenerMenusPorDieta(
                            getDietaSeleccionada().getCodDieta()).toArray()
            )
            );
        }
        cargarRenglones();
    }

    public Dieta getDietaSeleccionada() {
        Dieta dieta = null;
        try {
            var y = tablaDietas.getSelectedRow();
            y = y < 0 ? 0 : y;
            dieta = (Dieta) tablaDietas.getValueAt(y, 0);
        } catch (Exception ex) {
        }
        return dieta;
    }

    public void cargarRenglones() {
        var tb = jTable4;
        var header = new String[]{"Alimento", "Gramos", "T. Calorias"};
        var model = new DefaultTableModel(header, 0);
        tb.setModel(model);

        var menu = (MenuDiario) jComboBox1.getSelectedItem();
        if (menu == null) {
            return;
        }
        var horario = (String) jComboBox2.getSelectedItem();
        var renglones = repoRenglones.buscarpormenu(menu.getCodMenu());

        for (var ren : renglones) {
            if (ren.getHorario().equals(horario)) {
                System.out.println(ren.getAlimento());
                model.addRow(new Object[]{
                    ren,
                    ren.getCantidadGrs(),
                    ren.getSubTotalCalorias()
                });
            }

        }

    }

    public void cargarAlimentos(List<Alimento> alimentos) {
        Object header[] = {"Nombre", "Calorias"};
        var model = new DefaultTableModel(header, 0);
        jTable2.setModel(model);
        if (alimentos == null) {
            alimentos = repoAlimentos.listarAlimentos();
        }
        alimentos.forEach(alimento -> {
            model.addRow(new Object[]{alimento, alimento.getCaloriasPor100g()});
        });

    }

}