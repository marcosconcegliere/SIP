/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class Cirurgia extends RegistroClinico {

    private int duracao;
    private String sala, anestesia;
    private ArrayList<String> equipe;
    private ArrayList<String> medicamentos;

    public Cirurgia(int id, String data, String descricao, Veterinario veterinario, String sala) {
        super(id, data, descricao, veterinario);
        this.sala = sala;
        this.duracao = 120;
        this.equipe = new ArrayList<String>();
        this.anestesia = "";
        this.medicamentos = new ArrayList<String>();
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        if (!isFinalizado()) {
            if (duracao >= 120) {
                this.duracao = duracao;
            } else {
                this.duracao = 120;
            }
        }
    }

    public String getSala() {
        return sala;
    }

    public void setEquipe(ArrayList<String> e) {
        if (!isFinalizado() && e != null) {
            this.equipe = e;
        }
    }

    public void adicionarMedicamento(String m) {
        if (!isFinalizado() && m != null && !m.isEmpty()) {
            medicamentos.add(m);
        }
    }

    public boolean validarRecursos() {
        return sala != null && !sala.isEmpty() && equipe.size() > 0 && medicamentos.size() > 0;
    }

    @Override
    public void exibir() {
        System.out.println("[CIRURGIA] Sala: " + sala + " | Duracao: " + duracao + " min");
    }
}
