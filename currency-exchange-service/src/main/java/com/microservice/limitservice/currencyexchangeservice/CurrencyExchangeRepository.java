package com.microservice.limitservice.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.limitservice.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>    {
	
	CurrencyExchange findByFromAndTo(String from, String to);
	

}
