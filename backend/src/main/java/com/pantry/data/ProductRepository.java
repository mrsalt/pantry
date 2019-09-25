package com.pantry.data;

import org.springframework.data.repository.CrudRepository;

import com.pantry.data.User;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}