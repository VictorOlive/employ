package com.ey;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Teste {

    public static void main(String[] args) {
        EntityManager em = null;

        Estabelecimento estabelecimento = new Estabelecimento("Novo velho bar", "02893949000193", "85991671254",
                "Um otimo pior lugar");

        Bebida pilsen = new Bebida("pilsen", "", "Patagonia", 6.5d);
        Bebida weiss = new Bebida("weiss", "", "Patagonia", 8.0d);
        Bebida ipa = new Bebida("ipa", "", "Patagonia", 5.33d);

        Consumidor cliente = new Consumidor("62989290243", "Mariane Malu Francisca Teixeira",
                "tatiane_baptista@salvagninigroup.com", "05602395300", "F", LocalDateTime.now());

        try {
            em = Persistence.createEntityManagerFactory("ey").createEntityManager();

            Movimentacao movimentacao = new Movimentacao(4, pilsen);
            Movimentacao movimentacao2 = new Movimentacao(5, weiss);
            Movimentacao movimentacao3 = new Movimentacao(6, ipa);

            Comanda comanda = new Comanda(estabelecimento, cliente, 1);
            Comanda comanda2 = new Comanda(estabelecimento, cliente, 2);
            Comanda comanda3 = new Comanda(estabelecimento, cliente, 3);


            comanda.addMovimentacao(movimentacao);
            comanda2.addMovimentacao(movimentacao2);
            comanda3.addMovimentacao(movimentacao3);

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

            // Qual a data da última visita ao estabelecimento?
            List<LocalDateTime> ultimaVisita = em.createQuery("SELECT co.data FROM Consumidor c INNER JOIN c.comandas co ORDER BY co.data DESC", LocalDateTime.class).setMaxResults(1).getResultList();

            // Consumidor co = em.find(Consumidor.class, 1);
            System.out.println(ultimaVisita);

            while(true){}

        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } 
    }

}
