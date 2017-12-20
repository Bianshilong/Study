package com.bsl.vo;


import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Admin_vo {
	
	@NotEmpty(message="用户名不能为空！！")
	private String username;
	
	@NotEmpty(message="密码不能为空！！")
	private String password;
}
