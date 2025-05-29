package com.uday.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uday.springcloud.Entities.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {

}
