package com.icarus.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UserWizard implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public User user = new User();
public User getUser() {
return user;
}
public void setUser(User user) {
this.user = user;
}
public void save(ActionEvent actionEvent) {
//Persist user
FacesMessage msg = new FacesMessage("Successful",
"Welcome :" + user.getFirstname());
FacesContext.getCurrentInstance().addMessage(null, msg);
}
}
