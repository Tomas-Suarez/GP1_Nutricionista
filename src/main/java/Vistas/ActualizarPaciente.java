/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Modelo.Paciente;
import Persistencia.PacienteData;
import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tomi
 */
public class ActualizarPaciente extends javax.swing.JPanel {

    private PacienteData pacienteData = PacienteData.getRepo();
    private Paciente paciente;
    private VistaPaciente detPaciente;

    /**
     * Creates new form ActualizarPaciente
     */
    public ActualizarPaciente(VistaPaciente detPaciente) {
        initComponents();

        jLabel1.setText("Nuevo paciente");
        jbActualizar.setText("Crear");
        this.detPaciente = detPaciente;

    }

    public ActualizarPaciente(Paciente paciente, VistaPaciente detPaciente) {
        initComponents();
        jlID.setText(String.valueOf("ID: " + paciente.getNroPaciente()));
        tNombre.setText(paciente.getNombre());
        tDni.setText(String.valueOf(paciente.getDni()));
        jsEdad.setValue(paciente.getEdad());
        tAltura.setText(String.valueOf(paciente.getAltura()));
        tPeso.setText(String.valueOf(paciente.getPesoActual()));
        jcActivo.setSelected(!paciente.isBaja());
        this.paciente = paciente;
        this.detPaciente = detPaciente;

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlID = new javax.swing.JLabel();
        jbExit = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jcActivo = new javax.swing.JCheckBox();
        tPeso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tAltura = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jsEdad = new javax.swing.JSpinner();
        tDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jlID.setText("ID");

        jbExit.setText("Cancelar");

        jbActualizar.setText("ACTUALIZAR");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jcActivo.setText("Activo");

        jLabel6.setText("Peso");

        jLabel5.setText("Altura(cm)");

        jLabel4.setText("Edad");

        jLabel3.setText("DNI");

        jLabel2.setText("Nombre");

        jLabel1.setText("PACIENTE SELECCIONADO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jcActivo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(tAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tDni, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jlID, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbExit)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(183, 183, 183)
                    .addComponent(jLabel6)
                    .addContainerGap(150, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlID))
                .addGap(18, 18, 18)
                .addComponent(jcActivo)
                .addGap(18, 18, 18)
                .addComponent(jbActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbExit)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(93, 93, 93)
                    .addComponent(jLabel6)
                    .addContainerGap(216, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed

        if (jbActualizar.getText().equals("ACTUALIZAR")) {
            actualizarPaciente();
        } else {
            crearPaciente();
        }
        
    }//GEN-LAST:event_jbActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbExit;
    private javax.swing.JCheckBox jcActivo;
    private javax.swing.JLabel jlID;
    private javax.swing.JSpinner jsEdad;
    private javax.swing.JTextField tAltura;
    private javax.swing.JTextField tDni;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tPeso;
    // End of variables declaration//GEN-END:variables

    private void crearPaciente() {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (validarFormulario()) {

            String nombre = tNombre.getText();
            int dni = Integer.parseInt(tDni.getText());
            int edad = (int) jsEdad.getValue();
            float altura = Float.parseFloat(tAltura.getText());
            float pesoActual = Float.parseFloat(tPeso.getText());
            boolean Activo = !jcActivo.isSelected();

            Paciente newPaciente = new Paciente(nombre, dni, edad, altura, pesoActual, Activo);
            JOptionPane.showMessageDialog(this, "Paciente creado correctamente!");
            pacienteData.agregarPaciente(newPaciente);
            detPaciente.TablaPaciente(Activo);
            window.dispose(); //Cerrar la ventana

        }

    }

    private void actualizarPaciente() {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (validarFormulario()) {

            int id = paciente.getNroPaciente();
            String nombre = tNombre.getText();
            int Dni = Integer.parseInt(tDni.getText());
            int edad = (int) jsEdad.getValue();
            float altura = Float.parseFloat(tAltura.getText());
            float peso = Float.parseFloat(tPeso.getText());
            boolean Activo = !jcActivo.isSelected();

            Paciente paciente = new Paciente(id, nombre, Dni, edad, altura, peso, Activo);

            pacienteData.actualizarPaciente(paciente);
            window.dispose(); //Cerrar la ventana
            JOptionPane.showMessageDialog(this, "Paciente actualizado correctamente!");
            detPaciente.TablaPaciente(Activo);
        }
    }

    private boolean validarFormulario() {

        if (tNombre.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "El campo de nombre no debe estar vacio!");
            return false;
        }
        // Validar edad
        try {

            if ((int) jsEdad.getValue() <= 0) {
                JOptionPane.showMessageDialog(this, "El campo de edad debe ser mayor a 0!");
                return false;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Solo se permiten numeros en este campo: " + e);
        }

        //Validar dni
        try {
            if (tDni.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "El campo de DNI no debe estar vacio!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Solo se permiten numeros en este campo: " + e);
        }
        //validar peso
        try {
            if (tPeso.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "El campo de peso no debe estar vacio!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Solo se permiten numeros en este campo: " + e);
        }
        //validar altura
        try {
            if (tAltura.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "El campo de altura no debe estar vacio!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Solo se permiten numeros en este campo: " + e);
        }

        return true;
    }

}
