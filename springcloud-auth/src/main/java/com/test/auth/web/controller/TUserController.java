package com.test.auth.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.auth.domain.TUser;
import com.test.auth.service.ITUserService;
import com.test.auth.util.R;


@RestController
@RequestMapping("///tuser")
public class TUserController {
	@Autowired
	private ITUserService tUserService;


	@PostMapping("/insert")
	public int insert(@RequestBody TUser example){
		return tUserService.insert(example);
	}
	
	@PostMapping("/deleteByExample")
	public int deleteByExample(@RequestBody TUser example){
		return tUserService.deleteByExample(example);
	}
	
	@PostMapping("/selectById")
	public R selectById(Integer id){
		TUser obj = tUserService.selectById(id);
		return R.ok().put("tUser", obj);
	}
	
	@PostMapping("/selectByExample")
	public R select(@RequestBody TUser example){
		List<TUser> list = tUserService.select(example);
		return R.ok().put("list", list);
	}
	
	@PostMapping("/updateByPrimaryKey")
	public R updateById(@RequestBody TUser example){
		tUserService.updateById(example);
		return R.ok();
	}
}
