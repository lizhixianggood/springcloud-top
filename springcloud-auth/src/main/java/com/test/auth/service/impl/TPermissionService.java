package com.test.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.test.auth.dao.ITPermissionDao;
import com.test.auth.domain.TPermission;
import com.test.auth.service.ITPermissionService;


@Service
public class TPermissionService implements ITPermissionService {

	@Autowired
	ITPermissionDao tPermissionDao;
	
	@Override
	public int insert(TPermission example){
		return tPermissionDao.insert(example);
	}
	
	@Override
	public int deleteByExample(TPermission example){
		return tPermissionDao.delete(example);
	}
	
	@Override
	public TPermission selectById(Integer id){
		return tPermissionDao.selectById(id);
	}
	
	@Override
	public List<TPermission> select(TPermission example){
		return tPermissionDao.select(example);
	}
	
	@Override
	public int updateById(TPermission example){
		return tPermissionDao.updateById(example);
	}

}
