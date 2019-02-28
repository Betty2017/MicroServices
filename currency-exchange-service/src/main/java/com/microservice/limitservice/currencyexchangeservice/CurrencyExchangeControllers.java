package com.microservice.limitservice.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.limitservice.currencyexchangeservice.bean.CurrencyExchange;

@RestController
public class CurrencyExchangeControllers {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveCurrency
		(@PathVariable String from, @PathVariable String to) {
		
		CurrencyExchange currencyExchange = 
				repository.findByFromAndTo(from, to);
			
		logger.info("{}", currencyExchange);
		currencyExchange.setPort(Integer.parseInt(
				environment.getProperty("local.server.port")));
		return currencyExchange;
	}

}
