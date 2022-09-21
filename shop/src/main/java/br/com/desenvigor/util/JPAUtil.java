package br.com.desenvigor.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("shoplist");

    public EntityManager createEntityManager(){
        return EMF.createEntityManager();
    }

}
