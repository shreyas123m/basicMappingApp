package com.demo.basicApp.dao;

import com.demo.basicApp.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product, Long> {
}
