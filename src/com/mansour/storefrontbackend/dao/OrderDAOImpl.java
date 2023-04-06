package com.mansour.storefrontbackend.dao;

import com.mansour.storefrontbackend.entities.Order;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createOrder(Order order) {
        sessionFactory
                .getCurrentSession()
                .saveOrUpdate(order);

    }

    @Override
    public Order getOrder(int orderId) {
        return sessionFactory
                .getCurrentSession()
                .get(Order.class, orderId);
    }

    @Override
    public List<Order> getOrders() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Order ", Order.class)
                .getResultList();
    }

    @Override
    public void deleteOrder(int orderId) {
        Order order = getOrder(orderId);
        sessionFactory
                .getCurrentSession()
                .remove(order);
    }

    @Override
    public List<Order> searchOrder(String orderName) {
        String sqlQuery = "";
        if (orderName.length() > 0)
            sqlQuery = "from Order where orderName=:orderName";
        else
            sqlQuery = "from Order";

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(sqlQuery);

        if (orderName.length() > 0)
            query.setParameter("orderName", orderName);

        return query.getResultList();
    }
}
