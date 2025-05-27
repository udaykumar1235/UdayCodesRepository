package com.uday.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.springcloud.Entities.Customer;
import com.uday.springcloud.Entities.CustomerId;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {

}
