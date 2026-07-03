package com.enterprise.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractJPATest {
    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    protected EntityTransaction tx;

    @BeforeAll
    static void setupFactory() {
        emf = Persistence.createEntityManagerFactory("EnterprisePU");
    }

    @BeforeEach
    void setupManager() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @AfterEach
    void tearDownManager() {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    @AfterAll
    static void closeFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
