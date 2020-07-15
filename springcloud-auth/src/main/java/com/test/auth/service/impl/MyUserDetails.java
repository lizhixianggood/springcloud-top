package com.test.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.auth.dao.ITPermissionDao;
import com.test.auth.dao.ITUserDao;
import com.test.auth.domain.TUser;

@Service
public class MyUserDetails implements UserDetailsService{
	
	@Autowired
	ITUserDao tUserDao;

	@Autowired
	ITPermissionDao tPermissionDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TUser user = tUserDao.loadUserByUsername(username);
		List<String> rplist = tPermissionDao.findPermissionsByUserId(String.valueOf(user.getId()));
		String[] authorities = new String[rplist.size()];
		rplist.toArray(authorities);
		UserDetails uds = User.withUsername(user.getUsername()).password(user.getPassword()).authorities(authorities).build();
		return uds;
	}

}
