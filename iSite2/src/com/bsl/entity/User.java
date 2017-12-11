package com.bsl.entity;

import java.util.Date;
import java.util.List;


//import javax.persistence.*;			//可以用*代表导入所有的该类型包

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="user")
@Getter@Setter
public class User {
	
	@Id@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name",nullable=false,unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	private String email;
	private String sex;
	@Temporal(TemporalType.DATE)
	private Date birth;
	
	//提供无参的构造函数
	public User() {
	}

	//提供有参的构造函数
	public User(String username, String password, String email, String sex, Date birth) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.birth = birth;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
}
