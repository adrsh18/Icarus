package com.icarus.pojo;

import java.io.Serializable;

public class Login extends PersistentPojo implements Serializable {

	public static final String FIND_LOGIN_BY_LOGIN_ID = "findLoginByLoginID";
	private String loginId;
	private String password;
	private long organizationId;
	
	public Login(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}
	
	public Login() {
		super();
	}

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	
}
