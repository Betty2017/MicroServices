package com.restfull.webservice.restfullwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfull.webservice.restfullwebservice.bean.HelloWorld;

@RestController
public class HelloWorldController {
	
	@GetMapping("/helloworld/{name}")
	public HelloWorld helloworld(@PathVariable String name) {
		return new HelloWorld(String.format("hello workd %s", name));
	}

}
