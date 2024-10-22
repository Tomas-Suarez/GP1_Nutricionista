package Persistencia;

import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PacienteData {
    private Connection con = null;
    private static Paciente object = null;
    
    public PacienteData() {
    con = Conexion.getConexion();
    }
    
    public static Paciente getRepo() {
        if (object == null) {
            object = new Paciente();
        }
        return object;
    }
    
    public void agregarPaciente(Paciente paciente) throws SQLException{
        String sql = "INSERT INTO paciente(nombre, edad, altura, pesoBuscado, baja) VALUES (?, ?, ?, ?, ?);";
     
        try{
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, paciente.getNombre());
        ps.setInt(2, paciente.getEdad());
        ps.setFloat(3, paciente.getAltura());
        ps.setFloat(4, paciente.getPesoBuscado());
        ps.setBoolean(5, paciente.isBaja());
        
        // Ejecutar la actualización
        ps.executeUpdate();

        // Manejar claves generadas (si es necesario)
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            paciente.setNroPaciente(rs.getInt(1));
        }

        rs.close();
        ps.close();

            JOptionPane.showMessageDialog(null, "Paciente agregado exitosamente!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al agregar al paciente!");
        }
    }
    
    public Paciente buscarPaciente(int id){
        String sql = "SELECT * FROM paciente WHERE nroPaciente = ?;";
        
        Paciente paciente = null;
        
        try{
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            paciente = new Paciente();
            
            paciente.setNroPaciente(rs.getInt("nroPaciente"));
            paciente.setNombre(rs.getString("nombre"));
            paciente.setEdad(rs.getInt("edad"));
            paciente.setAltura(rs.getFloat("altura"));
            paciente.setPesoBuscado(rs.getFloat("pesoBuscado"));
            paciente.setBaja(rs.getBoolean("baja"));
            }
            
            rs.close();
            ps.close();
            
            if(paciente != null){
                JOptionPane.showMessageDialog(null, "Paciente encontrado!");
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun paciente con el ID proporcionado!");
            }      
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar al paciente!");
        }
        return paciente;
    }
    
    public void modificarPaciente(Paciente paciente) throws SQLException{
        String sql = "UPDATE paciente SET nombre = ?, edad = ?, altura = ?, pesoBuscado = ?, baja = ? WHERE nroPaciente = ?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        try{
        ps.setString(1, paciente.getNombre());
        ps.setInt(2, paciente.getEdad());
        ps.setFloat(3, paciente.getAltura());
        ps.setFloat(4, paciente.getPesoBuscado());
        ps.setBoolean(5, paciente.isBaja());
        ps.setInt(6, paciente.getNroPaciente());
        
        ps.executeUpdate();
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar el paciente!");
        }
        
    }
    
    public List<Paciente> ListarPacienteActivos(){
        ArrayList<Paciente> listarPaciente = new ArrayList<>();
        
        String sql = "SELECT * FROM paciente WHERE baja = false;";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Paciente paciente = new Paciente();
                
                paciente.setNroPaciente(rs.getInt("nroPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setPesoBuscado(rs.getFloat("pesoBuscado"));
                paciente.setBaja(rs.getBoolean("baja"));
                
                listarPaciente.add(paciente);
            }
            rs.close();
            ps.close();   
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al listar los pacientes");
        }
        return listarPaciente;        
    }
    
    public List<Paciente> ListarPacienteDadoBaja(){
        ArrayList<Paciente> listarPaciente = new ArrayList<>();
        
        String sql = "SELECT * FROM paciente WHERE baja = true;";

        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Paciente paciente = new Paciente();
                
                paciente.setNroPaciente(rs.getInt("nroPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setPesoBuscado(rs.getFloat("pesoBuscado"));
                paciente.setBaja(rs.getBoolean("baja"));
                
                listarPaciente.add(paciente);
            }
            rs.close();
            ps.close();   
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al listar los pacientes");
        }
        return listarPaciente;        
    }
    
    public void darDeBajaPaciente(int id) {
        String sql = "UPDATE paciente SET baja = ? WHERE nroPaciente = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, id);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El paciente ha sido dado de baja correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el paciente con el ID proporcionado.");
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja el paciente");
        }
    }
    
    public void darDePaciente(int id) {
        String sql = "UPDATE paciente SET baja = ? WHERE nroPaciente = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setInt(2, id);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "El paciente ha sido dado de alta correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el paciente con el ID proporcionado.");
            }

            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta el paciente");
        }
    }
    
    public void eliminarPaciente(int id) {
        try {
            String sql = "DELETE FROM paciente WHERE nroPaciente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
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
    
}
