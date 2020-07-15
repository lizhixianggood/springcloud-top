package com.test.auth.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.auth.domain.TUserRole;
import com.test.auth.service.ITUserRoleService;
import com.test.auth.util.R;


@RestController
@RequestMapping("///tuserrole")
public class TUserRoleController {
	@Autowired
	private ITUserRoleService tUserRoleService;


	@PostMapping("/insert")
	public int insert(@RequestBody TUserRole example){
		return tUserRoleService.insert(example);
	}
	
	@PostMapping("/deleteByExample")
	public int deleteByExample(@RequestBody TUserRole example){
		return tUserRoleService.deleteByExample(example);
	}
	
	@PostMapping("/selectById")
	public R selectById(Integer id){
		TUserRole obj = tUserRoleService.selectById(id);
		return R.ok().put("tUserRole", obj);
	}
	
	@PostMapping("/selectByExample")
	public R select(@RequestBody TUserRole example){
		List<TUserRole> list = tUserRoleService.select(example);
		return R.ok().put("list", list);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public R updateById(@RequestBody TUserRole example){
		tUserRoleService.updateById(example);
		return R.ok();
	}
}
