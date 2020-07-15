package com.test.auth.service;

import com.test.auth.domain.TRole;
import java.util.List;

public interface ITRoleService {


	int insert(TRole example);
	
	int deleteByExample(TRole example);
	
	TRole selectById(Integer id);
	
	List<TRole> select(TRole example);
	
	int updateById(TRole example);
}
