package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import utils.Config;

public final class Conexion {

    private static Conexion obj = null;
    private static Connection conn = null;
    private static String url, usuario, password, options;

    private Conexion() {
        url = "jdbc:mariadb://" + Config.getDbURL();
        usuario = Config.getDbUser();
        password = Config.getDbPasswd();
        options = "?" + String.join("&", new String[]{
            "allowPublicKeyRetrieval=true",
            "useLegacyDatetimeCode=false",
            "serverTimezone=UTC",
            "user=" + usuario,
            "password=" + password
        });
    }

    public static Connection getConexion() {
        if (obj == null) {
            obj = new Conexion();
        }
        try {
            if (conn == null || !conn.isValid(1)) {
                conn = DriverManager.getConnection(url + options);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            var title = "Error de conexión";
            var msg = "Ocurrió un error al conectar con la base de datos.\n¿Volver a intentar?";
            var res = JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_NO_OPTION);
            if (res == 0) {
                obj = null;
                return getConexion();
            } else {
                System.exit(0);
            }
        }
        return conn;
    }
}
