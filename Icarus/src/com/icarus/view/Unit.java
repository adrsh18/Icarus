package com.icarus.view;

import java.io.Serializable;
import java.util.List;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.LatLngBounds;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.icarus.geo.GeoLocator;
import com.icarus.pojo.Transaction;

public class Unit implements Serializable {

	private String phoneNumber;
	private long unitId;
	private String status;
	private String latitude;
	private String longitude;
	private String firstName;
	private String lastName;
	private String description;
	private String email;
	private String address;
	private MapModel model;
	
	public String getAddress() {
		if(address==null)
		{
			address = GeoLocator.getAddress(latitude, longitude);
		}
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	private List<Transaction> transactionList;
	public Unit(String phoneNumber, long unitId, String status,
			String latitude, String longitude, String firstName,
			String lastName, String description, List<Transaction> transactionList) {
		super();
		this.phoneNumber = phoneNumber;
		this.unitId = unitId;
		this.status = status;
		this.latitude = latitude;
		this.longitude = longitude;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.transactionList = transactionList;
		model = new DefaultMapModel();
		LatLng coord = new LatLng(Double.parseDouble(latitude),Double.parseDouble(longitude));
		model.addOverlay(new Marker(coord,phoneNumber));
	}
	
	public MapModel getModel() {
		return model;
	}

	public void setModel(MapModel model) {
		this.model = model;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Unit() {
		// TODO Auto-generated constructor stub
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public long getUnitId() {
		return unitId;
	}
	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
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
	public List<Transaction> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
