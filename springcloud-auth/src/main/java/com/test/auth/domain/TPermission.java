package com.test.auth.domain;

public class TPermission{
	private String id;//1
	private String code;//2
	private String description;//3
	private String url;//4

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code=code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url=url;
	}
	
}