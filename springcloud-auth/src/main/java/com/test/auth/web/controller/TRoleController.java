package com.test.auth.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.auth.domain.TRole;
import com.test.auth.service.ITRoleService;
import com.test.auth.util.R;


@RestController
@RequestMapping("///trole")
public class TRoleController {
	@Autowired
	private ITRoleService tRoleService;


	@PostMapping("/insert")
	public int insert(@RequestBody TRole example){
		return tRoleService.insert(example);
	}
	
	@PostMapping("/deleteByExample")
	public int deleteByExample(@RequestBody TRole example){
		return tRoleService.deleteByExample(example);
	}
	
	@PostMapping("/selectById")
	public R selectById(Integer id){
		TRole obj = tRoleService.selectById(id);
		return R.ok().put("tRole", obj);
	}
	
	@PostMapping("/selectByExample")
	public R select(@RequestBody TRole example){
		List<TRole> list = tRoleService.select(example);
		return R.ok().put("list", list);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public R updateById(@RequestBody TRole example){
		tRoleService.updateById(example);
		return R.ok();
	}
}
