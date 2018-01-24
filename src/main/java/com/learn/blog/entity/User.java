package com.learn.blog.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

	private String uid;
	
	private String username;
	
	private String password;
	
	private String nick;
	
	private String sex;
	
	private String phone;
	
	private String QQ;
	
	private String email;
	
	private String age;
	
	private Date createTime;
	
	private Date updateTime;
	
}
