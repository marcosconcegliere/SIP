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
public class Notificador {

    private String canal, destinatario;
    private boolean ativo;

    public Notificador(String canal, String destinatario) {
        this.canal = canal;
        this.destinatario = destinatario;
        this.ativo = true;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        if (canal != null && !canal.isEmpty()) {
            this.canal = canal;
        }
    }

    public void enviarConfirmacao(Agendamento ag) {
        if (ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " - " + destinatario + ": " + ag.getTipo() + " confirmada!");
        }
    }

    public void enviarCancelamento(Agendamento ag) {
        if (ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " - " + destinatario + ": " + ag.getTipo() + " cancelada!");
        }
    }

    public void enviarReagendamento(Agendamento ag) {
        if (ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " - " + destinatario + ": " + ag.getTipo() + " reagendado para " + ag.getDataHora());
        }
    }

    public void enviarLembreteVacina(Animal a, String dt) {
        if (ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " - " + destinatario + ": lembrete de vacina de " + a.
                    getNome() + " em " + dt);
        }
    }

    public void enviarAlertaEstoque(ItemEstoque item) {
        if (ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " - " + destinatario + ": estoque baixo de " + item.getNome());
        }
    }

    public void enviarFatura(Fatura f) {
        if (ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " - " + destinatario + ": fatura de R$" + f.getValor());
        }
    }

    public void enviarAlerta(String dest, String msg) {
        if (ativo) {
            System.out.println("[NOTIFICADOR] " + canal + " - " + dest + ": " + msg);
        }
    }

    public void enviarCampanha(ArrayList<String> lista, String msg) {
        if (!ativo || lista == null) {
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("[NOTIFICADOR] " + canal + " - " + lista.get(i) + ": " + msg);
        }
    }

}
