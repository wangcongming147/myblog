package com.learn.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.learn.blog.entity.User;

@Mapper
public interface UserDao {

	@Select("SELECT * FROM T_USER WHERE PHONE = #{phone}")
	@Results({
		@Result(property = "name", column = "name"),  
		@Result(property = "age", column = "age")
	})
    User findUserByPhone(@Param("phone") String phone);
}
