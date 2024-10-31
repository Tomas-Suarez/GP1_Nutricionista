/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.Principal;

public class Temas {

    private static Principal principal;

    public static void main(String[] args) {
        Principal.cambiarTema(0); //</editor-fold>

        /* Create and display the form */


    }

    public static void setPrincipal(int x) {
        principal = new Principal();
                
        var comboBox = principal.getJcSeleccionarTema();
        //settear
        comboBox.addActionListener((e) -> {
            setPrincipal(comboBox.getSelectedIndex());
            principal.dispose();
            principal.cambiarTema(comboBox.getSelectedIndex());
            
        });
        principal.setVisible(true);
        
    }

    public static Principal getPrincipal() {
        return principal;
    }




}
