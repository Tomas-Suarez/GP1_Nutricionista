package com.mycompany.gp1_nutricionista;

import Modelo.Alimento;
import Modelo.Dieta;
import Modelo.MenuDiario;
import Modelo.Paciente;
import Persistencia.AlimentoData;
import Persistencia.MenuDiarioData;
import Persistencia.PacienteData;
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
        //testMenuDiario();
        //testPaciente();
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
        PacienteData pacData = new PacienteData();

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
}
