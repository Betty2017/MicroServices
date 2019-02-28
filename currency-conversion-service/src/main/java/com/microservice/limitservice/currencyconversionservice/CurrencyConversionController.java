package com.microservice.limitservice.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.limitservice.currencyconversionservice.bean.CurrencyConversion;

@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
		public CurrencyConversion retriveCurrencyFeign(@PathVariable String from,
					@PathVariable String to,
					@PathVariable BigDecimal quantity) {
	
	
			CurrencyConversion response = proxy.retriveCurrency(from, to);
	
			logger.info("{}", response);
			
			return new CurrencyConversion(response.getId(),from,to,
					response.getConverstionMultiple(),quantity,
					quantity.multiply(response.getConverstionMultiple()),response.getPort());
	
	
	}
	
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
		public CurrencyConversion retriveCurrency(@PathVariable String from,
						@PathVariable String to,
						@PathVariable BigDecimal quantity) {
		
			Map<String,String> uriVariables = new HashMap<>();
			uriVariables.put("from", from);
			uriVariables.put("to", to);
			
			ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
					"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
					CurrencyConversion.class,
					uriVariables );
			CurrencyConversion response = responseEntity.getBody();
		
		return new CurrencyConversion(response.getId(),from,to,response.getConverstionMultiple(),quantity,quantity.multiply(response.getConverstionMultiple()),response.getPort());
		
		
		}
		
	

}
