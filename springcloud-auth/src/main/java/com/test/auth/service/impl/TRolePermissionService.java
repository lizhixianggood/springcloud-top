package com.test.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.test.auth.dao.ITRolePermissionDao;
import com.test.auth.domain.TRolePermission;
import com.test.auth.service.ITRolePermissionService;


@Service
public class TRolePermissionService implements ITRolePermissionService {

	@Autowired
	ITRolePermissionDao tRolePermissionDao;
	
	@Override
	public int insert(TRolePermission example){
		return tRolePermissionDao.insert(example);
	}
	
	@Override
	public int deleteByExample(TRolePermission example){
		return tRolePermissionDao.delete(example);
	}
	
	@Override
	public TRolePermission selectById(Integer id){
		return tRolePermissionDao.selectById(id);
	}
	
	@Override
	public List<TRolePermission> select(TRolePermission example){
		return tRolePermissionDao.select(example);
	}
	
	@Override
	public int updateById(TRolePermission example){
		return tRolePermissionDao.updateById(example);
	}

}
