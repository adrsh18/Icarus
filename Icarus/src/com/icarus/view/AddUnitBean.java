package com.icarus.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.icarus.control.ApplicationControl;
import com.icarus.control.ApplicationControlImpl;

@ManagedBean
@ViewScoped
public class AddUnitBean implements Serializable {

	private Unit unit;
	private boolean done;

	@ManagedProperty(value="#{loginUtil}")
	private LoginUtil x;
	private LoginUtil loginUtil;
	
	public LoginUtil getX() {
		return x;
	}
	public void setX(LoginUtil x) {
		this.x = x;
	}
	@PostConstruct
	public void initialize()
	{
		if(x!=null)
		{
			loginUtil = x;
			System.out.println("Got Got");
		}
	}
	public LoginUtil getLoginUtil() {
		return loginUtil;
	}

	public void setLoginutil(LoginUtil loginUtil) {
		this.loginUtil = loginUtil;
	}

	public AddUnitBean() {
		super();
		unit = new Unit();
		done = false;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public String addUnit()
	{
		done = false;
		if(loginUtil!=null)
		{
			Long id = loginUtil.getLogin().getOrganizationId();
			ApplicationControl control = new ApplicationControlImpl();
			if(control.addUnit(unit, id))
			{
				done = true;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Unit Added Successfully",""));
				return "welcome-auth.xhtml";
			}
		}
		return null;
	}
	public void phoneNumberCheck()
	{
		ApplicationControl control = new ApplicationControlImpl();
		if(control.isUserPresent(unit.getPhoneNumber()))
		{
			unit.setPhoneNumber("");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Phone Number not available. Try another number.",""));
		}
	}
}
