package com.mansour.storefrontbackend.dao;

import com.mansour.storefrontbackend.entities.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createProduct(Product product) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(product);
    }

    @Override
    public List<Product> getProducts() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Product ", Product.class)
                .getResultList();
    }

    @Override
    public Product getProduct(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Product.class, id);
    }

    @Override
    public void deleteProduct(int id) {
        Product product = getProduct(id);
        sessionFactory
                .getCurrentSession()
                .remove(product);
    }

    @Override
    public List<Product> searchProduct(String productName) {
        String sqlQuery = "";
        if (productName.length() > 0)
            sqlQuery = "from Product where name=:productName";
        else
            sqlQuery = "from Product";

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(sqlQuery);

        if (productName.length() > 0)
            query.setParameter("productName", productName);

        return query.getResultList();

    }
}
