package Vistas;

import Vistas.Alimento.ListaAlimento;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class Principal extends javax.swing.JFrame {

    JPanel k;
    /**
     * Creates new form Principal
     */
    private static Principal principal;
    
    private Principal() {
        initComponents();
    }
    
    public static Principal getPrincipal() {
        if (principal == null) {
            principal = new Principal();
        }
        return principal;
    }
    
    public static Principal New() {
        principal = null;
        return getPrincipal();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        bPaciente = new javax.swing.JToggleButton();
        bAlimento = new javax.swing.JToggleButton();
        bConsultas = new javax.swing.JToggleButton();
        Tablero = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jcSeleccionarTema = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1850, 800));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        buttonGroup3.add(bPaciente);
        bPaciente.setText("Paciente");
        bPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPacienteActionPerformed(evt);
            }
        });

        buttonGroup3.add(bAlimento);
        bAlimento.setText("Alimento");
        bAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlimentoActionPerformed(evt);
            }
        });

        buttonGroup3.add(bConsultas);
        bConsultas.setText("Consultas");
        bConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultasActionPerformed(evt);
            }
        });

        Tablero.setPreferredSize(new java.awt.Dimension(800, 500));

        javax.swing.GroupLayout TableroLayout = new javax.swing.GroupLayout(Tablero);
        Tablero.setLayout(TableroLayout);
        TableroLayout.setHorizontalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 824, Short.MAX_VALUE)
        );
        TableroLayout.setVerticalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jcSeleccionarTema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Claro", "Oscuro" }));
        jcSeleccionarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcSeleccionarTemaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bAlimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bConsultas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jcSeleccionarTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(bPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(bPaciente)
                        .addGap(18, 18, 18)
                        .addComponent(bAlimento)
                        .addGap(62, 62, 62)
                        .addComponent(bConsultas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jcSeleccionarTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
            .addComponent(Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPacienteActionPerformed
        Vista_lista_Paciente detPaciente = new Vista_lista_Paciente();
        ShowPanel(detPaciente);
    }//GEN-LAST:event_bPacienteActionPerformed

    private void bAlimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlimentoActionPerformed
        ListaAlimento detAlimento = new ListaAlimento();
        ShowPanel(detAlimento);
    }//GEN-LAST:event_bAlimentoActionPerformed

    private void bConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultasActionPerformed
        GraficoEstadistica grafEstad = new GraficoEstadistica();
        ShowPanel(grafEstad);
        
    }//GEN-LAST:event_bConsultasActionPerformed

    private void jcSeleccionarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcSeleccionarTemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcSeleccionarTemaActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        Tablero.setSize(getWidth()-300, getHeight()-100);
            
        if (k != null) {
        k.setSize(Tablero.getWidth(),Tablero.getHeight());
        k.setLocation(0, 0);
        
        Tablero.removeAll();
        Tablero.add(k, BorderLayout.CENTER);
        Tablero.revalidate();
        Tablero.repaint();
        }
    }//GEN-LAST:event_formComponentResized


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Tablero;
    private javax.swing.JToggleButton bAlimento;
    private javax.swing.JToggleButton bConsultas;
    private javax.swing.JToggleButton bPaciente;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcSeleccionarTema;
    // End of variables declaration//GEN-END:variables

    public JComboBox getJcSeleccionarTema() {
        return jcSeleccionarTema;
    }

    public void ShowPanel(JPanel p) {
        k=p;
        p.setSize(Tablero.getWidth(),Tablero.getHeight());
        p.setLocation(0, 0);

        Tablero.removeAll();
        Tablero.add(p, BorderLayout.CENTER);
        Tablero.revalidate();
        Tablero.repaint();
    }

        // El metodo retorna TRUE si todos los campos están llenos. Y en caso contrario retornara FALSE
    public boolean validarCamposVacios(JPanel jPanel) {
        for (Component c : jPanel.getComponents()) { //Se fija en los TextField
            System.out.println(c.getName() + c.getClass());
            if (c instanceof JTextField) {
                JTextField caja = (JTextField) c;
                if (caja.getText().trim().isEmpty()) {
                    return false;
                }
            } else if (c instanceof JSpinner) { //Se fija en los Spinner
                JSpinner spinner = (JSpinner) c;
                Number value = (Number) spinner.getValue();
                if (value.floatValue() <= 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
