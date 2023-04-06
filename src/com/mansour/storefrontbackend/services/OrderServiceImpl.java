package com.mansour.storefrontbackend.services;

import com.mansour.storefrontbackend.dao.OrderDAO;
import com.mansour.storefrontbackend.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;


    @Override
    public void createOrder(Order order) {
        orderDAO.createOrder(order);
    }

    @Override
    public Order getOrder(int orderId) {
        return orderDAO.getOrder(orderId);
    }

    @Override
    public List<Order> getOrders() {
        return orderDAO.getOrders();
    }

    @Override
    public void deleteOrder(int orderId) {
        orderDAO.deleteOrder(orderId);
    }

    @Override
    public List<Order> searchOrder(String orderName) {
        return orderDAO.searchOrder(orderName);
    }
}
