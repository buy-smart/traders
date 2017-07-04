package com.traders.repo;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.traders.model.StockItem;

public interface StockItemRepository extends CrudRepository<StockItem, Long> {
}
