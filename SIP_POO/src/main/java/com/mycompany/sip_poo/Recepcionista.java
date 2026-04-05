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
public class Recepcionista extends Usuario {

    private String ramal, turno;
    private static ArrayList<Tutor> tutores = new ArrayList<>();
    private static ArrayList<Animal> animais = new ArrayList<>();
    private static ArrayList<Agendamento> agendamentos = new ArrayList<>();

    public Recepcionista(String ramal, int id, String nome, String email, String senha, String perfil) {
        super(id, nome, email, senha, perfil);
        this.ramal = ramal;
        this.turno = "";
    }

    public void cadastrarTutor(Tutor t) {
        if (t == null) {
            return;
        }
        Tutor existente = buscarTutor(t.getId());
        if (existente == null) {
            tutores.add(t);
        }
    }

    public void cadastrarAnimal(Animal a) {
        if (a == null) {
            return;
        }
        Animal existente = buscarAnimal(a.getId());
        if (existente == null) {
            animais.add(a);
            Tutor tutor = a.getTutor();
            if (tutor != null) {
                tutor.adicionarAnimal(a);
                cadastrarTutor(tutor);
            }
        }
    }

    public void agendarConsulta(Agendamento agendamento) {
        if (agendamento != null) {
            agendamentos.add(agendamento);
            agendamento.agendar();
        }
    }

    public void cancelarConsulta(Agendamento agendamento) {
        if (agendamento != null) {
            agendamento.cancelar();
        }
    }

    public Tutor buscarTutor(int id) {
        for (Tutor t : tutores) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public Animal buscarAnimal(int id) {
        for (Animal a : animais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public static ArrayList<Tutor> getTutores() {
        return tutores;
    }

    public static ArrayList<Animal> getAnimais() {
        return animais;
    }

    public static ArrayList<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    @Override
    public void exibir() {
        System.out.println("[RECEPCIONISTA] " + getNome());
    }
}
