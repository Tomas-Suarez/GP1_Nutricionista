package com.mycompany.gp1_nutricionista;


import Modelo.Alimento;
import Modelo.Dieta;
import Modelo.MenuDiario;
import Modelo.Paciente;
import Modelo.RenglonDeMenu;
import Persistencia.AlimentoData;
import Persistencia.MenuDiarioData;
import Persistencia.PacienteData;
import Persistencia.RenglonDeMenuData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import Modelo.RenglonDeMenu;
import Persistencia.RenglonDeMenuData;


/**
 *
 * @author Tomi
 */
public class GP1_Nutricionista {


    public static void main(String[] args) throws SQLException {
        testAlimentoData();
        //testMenuDiario();
        //testPaciente();
        //testReglon();
    }

    private static void testAlimentoData() {
        AlimentoData repoAlimentos = AlimentoData.getRepo();
        Alimento alimento = new Alimento("nombre", "tipoComida", 0, "detalle", Boolean.TRUE);
        repoAlimentos.guardarAlimento(alimento);

        var a2 = repoAlimentos.getAlimentById(alimento.getCodComida());

        alimento.setNombre("editado");
        repoAlimentos.actualizarAlimento(alimento);

        repoAlimentos.remove(alimento.getCodComida());
    }

    public static void testMenuDiario() throws SQLException { //falta el codDieta
        MenuDiarioData menuData = new MenuDiarioData();

        Dieta dieta = new Dieta();
        dieta.setCodDieta(1);

        MenuDiario nuevoMenu = MenuDiarioData.getRepo();
        nuevoMenu.setDia(1);
        nuevoMenu.setCaloriasDelMenu(5000);

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

    public static void testDieta() {

    }

    public static void testPaciente() throws SQLException {
        PacienteData pacData = PacienteData.getRepo();

        // Creamos un paciente y lo agregamos
        //Paciente nuevoPaciente = new Paciente("Jepeto", 20, 176, 60, false);ver
        //pacData.agregarPaciente(nuevoPaciente);

        // Modificamos los datos del paciente
        Paciente pacienteModificado = new Paciente();
        pacienteModificado.setNroPaciente(1);
        pacienteModificado.setNombre("Jepeto");
        pacienteModificado.setEdad(17);
        pacienteModificado.setAltura(176);
        pacienteModificado.setBaja(true);
        //Falta peso actual

        pacData.modificarPaciente(pacienteModificado);
        List<Paciente> pacientesActivos = pacData.ListarPacienteActivos();
        System.out.println("Pacientes activos");
        for (Paciente paciente : pacientesActivos) {
            System.out.println("Codigo: " + paciente.getNroPaciente() + ", Nombre: " + paciente.getNombre() + ", Edad: " + paciente.getEdad());
        }
        
        System.out.println("----------------------------------------------------");
        
        List<Paciente> pacientesDadosDeBaja = pacData.ListarPacienteDadoBaja();
        System.out.println("Pacientes dados de baja:");
        for (Paciente paciente : pacientesDadosDeBaja) {
            System.out.println("Codigo: " + paciente.getNroPaciente() + ", Nombre: " + paciente.getNombre() + ", Edad: " + paciente.getEdad());
        }

        // Buscamos un paciente por su código
        Paciente pacienteBuscado = pacData.buscarPaciente(1);
        if (pacienteBuscado != null) {
            System.out.println("Paciente encontrado: " + pacienteBuscado.getNombre());
        } else {
            System.out.println("No se encontro ningun paciente con este codigo");
        }

    }
    
    public static void testReglon () throws SQLException {
        RenglonDeMenuData dat = new RenglonDeMenuData();
        
        
        Alimento ali = new Alimento();
        ali.setCodComida(1);
        MenuDiario men = new MenuDiario();
        men.setCodMenu(1);
        
        RenglonDeMenu ren = new RenglonDeMenu(123,123,ali,men,"manana");
        
        dat.agregarRen(ren);
        
        
        
    }

    /*public static void main(String[] args) {
        // Crear una instancia de RenglonDeMenuData
        RenglonDeMenuData renglonDeMenuData = new RenglonDeMenuData();

        // Supongamos que 'codRenglon' es el código del renglón que estás buscando
        int codRenglon = 1; // Cambia este valor por uno válido que exista en tu base de datos

        // Llamar al método BuscarRenglon y pasar el código del renglón
        RenglonDeMenu renglon = renglonDeMenuData.BuscarRenglon(codRenglon);

        // Verificar si el objeto no es nulo y mostrar el resultado
        if (renglon != null) {
            System.out.println("Codigo del Renglon: " + renglon.getCodRenglon());
            System.out.println("Cantidad de Gramos: " + renglon.getCantidadGrs());
            System.out.println("Subtotal de Calorias: " + renglon.getSubTotalCalorias());
            System.out.println("Codigo de Comida: " + renglon.getAlimento().getCodComida());
        } else {
            System.out.println("No se encontró el renglón con el codigo: " + codRenglon);
        }
    }*/
    
  

    
}
