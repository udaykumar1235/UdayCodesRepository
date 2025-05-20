package com.uday.springcloud.repository;

import java.util.List;

import com.uday.springcloud.entity.User;

public interface UserRepository {
	
	User createUser(User user);
	User updateUser(User user);
	User getById(int id);
	List<User> allUser();                 
	String deleteById(int id);

}
