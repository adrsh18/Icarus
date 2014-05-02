package com.icarus.control;

public class UserBean {

	private long userId;
	private String phoneNumber;
	private String latitude;
	private String longitude;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	@Override
	public String toString() {
		return "{userId:" + userId + ", phoneNumber:" + phoneNumber
				+ ", latitude:" + latitude + ", longitude:" + longitude + "}";
	}
	
}
