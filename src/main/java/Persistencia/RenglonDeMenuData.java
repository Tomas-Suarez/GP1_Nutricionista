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
import javax.swing.JOptionPane;

/**
 *
 * @author franco
 */
public class RenglonDeMenuData {
    
    private Connection con = null;
    private Alimento ali  ;
    private MenuDiario men ;
    
    
    public RenglonDeMenuData () {
    con = Conexion.getConexion();
    
    this.ali = new Alimento() ;
    
}

    public RenglonDeMenuData(Connection conexion ,Alimento ali,MenuDiario men) {
        this.ali = ali;
        this.con = conexion;
        this.men = men;
    }
    
    
    
    
    
    
    public void agregarRen (RenglonDeMenu dato)throws SQLException{
        
        String sql = "INSERT INTO renglondemenu (cantidadGrs,subtotalCalorias,codMenu,codComida VALUES (?,?,?,?);";
        
        try {
            PreparedStatement cosa = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            cosa.setDouble(1, dato.getCantidadGrs());
            cosa.setInt(2, dato.getSubTotalCalorias());
            cosa.setInt(3, dato.getMenu().getCodMenu());
            cosa.setInt(4,dato.getAlimento().getCodComida());
            
            
            cosa.executeUpdate();
            
            ResultSet rs = cosa.getGeneratedKeys();
            
            
            if (rs.next()){
                dato.setCodRenglon(rs.getInt(1));
            }
            
            rs.close();
            cosa.close();
            
            JOptionPane.showMessageDialog(null,"Renglon del menu agregado exitosamente!");
            
            
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error al agregar el renglon!");
        }
        
    }
    
    public RenglonDeMenu BuscarRenglon (int cod){
        String sql = "SELECT * FROM paciente WHERE codRenglon = ?;";
        
        RenglonDeMenu ren = null;
        
        
        try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,cod);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()){
            
            ren = new RenglonDeMenu();
            ali = new Alimento();
            men = new MenuDiario();
            
            ren.setCodRenglon(rs.getInt("codRenglon"));
            ren.setCantidadGrs(rs.getDouble("cantidadGrs"));
            ren.setSubTotalCalorias(rs.getInt("subtotalCalorias"));
            ali.setCodComida(rs.getInt("codComida"));
            ren.setAlimento(ali);
            men.setCodMenu(rs.getInt("codMenu"));
            
            rs.close();
            ps.close();
            
            
            if (ren !=null){
                 JOptionPane.showMessageDialog(null, "se encontro");
            }else{
                 JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar");
            }
           
        }
            
            
        }catch(SQLException e) {
             JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar al paciente!");
        }
        
       return ren; 
        
    }
    
    
    
}
