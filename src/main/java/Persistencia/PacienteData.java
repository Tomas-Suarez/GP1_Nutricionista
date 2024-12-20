package Persistencia;

import Modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PacienteData {

    private static PacienteData obj = null;

    private PacienteData() {

    }

    public static PacienteData getRepo() {
        if (obj == null) {
            obj = new PacienteData();
        }
        return obj;
    }

    public void agregarPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente(nombre, dni, edad, altura, baja, pesoActual) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getDni());
            ps.setInt(3, paciente.getEdad());
            ps.setFloat(4, paciente.getAltura());
            ps.setBoolean(5, paciente.isBaja());
            ps.setFloat(6, paciente.getPesoActual());

            // Ejecutar la actualización
            ps.executeUpdate();

            // Manejar claves generadas (si es necesario)
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paciente.setNroPaciente(rs.getInt(1));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al agregar al paciente: " + e.getMessage());
        }
    }

    public Paciente buscarPaciente(int id) {
        String sql = "SELECT * FROM paciente WHERE idPaciente = ?;";

        Paciente paciente = null;

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                paciente = new Paciente();

                paciente.setNroPaciente(rs.getInt("idPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setBaja(rs.getBoolean("baja"));
                paciente.setPesoActual(rs.getFloat("pesoActual"));
            }

            rs.close();
            ps.close();

            if (paciente != null) {
                //JOptionPane.showMessageDialog(null, "Paciente encontrado!");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ningun paciente con el ID proporcionado!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar al paciente!");
        }
        return paciente;
    }

    public void actualizarPaciente(Paciente paciente) {
        String sql = "UPDATE paciente SET nombre = ?, dni = ?, edad = ?, altura = ?, baja = ?, pesoActual = ? WHERE idPaciente = ?;";

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getDni());
            ps.setInt(3, paciente.getEdad());
            ps.setFloat(4, paciente.getAltura());
            ps.setBoolean(5, paciente.isBaja());
            ps.setFloat(6, paciente.getPesoActual());
            ps.setInt(7, paciente.getNroPaciente());

            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar el paciente!");
        }

    }

    public List<Paciente> listarPacientesBaja(boolean estado) {
        ArrayList<Paciente> listarPaciente = new ArrayList<>();
        String sql;

        if (estado) { //Si la condicion se cumple, se le da de baja 
            sql = "SELECT * FROM paciente WHERE baja = true;";
        } else { //Si la condicion no se cumple, no se le dara de baja (Osea quedara Activo)
            sql = "SELECT * FROM paciente WHERE baja = false;";
        }

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();

                paciente.setNroPaciente(rs.getInt("idPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setDni(rs.getInt("dni"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setBaja(rs.getBoolean("baja"));
                paciente.setPesoActual(rs.getFloat("pesoActual"));

                listarPaciente.add(paciente);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al listar los pacientes: " + e.getMessage());
        }

        return listarPaciente;
    }

    public void estadoAltaPaciente(int id) {
        String sql = "UPDATE paciente SET baja = ? WHERE idPaciente = ?";

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El paciente ha sido dado de ALTA correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el paciente con el ID proporcionado.");
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja el paciente");
        }
    }

    public void estadoBajaPaciente(int id) {
        String sql = "UPDATE paciente SET baja = ? WHERE idPaciente = ?";

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El paciente ha sido dado de BAJA correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el paciente con el ID proporcionado.");
            }

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta el paciente");
        }
    }

    public void eliminarPaciente(int id) {
        String sql = "DELETE FROM paciente WHERE idPaciente = ?";
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setInt(1, id);

            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "El paciente fue eliminado de forma permanente correctamente!");

            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún paciente con el ID: " + id);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al acceder a la tabla Paciente!");
        }
    }

    public int[] edadesPaciente() {
        int[] edadesPaciente = new int[3];
        String sql = """
                SELECT 
                    COUNT(CASE WHEN edad >= 0 AND edad <= 17 THEN 1 END) AS Niños_y_adolescentes,
                    COUNT(CASE WHEN edad >= 18 AND edad <= 54 THEN 1 END) AS Adultos_jovenes,
                    COUNT(CASE WHEN edad >= 55 THEN 1 END) AS Adultos_mayores
                FROM paciente;
                 """;
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                edadesPaciente[0] = rs.getInt("Niños_y_adolescentes");
                edadesPaciente[1] = rs.getInt("Adultos_jovenes");
                edadesPaciente[2] = rs.getInt("Adultos_mayores");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener las edades de los pacientes: " + e.getMessage());
        }
        return edadesPaciente;
    }

    public double[] promedioAlturas() {
        double[] alturasPaciente = new double[3];
        String sql = """
                SELECT 
                    AVG(CASE WHEN edad >= 0 AND edad <= 17 THEN altura END) AS Promedio_altura_niños_y_adolescentes,
                    AVG(CASE WHEN edad >= 18 AND edad <= 54 THEN altura END) AS Promedio_altura_adultos_jovenes,
                    AVG(CASE WHEN edad >= 55 THEN altura END) AS Promedio_altura_adultos_mayores
                FROM paciente;
                 """;
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alturasPaciente[0] = rs.getInt("Promedio_altura_niños_y_adolescentes");
                alturasPaciente[1] = rs.getInt("Promedio_altura_adultos_jovenes");
                alturasPaciente[2] = rs.getInt("Promedio_altura_adultos_mayores");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener los promedios de alturas de los pacientes: " + e.getMessage());
        }
        return alturasPaciente;
    }
    
    public double[] promedioEdades() {
        double[] edadesPaciente = new double[3];
        String sql = """
                SELECT 
                    AVG(CASE WHEN edad >= 0 AND edad <= 17 THEN edad END) AS Promedio_Edad_Niños_y_Adolescentes,
                    AVG(CASE WHEN edad >= 18 AND edad <= 54 THEN edad END) AS Promedio_Edad_Adultos_Jovenes,
                    AVG(CASE WHEN edad >= 55 THEN edad END) AS Promedio_Edad_Adultos_Mayores
                FROM paciente;
                 """;
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                edadesPaciente[0] = rs.getInt("Promedio_edad_niños_y_adolescentes");
                edadesPaciente[1] = rs.getInt("Promedio_edad_adultos_jovenes");
                edadesPaciente[2] = rs.getInt("Promedio_edad_adultos_mayores");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener los promedios de alturas de los pacientes: " + e.getMessage());
        }
        return edadesPaciente;
    }
}
