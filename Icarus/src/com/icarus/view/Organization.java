package com.icarus.view;

import java.io.Serializable;
import java.util.List;

import com.icarus.control.ApplicationControl;
import com.icarus.control.ApplicationControlImpl;
import com.icarus.pojo.Type;

public class Organization implements Serializable {

	private String companyName;
	private long typeId;
	private List<Type> types;
	private String country;
	private String street;
	private String city;
	private String postalCode;
	private String primaryPhone;
	private String secondaryPhone;
	private String email;
	private String website;
	private boolean done;
	public Organization()
	{
		ApplicationControl control = new ApplicationControlImpl();
		types = control.getAllTypes();
		done= false;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public List<Type> getTypes() {
		return types;
	}
	public void setTypes(List<Type> types) {
		this.types = types;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPrimaryPhone() {
		return primaryPhone;
	}
	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}
	public String getSecondaryPhone() {
		return secondaryPhone;
	}
	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
}
