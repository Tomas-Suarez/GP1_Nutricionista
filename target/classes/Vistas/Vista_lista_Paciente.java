/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Modelo.Paciente;
import Persistencia.DietaData;
import Persistencia.PacienteData;
import Vistas.Dieta.DietaVista;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cisco
 */
public class Vista_lista_Paciente extends javax.swing.JPanel {

    private DefaultTableModel tablas = new DefaultTableModel();
    private PacienteData pacData = PacienteData.getRepo();
    private DietaData dietaData = DietaData.getRepo();

    /**
     * Creates new form DetallesPaciente
     */
    public Vista_lista_Paciente() {
        initComponents();
        
        TablaPaciente(!jrActivo.isSelected());

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner2 = new javax.swing.JSpinner();
        groupBaja = new javax.swing.ButtonGroup();
        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        tuto = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPaciente = new javax.swing.JTable();
        jrActivo = new javax.swing.JRadioButton();
        jrNoActivo = new javax.swing.JRadioButton();
        jtBuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setPreferredSize(new java.awt.Dimension(800, 430));

        tuto.setText("Doble click para administrar el paciente");

        jbNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/agregar16x16.png"))); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/borrado.png"))); // NOI18N
        jbBorrar.setText("Borrar");
        jbBorrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jbEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editar.png"))); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        tPaciente.setModel(new javax.swing.table.DefaultTableModel(
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
        tPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tPaciente);

        groupBaja.add(jrActivo);
        jrActivo.setSelected(true);
        jrActivo.setText("Activos");
        jrActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrActivoActionPerformed(evt);
            }
        });

        groupBaja.add(jrNoActivo);
        jrNoActivo.setText("No activos");
        jrNoActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNoActivoActionPerformed(evt);
            }
        });

        jtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBuscarActionPerformed(evt);
            }
        });
        jtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarKeyReleased(evt);
            }
        });

        jLabel8.setText("BUSCAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tuto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                        .addComponent(jrActivo)
                        .addGap(18, 18, 18)
                        .addComponent(jrNoActivo)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrActivo)
                    .addComponent(jrNoActivo)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(tuto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jrActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrActivoActionPerformed
        TablaPaciente(false);
        jbBorrar.setText("Borrar");
        jbEditar.setEnabled(true);
    }//GEN-LAST:event_jrActivoActionPerformed

    private void jrNoActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNoActivoActionPerformed
        TablaPaciente(true);
        jbBorrar.setText("Restaurar");
        jbEditar.setEnabled(false);
    }//GEN-LAST:event_jrNoActivoActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        ActualizarPaciente newPaciente = new ActualizarPaciente(this);
        Principal.showFrame(newPaciente, "Nuevo paciente");
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int rowSelected = tPaciente.getSelectedRow();

        if (rowSelected != -1) { // Nos sirve para verificar si la tabla esta seleccionada

            Paciente pacienteSelect = (Paciente) tPaciente.getValueAt(rowSelected, 0);

            ActualizarPaciente actPaciente = new ActualizarPaciente(pacienteSelect, this);

            Principal.showFrame(actPaciente, "Actualizar paciente");

        } else {
            JOptionPane.showMessageDialog(null, "Primero debe seleccionar un paciente...");
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        int rowSelected = tPaciente.getSelectedRow();

        if (rowSelected != -1) { // Verifica si hay una fila seleccionada
            Paciente pacienteSelect = (Paciente) tPaciente.getValueAt(rowSelected, 0);

            if (jrActivo.isSelected()) {
                if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de borrar al paciente?") == 0) {
                    pacienteSelect.setBaja(true);
                    pacData.actualizarPaciente(pacienteSelect);
                    TablaPaciente(false);
                }
            } else {
                if (JOptionPane.showConfirmDialog(null, "¿Estás seguro de restaurar al paciente?") == 0) {
                    pacienteSelect.setBaja(false);
                    pacData.actualizarPaciente(pacienteSelect);
                    TablaPaciente(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Primero debe seleccionar un paciente...");
        }


    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarKeyReleased
        TablaPaciente(!jrActivo.isSelected());
    }//GEN-LAST:event_jtBuscarKeyReleased

    private void jtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBuscarActionPerformed

    private void tPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPacienteMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            DietaVista detallePaciente = new DietaVista(getPacienteSeleccionado());
            var principal = Principal.getPrincipal();
            principal.ShowPanel(detallePaciente);
        }
    }//GEN-LAST:event_tPacienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup groupBaja;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JRadioButton jrActivo;
    private javax.swing.JRadioButton jrNoActivo;
    private javax.swing.JTextField jtBuscar;
    private javax.swing.JTable tPaciente;
    private javax.swing.JLabel tuto;
    // End of variables declaration//GEN-END:variables

    public void TablaPaciente(boolean estado) {
        String tablaHeader[] = {"Nombre", "DNI", "Edad", "Altura", "Peso", "Estado"};
        tablas.setColumnIdentifiers(tablaHeader);
        tPaciente.setModel(tablas); //Le asiganamos el modelo a la tabla
        tPaciente.setDefaultEditor(Object.class, null); // Deshabilita la edicion de celdas

        tablas.setRowCount(0); //Es para que cada vez q llamemos la tabla, no se duplique

        String nombre = jtBuscar.getText().toLowerCase().trim();
        List<Paciente> pacientesActivos = pacData.listarPacientesBaja(!jrActivo.isSelected());
        List<Paciente> listaFiltrada = pacientesActivos.stream().filter(paciente -> {
            String x = paciente.getNombre() + " " + paciente.getDni();
            x = x.toLowerCase();
            return x.contains(nombre);
        }).toList();

        for (Paciente paciente : listaFiltrada) {
            tablas.addRow(new Object[]{
                paciente,
                paciente.getDni(),
                paciente.getEdad(),
                paciente.getAltura(),
                paciente.getPesoActual(),
                paciente.isBaja() ? "No activo" : "Activo" //Si es TRUE, lo coloca en "No activo", y si es FALSE lo coloca en "Activo"
            });
        }
    }

    public Paciente getPacienteSeleccionado() {
        int rowSelected = tPaciente.getSelectedRow();
        Paciente pac = null;
        if (rowSelected != -1) { // Verifica si hay una fila seleccionada
            Paciente pacienteSelect = (Paciente) tPaciente.getValueAt(rowSelected, 0);
            pac = pacienteSelect;
        }
        return pac;
    }

    public JRadioButton getJrActivo() {
        return jrActivo;
    }

    public void setJrActivo(JRadioButton jrActivo) {
        this.jrActivo = jrActivo;
    }

    public JRadioButton getJrNoActivo() {
        return jrNoActivo;
    }

    public void setJrNoActivo(JRadioButton jrNoActivo) {
        this.jrNoActivo = jrNoActivo;
    }

}
