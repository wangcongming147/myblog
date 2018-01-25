package com.learn.blog.util;

public class Global {

	public static final class RedisKey{
		
		public static final String USER_LOGIN_COUNT = "blog:login:count:";//用户登录次数计数 
		public static final String USER_IS_LOCK = "blog:login:lock:";//用户登录是否被锁定    一小时 
	}
	
	public static final class Constant{
		public static final String USER_LOCK = "LOCK";
	}
}
