package com.uday.springcloud.TransactionManagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.uday.springcloud.TransactionManagement.Entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
