/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Windows
 */
public class Animal {

    private int id;
    private String nome, especie, raca, dataNascimento;
    private double peso;
    private Tutor tutor;
    private HistoricoClinico historico;

    public Animal(int id, String nome, String especie, String raca, Tutor tutor) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.tutor = tutor;
        this.historico = new HistoricoClinico(id);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public HistoricoClinico getHistorico() {
        return historico;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso > 0) {
            this.peso = peso;
        }
    }

    public int calcularIdade() {
        try {
            LocalDate nascimento = LocalDate.parse(dataNascimento);
            return Period.between(nascimento, LocalDate.now()).getYears();
        } catch (Exception e) {
            return 0;
        }
    }

    public void exibir() {
        String nomeTutor = "Sem tutor";
        if (tutor != null) {
            nomeTutor = tutor.getNome();
        }
        System.out.println("[ANIMAL] " + nome + " | " + raca + " | Tutor: " + nomeTutor);
    }

    public void setDataNascimento(String dataNascimento) {
        if (dataNascimento != null && !dataNascimento.isEmpty()) {
            this.dataNascimento = dataNascimento;
        }
    }
    
}
