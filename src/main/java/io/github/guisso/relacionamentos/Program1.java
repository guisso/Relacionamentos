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

import io.github.guisso.relacionamentos.entidade.Telefone;
import io.github.guisso.relacionamentos.entidade.Cliente;
import io.github.guisso.relacionamentos.entidade.Credencial;
import io.github.guisso.relacionamentos.entidade.EmpregadoComissionado;
import io.github.guisso.relacionamentos.entidade.EmpregadoHorista;
import io.github.guisso.relacionamentos.entidade.EmpregadoMensalista;
import java.util.Arrays;

/**
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 */
public class Program1 {

    /**
     * Fundamentos de arranjos e sua aplicação na definição de relacionamentos
     *
     * <pre>Pressione SHIFT+F6 para executar este método</pre>
     *
     * @param args Não utilizado
     */
    public static void main(String[] args) {

        // Declaração de arranjos
//        int[] idades, pesos, alturas;
//        int idades[], pesos[], alturas[];
//        int produtos[], desconto, caixas[];
        int[] idades1 = new int[3];
        idades1[0] = 15;
        idades1[1] = 18;
        idades1[2] = 17;
        // IndexOutOfBoundException
//        idades[3] = 17;
        System.out.println("01 > "
                // Classe Arrays possui este método estático para
                // simplificar a exibição dos dados de um arranjo
                + Arrays.toString(idades1));
        // versus
//                + idades1);

        int[] idades2 = {15, 18, 17};
        // IndexOutOfBoundException
//        int idades[3]; // = { 15, 18, 17 };

        // Acesso direto aos elementos do arranjo
        System.out.println("02 > "
                + idades2[0] + ", "
                + idades2[1] + ", "
                + idades2[2]);

        String[] cores = new String[3];
        cores[0] = "vermelho";
        cores[1] = "verde";
        cores[2] = "azul";

        // for com controle de índices
        for (int i = 0; i < cores.length; i++) {
            System.out.println("03 > " + cores[i]);
        }

        // for aprimorado (ou avançado)
        for (String c : cores) {
            System.out.println("04 > " + c);
        }

        //
        // Relacionamentos
        //
        Credencial cre1
                = new Credencial("ana@mail.com", "asdf123", true);
        System.out.println("05 > " + cre1);

        Cliente cli1
                = new Cliente();
//                = new Cliente("Ana Zayra");
        cli1.setNome("Ana Zaira");
        System.out.println("06 > " + cli1);

        Telefone t1 = new Telefone((byte) 38, 21044141);
        Telefone t2 = new Telefone((byte) 38, 21044242);

        // Estabelecimento manual dos relacionamentos
        cli1.getTelefones()[0] = t1;
        t1.setCliente(cli1);

        cli1.getTelefones()[1] = t2;
        t2.setCliente(cli1);

        // Bidirecionalidade automática implementada no método
        cli1.alocarTelefone(0, t1);
        cli1.alocarTelefone(1, t2);

        // Maneira mais elegante de executar definição de telefones
        cli1.alocarTelefonePrincipal(t1);
        cli1.alocarTelefoneSecundario(t2);

        // Relacionamento cliente/credencial
        // com biderecionalidade automática via setter
        cli1.setCredencial(cre1);

        // Verificação do relacionamento
        System.out.println("07 > " + cli1);
        System.out.println("08 > " + cre1);
        
        // Remover telefone principal de cli1 manualmente
        cli1.getTelefones()[0] = null;

        // Maneira mais elegante de executar remoção de telefones
        cli1.removerTelefonePrincipal();
        cli1.removerTelefoneSecundario();
        
        // Verificação da remoção dos telefones
        System.out.println("09 > " + cli1);

        // Qual o email do cliente 1?
        System.out.println("10 > Email: "
                + cli1.getCredencial().getEmail());

        // Qual o nome do cliente da credencial 1?
        System.out.println("11 > "
                + cre1.getCliente().getNome());

        //
        // Testes com arranjos de tipos abstratos de dados
        //
        EmpregadoMensalista[] funcs1 = new EmpregadoMensalista[2];

        EmpregadoMensalista eAux;

        eAux = new EmpregadoMensalista();
        eAux.setNome("Ana");
        eAux.setSalarioFixo(1111.11);
        funcs1[0] = eAux;

        eAux = new EmpregadoMensalista();
        eAux.setNome("Beatriz");
        eAux.setSalarioFixo(2222.22);
        funcs1[1] = eAux;

        double salarioMensalistaTotal = 0;
        for (EmpregadoMensalista e : funcs1) {
            System.out.println("12 > " + e.getNome()
                    + " : R$ " + e.calcularSalario());
            salarioMensalistaTotal += e.calcularSalario();
        }

        EmpregadoHorista[] funcs2 = new EmpregadoHorista[2];

        EmpregadoHorista eAuxH;

        eAuxH = new EmpregadoHorista();
        eAuxH.setNome("Cecília");
        eAuxH.setHorasTrabalhadas(100.0);
        eAuxH.setValorHora(99.99);
        funcs2[0] = eAuxH;

        eAuxH = new EmpregadoHorista();
        eAuxH.setNome("Deise");
        eAuxH.setHorasTrabalhadas(200.0);
        eAuxH.setValorHora(55.55);
        funcs2[1] = eAuxH;

        double salarioHoristaTotal = 0;
        for (EmpregadoHorista e : funcs2) {
            System.out.println("13 > " + e.getNome()
                    + " : R$ " + e.calcularSalario());
            salarioHoristaTotal += e.calcularSalario();
        }

        EmpregadoComissionado[] funcs3 = new EmpregadoComissionado[2];

        EmpregadoComissionado eAuxC;

        eAuxC = new EmpregadoComissionado();
        eAuxC.setNome("Eugênia");
        eAuxC.setSalarioFixo(777.77);
        eAuxC.setVenda(2000.00);
        eAuxC.setComissao(.1);
        funcs3[0] = eAuxC;

        eAuxC = new EmpregadoComissionado();
        eAuxC.setNome("Fernanda");
        eAuxC.setSalarioFixo(999.99);
        eAuxC.setVenda(5000.00);
        eAuxC.setComissao(.05);
        funcs3[1] = eAuxC;

        double salarioComissionadoTotal = 0;
        for (EmpregadoComissionado e : funcs3) {
            System.out.println("14 > " + e.getNome()
                    + " : R$ " + e.calcularSalario());
            salarioComissionadoTotal += e.calcularSalario();
        }

        // Cálculo da folha de pagamento total
        System.out.println("15 > R$ "
                + (salarioMensalistaTotal
                + salarioHoristaTotal
                + salarioComissionadoTotal));

    }
}
