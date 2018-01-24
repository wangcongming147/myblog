package com.learn.blog.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private String uid;
	
	private String username;
	
	private String password;
	
	private String nick;
	
	private String sex;
	
	private String phone;
	
	private String QQ;
	
	private String email;
	
	private String wechat;
	
	private String delFlag;
	
	private Date createTime;
	
	private Date updateTime;
	
}
