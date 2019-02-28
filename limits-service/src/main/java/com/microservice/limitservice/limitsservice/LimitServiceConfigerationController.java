package com.microservice.limitservice.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.limitservice.limitsservice.bean.limitservice;

@RestController
public class LimitServiceConfigerationController {
	
	@Autowired
	private Configeration configeration;
	
	@GetMapping("/limits")
	public limitservice retrivelimitservice() {
		return new limitservice(configeration.getMaximum(),configeration.getMinimum());
	}

}
