package com.mansour.storefrontbackend.dao;

import com.mansour.storefrontbackend.entities.Order;

public interface OrderDAO {
    void createOrder(Order order);

    void deleteOrder(int orderId);
}
