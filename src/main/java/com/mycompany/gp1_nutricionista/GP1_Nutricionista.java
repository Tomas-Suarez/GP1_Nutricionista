/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gp1_nutricionista;

import Modelo.Alimento;
import Persistencia.AlimentoData;
import java.sql.SQLException;

/**
 *
 * @author Tomi
 */
public class GP1_Nutricionista {

    public static void main(String[] args) {
        testAlimentoData();
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

}
