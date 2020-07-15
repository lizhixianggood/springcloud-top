package com.test.auth.service;

import com.test.auth.domain.TUser;
import java.util.List;

public interface ITUserService {


	int insert(TUser example);
	
	int deleteByExample(TUser example);
	
	TUser selectById(Integer id);
	
	List<TUser> select(TUser example);
	
	int updateById(TUser example);
}
