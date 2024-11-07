/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Modelo.Paciente;
import Modelo.Registro;
import Persistencia.PacienteData;
import Persistencia.RegistroData;
import chart.ModelChart;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tomi
 */
public class GraficoEstadistica extends javax.swing.JPanel {

    private RegistroData regisData = RegistroData.getRepo();
    private PacienteData pacData = PacienteData.getRepo();
    private DefaultTableModel tablas = new DefaultTableModel();

    /**
     * Creates new form GraficoEstadistica
     */
    public GraficoEstadistica() {
        initComponents();
        graficoBarra();
        graficoLinea();
        tablaGrafico();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPaciente = new javax.swing.JTable();
        jtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        graficoProgreso = new chart.Chart();
        jLabel3 = new javax.swing.JLabel();
        graficoLinea = new chart.LineChart();

        setPreferredSize(new java.awt.Dimension(1498, 688));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaPaciente.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPaciente);

        jtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("BUSCAR");

        jLabel2.setText("Doble click para obtener los datos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        graficoProgreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("DATOS GENERALES");

        graficoLinea.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(graficoProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(384, 384, 384))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(graficoLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(graficoProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(graficoLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtBuscarKeyReleased
        tablaGrafico();
    }//GEN-LAST:event_jtBuscarKeyReleased

    private void tablaPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPacienteMouseClicked
        if (evt.getClickCount() == 2) {
            graficoLinea();
        }
    }//GEN-LAST:event_tablaPacienteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chart.LineChart graficoLinea;
    private chart.Chart graficoProgreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtBuscar;
    private javax.swing.JTable tablaPaciente;
    // End of variables declaration//GEN-END:variables

    public void graficoBarra() {
        int estadoRegis[] = regisData.EstadoPaciente();
        graficoProgreso.addLegend("Alcanzo el peso", new Color(5, 125, 0), new Color(95, 209, 69));
        graficoProgreso.addLegend("No alcanzo el peso", new Color(186, 37, 37), new Color(241, 100, 120));
        graficoProgreso.addLegend("En progreso", new Color(12, 84, 175), new Color(0, 108, 247));

        graficoProgreso.addData(new ModelChart("", new double[]{estadoRegis[0], estadoRegis[1], estadoRegis[2]}));

        graficoProgreso.start();
    }

    public void graficoLinea() {    
        graficoLinea.clear(); //La clase anterior fue modificada para limpiar el legend tmb. Si no limpiamos tira error

        int rowSelected = tablaPaciente.getSelectedRow();
        if (rowSelected != -1) {
            Paciente pacienteSelect = (Paciente) tablaPaciente.getValueAt(rowSelected, 0);
            List<Registro> datosRegistro = regisData.RegistroPaciente(pacienteSelect.getNroPaciente());

            graficoLinea.addLegend(pacienteSelect.getNombre(), new Color(54, 4, 143), new Color(104, 49, 200));

            for (Registro regist : datosRegistro) {
                graficoLinea.addData(new ModelChart(regist.getFechaRegistro().toString(), new double[]{regist.getPeso()}));
            }
            graficoLinea.start();
        }

    }

    public void tablaGrafico() {
        String tablaHeader[] = {"Nombre", "DNI", "Edad"};
        tablas.setColumnIdentifiers(tablaHeader);
        tablaPaciente.setModel(tablas); //Le asiganamos el modelo a la tabla
        tablaPaciente.setDefaultEditor(Object.class, null); // Deshabilita la edicion de celdas

        tablas.setRowCount(0); //Es para que cada vez q llamemos la tabla, no se duplique

        String nombre = jtBuscar.getText().toLowerCase().trim();
        List<Paciente> pacientesActivos = pacData.listarPacientesBaja(false);
        List<Paciente> listaFiltrada = pacientesActivos.stream().filter(paciente -> {
            String x = paciente.getNombre() + " " + paciente.getDni();
            x = x.toLowerCase();
            return x.contains(nombre);
        }).toList();

        for (Paciente paciente : listaFiltrada) {
            tablas.addRow(new Object[]{
                paciente,
                paciente.getDni(),
                paciente.getEdad(),});
        }
    }
}
