package Persistencia;

import Modelo.Alimento;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author cisco
 */
public class AlimentoData {

    private Connection connection;
    private static AlimentoData object = null;

    private AlimentoData() {
        this.connection = Conexion.getConexion();
    }

    public static AlimentoData getRepo() {
        if (object == null) {
            object = new AlimentoData();
        }
        return object;
    }

    public Alimento guardarAlimento(Alimento alimento) {
        try {
            var sql = """
                  insert into alimento(nombre,	tipoComida, caloriasPor100g, detalle, baja) 
                  values(?, ?, ?, ?, ?) returning codComida;""";
            var ps = connection.prepareStatement(sql, new String[]{"codComida", "nombre", "tipoComida", "caloriasPor100g", "detalle", "baja"});
            ps.setString(1, alimento.getNombre());
            ps.setString(2, alimento.getTipoComida());
            ps.setInt(3, alimento.getCaloriasPor100g());
            ps.setString(4, alimento.getDetalle());
            ps.setBoolean(5, alimento.getBaja());
            var rs = ps.executeQuery();
            if (rs.next()) {
                alimento.setCodComida(rs.getInt(1));
            }
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return alimento;
    }

    public List<Alimento> listarAlimentos() throws SQLException {
        List<Alimento> lista = new ArrayList<>();
        try {
            var sql = "select * from alimento";
            var ps = connection.prepareStatement(sql);
            var rs = ps.executeQuery(sql);
            while (rs.next()) {
                //"codComida", "nombre", "tipoComida", "caloriasPor100g", "detalle", "baja"
                Alimento a = new Alimento(
                        rs.getInt("codComida"),
                        rs.getString("nombre"),
                        rs.getString("tipoComida"),
                        rs.getInt("caloriasPor100g"),
                        rs.getString("detalle"),
                        rs.getBoolean("baja")
                );
                lista.add(a);
            }
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return lista;
    }

    public Alimento getAlimentById() {
        Alimento a = null;
        try {
            var sql = "select * from alimento where alimento.codComida = ?";
            var ps = connection.prepareStatement(sql);
            var rs = ps.executeQuery(sql);

            while (rs.next()) {
                a = new Alimento(
                        rs.getInt("codComida"),
                        rs.getString("nombre"),
                        rs.getString("tipoComida"),
                        rs.getInt("caloriasPor100g"),
                        rs.getString("detalle"),
                        rs.getBoolean("baja")
                );
            }
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return a;
    }

    public boolean actualizarAlimento(Alimento a) throws SQLException {
        int r = 0;
        try {
            var sql = "UPDATE alimento SET nombre=?, tipoComida=?, caloriasPor100g=?,detalle=?,baja=? WHERE codComida = ?";
            var ps = connection.prepareStatement(sql);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getTipoComida());
            ps.setInt(3, a.getCaloriasPor100g());
            ps.setString(4, a.getDetalle());
            ps.setBoolean(5, a.getBaja());
            ps.setInt(6, a.getCodComida());
            r = ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return r == 1;
    }

    public boolean remove(int codComida) throws SQLException {
        var r = 0;
        try {
            var sql = "delete from alimento where codComida = ?";
            var ps = connection.prepareStatement(sql);
            r = ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return r == 1;
    }
}
