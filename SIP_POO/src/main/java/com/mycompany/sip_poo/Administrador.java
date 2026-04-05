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
public class Administrador extends Usuario {

    private int nivelAcesso;
    private String departamento;

    public Administrador(int nivelAcesso, String departamento, int id, String nome, String email, String senha, String perfil) {
        super(id, nome, email, senha, perfil);
        this.nivelAcesso = nivelAcesso;
        this.departamento = departamento;
    }

    public Relatorio gerarRelatorio(int mes, int ano) {
        Relatorio relatorio = new Relatorio(mes, ano);
        relatorio.gerar();
        return relatorio;
    }

    public boolean excluirRegistro(int id, String tipo) {
        if (tipo == null || tipo.isEmpty()) {
            return false;
        }
        System.out.println("[ADMIN] Excluiu registro " + id + " do tipo: " + tipo);
        return true;
    }

    public void ajustarEstoque(ItemEstoque item, int qtd) {
        if (item == null) {
            return;
        }

        if (qtd > 0) {
            System.out.println("[ADMIN] Entrada de " + qtd + " no item: " + item.getNome());
        } else if (qtd < 0) {
            System.out.println("[ADMIN] Saída de " + (-qtd) + " do item: " + item.getNome());
        } else {
            System.out.println("[ADMIN] Nenhuma alteração no estoque");
        }
    }

    public void gerenciarUsuario(Usuario u) {
        if (u != null) {
            System.out.println("Gerenciando usuario: " + u.getNome());
        }
    }

    public List<String> visualizarLogs() {
        return new ArrayList<String>();
    }

    @Override
    public void exibir() {
        System.out.println("Administrador:  " + getNome() + " Departamento: " + departamento + " Nivel de acesso: " + nivelAcesso);
    }
}
