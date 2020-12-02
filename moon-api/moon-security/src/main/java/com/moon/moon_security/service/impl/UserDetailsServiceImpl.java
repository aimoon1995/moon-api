package com.moon.moon_security.service.impl;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * spring security登陆处理<br>
 * <p>
 * 密码校验请看文档（02 框架及配置），第三章第4节
 *
 * @author wpw
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//	@Autowired
//	private UserService userService;
//	@Resource
//	private PermissionDao permissionDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//	    //按用户名登录
//		//SysUser sysUser = userService.getUser(username);
//        //按用手机号登录
//        SysUser sysUser = userService.getUserByPhone(username);
//
//		if (sysUser == null) {
//			throw new AuthenticationCredentialsNotFoundException("用户名不存在");
//		} else if (sysUser.getStatus() == SysUser.Status.LOCKED) {
//			throw new LockedException("用户被禁用,请联系管理员");
//		} else if (sysUser.getStatus() == SysUser.Status.DISABLED) {
//			throw new DisabledException("用户已作废");
//		}
//
//		LoginUser loginUser = new LoginUser();
//		BeanUtils.copyProperties(sysUser, loginUser);
//
//		List<Permission> permissions = permissionDao.listByUserId(sysUser.getId());
//		loginUser.setPermissions(permissions);
//
//		return loginUser;
		return  null;
	}

}
