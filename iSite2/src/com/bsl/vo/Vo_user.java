package com.bsl.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Vo_user {
	
	private String name;
	private String pass;
	private String email;
	private String sex;
	private Date birth;
	
}
