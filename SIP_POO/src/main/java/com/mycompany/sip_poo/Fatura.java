/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class Fatura {

    private int id;
    private Tutor tutor;
    private double valor;
    private String dataEmissao, dataVencimento, status, descricaoServico;
    private Notificador notificador;

    private static ArrayList<Fatura> faturas = new ArrayList<Fatura>();

    public Fatura(int id, Tutor tutor, double valor, String desc, Notificador notif) {
        this.id = id;
        this.tutor = tutor;
        this.valor = valor;
        this.dataEmissao = LocalDate.now().toString();
        this.dataVencimento = LocalDate.now().plusDays(10).toString();
        this.status = "PENDENTE";
        this.descricaoServico = desc;
        this.notificador = notif;
        faturas.add(this);
    }

    public void emitir() {
        if (notificador != null) {
            notificador.enviarFatura(this);
        }
    }

    public String gerarBoleto() {
        return "BOLETO-" + id + "-" + tutor.getCpf();
    }

    public String gerarLinkPagamento() {
        return "https://pagamento.petcare/fatura/" + id;
    }

    public void registrarPagamento() {
        status = "PAGO";
    }

    public boolean confirmarPagOnline() {
        return true;
    }

    public boolean isPendente() {
        return status.equals("PENDENTE");
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public static ArrayList<Fatura> buscarPorTutor(Tutor tutor) {
        ArrayList<Fatura> lista = new ArrayList<Fatura>();
        for (int i = 0; i < faturas.size(); i++) {
            if (faturas.get(i).getTutor() == tutor) {
                lista.add(faturas.get(i));
            }
        }
        return lista;
    }

    public void exibir() {
        if (notificador != null) {
            notificador.enviarAlerta(tutor.getEmail(), "Fatura pronta: " + descricaoServico);
        }
        System.out.println("[FATURA] Valor: R$" + valor + " | Status: " + status);
    }
}
