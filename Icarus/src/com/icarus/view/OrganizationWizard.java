package com.icarus.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class OrganizationWizard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Organization organization = new Organization();
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public void save(ActionEvent actionEvent) {
		//Persist user
		organization.setDone(true);
		FacesMessage msg = new FacesMessage("Successful",
		"Organization registered");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		}
}
