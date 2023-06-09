package com.mansour.storefrontbackend.dao;

import com.mansour.storefrontbackend.entities.Order;

import java.util.List;

public interface OrderDAO {
    void createOrder(Order order);

    Order getOrder(int orderId);

    List<Order> getOrders();

    void deleteOrder(int orderId);

    List<Order> searchOrder(String orderName);
}
