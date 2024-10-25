package com.mycompany.gp1_nutricionista;

import Modelo.Alimento;
import Modelo.Dieta;
import Modelo.MenuDiario;
import Modelo.Paciente;
import Persistencia.AlimentoData;
import Persistencia.MenuDiarioData;
import Persistencia.PacienteData;
import java.sql.SQLException;
import java.util.List;

import Modelo.RenglonDeMenu;
import Persistencia.RenglonDeMenuData;

/**
 *
 * @author Tomi
 */
public class GP1_Nutricionista {

    public static void main(String[] args) throws SQLException {
        //testAlimentoData();
        //testMenuDiario(); FUNCIONA
        //testPaciente(); FUNCIONA
        //testReglon();
    }

    private static void testAlimentoData() {
        AlimentoData repoAlimentos = AlimentoData.getRepo();
        Alimento alimento = new Alimento("nombre", "tipoComida", 0, "detalle", Boolean.TRUE);
        repoAlimentos.guardarAlimento(alimento);

        var a2 = repoAlimentos.getAlimentById(alimento.getCodComida());

        alimento.setNombre("editado");
        repoAlimentos.actualizarAlimento(alimento);
        System.out.println(alimento.getCodComida());
        //repoAlimentos.remove(alimento.getCodComida());
    }

    public static void testMenuDiario() throws SQLException {
        MenuDiarioData menuData = new MenuDiarioData();

        Dieta dieta = new Dieta();
        dieta.setCodDieta(1);

        MenuDiario nuevoMenu = MenuDiarioData.getRepo();
        nuevoMenu.setDia(1);
        nuevoMenu.setCaloriasDelMenu(5000);
        
        nuevoMenu.setBaja(true);
        nuevoMenu.setCodMenu(4);
        nuevoMenu.setDieta(dieta);
        menuData.modificarMenuDiario(nuevoMenu);

        //Obtenemos los Menus Diarios con baja en FALSE
        List<MenuDiario> menusSinBaja = menuData.MenuDiarioBaja(false);
        System.out.println("Menus Diarios activos:");
        for (MenuDiario menu : menusSinBaja) {
            System.out.println("Código: " + menu.getCodMenu() + ", Dia: " + menu.getDia() + ", Calorias: " + menu.getCaloriasDelMenu());
        }

        //Obtenemos los Menus Diarios con baja en TRUE
        List<MenuDiario> menusBaja = menuData.MenuDiarioBaja(true);
        System.out.println("Menus Diarios dados de baja:");
        for (MenuDiario menu : menusBaja) {
            System.out.println("Código: " + menu.getCodMenu() + ", Dia: " + menu.getDia() + ", Calorias: " + menu.getCaloriasDelMenu());
        }

        menuData.buscarMenuComida(1);

    }

    public static void testDieta() {

    }

    public static void testPaciente() throws SQLException {
        PacienteData pacData = new PacienteData();

        //
        /*Estan todos los metodos hechos, Solo tiene que borrar el comentario para probar*/
        //
        // Creamos un paciente y lo agregamos
        Paciente nuevoPaciente1 = new Paciente("Pepito", 41563259, 21, 180, 65, true);
        Paciente nuevoPaciente2 = new Paciente("Jepeto", 42562222, 19, 160, 70, false);
        pacData.agregarPaciente(nuevoPaciente1);
        /* Borrar el comentario para probar el agregar Paciente */
        pacData.agregarPaciente(nuevoPaciente2);
        /* Borrar el comentario para probar el agregar Paciente */

        // Modificamos los datos del paciente
        Paciente pacienteModificado = new Paciente();
        pacienteModificado.setNombre("Jepeto");
        pacienteModificado.setDni(44562221);
        pacienteModificado.setEdad(17);
        pacienteModificado.setAltura(176);
        pacienteModificado.setBaja(true);
        pacienteModificado.setNroPaciente(2); //ID del paciente
        pacienteModificado.setPesoActual(70);

        //pacData.actualizarPaciente(pacienteModificado); /* Borrar el comentario para probar el modificar Paciente */
        //Mostramos los pacientes Activos
        List<Paciente> pacientesActivos = pacData.ListarPacienteActivos();
        System.out.println("Pacientes activos");
        for (Paciente paciente : pacientesActivos) {
            System.out.println(paciente);
        }

        System.out.println("----------------------------------------------------");
        //Mostramos los pacientes dados de Baja
        List<Paciente> pacientesDadosDeBaja = pacData.ListarPacienteDadoBaja();
        System.out.println("Pacientes dados de baja:");
        for (Paciente paciente : pacientesDadosDeBaja) {
            System.out.println(paciente);
        }

        // Buscamos un paciente por su código
        Paciente pacienteBuscado = pacData.buscarPaciente(1); //Ingresamos el id por parametro
        if (pacienteBuscado != null) {
            System.out.println("Paciente encontrado: " + pacienteBuscado.getNombre());
        } else {
            System.out.println("No se encontro ningun paciente con este codigo");
        }

        /*Dar de baja al paciente*/
        pacData.estadoAltaPaciente(1);
        /* Ingresamos el id del paciente para dar de baja (Baja == FALSE) */

        /*Dar de alta al paciente*/
        //pacData.estadoBajaPaciente(1); /* Ingresamos el id del paciente para alta de baja (Baja == TRUE) */
    }

    public static void testReglon() throws SQLException {
        RenglonDeMenuData dat = new RenglonDeMenuData();

        Alimento ali = new Alimento();
        ali.setCodComida(1);
        MenuDiario men = new MenuDiario();
        men.setCodMenu(1);

        RenglonDeMenu ren = new RenglonDeMenu(123, 123, ali, men, "manana");

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
