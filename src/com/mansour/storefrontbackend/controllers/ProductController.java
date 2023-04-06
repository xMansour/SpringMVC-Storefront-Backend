package com.mansour.storefrontbackend.controllers;

import com.mansour.storefrontbackend.entities.Product;
import com.mansour.storefrontbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String index(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "list-products";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-product-form";
    }

    @PostMapping("/saveNewProduct")
    public String saveNewProduct(@ModelAttribute("product") Product product) {
        productService.createProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/searchForProduct")
    public String searchForProduct(Model model, @RequestParam("productName") String productName) {
        List<Product> products = productService.searchProduct(productName);
        model.addAttribute("products", products);
        return "list-products";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(Model model, @RequestParam("productId") int productId) {
        Product product = productService.getProduct(productId);
        model.addAttribute("product", product);
        return "add-product-form";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") int productId) {
        productService.deleteProduct(productId);
        return "redirect:/product/list";
    }
}
