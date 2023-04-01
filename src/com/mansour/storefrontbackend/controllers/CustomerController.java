package com.mansour.storefrontbackend.controllers;

import com.mansour.storefrontbackend.entities.Customer;
import com.mansour.storefrontbackend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String index(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customer";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "add-customer-from";
    }

    @PostMapping("/saveNewCustomer")
    public String saveNewCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.createCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/searchForCustomer")
    public String searchForCustomer(Model model, @RequestParam("customerName") String name) {
        List<Customer> customers = customerService.searchCustomer(name);
        model.addAttribute("customers", customers);
        return "list-customer";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(Model model, @RequestParam("customerId") int customerId) {
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return "add-customer-from";
    }


}
