package com.uday.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	
	private int id;
	private String fname;
	private String lname;
	private String email;
	

}
