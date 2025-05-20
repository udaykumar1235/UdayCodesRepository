package com.uday.springcloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uday.springcloud.entities.Check;
import com.uday.springcloud.entities.Creditcard;
import com.uday.springcloud.repo.PaymentRepository;

@SpringBootTest
class HibernateInheritanceProjectApplicationTests {
	
	@Autowired
	PaymentRepository repo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreatePayment() {
		
		Creditcard cc = new Creditcard();
		cc.setId(4);
		cc.setCardnumber("11222333");
		cc.setAmount(2500);
		
		repo.save(cc);
	}
	
	@Test
	public void testCheckPayment() {
		
		Check ch = new Check();
		ch.setId(5);
		ch.setAmount(1500);
		ch.setChecknumber("12312312");
		
		repo.save(ch);
		
	}
}
