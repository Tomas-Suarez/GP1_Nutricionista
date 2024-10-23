package Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import Modelo.Dieta;

public class DietaData {
    private static DietaData obj = null;
    private Connection connection;
    private String[] header;
    private PacienteData repoPaciente;

    private DietaData() {
        obj = new DietaData();
        connection = Conexion.getConexion();
        repoPaciente = PacienteData.getRepo();

        header = new String[] { "codDieta", "nombre", "fechaInicio", "fechaFin",
                "pesoInicial", "pesoFinal", "totalCalorias", "nroPaciente", "baja" };
    }

    public static DietaData getRepo() {
        if (obj == null) {
            obj = new DietaData();
        }
        return obj;
    }

    public void save(Dieta dieta) {
        try {
            var sql = "insert into dieta (nombre, fechaInicio, pesoInicial, pesoFinal, totalCalorias, nroPaciente, baja)"
                    + "values (?,?,?,?,?,?,?);";
            var ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, dieta.getNombre());
            ps.setDate(2, Date.valueOf(dieta.getFechaInicio()));
            ps.setFloat(3, dieta.getPesoInicial());
            ps.setFloat(4, dieta.getPesoFinal());
            ps.setInt(5, dieta.getTotalCalorias());
            ps.setInt(6, dieta.getPaciente().getNroPaciente());
            ps.setBoolean(7, dieta.getBaja());

            ps.executeQuery();

            var rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dieta.setCodDieta(rs.getInt(1));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Dieta getById(int id) {
        Dieta dieta = new Dieta();

        try {
            var sql = "select * from dieta where id = ?";
            var ps = connection.prepareStatement(sql, this.header);
            ps.setInt(1, id);
            var rs = ps.executeQuery();
            dieta.setCodDieta(rs.getInt("codDieta"));
            dieta.setNombre(rs.getString("nombre"));
            dieta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
            dieta.setFechaFinal(rs.getDate("fechaFin").toLocalDate());
            dieta.setTotalCalorias(rs.getInt("totalCalorias"));
            dieta.setPaciente(repoPaciente.buscarPaciente(rs.getInt("nroPaciente")));
            dieta.setBaja(rs.getBoolean("baja"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dieta;
    }

    public List<Dieta> getAll() throws SQLException {
        List<Dieta> dietas = new ArrayList<>();

        var sql = "select * from dieta";
        var ps = connection.prepareStatement(sql, this.header);
        var rs = ps.executeQuery();

        while (rs.next()) {
            Dieta dieta = new Dieta();
            dieta.setCodDieta(rs.getInt("codDieta"));
            dieta.setNombre(rs.getString("nombre"));
            dieta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
            dieta.setFechaFinal(rs.getDate("fechaFin").toLocalDate());
            dieta.setTotalCalorias(rs.getInt("totalCalorias"));
            dieta.setPaciente(repoPaciente.buscarPaciente(rs.getInt("nroPaciente")));
            dieta.setBaja(rs.getBoolean("baja"));
            dietas.add(dieta);
        }

        return dietas;
    }

    public void remove(int id) throws SQLException {
        var sql = "delete from dieta where id = ?";
        var ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
