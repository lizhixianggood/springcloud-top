package com.test.auth.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.auth.domain.TPermission;
import com.test.auth.service.ITPermissionService;
import com.test.auth.util.R;


@RestController
@RequestMapping("///tpermission")
public class TPermissionController {
	@Autowired
	private ITPermissionService tPermissionService;


	@PostMapping("/insert")
	public int insert(@RequestBody TPermission example){
		return tPermissionService.insert(example);
	}
	
	@PostMapping("/deleteByExample")
	public int deleteByExample(@RequestBody TPermission example){
		return tPermissionService.deleteByExample(example);
	}
	
	@PostMapping("/selectById")
	public R selectById(Integer id){
		TPermission obj = tPermissionService.selectById(id);
		return R.ok().put("tPermission", obj);
	}
	
	@PostMapping("/selectByExample")
	public R select(@RequestBody TPermission example){
		List<TPermission> list = tPermissionService.select(example);
		return R.ok().put("list", list);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public R updateById(@RequestBody TPermission example){
		tPermissionService.updateById(example);
		return R.ok();
	}
}
