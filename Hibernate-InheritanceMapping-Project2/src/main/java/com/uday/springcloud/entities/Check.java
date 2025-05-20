package com.uday.springcloud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bankcheck")
public class Check extends Payment{

	private String checknumber;

	public String getChecknumber() {
		return checknumber;
	}

	public void setChecknumber(String checknumber) {
		this.checknumber = checknumber;
	}
	
	
}
