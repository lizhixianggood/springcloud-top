package com.test.auth.domain;


public class TRolePermission{
	private String roleId;//1
	private String permissionId;//2

	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId=roleId;
	}
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId=permissionId;
	}
	
	public String getId() {
		return this.roleId;
	}
	
	public void setId(String roleId) {
		this.roleId=roleId;
	}
	
}