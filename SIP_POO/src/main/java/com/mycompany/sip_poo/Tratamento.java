/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

/**
 *
 * @author Windows
 */
public class Tratamento extends RegistroClinico {

    private String tipoTratamento, prescricao;
    private int duracaoDias;

    public Tratamento(int id, String data, String desc, Veterinario vet, String tipoTratamento) {
        super(id, data, desc, vet);
        this.tipoTratamento = tipoTratamento;
        this.duracaoDias = 0;
        this.prescricao = "";
    }

    public String getTipoTratamento() {
        return tipoTratamento;
    }

    public void setDuracaoDias(int duracaoDias) {
        if (!isFinalizado() && duracaoDias >= 0) {
            this.duracaoDias = duracaoDias;
        }
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public void setPrescricao(String prescricao) {
        if (!isFinalizado()) {
            this.prescricao = prescricao;
        }
    }

    public String getPrescricao() {
        return prescricao;
    }

    @Override
    public void exibir() {
        System.out.println("[TRATAMENTO] " + tipoTratamento + " | Dias: " + duracaoDias);
    }
}
