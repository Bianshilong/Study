package com.yue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity(name="admin")
@Getter@Setter
public class Admin extends IdEntity {

	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;

	
	
	
	//提供username和password的构造函数
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//提供无参的构造函数
	public Admin() {
	}
}
