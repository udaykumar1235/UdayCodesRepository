package com.uday.springcloud.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uday.springcloud.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private static final String INSERT_USER_QUERY = "INSERT INTO USER(ID, fname, lname, email) values(?,?,?,?)";
	private static final String UPDATE_USER_QUERY = "UPDATE USER SET fname=? WHERE id=?";
	private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM USER WHERE id=?";
	private static final String GET_USERS_QUERY = "SELECT * FROM USER";
	private static final String DELETE_USER_QUERY = "DELETE FROM USER WHERE id=?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public User createUser(User user) {
		
		jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getFname(), user.getLname(),user.getEmail());
		
		return user;
	}

	@Override
	public User updateUser(User user) {
		
		jdbcTemplate.update(UPDATE_USER_QUERY, user.getFname(), user.getId());
		
		return user;
	}

	@Override
	public User getById(int id) {
		
		return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum)-> {
			
			return new User(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
		}, id);

	}

	@Override
	public List<User> allUser() {
		
		return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
			return new User(rs.getInt("ID"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
		});
	}

	@Override
	public String deleteById(int id) {
		
		 jdbcTemplate.update(DELETE_USER_QUERY, id);
		 
		 return "User is Deleted with id:" +id;
	}

}
