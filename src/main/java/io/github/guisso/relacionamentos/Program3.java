/*
 * CC BY-NC-SA 4.0
 *
 * Copyright 2022 Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;.
 *
 * Attribution-NonCommercial-ShareAlike 4.0 International (CC BY-NC-SA 4.0)
 *
 * You are free to:
 *   Share - copy and redistribute the material in any medium or format
 *   Adapt - remix, transform, and build upon the material
 *
 * Under the following terms:
 *   Attribution - You must give appropriate credit, provide 
 *   a link to the license, and indicate if changes were made.
 *   You may do so in any reasonable manner, but not in any 
 *   way that suggests the licensor endorses you or your use.
 *   NonCommercial - You may not use the material for commercial purposes.
 *   ShareAlike - If you remix, transform, or build upon the 
 *   material, you must distribute your contributions under 
 *   the same license as the original.
 *   No additional restrictions - You may not apply legal 
 *   terms or technological measures that legally restrict 
 *   others from doing anything the license permits.
 *
 * Notices:
 *   You do not have to comply with the license for elements 
 *   of the material in the public domain or where your use 
 *   is permitted by an applicable exception or limitation.
 *   No warranties are given. The license may not give you 
 *   all of the permissions necessary for your intended use. 
 *   For example, other rights such as publicity, privacy, 
 *   or moral rights may limit how you use the material.
 */
package io.github.guisso.relacionamentos;

import io.github.guisso.relacionamentos.entidade.Empregado;
import io.github.guisso.relacionamentos.entidade.EmpregadoComissionado;
import io.github.guisso.relacionamentos.entidade.EmpregadoHorista;
import io.github.guisso.relacionamentos.entidade.EmpregadoMensalista;

/**
 * Classe Program3
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 2022-09-20
 */
public class Program3 {

    /**
     * Fundamentos de herança e polimorfismo
     *
     * <pre>Pressione SHIFT+F6 para executar este método</pre>
     *
     * @param args Não utilizado
     */
    public static void main(String[] args) {
        // Empregado
        Empregado empregado;

        // Empregado mensalista
        EmpregadoMensalista empregadoMensalista;

        // Operações básicas com empregado
        empregado = new Empregado();
        empregado.setNome("Alfredo");
        System.out.println("> " + empregado.getNome()
                + " -> R$ " + empregado.calcularSalario());

        // Operações básicas com empregado mensalista
        empregadoMensalista = new EmpregadoMensalista(1111.11);
        empregadoMensalista.setNome("Bertoldo");
        System.out.println("> " + empregadoMensalista.getNome()
                + " -> R$ " + empregadoMensalista.calcularSalario());

        // Testes de relacionamento É-UM
        // * Note o tipo da variável "empregado"
        //   versus o tipo de objeto que recebe
        empregado = empregadoMensalista;
        empregado.setNome("Ana Zaira");
        System.out.println("> " + empregado.getNome()
                + " -> R$ " + empregado.calcularSalario());

        empregado = new EmpregadoHorista(11.11, 2.0);
        empregado.setNome("Beatriz Yana");
        System.out.println("> " + empregado.getNome()
                + " -> R$ " + empregado.calcularSalario());

        empregado = new EmpregadoComissionado(233.33, 1000.0, .1);
        empregado.setNome("Cecília Xerxes");
        System.out.println("> " + empregado.getNome()
                + " -> R$ " + empregado.calcularSalario());
    }
}
