package com.icarus.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.icarus.control.ApplicationControl;
import com.icarus.control.ApplicationControlImpl;
import com.icarus.pojo.Location;
import com.icarus.pojo.Organization;
import com.icarus.pojo.ServiceUnit;
import com.icarus.pojo.User;
import com.icarus.pojo.UserData;


@ManagedBean
@SessionScoped
public class OrganizationUtil implements Serializable {

	private Organization organization;
	private List<User> units;
	private List<Location> locations;
	private List<ServiceUnit> availList;
	private List<UserData> userdataList;
	@ManagedProperty(value="#{loginUtil}")
	private LoginUtil loginUtil;
	private boolean ready;
	
	
	public LoginUtil getLoginUtil() {
		return loginUtil;
	}
	public void setLoginUtil(LoginUtil loginUtil) {
		this.loginUtil = loginUtil;
	}
	public boolean isReady() {
		return ready;
	}
	public void setReady(boolean ready) {
		this.ready = ready;
	}
	public OrganizationUtil() {
		super();
		ready = false;
	}
	@PostConstruct
	public void initialize()
	{
		if(loginUtil!=null)
		{
			Long id = loginUtil.getLogin().getOrganizationId();
			ApplicationControl control = new ApplicationControlImpl();
			organization = control.getOrganizationById(id);
			units = control.getUsersByOrganizationId(id);
			locations = control.getUserLocationByOrganizationId(id);
			availList = control.getServiceUnitsByOrganizationId(id);
			userdataList = control.getUserDataByOrganizationId(id);
		}
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public List<User> getUnits() {
		return units;
	}
	public void setUnits(List<User> units) {
		this.units = units;
	}
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	public List<ServiceUnit> getAvailList() {
		return availList;
	}
	public void setAvailList(List<ServiceUnit> availList) {
		this.availList = availList;
	}
	
	public int totalUnitCount()
	{
		return getUnits().size();
	}
	public int activeUnitCount()
	{
		int result = getUnits().size();
		for(ServiceUnit s: availList)
		{
			if(s.getAvailability().equalsIgnoreCase("incative"))
			{
				result--;
			}
		}
		return result;
	}
	public List<UserData> getUserdataList() {
		return userdataList;
	}
	public void setUserdataList(List<UserData> userdataList) {
		this.userdataList = userdataList;
	}
	
}
