package com.mansour.storefrontbackend.services;

import com.mansour.storefrontbackend.dao.ProductDAO;
import com.mansour.storefrontbackend.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;


    @Transactional
    @Override
    public void createProduct(Product product) {
        productDAO.createProduct(product);
    }

    @Transactional
    @Override
    public List<Product> getProducts() {
        return productDAO.getProducts();
    }

    @Transactional
    @Override
    public Product getProduct(int id) {
        return productDAO.getProduct(id);
    }

    @Transactional
    @Override
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }

    @Transactional
    @Override
    public List<Product> searchProduct(String productName) {
        return productDAO.searchProduct(productName);
    }
}
