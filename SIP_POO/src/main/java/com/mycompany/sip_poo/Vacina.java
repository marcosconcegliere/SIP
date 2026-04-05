/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

import java.time.LocalDate;

/**
 *
 * @author Windows
 */
public class Vacina extends RegistroClinico {

    private String nomeVacina, dataAplicacao, dataReforco, lote, fabricante;

    public Vacina(int id, String data, String descricao, Veterinario vet, String nomeVacina) {
        super(id, data, descricao, vet);
        this.nomeVacina = nomeVacina;
        this.dataAplicacao = data;
        this.dataReforco = "";
        this.lote = "";
        this.fabricante = "";
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public String getDataReforco() {
        return dataReforco;
    }

    public void setDataReforco(String dataReforco) {
        if (!isFinalizado()) {
            this.dataReforco = dataReforco;
        }
    }

    public boolean precisaReforco() {
        if (dataReforco == null || dataReforco.isEmpty()) {
            return false;
        }
        try {
            LocalDate reforco = LocalDate.parse(dataReforco);
            return reforco.isBefore(LocalDate.now());
        } catch (Exception e) {
            return false;
        }
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        if (!isFinalizado()) {
            this.lote = lote;
        }
    }

    @Override
    public void exibir() {
        System.out.println("[VACINA] " + nomeVacina + " | Reforco: " + dataReforco);
    }
}
