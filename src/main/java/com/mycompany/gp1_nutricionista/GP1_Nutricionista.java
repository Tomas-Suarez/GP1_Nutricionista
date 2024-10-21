/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gp1_nutricionista;

import Modelo.Alimento;
import Modelo.Dieta;
import Modelo.MenuDiario;
import Modelo.Paciente;
import Persistencia.AlimentoData;
import Persistencia.MenuDiarioData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Tomi
 */
public class GP1_Nutricionista {

    public static void main(String[] args) throws SQLException {
       // testAlimentoData();
        testMenuDiario();
    }

    private static void testAlimentoData() {
        AlimentoData repoAlimentos = AlimentoData.getRepo();
        Alimento alimento = new Alimento("nombre", "tipoComida", 0, "detalle", Boolean.TRUE);
        repoAlimentos.guardarAlimento(alimento);
        
        var a2 = repoAlimentos.getAlimentById(alimento.getCodComida());
        
        System.out.println(alimento.equals(a2));

        alimento.setNombre("editado");
        repoAlimentos.actualizarAlimento(alimento);


        repoAlimentos.remove(alimento.getCodComida());
    }
    
    public static void testMenuDiario() throws SQLException{
        MenuDiarioData menuData = new MenuDiarioData();
        
        Dieta dieta = new Dieta();
        dieta.setCodDieta(1); 
        
        MenuDiario nuevoMenu = MenuDiarioData.getRepo(); 
        nuevoMenu.setDia(1);
        nuevoMenu.setCaloriasDelMenu(5000);
        //nuevoMenu.setDieta(dieta);
        nuevoMenu.setBaja(true);
        nuevoMenu.setCodMenu(4);
        
        menuData.modificarMenuDiario(nuevoMenu);
       
        //Obtenemos los Menus Diarios con baja en FALSE
        List<MenuDiario> menusSinBaja = menuData.ListarMenuDiarioSinBaja();
        System.out.println("Menus Diarios activos:");
        for (MenuDiario menu : menusSinBaja) {
            System.out.println("Código: " + menu.getCodMenu() + ", Dia: " + menu.getDia() + ", Calorias: " + menu.getCaloriasDelMenu());
        }

        //Obtenemos los Menus Diarios con baja en TRUE
        List<MenuDiario> menusBaja = menuData.ListarMenuDiarioBaja();
        System.out.println("Menus Diarios dados de baja:");
        for (MenuDiario menu : menusBaja) {
            System.out.println("Código: " + menu.getCodMenu() + ", Dia: " + menu.getDia() + ", Calorias: " + menu.getCaloriasDelMenu());
        }
        
        menuData.buscarMenuComida(1);
        
    }
    
    public static void testDieta(){

    }
}

