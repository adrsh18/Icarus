package com.icarus.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.icarus.pojo.Location;
import com.icarus.pojo.ServiceUnit;
import com.icarus.pojo.UserData;
@ManagedBean
@SessionScoped
public class UnitsBean implements Serializable{
	private List<Unit> unitList;
	private List<Unit> filteredUnits;
	private Unit selectedUnit;
	
	public Unit getSelectedUnit() {
		return selectedUnit;
	}
	public void setSelectedUnit(Unit selectedUnit) {
		this.selectedUnit = selectedUnit;
	}
	@ManagedProperty(value="#{organizationUtil}")
	private OrganizationUtil orgUtil;
	public UnitsBean() {
		super();
		unitList = new ArrayList<Unit>();
	}
	@PostConstruct
	public void initialize()
	{
		Unit unit = null;
		List<com.icarus.pojo.User> units = orgUtil.getUnits();
		List<Location> locations = orgUtil.getLocations();
		List<ServiceUnit> availList = orgUtil.getAvailList();
		List<UserData> dataList = orgUtil.getUserdataList();
		for(int i=0;i<availList.size();i++)
		{
			unit= new Unit(units.get(i).getPhoneNumber(),units.get(i).getUserId(), availList.get(i).getAvailability(), locations.get(i).getLatitude(), locations.get(i).getLongitude(),dataList.get(i).getFirstName(),dataList.get(i).getLastName(),"", null);
			unitList.add(unit);
		}
	}
	
	public List<Unit> getFilteredUnits() {
		return filteredUnits;
	}
	public void setFilteredUnits(List<Unit> filteredUnits) {
		this.filteredUnits = filteredUnits;
	}
	public List<Unit> getUnitList() {
		return unitList;
	}
	public void setUnitList(List<Unit> unitList) {
		this.unitList = unitList;
	}
	public OrganizationUtil getOrgUtil() {
		return orgUtil;
	}
	public void setOrgUtil(OrganizationUtil orgUtil) {
		this.orgUtil = orgUtil;
	}
	
}
