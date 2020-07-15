package com.test.auth.dao;

import java.util.List;
import com.test.auth.domain.TRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITRoleDao {

	int insert(TRole example);
	
	int delete(TRole example);
	
	TRole selectById(Integer id);
	
	List<TRole> select(TRole example);
	
	int updateById(TRole record);
}
