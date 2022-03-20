package com.ey;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Teste {

    public static void main(String[] args) {
        EntityManager em = null;

        try {
            em = Persistence.createEntityManagerFactory("ey").createEntityManager();
        
            Bebida bebida = new Bebida("Cerveja", null , "Brahma", 2.5d);
            em.getTransaction().begin();
            em.persist(bebida);
            em.getTransaction().commit();        
            
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally{
            if (em != null) {
                em.close();
            }
            System.exit(0);
        }
    }
    
}
