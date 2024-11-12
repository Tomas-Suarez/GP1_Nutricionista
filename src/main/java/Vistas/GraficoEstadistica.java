/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Persistencia.PacienteData;
import Persistencia.RegistroData;
import chart.ModelChart;
import java.awt.Color;
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
        seleccionGraficos();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graficoGeneral = new chart.Chart();
        jLabel3 = new javax.swing.JLabel();
        jcGraficos = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(430, 800));

        graficoGeneral.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("DATOS GENERALES");

        jcGraficos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Progreso general", "Rango de edades", "Promedio Alturas", "Promedio edades" }));
        jcGraficos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcGraficosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jLabel3)
                        .addGap(116, 116, 116))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(graficoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jcGraficos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcGraficos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(graficoGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcGraficosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcGraficosActionPerformed
        seleccionGraficos();
    }//GEN-LAST:event_jcGraficosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private chart.Chart graficoGeneral;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> jcGraficos;
    // End of variables declaration//GEN-END:variables

    public void graficoProgresoGeneral() {
        int estadoRegis[] = regisData.EstadoPaciente();
        graficoGeneral.addLegend("Alcanzo el peso", new Color(5, 125, 0), new Color(95, 209, 69));
        graficoGeneral.addLegend("No alcanzo el peso", new Color(186, 37, 37), new Color(241, 100, 120));
        graficoGeneral.addLegend("En progreso", new Color(12, 84, 175), new Color(0, 108, 247));

        graficoGeneral.addData(new ModelChart("", new double[]{estadoRegis[0], estadoRegis[1], estadoRegis[2]}));

        graficoGeneral.start();
    }

    public void graficoEdades() {
        int edadesPaciente[] = pacData.edadesPaciente();
        graficoGeneral.addLegend("Niños y adolescentes: 0 - 17 años", new Color(12, 84, 175), new Color(0, 108, 247));
        graficoGeneral.addLegend("Jovenes adultos: 18 - 54 años", new Color(54, 4, 143), new Color(104, 49, 200));
        graficoGeneral.addLegend("Adultos mayores: 55 años en adelante", new Color(5, 125, 0), new Color(95, 209, 69));

        graficoGeneral.addData(new ModelChart("", new double[]{edadesPaciente[0], edadesPaciente[1], edadesPaciente[2]}));

        graficoGeneral.start();
    }

    public void graficoPromedioEdades() {
        double promedioEdades[] = pacData.promedioEdades();
        graficoGeneral.addLegend("Niños y adolescentes: 0 - 17 años", new Color(12, 84, 175), new Color(0, 108, 247));
        graficoGeneral.addLegend("Jovenes adultos: 18 - 54 años", new Color(54, 4, 143), new Color(104, 49, 200));
        graficoGeneral.addLegend("Adultos mayores: 55 años en adelante", new Color(5, 125, 0), new Color(95, 209, 69));

        graficoGeneral.addData(new ModelChart("", new double[]{promedioEdades[0], promedioEdades[1], promedioEdades[2]}));

        graficoGeneral.start();
    }
    
    public void graficoPromedioAlturas(){
        double promedioAlturas[] = pacData.promedioAlturas();
        graficoGeneral.addLegend("Niños y adolescentes: 0 - 17 años", new Color(12, 84, 175), new Color(0, 108, 247));
        graficoGeneral.addLegend("Jovenes adultos: 18 - 54 años", new Color(54, 4, 143), new Color(104, 49, 200));
        graficoGeneral.addLegend("Adultos mayores: 55 años en adelante", new Color(5, 125, 0), new Color(95, 209, 69));

        graficoGeneral.addData(new ModelChart("", new double[]{promedioAlturas[0], promedioAlturas[1], promedioAlturas[2]}));

        graficoGeneral.start();
    }

 

    public void seleccionGraficos() {
        int indice = jcGraficos.getSelectedIndex();
        graficoGeneral.clear();

        switch (indice) {
            case 0:
                graficoProgresoGeneral();
                break;
            case 1:
                graficoEdades();
                break;
            case 2:
                graficoPromedioAlturas();
                break;
            default:
                graficoPromedioEdades();
                break;
        }
    }

}
