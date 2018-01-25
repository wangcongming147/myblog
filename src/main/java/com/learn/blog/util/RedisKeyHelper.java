package com.learn.blog.util;

public class RedisKeyHelper {

	/**
	 * 用户登录次数计数 
	 * @param uid 用户id
	 * @return
	 */
	public static String getUserLoginCountKey(String uid){
		return Global.RedisKey.USER_LOGIN_COUNT + uid;
	}
	
	/**
	 * 用户登录是否被锁定    一小时 
	 * @param uid
	 * @return
	 */
	public static String getUserIsLock(String uid){
		return Global.RedisKey.USER_IS_LOCK + uid;
	}
}
