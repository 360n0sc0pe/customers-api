package com.store.customers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.customers.model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{

}
