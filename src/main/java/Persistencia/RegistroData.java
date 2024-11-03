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
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

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

    public void modificarRegistro(Registro registro) {
        String sql = "UPDATE registro SET idDieta = ?, peso = ?, FechaRegistro = ?, detalle = ? WHERE idRegistro = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

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
            PreparedStatement ps = con.prepareStatement(sql);
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

    /*public Registro buscarRegistro(int id){ no tiene sentido el metodo este xd
        String sql = "SELECT * FROM registro WHERE idRegistro = ?";
        Registro registroP = null;
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Registro registro = new Registro();
                Dieta dieta = new Dieta();
                
                registro.setIdRegistro(rs.getInt("idRegistro"));
                dieta.setCodDieta(rs.getInt("idDieta"));
                registro.setDieta(dieta);
                registro.setPeso(rs.getFloat("peso"));
                registro.setFechaRegistro(rs.getDate("FechaRegistro").toLocalDate());
                registro.setDetalle(rs.getString("detalle"));
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar el registro: "+e.getMessage());
        }
        return registroP;
    }*/
    /*public List<Registro> RegistrosDieta(int idDieta) {
        ArrayList<Registro> registroDieta = new ArrayList<>();
        String sql = "SELECT idRegistro, idDieta, FechaRegistro, peso, detalle FROM registro WHERE idDieta = ?;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta); // Establece el parámetro idDieta
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

                registroDieta.add(registro);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al obtener los registros: " + e.getMessage());
        }

        return registroDieta;
    }*/

    public List<Registro> RegistroPaciente(int idPaciente) {
        ArrayList<Registro> registroPaciente = new ArrayList<>();
        String sql = """ 
        SELECT r.idRegistro, r.FechaRegistro, r.peso, r.idDieta, p.idPaciente 
        FROM registro r
        JOIN dieta d ON r.idDieta = d.idDieta
        JOIN paciente p ON p.idPaciente = d.idPaciente
        WHERE p.idPaciente = ?;
        """;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente); // Establece el parámetro idPaciente
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Registro registro = new Registro();
                Dieta dieta = new Dieta();
                Paciente paciente = new Paciente();

                registro.setIdRegistro(rs.getInt("idRegistro"));
                registro.setFechaRegistro(rs.getDate("FechaRegistro").toLocalDate());
                registro.setPeso(rs.getFloat("peso"));

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

}
