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

        //
        /*Estan todos los metodos hechos, Solo tiene que borrar el comentario para probar*/
        //
        
        // Creamos un paciente y lo agregamos
        Paciente nuevoPaciente = new Paciente("Jepeto", 44562221, 19, 160, 70, false);
        //pacData.agregarPaciente(nuevoPaciente); /* Borrar el comentario para probar el agregar Paciente */

        // Modificamos los datos del paciente
        Paciente pacienteModificado = new Paciente(); 
        pacienteModificado.setNombre("Jepeto");
        pacienteModificado.setDni(44562221);
        pacienteModificado.setEdad(17);
        pacienteModificado.setAltura(176);
        pacienteModificado.setBaja(true);
        pacienteModificado.setNroPaciente(2);
        pacienteModificado.setPesoActual(70);

        //pacData.modificarPaciente(pacienteModificado); /* Borrar el comentario para probar el modificar Paciente */
        
        
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
        pacData.estadoAltaPaciente(1); /* Ingresamos el id del paciente para dar de baja (Baja == FALSE) */
        
        /*Dar de alta al paciente*/
        //pacData.estadoBajaPaciente(1); /* Ingresamos el id del paciente para alta de baja (Baja == TRUE) */
    }
}
