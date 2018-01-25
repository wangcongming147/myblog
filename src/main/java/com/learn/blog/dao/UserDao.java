package com.learn.blog.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.learn.blog.dao.provider.UserProvider;
import com.learn.blog.model.User;

@Mapper
public interface UserDao {

	@Select("select * from mb_user u where u.username = #{username}")
	@Results({
		@Result(property = "id",column = "uid"),
		@Result(property = "createTime",column = "create_time"),
		@Result(property = "updateTime",column = "update_time")
	})
	public User findUserByUsername(String username);
	
	@Select("select * from mb_user u where u.email = #{email}")
	public User findUserByEmail(String email);
	
	@InsertProvider(type = UserProvider.class, method = "insertSql")
	public void save(@Param("user")User user);
	
	@UpdateProvider(type = UserProvider.class, method = "updateSql")
	public void updateEntity(@Param("user") User entity);
}