package com.bsl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String name;
	private String pass;
	
	public User() {
		
	}

	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

}
