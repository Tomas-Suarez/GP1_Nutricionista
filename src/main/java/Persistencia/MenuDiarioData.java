 
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
    
    public void agregarMenuDiario(MenuDiario menu){
        String sql = "INSERT INTO MenuDiario(dia, caloriasdelMenu, codDieta, baja) VALUES (?, ?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, menu.getDia());
            ps.setInt(2, menu.getCaloriasDelMenu());
            ps.setInt(3, menu.getDieta().getCodDieta());
            ps.setBoolean(4, menu.isBaja());
            
            //Ejecutamos la actualización
            ps.execute();
            
            //Agregamos las claves primarias (En caso que sea necesario)
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                menu.setCodMenu(rs.getInt(1));
            }

            rs.close();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "El Menu diario fue agregado exitosamente!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al agregar el Menu diario");
        }
        
    }
    
    public void modificarMenuDiario(MenuDiario menu) throws SQLException{
        String sql = "UPDATE menudiario SET dia = ?, caloriasdelMenu = ?, baja = ?, codDieta = ? WHERE codMenu = ?;";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        try{
            ps.setInt(1, menu.getDia());
            ps.setInt(2, menu.getCaloriasDelMenu());
            ps.setBoolean(3, menu.isBaja());
            ps.setInt(4, menu.getDieta().getCodDieta());
            ps.setInt(5, menu.getCodMenu());
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al modificar al Menu diario");
        }
    }
    
    
    //Retonamos una lista del menuDiario los que no estan de baja
    public List<MenuDiario> ListarMenuDiarioSinBaja(){
        ArrayList<MenuDiario> ListarMenuDiarioSinBaja = new ArrayList<>();
        
        String sql = "SELECT * FROM menudiario WHERE baja = false;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                MenuDiario menu = new MenuDiario();
                Dieta dieta = new Dieta();
                
                menu.setCodMenu(rs.getInt("codMenu"));
                menu.setDia(rs.getInt("dia"));
                menu.setCaloriasDelMenu(rs.getInt("caloriasdelMenu"));
                int codDieta = rs.getInt("codDieta");
                dieta.setCodDieta(codDieta);
                menu.setBaja(rs.getBoolean("baja"));

                
                ListarMenuDiarioSinBaja.add(menu);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar Menu Diario");

        }
        return ListarMenuDiarioSinBaja;
    }
    
        //Retonamos una lista del menuDiario los que estan de baja
    public List<MenuDiario> ListarMenuDiarioBaja(){
        ArrayList<MenuDiario> ListarMenuDiarioBaja = new ArrayList<>();
        
        String sql = "SELECT * FROM menudiario WHERE baja = true;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                MenuDiario menu = new MenuDiario();
                Dieta dieta = new Dieta();
                
                menu.setCodMenu(rs.getInt("codMenu"));
                menu.setDia(rs.getInt("dia"));
                menu.setCaloriasDelMenu(rs.getInt("caloriasdelMenu"));
                int codDieta = rs.getInt("codDieta");
                dieta.setCodDieta(codDieta);
                menu.setBaja(rs.getBoolean("baja"));

                
                ListarMenuDiarioBaja.add(menu);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar Menu Diario");
        }
        return ListarMenuDiarioBaja;
    }
    
    public MenuDiario buscarMenuComida(int id){
        String sql = "SELECT * FROM MenuDiario WHERE codMenu = ?";
        
        MenuDiario menu = null;
        Dieta dieta = null;
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                menu = new MenuDiario();
                dieta = new Dieta();
                
                menu.setCodMenu(rs.getInt("codMenu"));
                menu.setDia(rs.getInt("dia"));
                menu.setCaloriasDelMenu(rs.getInt("caloriasdelMenu"));
                int codDieta = rs.getInt("codDieta");
                dieta.setCodDieta(codDieta);
                menu.setDieta(dieta);    
            }
            
            if(menu != null){
                JOptionPane.showMessageDialog(null, "Menu diario encontrado!");
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun Menu diario");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar el Menu Comida");
        }
        return menu;
    }
    
}
