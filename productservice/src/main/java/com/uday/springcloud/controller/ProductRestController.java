package com.uday.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uday.springcloud.model.Coupon;
import com.uday.springcloud.model.Product;
import com.uday.springcloud.repos.ProductRepo;
import com.uday.springcloud.restclients.CouponClient;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	
	@Autowired
	CouponClient couponClient;
	
	@Autowired
	private ProductRepo repo;

	/* @PostMapping("/products")
	public Product create(@RequestBody Product product) {
		return repo.save(product);
	} */
	
	@PostMapping("/products")
	@Retry(name = "product-api", fallbackMethod = "handleError")
	public Product create(@RequestBody Product product) {
		
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		
		return repo.save(product);
	}
	
	public Product handleError(Product product, Exception exception) {
		System.out.println("Inside Handle Error..");
		return product;
	}
}
