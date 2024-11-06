/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.Principal;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import utils.Config;

public class Temas {

    public static void main(String[] args) {//el indice deberia cambiar con el valor del "archivo", falta eso
        int temaGuardado = cargarTemaGuardado();
        setPrincipal(Config.getTheme());
    }

    public static void setPrincipal(int x) {
        cambiarTema(x);

        var principal = Principal.New();

        var comboBox = principal.getJcSeleccionarTema();
        comboBox.setSelectedIndex(x);

        comboBox.addActionListener((e) -> {
            principal.dispose();
            Config.setTheme(comboBox.getSelectedIndex());
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

    public static void guardar_tema(int indiceTema) {
        try {
            BufferedWriter archivo = new BufferedWriter(new FileWriter("./config.txt", false));
            archivo.write(String.valueOf(indiceTema));
            archivo.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el tema: " + e.getMessage());
        }
    }

    public static int cargarTemaGuardado() {
        try {
            BufferedReader archivo = new BufferedReader(new FileReader("./config.txt"));
            String linea = archivo.readLine();
            return (linea != null) ? Integer.parseInt(linea) : 0; // Nos devuelve el valor leído o 0 si es null
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al cargar el tema: " + e.getMessage());
        }
        return 0;
    }

}
