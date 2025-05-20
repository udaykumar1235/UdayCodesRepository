package com.uday.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
