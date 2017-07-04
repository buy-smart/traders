package com.traders.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.traders.model.Product;
import com.traders.model.Trader;
import com.traders.repo.ProductRepository;
import com.traders.repo.TraderRepository;

@RestController
public class ProductsController {

    @Autowired
    ProductRepository productRepository;
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json" , produces = "application/json" , value = "/products")
    public Product createItem(@RequestBody() Product product) {
    	return productRepository.save(product);
    }
    
    @ResponseBody
    @RequestMapping(method=RequestMethod.GET,  produces={"application/json"}, value="/products")
    public List<Product> getItem(@RequestParam(required=false) String name) {
    	List<Product> p = new ArrayList<>();
    	if( name!=null)return productRepository.findByName(name);
    	else {
    		productRepository.findAll().forEach(p::add);
    		return p;
    	}
    }
}
