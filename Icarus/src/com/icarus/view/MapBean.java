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

import com.icarus.geo.GeoLocator;
import com.icarus.pojo.Location;
import com.icarus.pojo.ServiceUnit;
  
@ManagedBean
@SessionScoped
public class MapBean implements Serializable {  
      
    private MapModel advancedModel;  
  
    private Marker marker;  
  
    @ManagedProperty(value="#{organizationUtil}")
	private OrganizationUtil orgUtil;
    
    public OrganizationUtil getOrgUtil() {
		return orgUtil;
	}

	public void setOrgUtil(OrganizationUtil orgUtil) {
		this.orgUtil = orgUtil;
	}

	public MapBean() {  
        advancedModel = new DefaultMapModel();  
          
        //Shared coordinates  
         
    }  
  
    public MapModel getAdvancedModel() {  
        return advancedModel;  
    }  
      
    public void onMarkerSelect(OverlaySelectEvent event) {  
        marker = (Marker) event.getOverlay();  
    }  
      
    public Marker getMarker() {  
        return marker;  
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
				advancedModel.addOverlay(new Marker(coord, "Unit:"+userList.get(i).getPhoneNumber(), "Status:"+availList.get(i).getAvailability()+"\n"+GeoLocator.getAddress(list.get(i).getLatitude(), list.get(i).getLongitude()), "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));
				System.out.println(userList.get(i).getPhoneNumber()+" "+list.get(i).getLatitude());
			}
		}
	}
}  