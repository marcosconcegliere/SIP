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
public class ItemEstoque {

    private int id, quantidade, quantidadeMinima;
    private String nome, lote, validade, responsavelRetirada, categoria;
    private boolean controlado;

    public ItemEstoque(int id, String nome, int qtd, int qtdMin, String lote) {
        this.id = id;
        this.nome = nome;
        this.quantidade = qtd;
        this.quantidadeMinima = qtdMin;
        this.lote = lote;
        this.validade = "";
        this.controlado = false;
        this.responsavelRetirada = "";
        this.categoria = "";
    }

    public void darEntrada(int qtd, String resp) {
        if (qtd > 0) {
            quantidade = quantidade + qtd;
            responsavelRetirada = resp;
        }
    }

    public boolean darSaida(int qtd, String resp) {
        if (qtd <= 0) {
            return false;
        }
        if (controlado) {
            if (lote == null) {
                return false;
            }
            if (validade == null) {
                return false;
            }
            if (resp == null) {
                return false;
            }
        }
        if (quantidade >= qtd) {
            quantidade = quantidade - qtd;
            responsavelRetirada = resp;
            return true;
        }
        return false;
    }

    public boolean reservar(int qtd) {
        return darSaida(qtd, "RESERVA_AUTOMATICA");
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isAbaixoMinimo() {
        return quantidade < quantidadeMinima;
    }

    public boolean isControlado() {
        return controlado;
    }

    public String getStatus() {
        if (isAbaixoMinimo()) {
            return "BAIXO";
        } else {
            return "OK";
        }
    }

    public boolean isVencido() {
        if (validade == null || validade.isEmpty()) {
            return false;
        }
        try {
            LocalDate v = LocalDate.parse(validade);
            return v.isBefore(LocalDate.now());
        } catch (Exception e) {
            return false;
        }
    }

    public String getLote() {
        return lote;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void exibir() {
        System.out.println("[ESTOQUE] " + nome + " | Qtd: " + quantidade + " | Minimo: " + quantidadeMinima + " - " + getStatus());
    }
}
