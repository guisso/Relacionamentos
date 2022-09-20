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
package io.github.guisso.relacionamentos.entidade;

/**
 * Classe Cliente
 *
 * @author Luis Guisso &lt;luis dot guisso at ifnmg dot edu dot br&gt;
 * @version 0.1, 2022-09-12
 */
public class Cliente {

    private String nome;
    private Credencial credencial;
    private Telefone[] telefones;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Cliente() {
        telefones = new Telefone[2];
        // ....
    }

    public Cliente(String nome) {
//        telefones = new Telefone[2];
        this();
        this.nome = nome;
    }

    public Cliente(String nome, Credencial credencial) {
//        telefones = new Telefone[2];
        this(nome);
//        this.nome = nome;
        this.credencial = credencial;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Credencial getCredencial() {
        return credencial;
    }

    public void setCredencial(Credencial credencial) {
        this.credencial = credencial;
        if (credencial != null) {
            credencial.setCliente(this);
        }
    }

    public Telefone[] getTelefones() {
        return telefones;
    }

    public void setTelefones(Telefone[] telefones) {
        this.telefones = telefones;
    }
    //</editor-fold>

    public void alocarTelefone(int pos, Telefone t) {
        telefones[pos] = t;
        if (t != null) {
            t.setCliente(this);
        }
    }

    public void alocarTelefonePrincipal(Telefone t) {
//        telefones[0] = t;
        alocarTelefone(0, t);
    }

    public void removerTelefonePrincipal() {
        if (telefones[0] != null) {
            telefones[0].setCliente(null);
        }
        alocarTelefone(0, null);
    }

    public void alocarTelefoneSecundario(Telefone t) {
//        telefones[1] = t;
        alocarTelefone(1, t);
    }

    public void removerTelefoneSecundario() {
        if (telefones[1] != null) {
            telefones[1].setCliente(null);
        }
        alocarTelefone(1, null);
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "nome=" + nome
                + ", telefone1=" + telefones[0]
                + ", telefone2=" + telefones[1]
                + ", credencial=" + credencial
                + '}';
    }

}
