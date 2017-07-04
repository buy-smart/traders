package com.traders.repo;

import org.springframework.data.repository.CrudRepository;

import com.traders.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
