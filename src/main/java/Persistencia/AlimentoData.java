package Persistencia;

import Modelo.Alimento;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author cisco
 */
public class AlimentoData {

    private Connection connection;
    private static AlimentoData object = null;
    private static String[] tbHeader = new String[]{"idAlimento", "nombre", "tipoComida", "caloriasPor100g", "detalle", "baja"};

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
                  values(?, ?, ?, ?, ?)""";
            var ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alimento.getNombre());
            ps.setString(2, alimento.getTipoComida());
            ps.setInt(3, alimento.getCaloriasPor100g());
            ps.setString(4, alimento.getDetalle());
            ps.setBoolean(5, alimento.getBaja());
            
            ps.executeUpdate();
            var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alimento.setCodComida(rs.getInt(1));
            }
            
            ps.close();
        } catch (Exception ex) {
            System.out.println("error guardando alimento");
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return alimento;
    }

    public List<Alimento> listarAlimentos() {
        List<Alimento> lista = new ArrayList<>();
        try {
            var sql = "select * from alimento";
            var ps = connection.prepareStatement(sql);
            var rs = ps.executeQuery(sql);
            while (rs.next()) {
                //"idAlimento", "nombre", "tipoComida", "caloriasPor100g", "detalle", "baja"
                Alimento a = new Alimento(
                        rs.getInt("idAlimento"),
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
            System.out.println("error listando alimentos");
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return lista;
    }
    
    
    

    public Alimento getAlimentById(int id) {
        Alimento a = null;
        try {
            var sql = "select * from alimento where idAlimento = ?;";
            var ps = connection.prepareStatement(sql, tbHeader);
            ps.setInt(1, id);
            var rs = ps.executeQuery();

            while (rs.next()) {
                a = new Alimento(
                        rs.getInt("idAlimento"),
                        rs.getString("nombre"),
                        rs.getString("tipoComida"),
                        rs.getInt("caloriasPor100g"),
                        rs.getString("detalle"),
                        rs.getBoolean("baja")
                );
            }
            ps.close();
        } catch (Exception ex) {
            System.out.println("error obteniendo aliment");
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return a;
    }

    public boolean actualizarAlimento(Alimento a) {
        int r = 0;
        try {
            var sql = "UPDATE alimento SET nombre=?, tipoComida=?, caloriasPor100g=?,detalle=?,baja=? WHERE idAlimento = ?";
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
            System.out.println("error actualizando aliment");
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return r == 1;
    }
    
     public List<Alimento> getAlimentByEstado(boolean est) {
        Alimento a = null;
        List<Alimento> lista = new ArrayList<>();
        try {
            var sql = "select * from alimento where  baja = ?;";
            var ps = connection.prepareStatement(sql, tbHeader);
             
            ps.setBoolean(1, est);
            var rs = ps.executeQuery();

            while (rs.next()) {
                a = new Alimento(
                        rs.getInt("idAlimento"),
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
            System.out.println("error obteniendo aliment");
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return lista;
    }
             
    public boolean remove(int idAlimento) {
        var r = 0;
        try {
            var sql = "delete from alimento where idAlimento = ?";
            var ps = connection.prepareStatement(sql);
            ps.setInt(1, idAlimento);
            r = ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            System.out.println("error removiendo");
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return r == 1;
    }
}
