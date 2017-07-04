package com.traders.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.traders.model.Sale;
import com.traders.repo.SaleRepository;

@RestController
public class SalesController {

    @Autowired
    SaleRepository saleRepository;
    
    @RequestMapping(method=RequestMethod.POST, consumes={"application/json"}, produces={"application/json"}, value="/sales")
    public Sale createOrder(@RequestBody() Sale sale) {
    	
    	return saleRepository.save(sale);
    }
    
    @RequestMapping(method=RequestMethod.GET,  produces={"application/json"}, value="/sales")
    public List<Sale> getSales() {
    	List<Sale> l = new ArrayList<Sale>();
    	 saleRepository.findAll().forEach(l::add);
    	 return l;
    }
}
