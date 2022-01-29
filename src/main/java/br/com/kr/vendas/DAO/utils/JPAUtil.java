package br.com.kr.vendas.DAO.utils;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("vendas");

    @Produces
    @RequestScoped
    public EntityManager createEntityManger(){
        return emf.createEntityManager();
    }

    public void closeEntityManeger(@Disposes EntityManager em){
        if(em != null && em.isOpen()){
            em.close();
        }
    }

}
