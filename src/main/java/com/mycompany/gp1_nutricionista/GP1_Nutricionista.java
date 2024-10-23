package com.mycompany.gp1_nutricionista;

import Modelo.Paciente;
import Persistencia.PacienteData;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Tomi
 */
public class GP1_Nutricionista {

    public static void main(String[] args) throws SQLException {
        testPaciente();
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
