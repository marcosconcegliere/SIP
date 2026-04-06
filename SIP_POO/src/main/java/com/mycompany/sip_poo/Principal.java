/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sip_poo;

/**
 *
 * @author Windows
 */
public class Principal {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA PETCARE ===");

        // USUARIO Veterinário
        Veterinario vet1 = new Veterinario(1, "Ana", "ana@petcare.com", "1234", "VET", "CRMV-SP 00000", "Mamiferos");
        vet1.setDisponivel(true);

        vet1.exibir();

        //USUARO Tutor
        Tutor tutor = new Tutor(2, "Joao Silva", "joao@email.com", "12345678900", "1", "99999-9999", "100.100.100-00");
        
        //ANIMAL
        Animal animal = new Animal(1, "Rex", "Cachorro", "Labrador", tutor);

        animal.exibir();

        //HISTORICO
        HistoricoClinico historico = animal.getHistorico();

        historico.adicionarConsulta(new Consulta(1, "2025-04-01", "Consulta rotina", vet1, "Check-up"));
        historico.adicionarConsulta(new Consulta(2, "2025-04-02", "Retorno", vet1, "Revisão"));

        historico.adicionarVacina(new Vacina(3, "2025-04-01", "Vacina V10", vet1, "V10"));

        historico.adicionarCirurgia(new Cirurgia(4, "2026-05-04", "Cirugia de pata", vet1, "Sala 11"));
        
        historico.exibir();
        
        //NOTIFICADOR
        Notificador notificador = new Notificador("EMAIL", tutor.getEmail());
        
        //AGENDAMENTO
        Agendamento ag = new Agendamento(1, "10:00", "CONSULTA", animal, vet1, notificador);
        
        ag.agendar(); // notificador aqui
        
        ag.exibir();

        //ESTOQUE
        Estoque estoque = new Estoque(notificador);

        ItemEstoque item = new ItemEstoque(1, "Dipirona", 50, 10, "L001");

        estoque.adicionarItem(item);

        item.exibir();

        //FATURA
        Fatura fatura = new Fatura(1, tutor, 150.0, "Consulta", notificador);

        fatura.exibir();
        
        //LOG
        LogAuditoria log = new LogAuditoria(vet1, "AJUSTE_ESTOQUE", "ItemEstoque");

        log.registrar();

        log.exibir();
    }
}
