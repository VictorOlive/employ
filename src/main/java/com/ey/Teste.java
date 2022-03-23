package com.ey;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.ey.models.Bebida;
import com.ey.models.Comanda;
import com.ey.models.Consumidor;
import com.ey.models.Estabelecimento;
import com.ey.models.Movimentacao;
import com.ey.repository.ConsumidorDAO;

public class Teste {

    private static Consumidor cliente;
    private static Estabelecimento estabelecimento;

    public static void main(String[] args) {

        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("ey").createEntityManager();

            init(em);

            ConsumidorDAO dao = new ConsumidorDAO(em);

            // Qual a data da última visita ao estabelecimento?
            LocalDateTime ultimaVisita = dao.getUltimaVisita(cliente, estabelecimento);
            System.out.println("Qual a data da última visita ao estabelecimento: " + ultimaVisita);

            // Qual é a frequência de visitas?
            Long frequencia = dao.getFrequencia(cliente, estabelecimento);
            System.out.println("Qual é a frequência de visitas: " + frequencia);

            // Qual é o ticket médio (valor médio gasto no estabelecimento)?
            Double ticketMedio = dao.getTicketMedio(cliente, estabelecimento);
            System.out.println("Qual é o ticket médio (valor médio gasto no estabelecimento): " + ticketMedio);

            // Qual é a bebida e o estilo (cervejas IPA, Pilsen etc.) favoritos com base no
            // consumo?
            Bebida bebidaFavorita = dao.getBebidaFavorita(cliente, estabelecimento);
            System.out.println("Qual é a bebida e o estilo (cervejas IPA, Pilsen etc.) favoritos com base no consumo: "
                    + bebidaFavorita);

            // precisei colocar esse loop infinito pois o hibernate esta demorando para
            // retornar os dados
            // e por causa disso o programa fechava antes da thread do hibernate retornar os
            // dados
            while (true) {
            }

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public static void init(EntityManager em) {

        estabelecimento = new Estabelecimento("Novo velho bar", "02893949000193", "85991671254",
                "Um otimo pior lugar");

        Bebida pilsen = new Bebida("pilsen", "", "Patagonia", 6.5d);
        Bebida weiss = new Bebida("weiss", "", "Patagonia", 8.0d);
        Bebida ipa = new Bebida("ipa", "", "Patagonia", 5.33d);

        cliente = new Consumidor("62989290243", "Mariane Malu Francisca Teixeira",
                "tatiane_baptista@salvagninigroup.com", "05602395300", "F", LocalDateTime.now());

        Movimentacao movimentacao = new Movimentacao(4, pilsen);
        Movimentacao movimentacao2 = new Movimentacao(5, weiss);
        Movimentacao movimentacao3 = new Movimentacao(6, ipa);
        Movimentacao movimentacao4 = new Movimentacao(10, pilsen);

        Comanda comanda = new Comanda(estabelecimento, cliente, 1);
        Comanda comanda2 = new Comanda(estabelecimento, cliente, 2);
        Comanda comanda3 = new Comanda(estabelecimento, cliente, 3);

        comanda.addMovimentacao(movimentacao);
        comanda2.addMovimentacao(movimentacao2);
        comanda3.addMovimentacao(movimentacao3);
        comanda3.addMovimentacao(movimentacao4);

        cliente.addComanda(comanda);
        cliente.addComanda(comanda2);
        cliente.addComanda(comanda3);

        em.getTransaction().begin();
        em.persist(estabelecimento);
        em.persist(pilsen);
        em.persist(weiss);
        em.persist(ipa);
        em.persist(cliente);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.persist(comanda);
        em.getTransaction().commit();
    }
}
