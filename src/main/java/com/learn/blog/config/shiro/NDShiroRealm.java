package com.learn.blog.config.shiro;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.learn.blog.entity.User;
import com.learn.blog.rao.RedisRao;
import com.learn.blog.util.Global;
import com.learn.blog.util.RedisKeyHelper;

/**
 * shiro身份校验核心类
 * 
 * @author 作者: z77z
 * @date 创建时间：2017年2月10日 下午3:19:48
 */

public class NDShiroRealm extends AuthorizingRealm {

	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	RedisRao redisRao;

	/**
	 * 认证信息.(身份验证) : Authentication 是用来验证用户身份
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String name = token.getUsername();
		String password = String.valueOf(token.getPassword());
		//访问一次，计数一次
		long loginCount = redisRao.increment(RedisKeyHelper.getUserLoginCountKey(name), 1);
		//计数大于5时，设置用户被锁定一小时
		if(loginCount >= 5){
			redisRao.setString(RedisKeyHelper.getUserIsLock(name), Global.Constant.USER_LOCK);
			redisRao.expire(RedisKeyHelper.getUserIsLock(name), 1, TimeUnit.HOURS);
		}
		
		if (Global.Constant.USER_LOCK.equals(redisRao.getSet(RedisKeyHelper.getUserIsLock(name)))){
			throw new DisabledAccountException("密码输入错误次数大于5次，请一个小时之后重试！");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", name);
		User user = null;
		//密码进行加密处理  明文为  password+name
		String paw = password+name;
//		String pawDES = MyDES.encryptBasedDes(paw);
//		map.put("pswd", pawDES);
//		SysUser user = null;
//		// 从数据库获取对应用户名密码的用户
//		List<SysUser> userList = sysUserService.selectByMap(map);
//		if(userList.size()!=0){
//			user = userList.get(0);
//		} 
//		if (null == user) {
//			throw new AccountException("帐号或密码不正确！");
//		}else if("0".equals(user.getStatus())){
//			/**
//			 * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
//			 */
//			throw new DisabledAccountException("此帐号已经设置为禁止登录！");
//		}else{
//			//登录成功
//			//更新登录时间 last login time
//			user.setLastLoginTime(new Date());
//			sysUserService.updateById(user);
//			//清空登录计数
//			opsForValue.set(SHIRO_LOGIN_COUNT+name, "0");
//		}
		Logger.getLogger(getClass()).info("身份认证成功，登录用户："+name);
		return new SimpleAuthenticationInfo(user, password, getName());
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
//		System.out.println("权限认证方法：MyShiroRealm.doGetAuthorizationInfo()");
//		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
//		String userId = user.getId();
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
		//根据用户ID查询角色（role），放入到Authorization里。
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", userId);
		List<SysRole> roleList = sysRoleService.selectByMap(map);
		Set<String> roleSet = new HashSet<String>();
		for(SysRole role : roleList){
			roleSet.add(role.getType());
		}*/
//		Set<String> roleSet = new HashSet<String>();
//		roleSet.add("100002");
//		info.setRoles(roleSet);
		//根据用户ID查询权限（permission），放入到Authorization里。
		/*List<SysPermission> permissionList = sysPermissionService.selectByMap(map);
		Set<String> permissionSet = new HashSet<String>();
		for(SysPermission Permission : permissionList){
			permissionSet.add(Permission.getName());
		}*/
//		Set<String> permissionSet = new HashSet<String>();
//		permissionSet.add("权限添加");
//		permissionSet.add("权限删除");
//		info.setStringPermissions(permissionSet);
        return info;
	}
}
