package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Expense;

public interface ExpenseService {
	
	Expense saveExpenseDetails(Expense expense);
	
	Expense updateExpenseDetails(Long id, Expense expense);

	List<Expense> getAllExpenses();
 
	Expense getExpenseById(Long id);
 
	void deleteExpenseById(Long id);
	
}
