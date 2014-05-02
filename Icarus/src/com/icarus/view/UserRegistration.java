package com.icarus.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UserRegistration  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7380412803958636984L;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private boolean readyDownload;
	private String downloadOption;
	
	public UserRegistration() {
		super();
	}


	@PostConstruct
	public void init(){
		readyDownload = false;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@SuppressWarnings("unused")
	public String registerUser()
	{
		/*String result = null;
		ApplicationControl control = new ApplicationControlImpl();
		return result;*/
		int x=10;
		readyDownload = true;
		return null;
	}


	public boolean isReadyDownload() {
		return readyDownload;
	}


	public void setReadyDownload(boolean readyDownload) {
		this.readyDownload = readyDownload;
	}


	public String getDownloadOption() {
		return downloadOption;
	}


	public void setDownloadOption(String downloadOption) {
		this.downloadOption = downloadOption;
	}
}
