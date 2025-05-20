package com.uday.springcloud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uday.springcloud.entity.Product;
import com.uday.springcloud.repository.ProductRepository;

@SpringBootTest
class CrudJpaProjectApplicationTests {
	
	@Autowired
	ProductRepository repo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreate() {

		Product product = new Product();
		product.setId(1);
		product.setName("uday");
		product.setDesc("ckae description");
		product.setPrice(250.00d);
		
		repo.save(product);	
	}
	
	@Test
	public void testRead() {
		
		Product  product = repo.findById(1).get();
		
		assertNotNull(product);
		assertEquals("ckae", product.getName());
		
		System.out.println("==============>>>>>>>>>>>>>>>>>>" + product.getDesc());
	}
	
	@Test
	public void testUpdate() {
		
		Product product = repo.findById(1).get();
		product.setPrice(13.00d);
		product.setDesc("Update New decription");
		
		repo.save(product);
	}
	
	@Test
	public void testDelete() {
		if(repo.existsById(1)) {
		repo.deleteById(1);
	}
	}
	
	@Test
	public void testCount() {
		
		System.out.println("ToTal Records : " + repo.count());
	}
	
	//Finder Methods
	
	@Test
	public void testFindName() {
		
		List<Product> products = repo.findByName("IWatch");
		
		products.forEach((p) -> System.out.println(p.getName() + " " + p.getDesc() + " " + p.getPrice()));	
	}
	
	@Test
	public void testFindByNameAndDesc() {
		
		List<Product> products = repo.findByNameAndDesc("TV", "Samsung");
		products.forEach((p) -> System.out.println("Name and Description of Price is :: " +p.getPrice()));
	}
	
	@Test
	public void testFindByPriceGreterthan() {
		
		List<Product> products = repo.findByPriceGreaterThan(1000d);
		
		products.forEach((p) -> System.out.println(p.getPrice()));
	}
	
	@Test
	public void testFindByDescContains() {
		
		List<Product>  products = repo.findByDescContains("AppleInc");
		products.forEach((p) -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByPriceBetween() {
		
		List<Product> products = repo.findByPriceBetween(500d, 2500d);
		products.forEach((p) -> System.out.println(p.getName()));
	}
	
	@Test
	public void testFindByDescLike() {
		
		List<Product> products = repo.findByDescLike("%A%");
		products.forEach((p) -> System.out.println(p.getName()));
	}
	
	@Test
	public void testfindByIdInIds() {
		
		List<Product> products = repo.findByIdIn(Arrays.asList(1,2));
		products.forEach((p) -> System.out.println(p.getName()));
	}
}
