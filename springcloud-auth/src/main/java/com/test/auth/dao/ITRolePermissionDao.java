package com.test.auth.dao;

import java.util.List;
import com.test.auth.domain.TRolePermission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ITRolePermissionDao {

	int insert(TRolePermission example);
	
	int delete(TRolePermission example);
	
	TRolePermission selectById(Integer id);
	
	List<TRolePermission> select(TRolePermission example);
	
	int updateById(TRolePermission record);
}
