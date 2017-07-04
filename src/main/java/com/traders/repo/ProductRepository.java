package com.traders.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.traders.model.Product;
import com.traders.model.Trader;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByName(String name);

}
