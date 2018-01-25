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
	//1-已删除 2-正常
	private String delFlag;
	
	private Date createTime;
	
	private Date updateTime;
	//1-正常 2-禁止登陆
	private String status;
}
