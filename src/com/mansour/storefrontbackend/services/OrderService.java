package com.mansour.storefrontbackend.services;

import com.mansour.storefrontbackend.entities.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Order order);

    Order getOrder(int orderId);

    List<Order> getOrders();

    void deleteOrder(int orderId);

    List<Order> searchOrder(String orderName);
}
