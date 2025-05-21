package com.uday.springcloud.TransactionManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uday.springcloud.TransactionManagement.Entities.BankAccount;
import com.uday.springcloud.TransactionManagement.repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	@Autowired
	BankAccountRepository repo;
	
	@Override
	public void transfer(int amount) {
		
		BankAccount firstAccount = repo.findById(1).orElseThrow(() -> new RuntimeException("Resource is Not Found"));
		firstAccount.setBal(firstAccount.getBal()-amount);
		System.out.println("Find by id=======> " +firstAccount);
		repo.save(firstAccount);
		
		if(true) {
			throw new RuntimeException();
		}
		
		BankAccount secondAccount = repo.findById(2).orElseThrow(() -> new RuntimeException("Not Found"));
		System.out.println("Find by id=======> " +secondAccount);
		secondAccount.setBal(secondAccount.getBal()+amount);
		repo.save(secondAccount);
	}

}
