package com.uday.springcloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.uday.springcloud.Entities.Image;

public interface ImageRepository extends CrudRepository<Image, Long> {

}
