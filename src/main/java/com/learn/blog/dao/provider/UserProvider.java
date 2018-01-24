package com.learn.blog.dao.provider;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.learn.blog.model.User;

public class UserProvider {
	
	public String updateSQL(final User user) {
		return new SQL() {
			{
				UPDATE("mb_user");
				if(StringUtils.isEmpty(user.getNick())){
					SET("nick = #{nick}");
				}
				if(StringUtils.isEmpty(user.getPassword())){
					SET("password = #{password}");
				}
				if(StringUtils.isEmpty(user.getSex())){
					this.SET("sex = #{sex}");
				}
				if(StringUtils.isEmpty(user.getPhone())){
					this.SET("phone = #{phone}");
				}
				if(StringUtils.isEmpty(user.getQQ())){
					this.SET("QQ = #{QQ}");
				}
				if(StringUtils.isEmpty(user.getEmail())){
					this.SET("email = #{email}");
				}
				if(StringUtils.isEmpty(user.getWechat())){
					this.SET("wechat = #{wechat}");
				}
				SET("update_time = #{updateTime}");
				WHERE("id = #{id}");
			}
		}.toString();
	}
	
	public String insertSql(User user){
		return new SQL(){
			{
				INSERT_INTO("mb_user");
				if(StringUtils.isEmpty(user.getUid())){
					this.VALUES("id", user.getUid());
				}
				if(StringUtils.isEmpty(user.getUsername())){
					this.VALUES("username", user.getUsername());
				}
				if(StringUtils.isEmpty(user.getPassword())){
					this.VALUES("password", user.getPassword());
				}
				if(StringUtils.isEmpty(user.getNick())){
					this.VALUES("nick", user.getNick());
				}
				if(StringUtils.isEmpty(user.getSex())){
					this.VALUES("sex", user.getSex());
				}
				if(StringUtils.isEmpty(user.getPhone())){
					this.VALUES("phone", user.getPhone());
				}
				if(StringUtils.isEmpty(user.getQQ())){
					this.VALUES("QQ", user.getQQ());
				}
				if(StringUtils.isEmpty(user.getEmail())){
					this.VALUES("email", user.getEmail());
				}
				if(StringUtils.isEmpty(user.getWechat())){
					this.VALUES("wechat", user.getWechat());
				}
			}
			//id,username,password,nick,sex,phone,QQ,email,wechat
		}.toString();
	}
}