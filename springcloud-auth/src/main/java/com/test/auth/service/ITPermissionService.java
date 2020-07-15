package com.test.auth.service;

import com.test.auth.domain.TPermission;
import java.util.List;

public interface ITPermissionService {


	int insert(TPermission example);
	
	int deleteByExample(TPermission example);
	
	TPermission selectById(Integer id);
	
	List<TPermission> select(TPermission example);
	
	int updateById(TPermission example);
}
