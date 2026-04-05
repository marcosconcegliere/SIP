/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows
 */
public class Veterinario extends Usuario {

    private String crmv, especialidade;
    private boolean disponivel;

    public Veterinario(int id, String nome, String email, String senha, String perfil, String crmv, String especialidade) {
        super(id, nome, email, senha, perfil);
        this.crmv = crmv;
        this.especialidade = especialidade;
    }

    public String getCrmv() {
        return crmv;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void registrarLaudo(String laudo) {
        System.out.println("[LAUDO] " + laudo);
    }

    public void emitirPrescricao(String prescricao) {
        System.out.println("[PRESCRIÇÃO] " + prescricao);
    }

    public List<Agendamento> consultarAgenda() {
        System.out.println("[AGENDA] " + getNome());
        return new ArrayList<>();
    }

    @Override
    public void exibir() {
        System.out.println("[USUARIO] Login:" + getEmail() + " - Perfil: " + getPerfil());
    }
}
