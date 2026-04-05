/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sip_poo;

/**
 *
 * @author Windows
 */
public class Exame extends RegistroClinico {

    private String tipo, resultado, imagemAnexo, laboratorio;

    public Exame(int id, String data, String desc, Veterinario vet, String tipo) {
        super(id, data, desc, vet);
        this.tipo = tipo;
        this.resultado = "";
        this.imagemAnexo = "";
        this.laboratorio = "";
    }

    public String getTipo() {
        return tipo;
    }

    public String getResultado() {
        return resultado;
    }

    public String getImagem() {
        return imagemAnexo;
    }

    public void setResultado(String r) {
        if (!isFinalizado()) {
            this.resultado = r;
        }
    }

    public void anexarImagem(String path) {
        if (!isFinalizado()) {
            this.imagemAnexo = path;
        }
    }

    @Override
    public void exibir() {
        System.out.println("[EXAME] Tipo: " + tipo + " | Resultado: " + resultado);
    }
}
