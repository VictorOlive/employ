package com.ey.repository;

import javax.persistence.EntityManager;
import com.ey.Consumidor;

public class ConsumidorDAO extends GenericDAO<Consumidor , Integer>{

    public ConsumidorDAO(EntityManager em) {
        super(em);
    }
    
}

