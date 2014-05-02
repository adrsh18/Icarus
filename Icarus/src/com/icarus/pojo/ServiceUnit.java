package com.icarus.pojo;

import java.io.Serializable;

public class ServiceUnit extends PersistentPojo implements Serializable {

	public static final String FIND_SERVICE_UNITS_BY_ORGANIZATION_ID ="findServiceUnitsByOrganizationId";
	private long organizationId;
	private long userId;
	private String availability;
	
	public ServiceUnit() {
		super();
	}
	public ServiceUnit(long organizationId, long userId, String availability) {
		super();
		this.organizationId = organizationId;
		this.userId = userId;
		this.availability = availability;
	}
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
}
