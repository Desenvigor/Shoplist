package br.com.desenvigor.dao;

import br.com.desenvigor.model.ProductItem;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ProductItemDAO {
    private EntityManager em;

    public ProductItemDAO(EntityManager em) {
        this.em = em;
    }

    public void insertProduct (ProductItem product){
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();
    }

    public ProductItem findItem(ProductItem product){
        return em.merge(product);
    }

    public void deleteProduct(ProductItem product){
        ProductItem prod = em.merge(product);
        em.remove(prod);
    }

    public List<ProductItem> findAll(){
        List<ProductItem> allProducts;
        allProducts = em.createQuery("SELECT p from ProductItem p", ProductItem.class).getResultList();
        return allProducts;
    }
}
