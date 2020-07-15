package com.test.auth.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.auth.domain.TRolePermission;
import com.test.auth.service.ITRolePermissionService;
import com.test.auth.util.R;


@RestController
@RequestMapping("///trolepermission")
public class TRolePermissionController {
	@Autowired
	private ITRolePermissionService tRolePermissionService;


	@PostMapping("/insert")
	public int insert(@RequestBody TRolePermission example){
		return tRolePermissionService.insert(example);
	}
	
	@PostMapping("/deleteByExample")
	public int deleteByExample(@RequestBody TRolePermission example){
		return tRolePermissionService.deleteByExample(example);
	}
	
	@PostMapping("/selectById")
	public R selectById(Integer id){
		TRolePermission obj = tRolePermissionService.selectById(id);
		return R.ok().put("tRolePermission", obj);
	}
	
	@PostMapping("/selectByExample")
	public R select(@RequestBody TRolePermission example){
		List<TRolePermission> list = tRolePermissionService.select(example);
		return R.ok().put("list", list);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public R updateById(@RequestBody TRolePermission example){
		tRolePermissionService.updateById(example);
		return R.ok();
	}
}
