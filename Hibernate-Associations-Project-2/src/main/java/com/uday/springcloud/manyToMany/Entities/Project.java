package com.uday.springcloud.manyToMany.Entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "projects")
	private Set<Programmer> programmers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(Set<Programmer> programmers) {
		this.programmers = programmers;
	}
	
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
	
	
}
