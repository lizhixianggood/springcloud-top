package com.test.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.test.auth.dao.ITUserDao;
import com.test.auth.domain.TUser;
import com.test.auth.service.ITUserService;


@Service
public class TUserService implements ITUserService {

	@Autowired
	ITUserDao tUserDao;
	
	@Override
	public int insert(TUser example){
		return tUserDao.insert(example);
	}
	
	@Override
	public int deleteByExample(TUser example){
		return tUserDao.delete(example);
	}
	
	@Override
	public TUser selectById(Integer id){
		return tUserDao.selectById(id);
	}
	
	@Override
	public List<TUser> select(TUser example){
		return tUserDao.select(example);
	}
	
	@Override
	public int updateById(TUser example){
		return tUserDao.updateById(example);
	}

}
