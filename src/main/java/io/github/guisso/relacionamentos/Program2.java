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

import io.github.guisso.relacionamentos.entidade.EmpregadoMensalista;
import java.util.ArrayList;

/**
 * Classe Program2
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 2022-09-19
 */
public class Program2 {

    /**
     * Operações em ArrayList de tipos de dados abstratos
     *
     * <pre>Pressione SHIFT+F6 para executar este método</pre>
     *
     * @param args Não utilizado
     */
    public static void main(String[] args) {

        // Testa ArrayList de empregados mensalistas
        ArrayList<EmpregadoMensalista> empregadosMensalistas;
        empregadosMensalistas = new ArrayList<>();

        // Auxiliar para montagem de novo empregado mensalista
        EmpregadoMensalista empregadoMensalistaAuxiliar;

        // 0
        empregadoMensalistaAuxiliar = new EmpregadoMensalista();
        empregadoMensalistaAuxiliar.setNome("Ana");
        empregadoMensalistaAuxiliar.setSalarioFixo(1111.11);
        empregadosMensalistas.add(empregadoMensalistaAuxiliar);
        System.out.println("* Primeiro empregado adicionado");
        imprimirEmpregadosMensalistas(empregadosMensalistas);

        // 1
        empregadoMensalistaAuxiliar = new EmpregadoMensalista();
        empregadoMensalistaAuxiliar.setNome("Beatriz");
        empregadoMensalistaAuxiliar.setSalarioFixo(2222.22);
        empregadosMensalistas.add(empregadoMensalistaAuxiliar);
        System.out.println("* Segundo empregado adicionado");
        imprimirEmpregadosMensalistas(empregadosMensalistas);

        // 2
        empregadoMensalistaAuxiliar = new EmpregadoMensalista();
        empregadoMensalistaAuxiliar.setNome("Cecília");
        empregadoMensalistaAuxiliar.setSalarioFixo(3333.33);
        empregadosMensalistas.add(empregadoMensalistaAuxiliar);
        System.out.println("* Terceiro empregado adicionado");
        imprimirEmpregadosMensalistas(empregadosMensalistas);

        // Acesso ao objeto da posição 1 (base 0)
        System.out.println("* Impressão do nome do segundo empregado");
        System.out.println(empregadosMensalistas.get(1).getNome());

        // Movimenta demais objetos e aloca na posição específica
        empregadosMensalistas.add(0, empregadoMensalistaAuxiliar);
        System.out.println("* Novo empregado adicionado na posição 0");
        imprimirEmpregadosMensalistas(empregadosMensalistas);

        // Substitui objeto da posição específica
        empregadosMensalistas.set(2, empregadoMensalistaAuxiliar);
        System.out.println("* Substituição do empregado da posição 2");
        imprimirEmpregadosMensalistas(empregadosMensalistas);

        // Remove objeto da posição específica
        empregadosMensalistas.remove(1);
        System.out.println("* Remoção do empregado da posição 1");
        imprimirEmpregadosMensalistas(empregadosMensalistas);

        // Cálculo do pagamento total
        System.out.println("* Cálculo do salário total dos mensalistas");
        double salarioMensalistaTotal = 0;
        for (EmpregadoMensalista e : empregadosMensalistas) {
            salarioMensalistaTotal += e.calcularSalario();
        }

        System.out.println("R$ " + salarioMensalistaTotal);
        System.out.printf("R$ %,.2f", salarioMensalistaTotal);

    }

    private static void imprimirEmpregadosMensalistas(
            // Modificador final indica que não serão permitidas
            // alterações no ArrayList que está sendo recebido
            final ArrayList<EmpregadoMensalista> empregados) {

        for (EmpregadoMensalista e : empregados) {
            System.out.println(e.getNome()
                    + " -> R$ " + e.calcularSalario());
        }
    }
}
