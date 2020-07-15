package com.test.auth.dao;


import java.util.List;
import com.test.auth.domain.TUserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITUserRoleDao {

	int insert(TUserRole example);
	
	int delete(TUserRole example);
	
	TUserRole selectById(Integer id);
	
	List<TUserRole> select(TUserRole example);
	
	int updateById(TUserRole record);
}
