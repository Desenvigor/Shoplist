package br.com.desenvigor.dao;

import br.com.desenvigor.model.Client;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDAO {
    private EntityManager em;

    public ClientDAO(EntityManager em) {
        this.em = em;
    }

    public void insertClient(Client client){
        em.persist(client);
    }

    public void updateClient(Client client){

    }

    public List<Client> findALL(){
        String jpql = "SELECT c FROM Client c";
        return em.createQuery(jpql, Client.class).getResultList();
    }

    public Client find(int client) {
        return em.find(Client.class, client);
    }
}
