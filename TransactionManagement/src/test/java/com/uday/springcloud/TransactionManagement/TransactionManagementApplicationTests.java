package com.uday.springcloud.TransactionManagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.uday.springcloud.TransactionManagement.Service.BankAccountService;

@SpringBootTest
class TransactionManagementApplicationTests {

	@Autowired
	BankAccountService service;
	
	@Test
	@Transactional
	public void testTransfer() {
		
		service.transfer(500);
	}

}
