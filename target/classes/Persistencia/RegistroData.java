package Persistencia;

import Modelo.Dieta;
import Modelo.Paciente;
import Modelo.Registro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RegistroData {

    private Connection con = null;
    private static RegistroData obj = null;

    private RegistroData() {
        con = Conexion.getConexion();
    }

    public static RegistroData getRepo() {
        if (obj == null) {
            obj = new RegistroData();
        }
        return obj;
    }

    public void agregarRegistro(Registro registro) {
        String sql = "INSERT INTO registro(idDieta, peso, FechaRegistro, detalle) VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, registro.getDieta().getCodDieta());
            ps.setFloat(2, registro.getPeso());
            ps.setDate(3, Date.valueOf(registro.getFechaRegistro()));
            ps.setString(4, registro.getDetalle());

            ps.execute();

            //Agregamos las claves primarias (En caso que sea necesario)
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                registro.setIdRegistro(rs.getInt(1));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al agregar el registro " + e.getMessage());
        }
    }

    public void eliminarRegistro(int id) {
        String sql = "DELETE FROM registro WHERE idRegistro = ?";
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "El registro fue eliminado de forma permanente correctamente!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al acceder a la tabla registro!" + ex.getMessage());
        }
    }

    public void modificarRegistro(Registro registro) {
        String sql = "UPDATE registro SET idDieta = ?, peso = ?, FechaRegistro = ?, detalle = ? WHERE idRegistro = ?;";

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);

            ps.setInt(1, registro.getDieta().getCodDieta());
            ps.setFloat(2, registro.getPeso());
            ps.setDate(3, Date.valueOf(registro.getFechaRegistro()));
            ps.setString(4, registro.getDetalle());
            ps.setInt(5, registro.getIdRegistro());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue modificado correctamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningun registro para modificar.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar el registro: " + e.getMessage());
        }
    }

    public List<Registro> TodosLosRegistros() {
        ArrayList<Registro> listaRegistro = new ArrayList<>();

        String sql = "SELECT * FROM registro";

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Registro registro = new Registro();
                Dieta dieta = new Dieta();

                registro.setIdRegistro(rs.getInt("idRegistro"));
                dieta.setCodDieta(rs.getInt("idDieta"));
                registro.setDieta(dieta);
                registro.setPeso(rs.getFloat("peso"));
                registro.setFechaRegistro(rs.getDate("FechaRegistro").toLocalDate());
                registro.setDetalle(rs.getString("detalle"));

                listaRegistro.add(registro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener los registros: " + e.getMessage());
        }

        return listaRegistro;
    }

    public List<Registro> RegistroPaciente(int idPaciente) {
        ArrayList<Registro> registroPaciente = new ArrayList<>();
        String sql = """ 
        SELECT r.idRegistro, r.FechaRegistro, r.peso, r.detalle, r.idDieta, p.idPaciente
        FROM registro r
        JOIN dieta d ON r.idDieta = d.idDieta
        JOIN paciente p ON p.idPaciente = d.idPaciente
        WHERE p.idPaciente = ?
        AND d.baja = false
        AND p.baja = false;
        """;

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, idPaciente); // Establece el parámetro idPaciente
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Registro registro = new Registro();
                Dieta dieta = new Dieta();
                Paciente paciente = new Paciente();

                registro.setIdRegistro(rs.getInt("idRegistro"));
                registro.setFechaRegistro(rs.getDate("FechaRegistro").toLocalDate());
                registro.setPeso(rs.getFloat("peso"));
                registro.setDetalle(rs.getString("detalle"));

                dieta.setCodDieta(rs.getInt("idDieta"));
                registro.setDieta(dieta);

                paciente.setNroPaciente(rs.getInt("idPaciente"));
                dieta.setPaciente(paciente);

                registroPaciente.add(registro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener los registros del paciente: " + e.getMessage());
        }

        return registroPaciente;
    }

    public int[] EstadoPaciente() {
        int[] estadoPaciente = new int[3]; //En la posicion 0 - llegaron al objetivo, pos 1-No llegaron al objetivo, pos3- en_proceso
        String sql = """
                    SELECT
                        SUM(CASE WHEN (d.pesoInicial > d.pesoObjetivo AND r.peso <= d.pesoObjetivo AND d.pesoFinal IS NOT NULL)
                                  OR (d.pesoInicial < d.pesoObjetivo AND r.peso >= d.pesoObjetivo AND d.pesoFinal IS NOT NULL)
                                 THEN 1 END) AS llego_al_objetivo,
                     
                        SUM(CASE WHEN (d.pesoInicial > d.pesoObjetivo AND r.peso > d.pesoObjetivo AND d.pesoFinal IS NOT NULL)
                                  OR (d.pesoInicial < d.pesoObjetivo AND r.peso < d.pesoObjetivo AND d.pesoFinal IS NOT NULL)
                                 THEN 1 END) AS no_llego_al_objetivo,
                     
                        COUNT(CASE WHEN d.pesoFinal IS NULL THEN 1 END) AS en_proceso
                     
                    FROM dieta d
                    LEFT JOIN registro r ON d.idDieta = r.idDieta
                    WHERE r.FechaRegistro = (
                        SELECT MAX(FechaRegistro)
                        FROM registro
                        WHERE idDieta = d.idDieta
                    ) OR d.pesoFinal IS NULL;
                     """;

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                estadoPaciente[0] = rs.getInt("llego_al_objetivo");
                estadoPaciente[1] = rs.getInt("no_llego_al_objetivo");
                estadoPaciente[2] = rs.getInt("en_proceso");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al obtener los estados de los pacientes: " + e.getMessage());
        }
        return estadoPaciente;
    }

    //Estaria faltando el borrar registro o algo similar
}
