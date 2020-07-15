package com.test.auth.domain;

import java.util.Date;

public class TUserRole{
	private String userId;//1
	private String roleId;//2
	private Date createTime;//3
	private String creator;//4

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId=userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId=roleId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime=createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator=creator;
	}
	
	public String getId() {
		return this.userId;
	}
	
	public void setId(String userId) {
		this.userId=userId;
	}
	
}