package com.traders.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traders.model.Product;
import com.traders.model.Sale;
import com.traders.model.StockItem;
import com.traders.model.Trader;
import com.traders.repo.ProductRepository;
import com.traders.repo.StockItemRepository;
import com.traders.repo.TraderRepository;

@RestController
public class StockItemsController {

	@Autowired
	StockItemRepository stockItemRepository;

	@RequestMapping(method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" }, value = "/stockitems")
	public StockItem createItem(@RequestBody() StockItem item) {
		return stockItemRepository.save(item);
	}

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" }, value = "/stockitems")
	public List<StockItem> getItem(@RequestParam(required = false) String name) {
			List<StockItem> l = new ArrayList<StockItem>();
			stockItemRepository.findAll().forEach(l::add);
			return l;
	}
}
