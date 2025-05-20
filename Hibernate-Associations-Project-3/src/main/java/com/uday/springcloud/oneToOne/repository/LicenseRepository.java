package com.uday.springcloud.oneToOne.repository;

import org.springframework.data.repository.CrudRepository;

import com.uday.springcloud.oneToOne.Entities.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
