package com.icarus.view;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import com.icarus.control.ApplicationControl;
import com.icarus.control.ApplicationControlImpl;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Long organizationId;
	public Login() {
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	public Long login() {
		ApplicationControl control = new ApplicationControlImpl();
		Long id = control.login(this);
		setOrganizationId(id);
        return id;
    }  
}
