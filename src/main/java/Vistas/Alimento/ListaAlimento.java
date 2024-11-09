/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas.Alimento;

import Modelo.Alimento;
import Persistencia.AlimentoData;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franco
 */
public class ListaAlimento extends javax.swing.JPanel {

    private AlimentoData AliData;
    private DefaultTableModel tablas = new DefaultTableModel();

    /**
     * Creates new form ListaAlimento
     */
    public ListaAlimento() {
        AliData = AlimentoData.getRepo();
        initComponents();
        TablaAlimento();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jtBuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAlimento = new javax.swing.JTable();
        jrActivo = new javax.swing.JRadioButton();
        jrNoActivo = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(800, 430));

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

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbBorrar.setText("Borrar");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        tAlimento.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tAlimento);

        buttonGroup1.add(jrActivo);
        jrActivo.setSelected(true);
        jrActivo.setText("Activos");
        jrActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrActivoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrNoActivo);
        jrNoActivo.setText("No activos");
        jrNoActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrNoActivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBorrar)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240)
                .addComponent(jrActivo)
                .addGap(34, 34, 34)
                .addComponent(jrNoActivo)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrActivo)
                    .addComponent(jrNoActivo)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditar)
                    .addComponent(jbNuevo)
                    .addComponent(jbBorrar))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBuscarActionPerformed

    private void jtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarKeyReleased
        TablaAlimento();
    }//GEN-LAST:event_jtBuscarKeyReleased

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        DetallesAlimento actPaciente = new DetallesAlimento(this);

        JFrame nuevaVista = new JFrame("Nuevo alimento");
        nuevaVista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevaVista.getContentPane().add(actPaciente);
        nuevaVista.pack();
        nuevaVista.setVisible(true);
        nuevaVista.setLocation(585, 60); //Mover el Panel por cordenadas*/
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        int rowSelected = tAlimento.getSelectedRow();
        if (rowSelected != -1) { // Nos sirve para verificar si la tabla esta seleccionada
            if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de borrar al paciente de forma permanente?") == 0) {

                Alimento alimento = (Alimento) tablas.getValueAt(rowSelected, 0);
                AliData.remove(alimento.getCodComida());
                TablaAlimento();

            }
        }

    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int rowSelected = tAlimento.getSelectedRow();

        if (rowSelected != -1) { // Nos sirve para verificar si la tabla esta seleccionada

            Alimento alimento = (Alimento) tablas.getValueAt(rowSelected, 0);

            DetallesAlimento actAlimento = new DetallesAlimento(this, alimento);

            JFrame nuevaVista = new JFrame("Actualizar alimento");
            nuevaVista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            nuevaVista.getContentPane().add(actAlimento);
            nuevaVista.pack();
            nuevaVista.setVisible(true);
            nuevaVista.setLocation(585, 60);

        } else {
            JOptionPane.showMessageDialog(null, "seleccione");
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jrActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrActivoActionPerformed
        TablaAlimento();
    }//GEN-LAST:event_jrActivoActionPerformed

    private void jrNoActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrNoActivoActionPerformed
        TablaAlimento();
    }//GEN-LAST:event_jrNoActivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JRadioButton jrActivo;
    private javax.swing.JRadioButton jrNoActivo;
    private javax.swing.JTextField jtBuscar;
    private javax.swing.JTable tAlimento;
    // End of variables declaration//GEN-END:variables

    public void TablaAlimento() {
        String tablaHeader[] = {"Nombre", "Tipo", "Calorias x100Grs", "Detalle", "Estado"};
        tablas.setColumnIdentifiers(tablaHeader);
        tAlimento.setModel(tablas); //Le asiganamos el modelo a la tabla
        tAlimento.setDefaultEditor(Object.class, null); // Deshabilita la edicion de celdas

        tablas.setRowCount(0); //Es para que cada vez q llamemos la tabla, no se duplique

        String nombre = jtBuscar.getText().toLowerCase().trim();
        List<Alimento> AlimentosActivos = AliData.listarAlimentos();
        List<Alimento> listaFiltrada = AlimentosActivos.stream().filter(alimento -> {
            String x = alimento.getNombre() + " " + alimento.getDetalle();
            x = x.toLowerCase();
            return (x.contains(nombre) && jrActivo.isSelected() != alimento.getBaja());
        }).toList();

        for (Alimento alimento : listaFiltrada) {
            tablas.addRow(new Object[]{
                alimento,
                alimento.getTipoComida(),
                alimento.getCaloriasPor100g(),
                alimento.getDetalle(),
                alimento.getBaja() ? "No activo" : "Activo" //Si es TRUE, lo coloca en "No activo", y si es FALSE lo coloca en "Activo"
            });
        }
    }

    
    
}
