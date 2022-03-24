package com.store.customers.service;

import com.store.customers.dao.CustomerRepository;
import com.store.customers.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerModel addCustomer(CustomerModel customer) {
        return customerRepository.save(customer);
    }

    public Optional<CustomerModel> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerModel updateCustomer(Long id, CustomerModel customerDetails) {
        CustomerModel customerToUpdate = customerRepository.findById(id).get();
        customerToUpdate.setName(customerDetails.getName());
        customerToUpdate.setEmail(customerDetails.getEmail());
        customerToUpdate.setPhone(customerDetails.getPhone());
        customerToUpdate.setCity(customerDetails.getCity());

        return customerRepository.save(customerToUpdate);
    }

}
