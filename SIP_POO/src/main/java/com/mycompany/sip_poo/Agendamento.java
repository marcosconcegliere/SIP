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
public class Agendamento {

    private int id;
    private String dataHora, tipo, status, sala;
    private Animal animal;
    private Veterinario veterinario;
    private Notificador notificador;
    private ArrayList<String> historico;

    public Agendamento(int id, String dataHora, String tipo, Animal animal, Veterinario veterinario, Notificador notificador) {
        this.id = id;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.animal = animal;
        this.veterinario = veterinario;
        this.notificador = notificador;
        this.status = "AGENDADO";
        this.sala = "";
        this.historico = new ArrayList<String>();
    }
    
    public String getTipo() {
        return tipo;
    }

    public String getDataHora() {
        return dataHora;
    }

    public boolean agendar() {
        if (!validarVeterinario()) {
            System.out.println("Veterinário indisponível");
            return false;
        }

        if (!validarHorario()) {
            System.out.println("Fora do horário permitido (08h–18h)");
            return false;
        }

        status = "AGENDADO";
        notificador.enviarConfirmacao(this);
        return true;
    }

    public void cancelar() {
        status = "CANCELADO";
        notificador.enviarCancelamento(this);
    }

    public void reagendar(String novaDataHora) {
        this.dataHora = novaDataHora;
        status = "REAGENDADO";
        notificador.enviarReagendamento(this);
    }

    public boolean validarHorario() {
        try {
            int hora = Integer.parseInt(dataHora.substring(0, 2));
            return hora >= 8 && hora < 18;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validarVeterinario() {
        return veterinario != null && veterinario.isDisponivel();
    }

    public boolean reservarRecursos() {
        return veterinario != null && veterinario.isDisponivel();
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<String> getHistorico() {
        return historico;
    }

    public void notificarTutor() {
        if (notificador != null) {
            notificador.enviarConfirmacao(this);
        }
    }

    public void exibir() {
        System.out.println("[AGENDAMENTO] Tipo: " + tipo + " | Status: " + status);
    }
}
