package com.test.auth.service;

import com.test.auth.domain.TUserRole;
import java.util.List;

public interface ITUserRoleService {


	int insert(TUserRole example);
	
	int deleteByExample(TUserRole example);
	
	TUserRole selectById(Integer id);
	
	List<TUserRole> select(TUserRole example);
	
	int updateById(TUserRole example);
}
