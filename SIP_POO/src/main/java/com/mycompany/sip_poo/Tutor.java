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
public class Tutor extends Usuario {

    private String cpf;
    private String telefone;
    private String endereco;
    private ArrayList<Animal> animais;

    public Tutor(int id, String nome, String email, String senha, String perfil, String cpf, String telefone) {
        super(id, nome, email, senha, perfil);
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = "";
        this.animais = new ArrayList<Animal>();
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void adicionarAnimal(Animal a) {
        if (a == null) {
            return;
        }
        for (int i = 0; i < animais.size(); i++) {
            if (animais.get(i).getId() == a.getId()) {
                return;
            }
        }
        animais.add(a);
    }

    public void verHistoricoAnimal(int id) {
        Animal a = null;
        for (int i = 0; i < animais.size(); i++) {
            if (animais.get(i).getId() == id) {
                a = animais.get(i);
                break;
            }
        }
        if (a != null) {
            a.getHistorico().exibir();
        }
    }

    public ArrayList<Fatura> verFaturas() {
        return Fatura.buscarPorTutor(this);
    }

    public Animal buscarAnimal(String nome) {
        for (int i = 0; i < animais.size(); i++) {
            if (animais.get(i).getNome().equalsIgnoreCase(nome)) {
                return animais.get(i);
            }
        }
        return null;
    }

    @Override
    public void exibir() {
        System.out.println("[TUTOR] " + getNome() + " | CPF: " + cpf + " | Tel: " + telefone);
    }
}
