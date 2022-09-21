package br.com.desenvigor.dao;

import br.com.desenvigor.model.Client;

import javax.persistence.EntityManager;

public class ClientDAO {
    private EntityManager em;

    public ClientDAO(EntityManager em) {
        this.em = em;
    }

    public void insertClient(Client client){
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        em.close();
    }

    public void updateClient(Client client){

    }


}
