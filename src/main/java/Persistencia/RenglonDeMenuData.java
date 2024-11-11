/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Alimento;
import Modelo.MenuDiario;
import Modelo.RenglonDeMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author franco
 */
public class RenglonDeMenuData {

    private static RenglonDeMenuData obj = null;
    private Connection con = null;
    private Alimento ali;
    private MenuDiario men;

    public RenglonDeMenuData() {
        con = Conexion.getConexion();

        this.ali = new Alimento();

    }

    public static RenglonDeMenuData getRepo() {
        if (obj == null) {
            obj = new RenglonDeMenuData();
        }
        return obj;
    }

    public RenglonDeMenuData(Connection conexion, Alimento ali, MenuDiario men) {
        this.ali = ali;
        this.con = conexion;
        this.men = men;
    }

    public void agregarRen(RenglonDeMenu dato) {

        String sql = "INSERT INTO renglondemenu(cantidadGrs, subtotalCalorias, idMenu, idAlimento, horario) VALUES (?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, dato.getCantidadGrs());
            ps.setInt(2, dato.getSubTotalCalorias());
            ps.setInt(3, dato.getMenu().getCodMenu());
            ps.setInt(4, dato.getAlimento().getCodComida());
            ps.setString(5, dato.getHorario());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                dato.setCodRenglon(rs.getInt(1));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    public RenglonDeMenu BuscarRenglon(int cod) {
        String sql = "SELECT * FROM renglondemenu where idRenglon = ?;";

        RenglonDeMenu ren = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                ren = new RenglonDeMenu();
                ali = new Alimento();
                men = new MenuDiario();

                ren.setCodRenglon(rs.getInt("idRenglon"));
                ren.setCantidadGrs(rs.getFloat("cantidadGrs"));
                ren.setSubTotalCalorias(rs.getInt("subtotalCalorias"));
                men.setCodMenu(rs.getInt("idMenu"));
                ren.setMenu(men);
                ali.setCodComida(rs.getInt("idAlimento"));
                ren.setAlimento(ali);
                ren.setHorario(rs.getString("horario"));

                rs.close();
                ps.close();

                if (ren != null) {
                    JOptionPane.showMessageDialog(null, "se encontro el renglon");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar el renglon");
                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar el renglon" + e.getMessage());
        }

        return ren;

    }

    public void modificarRen(RenglonDeMenu dato) {

        String sql = "UPDATE renglondemenu SET cantidadGrs = ?, subtotalCalorias = ?, idMenu = ?, idAlimento = ?, horario = ? WHERE idRenglon = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setFloat(1, dato.getCantidadGrs());
            ps.setInt(2, dato.getSubTotalCalorias());
            ps.setInt(3, dato.getMenu().getCodMenu());
            ps.setInt(4, dato.getAlimento().getCodComida());
            ps.setString(5, dato.getHorario());
            ps.setInt(6, dato.getCodRenglon());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al agregar el renglon!" + e.getMessage());
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM renglondemenu WHERE idRenglon = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al acceder a la tabla renglon!" + ex.getMessage());
        }
    }

    public List<RenglonDeMenu> listarrenglon() {

        ArrayList<RenglonDeMenu> listarrenglon = new ArrayList<>();

        String sql = "SELECT * FROM renglondemenu";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RenglonDeMenu ren = new RenglonDeMenu();
                ali = new Alimento();
                men = new MenuDiario();

                ren.setCodRenglon(rs.getInt("idRenglon"));
                ren.setCantidadGrs(rs.getFloat("cantidadGrs"));
                ren.setSubTotalCalorias(rs.getInt("subtotalCalorias"));
                men.setCodMenu(rs.getInt("idMenu"));
                ren.setMenu(men);
                ali.setCodComida(rs.getInt("idAlimento"));
                ren.setAlimento(ali);
                ren.setHorario(rs.getString("horario"));

                listarrenglon.add(ren);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "hubo un error al cargar la lista" + e.getMessage());
        }
        return listarrenglon;
    }

    public List<RenglonDeMenu> buscarporalimento(int id) {

        ArrayList<RenglonDeMenu> listarrenglon = new ArrayList<>();

        String sql = "SELECT * FROM renglondemenu where idAlimento = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RenglonDeMenu ren = new RenglonDeMenu();
                ali = new Alimento();
                men = new MenuDiario();

                ren.setCodRenglon(rs.getInt("idRenglon"));
                ren.setCantidadGrs(rs.getFloat("cantidadGrs"));
                ren.setSubTotalCalorias(rs.getInt("subtotalCalorias"));
                men.setCodMenu(rs.getInt("idMenu"));
                ren.setMenu(men);
                ali.setCodComida(rs.getInt("idAlimento"));
                ren.setAlimento(ali);
                ren.setHorario(rs.getString("horario"));

                listarrenglon.add(ren);

            }
            rs.close();
            ps.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "hubo un error al cargar la lista" + e.getMessage());
        }

        return listarrenglon;
    }

    public List<RenglonDeMenu> buscarpormenu(int id) {

        ArrayList<RenglonDeMenu> listarrenglon = new ArrayList<>();

        String sql = "SELECT * FROM renglondemenu where IdMenu = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RenglonDeMenu ren = new RenglonDeMenu();
                ali = new Alimento();
                men = new MenuDiario();

                ren.setCodRenglon(rs.getInt("idRenglon"));
                ren.setCantidadGrs(rs.getFloat("cantidadGrs"));
                ren.setSubTotalCalorias(rs.getInt("subtotalCalorias"));
                men.setCodMenu(rs.getInt("idMenu"));
                ren.setMenu(men);
                ali.setCodComida(rs.getInt("idAlimento"));
                ren.setAlimento(ali);
                ren.setHorario(rs.getString("horario"));

                listarrenglon.add(ren);
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "hubo un error al cargar la lista " + e.getMessage());
        }

        return listarrenglon;
    }
}
