package com.icarus.pojo;

import java.io.Serializable;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
	@NamedQuery(
			name = "findUserByPhoneNumber",
			query = "from User u where u.phone_number = :phoneNumber"
			)
})
public class User extends PersistentPojo implements Serializable {

	public static final String FIND_USER_BY_PHONE_NUMBER = "findUserByPhoneNumber";
	private long userId;
	private String phoneNumber;
	private long typeId;
	
	public User() {
		super();
	}
	public User(String phoneNumber, long typeId) {
		super();
		this.phoneNumber = phoneNumber;
		this.typeId = typeId;
	}
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
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", phoneNumber=" + phoneNumber
				+ ", typeId=" + typeId + "]";
	}
	
}
