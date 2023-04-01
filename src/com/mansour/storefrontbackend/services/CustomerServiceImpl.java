package com.mansour.storefrontbackend.services;

import com.mansour.storefrontbackend.dao.CustomerDAO;
import com.mansour.storefrontbackend.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    @Override
    public void createCustomer(Customer customer) {
        customerDAO.createCustomer(customer);
    }

    @Transactional
    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    @Override
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Transactional
    @Override
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    @Transactional
    @Override
    public List<Customer> searchCustomer(String userName) {
        return customerDAO.searchCustomer(userName);
    }
}
