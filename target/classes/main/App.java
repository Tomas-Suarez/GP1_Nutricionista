package main;

import Vistas.Principal;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import utils.Config;

/**
 *
 * @author cisco
 */
public class App {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                init();
            }
        });
    }

    private static void init() {
        Config conf = Config.getInstance();
        setUpTheme();
        var principal = Principal.New();
        var comboBox = principal.getJcSeleccionarTema();

        var theme = conf.getTheme();
        comboBox.setSelectedIndex(theme);
        comboBox.addActionListener((e) -> {
            conf.setTheme(comboBox.getSelectedIndex());
            principal.dispose();
            init();
        });

        principal.setVisible(true);
    }

    public static void setUpTheme() {
        var theme = Config.getInstance().getTheme();
        try {
            if (theme == 0) {
                UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
            } else {
                UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
            }
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un error al cambiar el tema!");
        }
    }
}
