package com.test.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.test.auth.dao.ITUserRoleDao;
import com.test.auth.domain.TUserRole;
import com.test.auth.service.ITUserRoleService;


@Service
public class TUserRoleService implements ITUserRoleService {

	@Autowired
	ITUserRoleDao tUserRoleDao;
	
	@Override
	public int insert(TUserRole example){
		return tUserRoleDao.insert(example);
	}
	
	@Override
	public int deleteByExample(TUserRole example){
		return tUserRoleDao.delete(example);
	}
	
	@Override
	public TUserRole selectById(Integer id){
		return tUserRoleDao.selectById(id);
	}
	
	@Override
	public List<TUserRole> select(TUserRole example){
		return tUserRoleDao.select(example);
	}
	
	@Override
	public int updateById(TUserRole example){
		return tUserRoleDao.updateById(example);
	}

}
