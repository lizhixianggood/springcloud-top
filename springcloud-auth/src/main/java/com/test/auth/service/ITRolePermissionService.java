package com.test.auth.service;

import com.test.auth.domain.TRolePermission;
import java.util.List;

public interface ITRolePermissionService {


	int insert(TRolePermission example);
	
	int deleteByExample(TRolePermission example);
	
	TRolePermission selectById(Integer id);
	
	List<TRolePermission> select(TRolePermission example);
	
	int updateById(TRolePermission example);
}
