package Vistas;

import utils.Panelimagen;
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
        Tablero = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cambiarTema = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        bConsultas = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bAlimento = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bPaciente = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1150, 700));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        Tablero.setPreferredSize(new java.awt.Dimension(800, 500));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/alimsinderechos.png"))); // NOI18N

        javax.swing.GroupLayout TableroLayout = new javax.swing.GroupLayout(Tablero);
        Tablero.setLayout(TableroLayout);
        TableroLayout.setHorizontalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TableroLayout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addComponent(logo)
                .addContainerGap(410, Short.MAX_VALUE))
        );
        TableroLayout.setVerticalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TableroLayout.createSequentialGroup()
                .addContainerGap(265, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        cambiarTema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sol.png"))); // NOI18N
        cambiarTema.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cambiarTemaStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup3.add(bConsultas);
        bConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/estatsnegro.png"))); // NOI18N
        bConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultasActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("General");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bConsultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(bConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup3.add(bAlimento);
        bAlimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/comida.png"))); // NOI18N
        bAlimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlimentoActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Alimentos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAlimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bAlimento, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pacientes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cambiarTema, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cambiarTema, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jSeparator1)))
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
