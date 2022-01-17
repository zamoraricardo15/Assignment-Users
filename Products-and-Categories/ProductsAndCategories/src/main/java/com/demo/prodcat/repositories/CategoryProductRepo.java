package com.demo.prodcat.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.prodcat.models.CategoryProduct;

@Repository
public interface CategoryProductRepo extends CrudRepository <CategoryProduct, Long> {
}