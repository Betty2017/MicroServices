package com.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.restfull.webservice.restfullwebservice.bean.Users;

@Component
public class CallRestServices implements CommandLineRunner {
	
	
	
	private static void callRestService() {
		RestTemplate restTemplate = new RestTemplate();
		Users users = restTemplate.getForObject("http://localhost:8080/user/findOne/1", Users.class); 
		System.out.println("User:" + users.getName());
	}

	@Override
	public void run(String... args) throws Exception {
		callRestService();
		
	}

}
