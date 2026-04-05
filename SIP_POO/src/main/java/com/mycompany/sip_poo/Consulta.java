/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

/**
 *
 * @author Windows
 */
public class Consulta extends RegistroClinico {

    private String motivo;
    private String prescricao;
    private String dataRetorno;

    public Consulta(int id, String data, String descricao, Veterinario veterinario, String motivo) {
        super(id, data, descricao, veterinario);
        this.motivo = motivo;
        this.prescricao = "";
        this.dataRetorno = "";
    }

    public String getMotivo() {
        return motivo;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setPrescricao(String prescricao) {
        if (!isFinalizado()) {
            this.prescricao = prescricao;
        }
    }

    public void setDataRetorno(String dataRetorno) {
        if (!isFinalizado()) {
            this.dataRetorno = dataRetorno;
        }
    }

    @Override
    public void exibir() {
        System.out.println("[CONSULTA] Motivo: " + motivo + " | Prescricao: " + prescricao);
    }
}
