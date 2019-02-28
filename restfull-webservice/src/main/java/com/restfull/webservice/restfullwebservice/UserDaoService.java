package com.restfull.webservice.restfullwebservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restfull.webservice.restfullwebservice.bean.Users;

@Component
public class UserDaoService {
	
	private static List<Users> users = new ArrayList<>();
	
	private static int userCount = 3;
	
	static {
		users.add(new Users(1, "Betty", new Date()));
		users.add(new Users(2, "Yohana", new Date()));
		users.add(new Users(3, "Nate", new Date()));
	}

	
	public List<Users> findAll(){
		return users;
	}
	
	
	public Users findOne(int id) {
	 
		for (Users user:users ) {
			if (user.getId()== id) {
				return user;
			}
		}
			
	 return null;
	}
	

	public Users save(Users user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
}
