package com.store.customers.controller;

import com.store.customers.model.CustomerModel;
import com.store.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "{id}")
    public CustomerModel getCustomerById(@PathVariable("id") Long id) {
        return customerService.getCustomerById(id)
                .orElse(null);
    }

    @PostMapping
    public void addCustomer(@Validated @RequestBody CustomerModel customer) {
        customerService.addCustomer(customer);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCustomerById(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping(path = "{id}")
    public void updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerModel customerToUpdate) {
        customerService.updateCustomer(id, customerToUpdate);
    }
}
