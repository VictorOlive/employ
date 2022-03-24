package com.ey.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import com.ey.models.Bebida;
import com.ey.models.Consumidor;
import com.ey.models.Estabelecimento;

public class ConsumidorDAO extends GenericDAO<Consumidor, Integer> {

    public ConsumidorDAO(EntityManager em) {
        super(em);
    }

    public LocalDateTime getUltimaVisita(Consumidor cliente, Estabelecimento estabelecimento) {
        List<LocalDateTime> ultimaVisita = em
                .createQuery(
                        "SELECT co.data FROM Consumidor c INNER JOIN c.comandas co WHERE c.celular = :celular AND co.estabelecimento.id = :id ORDER BY co.data DESC",
                        LocalDateTime.class)
                .setParameter("celular", cliente.getCelular())
                .setParameter("id", estabelecimento.getId())
                .setMaxResults(1)
                .getResultList();

        if (ultimaVisita.isEmpty()) {
                return null; 
        }
        return ultimaVisita.get(0);
    }

    public Long getFrequencia(Consumidor cliente, Estabelecimento estabelecimento) {

        List<Long> frequencia = em
                .createQuery(
                        "SELECT COUNT(co.id) FROM Consumidor c INNER JOIN c.comandas co WHERE c.celular = :celular AND co.estabelecimento.id = :id",
                        Long.class)
                .setParameter("celular", cliente.getCelular())
                .setParameter("id", estabelecimento.getId())
                .getResultList();

        if (frequencia.isEmpty()) {
                return 0l; 
        }

        return frequencia.get(0);
    }

    public Double getTicketMedio(Consumidor cliente, Estabelecimento estabelecimento) {

        List<Double> ticketMedio = em.createQuery(
                "SELECT AVG(co.valor) FROM Consumidor c INNER JOIN c.comandas co WHERE c.celular = :celular AND co.estabelecimento.id = :id",
                Double.class)
                .setParameter("celular", "62989290243")
                .setParameter("id", 1)
                .getResultList();

        if (ticketMedio.isEmpty()){
                return 0.0d;
        }

        return ticketMedio.get(0);

    }

    public Bebida getBebidaFavorita(Consumidor cliente, Estabelecimento estabelecimento) {

        List<Integer> bebidaFavorita_id = em
                .createQuery(
                        "SELECT b.id FROM Consumidor c INNER JOIN c.comandas co INNER JOIN co.movimentacoes v INNER JOIN v.bebida b WHERE c.celular = :celular AND co.estabelecimento.id = :id GROUP BY b ORDER BY SUM(v.quantidade) DESC",
                        Integer.class)
                .setParameter("celular", cliente.getCelular())
                .setParameter("id", estabelecimento.getId())
                .setMaxResults(1)
                .getResultList();


        if (bebidaFavorita_id.isEmpty()){
                return null;
        }
        
        Bebida bebidaFavorita = em.find(Bebida.class, bebidaFavorita_id.get(0));

        return bebidaFavorita;
    }

}
