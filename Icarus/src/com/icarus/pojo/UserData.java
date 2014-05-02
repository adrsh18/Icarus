package com.icarus.pojo;

import java.io.Serializable;

public class UserData extends PersistentPojo implements Serializable {

	private long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String description;
	
	public UserData() {
		super();
	}
	public UserData(String firstName, String lastName, String email,
			String description) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.description = description;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
