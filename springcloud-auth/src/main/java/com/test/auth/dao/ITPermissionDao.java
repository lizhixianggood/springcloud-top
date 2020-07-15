package com.test.auth.dao;

import java.util.List;
import com.test.auth.domain.TPermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITPermissionDao {

	int insert(TPermission example);
	
	int delete(TPermission example);
	
	TPermission selectById(Integer id);
	
	List<TPermission> select(TPermission example);
	
	int updateById(TPermission record);
	
	List<String> findPermissionsByUserId(String userid);
}
