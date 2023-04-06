package com.mansour.storefrontbackend.services;

import com.mansour.storefrontbackend.entities.Product;

import java.util.List;

public interface ProductService {

    void createProduct(Product product);

    List<Product> getProducts();

    Product getProduct(int id);

    void deleteProduct(int id);


    List<Product> searchProduct(String productName);


}
