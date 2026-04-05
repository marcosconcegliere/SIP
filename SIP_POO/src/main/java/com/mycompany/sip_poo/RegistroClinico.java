/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

/**
 *
 * @author Windows
 */
public class RegistroClinico {

    private int id;
    private String data;
    private String descricao;
    private Veterinario veterinario;
    private String laudoAnexo;
    private boolean finalizado;

    public RegistroClinico(int id, String data, String descricao, Veterinario veterinario) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.veterinario = veterinario;
        this.laudoAnexo = "";
        this.finalizado = false;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void finalizar() {
        this.finalizado = true;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void anexarLaudo(String destino) {
        if (!finalizado && destino != null) {
            this.laudoAnexo = destino;
        }
    }

    public String getLaudo() {
        return laudoAnexo;
    }

    public void exibir() {
        System.out.println("[REGISTRO] " + id + " | " + data + " | " + descricao);
    }
}
