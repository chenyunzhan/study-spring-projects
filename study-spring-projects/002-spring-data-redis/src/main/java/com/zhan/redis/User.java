package com.zhan.redis;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer userId;
	private String userName;
	
	private Role role;
	
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public User(Integer userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	
	
	
	public User(Integer userId, String userName, Role role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.role = role;
	}
	
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}
	
	

}
