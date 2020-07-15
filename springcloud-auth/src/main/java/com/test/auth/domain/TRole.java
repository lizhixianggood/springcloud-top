package com.test.auth.domain;

import java.util.Date;

public class TRole{
	private String id;//1
	private String roleName;//2
	private String description;//3
	private Date createTime;//4
	private Date updateTime;//5
	private String status;//6

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName=roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime=createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	
}