package com.uday.springcloud.manyToMany.repository;

import org.springframework.data.repository.CrudRepository;

import com.uday.springcloud.manyToMany.Entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
