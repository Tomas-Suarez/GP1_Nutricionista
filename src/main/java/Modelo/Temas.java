/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.Principal;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Temas {

    private static Principal principal;

    public static void main(String[] args) {//el indice deberia cambiar con el valor del "archivo", falta eso
        setPrincipal(0); 
    }

    public static void setPrincipal(int x) {
                cambiarTema(x);
        principal = new Principal();

        var comboBox = principal.getJcSeleccionarTema();
        comboBox.setSelectedIndex(x);

        comboBox.addActionListener((e) -> {
            principal.dispose();
            cambiarTema(comboBox.getSelectedIndex());
            setPrincipal(comboBox.getSelectedIndex());
        });
        principal.setVisible(true);
    }

    public static void cambiarTema(int objSelect) {
        try {
            if (objSelect == 0) {
                UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
            } else {
                UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al cambiar el tema!");
        }

    }

}
