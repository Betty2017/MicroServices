package com.restfull.webservice.restfullwebservice.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Users {
	
	private Integer id;
	private String name;
	private Date birthdate;
	
	
	public Users() {
		
	}
	
	public Users(int id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	

}
