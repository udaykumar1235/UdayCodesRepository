package com.uday.springcloud.repo;

import org.springframework.data.repository.CrudRepository;

import com.uday.springcloud.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
