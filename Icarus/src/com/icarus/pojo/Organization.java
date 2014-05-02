package com.icarus.pojo;

import java.io.Serializable;

public class Organization extends PersistentPojo implements Serializable {

	public static final String FIND_USERS_BY_ORGANIZATION_ID = "findUsersByOrganizationId";
	public static final String FIND_USER_DATA_BY_ORGANIZATION_ID = "findUserDataByOrganizationId";
	public static final String FIND_USER_LOCATION_BY_ORGANIZATION_ID = "findUserLocationByOrganizationId";
	private long organizationId;
	private String organizationName;
	private long typeId;
	private String latitude;
	private String longitude;
	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
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
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
}
