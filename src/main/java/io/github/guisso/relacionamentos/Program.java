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

import java.util.Scanner;

/**
 * Classe Program
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 2022-09-20
 */
public class Program {

    public static void main(String[] args) {
        String op;
        Scanner in = new Scanner(System.in);
        
        do {
            System.out.println("Qual bateria de testes deseja executar?\n");
            System.out.println("1 Fundamentos de arranjos e sua aplicação na definição de relacionamentos");
            System.out.println("2 Operações em ArrayList de tipos de dados abstratos");
            System.out.println("3 Fundamentos de herança e polimorfismo\n");
            
            op = in.next();
            
        } while (!op.equals("1") 
                && !op.equals("2") 
                && !op.equals("3"));
        
        System.out.println("");
        
        switch (op) {
            case "1":
                System.out.println("Program1");
                Program1.main(null);
                break;
                
            case "2":
                System.out.println("Program2");
                Program2.main(null);
                break;
                
            case "3":
                System.out.println("Program3");
                Program3.main(null);
                break;
        }
        
    }
}
