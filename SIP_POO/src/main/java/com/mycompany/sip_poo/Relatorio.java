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
public class Relatorio {

    private int id, mes, ano, totalAtendimentos;
    private double faturamentoTotal, totalDespesas, taxaRetorno, tempMedioAtend;
    private String procedMaisRealizado;

    public Relatorio(int mes, int ano) {
        this.id = mes * 100 + ano;
        this.mes = mes;
        this.ano = ano;
        this.totalAtendimentos = 0;
        this.faturamentoTotal = 0;
        this.totalDespesas = 0;
        this.taxaRetorno = 0;
        this.tempMedioAtend = 0;
        this.procedMaisRealizado = "NENHUM";
    }

    public double calcularFaturamento() {
        double total = 0;
        ArrayList<Tutor> tutores = Recepcionista.getTutores();

        for (int i = 0; i < tutores.size(); i++) {
            ArrayList<Fatura> lista = Fatura.buscarPorTutor(tutores.get(i));

            for (int j = 0; j < lista.size(); j++) {
                total += lista.get(j).getValor();
            }
        }

        return total;
    }

    public void gerar() {
        totalAtendimentos = Recepcionista.getAgendamentos().size();
        faturamentoTotal = calcularFaturamento();
        taxaRetorno = calcularTaxaRetorno();
        tempMedioAtend = calcularTempMedio();
        procedMaisRealizado = getProcedMaisRealizado();
    }

    public String getEstatisticas() {
        return "Atendimentos: " + totalAtendimentos + " | Faturamento: " + faturamentoTotal + " | Taxa Retorno: " + taxaRetorno
                + " | Tempo Medio: " + tempMedioAtend + " | Mais realizado: " + procedMaisRealizado;
    }

    public double calcularTaxaRetorno() {
        int comRetorno = 0;
        int total = 0;

        ArrayList<Animal> animais = Recepcionista.getAnimais();

        for (int i = 0; i < animais.size(); i++) {
            List<Consulta> consultas = animais.get(i).getHistorico().getConsultas();

            for (int j = 0; j < consultas.size(); j++) {
                total++;

                if (consultas.get(j).getDataRetorno() != null
                        && !consultas.get(j).getDataRetorno().isEmpty()) {
                    comRetorno++;
                }
            }
        }

        if (total == 0) {
            return 0;
        }

        return (comRetorno * 100.0) / total;
    }

    public double calcularTempMedio() {
        int total = Recepcionista.getAgendamentos().size();

        if (total == 0) {
            return 0;
        }

        return 45.0;
    }

    public String getProcedMaisRealizado() {
        int consultas = 0, exames = 0, cirurgias = 0;

        ArrayList<Agendamento> lista = Recepcionista.getAgendamentos();

        for (int i = 0; i < lista.size(); i++) {
            String tipo = lista.get(i).getTipo();

            if (tipo.equalsIgnoreCase("CONSULTA")) {
                consultas++;
            } else if (tipo.equalsIgnoreCase("EXAME")) {
                exames++;
            } else if (tipo.equalsIgnoreCase("CIRURGIA")) {
                cirurgias++;
            }
        }

        if (consultas >= exames && consultas >= cirurgias) {
            return "CONSULTA";
        }
        if (exames >= consultas && exames >= cirurgias) {
            return "EXAME";
        }

        return "CIRURGIA";
    }

    public void exportar() {
        System.out.println("[RELATORIO EXPORTADO] " + getEstatisticas());
    }

    public void exibir() {
        System.out.println("[RELATORIO] Mes: " + mes + "/" + ano + " | " + getEstatisticas());
    }
}
