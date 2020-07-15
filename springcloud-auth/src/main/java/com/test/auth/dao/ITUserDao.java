package com.test.auth.dao;


import java.util.List;
import com.test.auth.domain.TUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITUserDao {

	int insert(TUser example);
	
	int delete(TUser example);
	
	TUser selectById(Integer id);
	
	List<TUser> select(TUser example);
	
	int updateById(TUser record);
	
	TUser loadUserByUsername(String username);
	
}
