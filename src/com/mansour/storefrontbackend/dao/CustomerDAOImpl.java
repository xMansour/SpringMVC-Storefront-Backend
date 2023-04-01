package com.mansour.storefrontbackend.dao;

import com.mansour.storefrontbackend.entities.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createCustomer(Customer customer) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(customer);

    }

    @Override
    public List<Customer> getCustomers() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Customer ", Customer.class)
                .getResultList();
    }

    @Override
    public Customer getCustomer(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Customer.class, id);
    }


    @Override
    public void deleteCustomer(int id) {
        Customer customer = getCustomer(id);
        sessionFactory
                .getCurrentSession()
                .remove(customer);

    }

    @Override
    public List<Customer> searchCustomer(String userName) {
        String sqlQuery = "";
        if (userName.length() > 0)
            sqlQuery = "from Customer where firstName=:userName or lastName=:userName";
        else
            sqlQuery = "from Customer";

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(sqlQuery);
        if (userName.length() > 0)
            query.setParameter("userName", userName);

        return query.getResultList();
    }

}

