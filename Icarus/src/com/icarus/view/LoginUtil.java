package com.icarus.view;

import java.io.IOException;
import java.io.Serializable;




import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean loggedIn;
	private Login login = new Login();
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public LoginUtil() {
		super();
		loggedIn = false;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String login()
	{
		Long id = login.login();
		if(id!=null)
		{
			loggedIn = true;
			System.out.println("Success");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Welcome",""));
			return "welcome-auth.xhtml";
		}else {
			System.out.println("Failed");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Invalid Username or Password",""));
			return "";
			
		}
	}
	public String logout()
	{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        System.out.println("Logout called");
        loggedIn = false;
        return "/login.xhtml";
	}
	public void loginCheck()
	{
		if(!loggedIn)
		{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
