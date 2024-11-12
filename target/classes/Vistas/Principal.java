package Vistas;

import Vistas.Alimento.ListaAlimento;
import Vistas.Dieta.vista_crear_dietas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Principal extends javax.swing.JFrame {
    
    JPanel k;
    
    /**
     * Creates new form Principal
     */
    private static Principal principal;

    private Principal() {
        initComponents();
        
        /*this.setLocationRelativeTo(null);
        Panelimagen mImagen = new Panelimagen(Tablero, "/icon/alim.png");
        Tablero.add(mImagen).repaint();
        Tablero.setOpaque(false);
        Tablero.setBorder(null);
        Tablero.setBackground(new Color(0,0,0,0));*/
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
        logo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cambiarTema = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1150, 700));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        buttonGroup3.add(bPaciente);
        bPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/paciente.png"))); // NOI18N
        bPaciente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bPaciente.setIconTextGap(2);
        bPaciente.setInheritsPopupMenu(true);
        bPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPacienteActionPerformed(evt);
            }
        });

        buttonGroup3.add(bAlimento);
        bAlimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/comida.png"))); // NOI18N
        bAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlimentoActionPerformed(evt);
            }
        });

        buttonGroup3.add(bConsultas);
        bConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/estatsnegro.png"))); // NOI18N
        bConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultasActionPerformed(evt);
            }
        });

        Tablero.setPreferredSize(new java.awt.Dimension(800, 500));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/alimsinderechos.png"))); // NOI18N

        javax.swing.GroupLayout TableroLayout = new javax.swing.GroupLayout(Tablero);
        Tablero.setLayout(TableroLayout);
        TableroLayout.setHorizontalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TableroLayout.createSequentialGroup()
                .addContainerGap(421, Short.MAX_VALUE)
                .addComponent(logo)
                .addContainerGap(421, Short.MAX_VALUE))
        );
        TableroLayout.setVerticalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TableroLayout.createSequentialGroup()
                .addContainerGap(265, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pacientes");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Alimentos");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Consultas");

        cambiarTema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sol.png"))); // NOI18N
        cambiarTema.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cambiarTemaStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bAlimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bConsultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cambiarTema, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cambiarTema, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
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

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
        Panelimagen mImagen = new Panelimagen(Tablero, "/icon/alim.png");
        Tablero.setSize(getWidth() - 150, getHeight() - 50);
        
        if (k != null) {
            logo.setVisible(false);
            k.setSize(Tablero.getWidth(), Tablero.getHeight());
            k.setLocation(0, 0);

            Tablero.removeAll();
            Tablero.add(k, BorderLayout.CENTER);
            Tablero.revalidate();
            Tablero.repaint();
        }else {logo.setVisible(true);}
    }//GEN-LAST:event_formComponentResized

    private void cambiarTemaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cambiarTemaStateChanged
        // TODO add your handling code here:
        if (cambiarTema.isSelected()){
            cambiarTema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/luna.png")));
        }else{
        cambiarTema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sol.png")));
        }
    }//GEN-LAST:event_cambiarTemaStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Tablero;
    private javax.swing.JToggleButton bAlimento;
    private javax.swing.JToggleButton bConsultas;
    private javax.swing.JToggleButton bPaciente;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JToggleButton cambiarTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables

   

    public JToggleButton getjToggleButton1() {
        return cambiarTema;
    }

    
    public void ShowPanel(JPanel p) {
        k = p;
        p.setSize(Tablero.getWidth(), Tablero.getHeight());
        p.setLocation(0, 0);

        Tablero.removeAll();
        Tablero.add(p, BorderLayout.CENTER);
        Tablero.revalidate();
        Tablero.repaint();
    }

    public static void showFrame(JPanel p, String nameFrame) {
        JFrame nuevaVista = new JFrame(nameFrame);
        nuevaVista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevaVista.getContentPane().add(p);
        nuevaVista.pack();
        nuevaVista.setVisible(true);
        
        nuevaVista.setLocation(585, 60);
    }
    
    public JPanel getTablero() {
        return Tablero;
    }
    
}
