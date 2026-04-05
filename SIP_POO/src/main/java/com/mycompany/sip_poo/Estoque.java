/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows
 */
public class Estoque {

    private ArrayList<ItemEstoque> itens;
    private Notificador notificador;

    public Estoque(Notificador notificador) {
        this.itens = new ArrayList<ItemEstoque>();
        this.notificador = notificador;
    }

    public void adicionarItem(ItemEstoque item) {
        if (item != null) {
            itens.add(item);
        }
    }

    public void registrarEntrada(int id, int qtd, String resp) {
        for (ItemEstoque item : itens) {
            if (item.getId() == id) {
                item.darEntrada(qtd, resp);
                verificarAlertas();
                return;
            }
        }
    }

    public boolean registrarSaida(int id, int qtd, String resp) {
        for (ItemEstoque item : itens) {
            if (item.getId() == id) {
                boolean ok = item.darSaida(qtd, resp);
                verificarAlertas();
                return ok;
            }
        }
        return false;
    }

    public boolean reservarParaProced(int id, int qtd) {
        ItemEstoque item = buscarItem(id);

        if (item != null) {
            return item.reservar(qtd);
        }

        return false;
    }

    public void verificarAlertas() {
        for (ItemEstoque item : itens) {
            if (item.isAbaixoMinimo() && notificador != null) {
                notificador.enviarAlertaEstoque(item);
            }
        }
    }

    public ItemEstoque buscarItem(int id) {
        for (ItemEstoque item : itens) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<ItemEstoque> getItens() {
        return itens;
    }

    public void exibir() {
        for (ItemEstoque item : itens) {
            item.exibir();
        }
    }
}
