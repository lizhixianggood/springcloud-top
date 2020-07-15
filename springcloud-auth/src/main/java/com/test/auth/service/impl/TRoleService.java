package com.test.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.test.auth.dao.ITRoleDao;
import com.test.auth.domain.TRole;
import com.test.auth.service.ITRoleService;


@Service
public class TRoleService implements ITRoleService {

	@Autowired
	ITRoleDao tRoleDao;
	
	@Override
	public int insert(TRole example){
		return tRoleDao.insert(example);
	}
	
	@Override
	public int deleteByExample(TRole example){
		return tRoleDao.delete(example);
	}
	
	@Override
	public TRole selectById(Integer id){
		return tRoleDao.selectById(id);
	}
	
	@Override
	public List<TRole> select(TRole example){
		return tRoleDao.select(example);
	}
	
	@Override
	public int updateById(TRole example){
		return tRoleDao.updateById(example);
	}

}
