package com.uday.springcloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.uday.springcloud.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
