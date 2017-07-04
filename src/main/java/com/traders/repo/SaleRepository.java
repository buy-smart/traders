package com.traders.repo;

import org.springframework.data.repository.CrudRepository;

import com.traders.model.Sale;

public interface SaleRepository extends CrudRepository<Sale, Long> {

}
