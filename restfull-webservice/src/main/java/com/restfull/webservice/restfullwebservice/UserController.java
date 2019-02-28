package com.restfull.webservice.restfullwebservice;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restfull.webservice.restfullwebservice.bean.Users;

@RestController
public class UserController {
	
	@Autowired
	UserDaoService userDaoService;
	
	@GetMapping("/user/findAll")
	public List<Users> findAllUser() {
		return userDaoService.findAll();
	}
	
	@GetMapping("/user/findOne/{id}")
	public Users findWithId(@PathVariable int id) {
		return userDaoService.findOne(id);
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveusers(@RequestBody Users user) {
		Users saveduser = userDaoService.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveduser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/user/delete/{id}")
	public Users deleteId(@PathVariable int id) {
		return userDaoService.findOne(id);
		
	}
}
