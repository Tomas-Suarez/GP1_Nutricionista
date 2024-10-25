package Persistencia;

import Modelo.Dieta;
import Modelo.MenuDiario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MenuDiarioData {

    private Connection con = null;
    private static MenuDiario object = null;

    public MenuDiarioData() {
        con = Conexion.getConexion();
    }

    public static MenuDiario getRepo() {
        if (object == null) {
            object = new MenuDiario();
        }
        return object;
    }

    public void agregarMenuDiario(MenuDiario menu) {
        String sql = "INSERT INTO menudiario(dia, calorias, idDieta, baja) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, menu.getDia());
            ps.setInt(2, menu.getCaloriasDelMenu());
            ps.setInt(3, menu.getDieta().getCodDieta());
            ps.setBoolean(4, menu.isBaja());

            ps.execute();

            //Agregamos las claves primarias (En caso que sea necesario)
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                menu.setCodMenu(rs.getInt(1));
            }

            rs.close();
            ps.close();

            JOptionPane.showMessageDialog(null, "El Menu diario fue agregado exitosamente!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al agregar el Menu diario");
        }

    }

    public void modificarMenuDiario(MenuDiario menu) throws SQLException {
        String sql = "UPDATE menudiario SET dia = ?, calorias = ?, baja = ?, idDieta = ? WHERE idMenu = ?;";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, menu.getDia());
            ps.setInt(2, menu.getCaloriasDelMenu());
            ps.setBoolean(3, menu.isBaja());
            ps.setInt(4, menu.getDieta().getCodDieta());
            ps.setInt(5, menu.getCodMenu());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El menu diario fue modificado correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el menú diario a modificar.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar el menu diario: " + e.getMessage());
        }
    }

    //Retonamos una lista del menuDiario los que estan de baja
    public List<MenuDiario> MenuDiarioBaja(boolean baja) {
        ArrayList<MenuDiario> menusDiariosBaja = new ArrayList<>();
        String sql;

        if (baja) { //Si la condicion se cumple, se le da de baja 
            sql = "SELECT * FROM menudiario WHERE baja = true;";
        } else {//Si la condicion no se cumple, no se le dara de baja (Osea quedara Activo)
            sql = "SELECT * FROM menudiario WHERE baja = false;";
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MenuDiario menu = new MenuDiario();

                menu.setCodMenu(rs.getInt("idMenu"));
                menu.setDia(rs.getInt("dia"));
                menu.setCaloriasDelMenu(rs.getInt("calorias"));
                menu.setBaja(rs.getBoolean("baja"));

                Dieta dieta = new Dieta();
                dieta.setCodDieta(rs.getInt("idDieta"));
                menu.setDieta(dieta);

                menusDiariosBaja.add(menu);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar Menu Diario dado de baja: " + e.getMessage());
        }

        return menusDiariosBaja;
    }

    public MenuDiario buscarMenuComida(int id) {
        String sql = "SELECT * FROM menudiario WHERE idMenu = ?";
        MenuDiario menu = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                menu = new MenuDiario();

                menu.setCodMenu(rs.getInt("idMenu"));
                menu.setDia(rs.getInt("dia"));
                menu.setCaloriasDelMenu(rs.getInt("calorias"));

                Dieta dieta = new Dieta();
                dieta.setCodDieta(rs.getInt("idDieta"));
                menu.setDieta(dieta);
            }

            if (menu != null) {
                JOptionPane.showMessageDialog(null, "Menu diario encontrado!");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ningun menu diario.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar el Menu Comida: " + e.getMessage());
        }
        return menu;
    }

    public List<MenuDiario> obtenerMenusPorDieta(int idDieta) {
        ArrayList<MenuDiario> MenusxDieta = new ArrayList<>();
        String sql = "SELECT * FROM menudiario WHERE idDieta = ? AND baja = false;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MenuDiario menu = new MenuDiario();

                menu.setCodMenu(rs.getInt("idMenu"));
                menu.setDia(rs.getInt("dia"));
                menu.setCaloriasDelMenu(rs.getInt("calorias"));
                menu.setBaja(rs.getBoolean("baja"));

                Dieta dieta = new Dieta();
                dieta.setCodDieta(idDieta);
                menu.setDieta(dieta);

                MenusxDieta.add(menu);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar Menu Diario: " + e.getMessage());
        }

        return MenusxDieta;
    }

}
