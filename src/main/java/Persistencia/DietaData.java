package Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import Modelo.Dieta;

public class DietaData {

    private static DietaData obj = null;
    private Connection connection;
    private String[] header;
    private PacienteData repoPaciente;
    private MenuDiarioData repoMenu;

    private DietaData() {
        connection = Conexion.getConexion();
        repoPaciente = PacienteData.getRepo();
        repoMenu = new MenuDiarioData();

        header = new String[]{"idDieta", "nombre", "fechaInicio", "fechaFin",
            "pesoInicial", "pesoFinal", "totalCalorias", "idPaciente", "baja"};
    }

    public static DietaData getRepo() {
        if (obj == null) {
            obj = new DietaData();
        }
        return obj;
    }

    public void save(Dieta dieta) {
        try {
            var sql = "insert into dieta (nombre, fechaInicio, pesoInicial, pesoObjetivo, totalCalorias, idPaciente, baja)"
                    + "values (?,?,?,?,?,?,?);";
            var ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, dieta.getNombre());
            ps.setDate(2, Date.valueOf(dieta.getFechaInicio()));
            ps.setFloat(3, dieta.getPesoInicial());
            ps.setFloat(4, dieta.getPesoObjetivo());
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
            dieta.setPesoObjetivo(rs.getFloat("pesoObjetivo"));

            try {
                dieta.setFechaFinal(rs.getDate("fechaFin").toLocalDate());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            dieta.setTotalCalorias(rs.getInt("totalCalorias"));
            dieta.setPaciente(repoPaciente.buscarPaciente(rs.getInt("idPaciente")));
            dieta.setBaja(rs.getBoolean("baja"));

            dieta.setMenu(repoMenu.obtenerMenusPorDieta(dieta.getCodDieta()));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dieta;
    }

    public List<Dieta> getAll() {
        List<Dieta> dietas = new ArrayList<>();

        var sql = "select * from dieta";
        try {
            var ps = connection.prepareStatement(sql, this.header);
            var rs = ps.executeQuery();

            while (rs.next()) {
                Dieta dieta = new Dieta();
                dieta.setCodDieta(rs.getInt("idDieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setPesoObjetivo(rs.getFloat("pesoObjetivo"));

                dieta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                try {
                    dieta.setFechaFinal(rs.getDate("fechaFin").toLocalDate());
                } catch (Exception ex) {

                }
                dieta.setTotalCalorias(rs.getInt("totalCalorias"));
                dieta.setPaciente(repoPaciente.buscarPaciente(rs.getInt("idPaciente")));
                dieta.setBaja(rs.getBoolean("baja"));
                dieta.setMenu(repoMenu.obtenerMenusPorDieta(dieta.getCodDieta()));

                dietas.add(dieta);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return dietas;
    }

    public List<Dieta> getByStatus(boolean status) {
        List<Dieta> dietas = new ArrayList();
        var sql = "select * from dieta where baja = ?";
        try {
            var ps = connection.prepareStatement(sql);
            ps.setBoolean(1, status);
            var rs = ps.executeQuery();

            while (rs.next()) {
                Dieta dieta = new Dieta();
                dieta.setCodDieta(rs.getInt("idDieta"));
                dieta.setNombre(rs.getString("nombre"));
                dieta.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                dieta.setPesoObjetivo(rs.getFloat("pesoObjetivo"));
                try {
                    dieta.setFechaFinal(rs.getDate("fechaFin").toLocalDate());
                } catch (Exception ex) {

                }
                dieta.setTotalCalorias(rs.getInt("totalCalorias"));
                dieta.setPaciente(repoPaciente.buscarPaciente(rs.getInt("idPaciente")));
                dieta.setBaja(rs.getBoolean("baja"));
                dieta.setMenu(repoMenu.obtenerMenusPorDieta(dieta.getCodDieta()));

                dietas.add(dieta);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return dietas;
    }

    public void remove(Dieta dieta) {
        var sql = "delete from dieta where id = ?";
        try {
            var ps = connection.prepareStatement(sql);
            ps.setInt(1, dieta.getCodDieta());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Dieta dieta) {
        try {
            var sql = "update dieta set nombre = ?, pesoFinal = ?, totalCalorias = ?, baja = ?, fechaFin = ? where idDieta = ?";
            var ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, dieta.getNombre());
            ps.setFloat(2, dieta.getPesoFinal());
            ps.setFloat(3, dieta.getTotalCalorias());
            ps.setBoolean(4, dieta.getBaja());
            ps.setDate(5, Date.valueOf(dieta.getFechaFinal()));
            ps.setInt(6, dieta.getCodDieta());

            ps.executeQuery();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
