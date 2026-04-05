/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Windows
 */
public class LogAuditoria {

    private int id, idEntidade;
    private String dataHora, acao, entidadeAfetada, ipOrigem;
    private Usuario usuario;
    private static ArrayList<LogAuditoria> logs = new ArrayList<LogAuditoria>();

    public LogAuditoria(Usuario usuario, String acao, String entidade) {
        this.id = logs.size() + 1;
        this.usuario = usuario;
        this.acao = acao;
        this.entidadeAfetada = entidade;
        this.idEntidade = 0;
        this.ipOrigem = "";
        this.dataHora = "";
    }

    public void registrar() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.dataHora = LocalDateTime.now().format(formato);
        logs.add(this);
    }

    public String getAcao() {
        return acao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getDataHora() {
        return dataHora;
    }

    public static ArrayList<LogAuditoria> buscarPorUsuario(Usuario u) {
        ArrayList<LogAuditoria> lista = new ArrayList<LogAuditoria>();
        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i).getUsuario() == u) {
                lista.add(logs.get(i));
            }
        }
        return lista;
    }

    public static ArrayList<LogAuditoria> buscarPorEntidade(String e) {
        ArrayList<LogAuditoria> lista = new ArrayList<LogAuditoria>();
        for (int i = 0; i < logs.size(); i++) {
            if (logs.get(i).entidadeAfetada.equalsIgnoreCase(e)) {
                lista.add(logs.get(i));
            }
        }
        return lista;
    }

    public static ArrayList<LogAuditoria> getLogs() {
        return logs;
    }

    public void exibir() {
        System.out.println("[LOG] " + dataHora + " | Usuario: " + usuario.getNome() + " | Acao: " + acao);
    }
}
