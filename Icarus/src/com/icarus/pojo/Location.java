package com.icarus.pojo;

import java.io.Serializable;
import java.util.Date;

public class Location extends PersistentPojo implements Serializable {
	
	public static final String FIND_NEAREST_USERS = "findNearestUsers";
	public static final String FIND_NEAREST_USER_BASIC_DATA = "findNearestUserBasicData";
	private long userId;
	private String latitude;
	private String longitude;
	private Date timeLogged;
	
	public Location() {
		super();
	}
	public Location(long userId, String latitude, String longitude,
			Date timeLogged) {
		super();
		this.userId = userId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timeLogged = timeLogged;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public Date getTimeLogged() {
		return timeLogged;
	}
	public void setTimeLogged(Date timeLogged) {
		this.timeLogged = timeLogged;
	}
	public void setTimeLogged() {
		this.timeLogged = new Date();
	}
	@Override
	public String toString() {
		return "Location [userId=" + userId + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", timeLogged=" + timeLogged
				+ "]";
	}
}
