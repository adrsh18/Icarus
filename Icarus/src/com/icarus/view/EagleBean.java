package com.icarus.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.icarus.pojo.Location;
import com.icarus.pojo.ServiceUnit;

@ManagedBean
@SessionScoped
public class EagleBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MapModel model;
	private Marker marker;
	
	@ManagedProperty(value="#{organizationUtil}")
	private OrganizationUtil orgUtil;
	
	public MapModel getModel() {
		return model;
	}
	public Marker getMarker() {
		return marker;
	}

	public OrganizationUtil getOrgUtil() {
		return orgUtil;
	}

	public void setOrgUtil(OrganizationUtil orgUtil) {
		this.orgUtil = orgUtil;
	}

	public EagleBean()
	{
		model = new DefaultMapModel();
		
	}
	@PostConstruct
	public void initialize()
	{
		LatLng coord = null;
		if(orgUtil!=null)
		{
			System.out.println("In");
			String icon = "images/blue-dot.png";
			List<Location> list = orgUtil.getLocations();
			List<com.icarus.pojo.User> userList = orgUtil.getUnits();
			List<ServiceUnit> availList = orgUtil.getAvailList();
			for(int i=0;i<list.size();i++)
			{
				if(availList.get(i).getAvailability().equalsIgnoreCase("busy")) {icon="images/red-dot.png";}
				coord = new LatLng(Double.parseDouble(list.get(i).getLatitude()), Double.parseDouble(list.get(i).getLongitude()));
				model.addOverlay(new Marker(coord, "Unit:"+userList.get(i).getPhoneNumber(), "Status:"+availList.get(i).getAvailability(), icon));
				System.out.println(userList.get(i).getPhoneNumber()+" "+list.get(i).getLatitude());
			}
		}
	}
	public void onMarkerSelect(OverlaySelectEvent event) {  
        marker = (Marker) event.getOverlay();  
    }

}
