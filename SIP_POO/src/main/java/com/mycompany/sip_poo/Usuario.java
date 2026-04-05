/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

/**
 *
 * @author Windows
 */
public class Usuario {

    private int id;
    private String nome, email, senha, perfil;
    private boolean ativo;
    private String dataCadastro;

    public Usuario(int id, String nome, String email, String senha, String perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    public boolean login(String email, String senha) {
        if (!ativo) {
            return false;
        }
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void logout() {
        System.out.println("[USUARIO] Logout realizado: " + nome);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
             System.out.println("Email Invalido");
        }
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }
    

    public boolean isAtivo() {
        return ativo;
    }

    public void desativar() {
        this.ativo = false;
    }

    public void exibir() {
        System.out.println("[USUARIO] " + nome + " | " + email + " | Perfil: " + perfil);
    }
}
