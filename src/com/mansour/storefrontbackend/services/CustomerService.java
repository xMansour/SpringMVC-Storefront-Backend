package com.mansour.storefrontbackend.services;

import com.mansour.storefrontbackend.entities.Customer;

import java.util.List;

public interface CustomerService {
    void createCustomer(Customer customer);

    List<Customer> getCustomers();

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomer(String userName);
}
