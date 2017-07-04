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

import com.traders.model.Trader;
import com.traders.repo.TraderRepository;

@RestController
public class TradersController {

	@Autowired
	TraderRepository traderRepository;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json" , produces = "application/json" , value = "/traders")
	@ResponseBody
	public Trader createTrader(@RequestBody Trader trader) {
		Trader t= traderRepository.save(trader);
		return t;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json" , value = "/traders")
	@ResponseBody
	public List<Trader> getTrader(@RequestParam(required = false) String businessName) {
		if (businessName != null){
			List<Trader> trader = traderRepository.findByBusinessName(businessName);
			return trader;
		}
		List<Trader> t = new ArrayList<Trader>();
		Iterable<Trader> ts= traderRepository.findAll();
		ts.forEach(t::add);
		return t;
	}

}
