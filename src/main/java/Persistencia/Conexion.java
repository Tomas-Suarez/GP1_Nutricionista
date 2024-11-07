package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import utils.Config;

public final class Conexion {

    private static Connection conn;
    private static String url, usuario, password, options;

    private Conexion() {
    }

    public static Connection getConexion() {
        Config config = Config.getInstance();
        
        try {
            if (conn == null || !conn.isValid(1)) {
                url = "jdbc:mariadb://" + config.getDbURL();
                usuario = config.getDbUser();
                password = config.getDbPasswd();
                options = "?" + String.join("&", new String[]{
                    "allowPublicKeyRetrieval=true",
                    "useLegacyDatetimeCode=false",
                    "serverTimezone=UTC",
                    "user=" + usuario,
                    "password=" + password
                });
                conn = DriverManager.getConnection(url + options);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            var title = "Error de conexión";
            var msg = "Ocurrió un error al conectar con la base de datos.\n¿Volver a intentar?";
            var res = JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_NO_OPTION);
            if (res == 0) {
                config.reload();
                return getConexion();
            } else {
                System.exit(0);
            }
        }
        return conn;
    }
}
