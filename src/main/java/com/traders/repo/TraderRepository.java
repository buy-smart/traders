package com.traders.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.traders.model.Trader;

public interface TraderRepository extends CrudRepository<Trader, Long> {

	List<Trader> findByBusinessName(String businessName);
}
