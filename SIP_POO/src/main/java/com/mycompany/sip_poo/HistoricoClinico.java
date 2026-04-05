/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Windows
 */
public class HistoricoClinico {

    private int idAnimal;
    private List<Consulta> consultas;
    private List<Vacina> vacinas;
    private List<Cirurgia> cirurgias;
    private List<Exame> exames;
    private List<Tratamento> tratamentos;
    private boolean finalizado;

    public HistoricoClinico(int idAnimal) {
        this.idAnimal = idAnimal;
        this.consultas = new ArrayList<Consulta>();
        this.vacinas = new ArrayList<Vacina>();
        this.cirurgias = new ArrayList<Cirurgia>();
        this.exames = new ArrayList<Exame>();
        this.tratamentos = new ArrayList<Tratamento>();
        this.finalizado = false;
    }

    public void adicionarConsulta(Consulta c) {
        if (!finalizado && c != null) {
            consultas.add(c);
        }
    }

    public void adicionarVacina(Vacina v) {
        if (!finalizado && v != null) {
            vacinas.add(v);
        }
    }

    public void adicionarCirurgia(Cirurgia c) {
        if (!finalizado && c != null) {
            cirurgias.add(c);
        }
    }

    public void adicionarExame(Exame e) {
        if (!finalizado && e != null) {
            exames.add(e);
        }
    }

    public void adicionarTratamento(Tratamento t) {
        if (!finalizado && t != null) {
            tratamentos.add(t);
        }
    }

    public void finalizar() {
        this.finalizado = true;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public List<Cirurgia> getCirurgias() {
        return cirurgias;
    }
    
    public void exibir() {
        System.out.println("[HISTORICO]: " + "Consultas: " + consultas.size() + " | Vacinas: " + vacinas.size() + " | Cirurgias: " + cirurgias.size());
    }
}
