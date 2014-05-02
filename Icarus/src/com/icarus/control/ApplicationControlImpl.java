package com.icarus.control;

import java.util.ArrayList;
import java.util.List;

import com.icarus.pojo.Location;
import com.icarus.pojo.Organization;
import com.icarus.pojo.OrganizationData;
import com.icarus.pojo.ServiceUnit;
import com.icarus.pojo.Transaction;
import com.icarus.pojo.Type;
import com.icarus.pojo.User;
import com.icarus.pojo.UserData;
import com.icarus.service.Service;
import com.icarus.service.ServiceImpl;
import com.icarus.view.Login;
import com.icarus.view.Unit;

public class ApplicationControlImpl implements ApplicationControl{

	public boolean updateLocation(String phoneNumber, String latitude, String longitude)
	{
		boolean result = false;
		Service service = new ServiceImpl();
		if(service.isUserPresent(phoneNumber))
		{
			Location location = new Location();
			location.setUserId(service.getUserIdByPhoneNumber(phoneNumber));
			location.setLatitude(latitude);
			location.setLongitude(longitude);
			if(service.updateLocation(location))
			{
				result = true;
			}
		}
		return result;
	}
	public String updateLocationRest(String phoneNumber, String latitude, String longitude)
	{
		boolean status = updateLocation(phoneNumber, latitude, longitude);
		String result = "{status:501}";
		if(status) 
		{
			result = "{status:200}";
		}
		return result;
	}
	public List<UserBean> getNearestUsers(String phoneNumber, String latitude, String longitude, Long typeId)
	{
		List<UserBean> results = null;
		if(updateLocation(phoneNumber, latitude, longitude))
		{
			UserBean temp = null;
			Service service = new ServiceImpl();
			Long id = service.getUserIdByPhoneNumber(phoneNumber);
			Location location = service.getUserLocationByUserId(id);
			List<Location> locations = service.getNearestUsers(location, typeId);
			List<User> users = service.getNearestUserBasicData(location, typeId);
			if(users.size() == locations.size())
			{
				results = new ArrayList<UserBean>();
				for(int i=0;i<users.size()&&i<10;i++)
				{
					temp = new UserBean();
					temp.setUserId(users.get(i).getUserId());
					temp.setPhoneNumber(users.get(i).getPhoneNumber());
					temp.setLatitude(locations.get(i).getLatitude());
					temp.setLongitude(locations.get(i).getLongitude());
					results.add(temp);
				}
			}
		}
		return results;
	}
	public String getNearestUsersRest(String phoneNumber, String latitude, String longitude, Long typeId)
	{
		String result = "{status:501}";
		Service service = new ServiceImpl();
		if(service.isUserPresent(phoneNumber))
		{
			StringBuffer temp = new StringBuffer();
			temp.append("{status:200, result:[");
			List<UserBean> list = getNearestUsers(phoneNumber, latitude, longitude, typeId);
			for(UserBean bean:list)
			{
				temp.append(bean.toString());
				temp.append(",");
			}
			result = temp.substring(0,temp.length()-1);
			result = result+"]}";
		}
		return result;
	}
	public Long startTransaction(String sourcePhoneNumber, String destinationPhoneNumber)
	{
		Long result = null;
		Service service = new ServiceImpl();
		if(service.isUserPresent(sourcePhoneNumber)&&service.isUserPresent(destinationPhoneNumber))
		{
			long sourceId = service.getUserIdByPhoneNumber(sourcePhoneNumber);
			long destinationId = service.getUserIdByPhoneNumber(destinationPhoneNumber);
			Location sourceLocation = service.getUserLocationByUserId(sourceId);
			Location destinationLocation = service.getUserLocationByUserId(destinationId);
			Transaction transaction = new Transaction();
			transaction.setDestinationId(destinationId);
			transaction.setSourceId(sourceId);
			transaction.setSourceLatitude(sourceLocation.getLatitude());
			transaction.setSourceLongitude(sourceLocation.getLongitude());
			transaction.setDestinationLatitude(destinationLocation.getLatitude());
			transaction.setDestinationLongitude(destinationLocation.getLongitude());
			if(service.createTransaction(transaction))
			{
				result = transaction.getTransactionId();
			}
		}
		return result;
	}
	public String startTransactionRest(String sourcePhoneNumber, String destinationPhoneNumber)
	{
		String result = "{status:501}";
		Long id = startTransaction(sourcePhoneNumber, destinationPhoneNumber);
		if(id!=null)
		{
			result = "{status:200, result:{transactionId:"+id+"}}";
		}
		return result;
	}
	public List<Type> getAllTypes()
	{
		Service service = new ServiceImpl();
		return service.getAllTypes();
	}
	public Long login(Login login)
	{
		Long result = null;
		com.icarus.pojo.Login l = new com.icarus.pojo.Login(login.getUsername(), login.getPassword());
		Service service = new ServiceImpl();
		result = service.organizationLogin(l);
		return result;
	}
	public OrganizationData getOrganizationData(Long id)
	{
		Service service = new ServiceImpl();
		return service.getOrganizationData(id);
	}
	public List<User> getUsersByOrganizationId(Long id)
	{
		Service service = new ServiceImpl();
		return service.getUsersByOrganizationId(id);
	}
	public List<UserData> getUserDataByOrganizationId(Long id)
	{
		Service service = new ServiceImpl();
		return service.getUserDataByOrganizationId(id);
	}
	public List<Location> getUserLocationByOrganizationId(Long id)
	{
		Service service = new ServiceImpl();
		return service.getUserLocationByOrganizationId(id);
	}
	public List<ServiceUnit> getServiceUnitsByOrganizationId(Long id)
	{
		Service service = new ServiceImpl();
		return service.getServiceUnitsByOrganizationId(id);
	}
	public Organization getOrganizationById(Long id)
	{
		Service service = new ServiceImpl();
		return service.getOrganizationById(id);
	}
	public boolean addUnit(Unit unit, Long id)
	{
		Service service = new ServiceImpl();
		Long userId = service.addUser(new User(unit.getPhoneNumber(), (long)1), new UserData(unit.getFirstName(),unit.getLastName(),unit.getEmail(),unit.getDescription()));
		return service.addServiceUnit(new ServiceUnit(id,userId,"unregd"), new Location(userId, "12.971599","77.594563",null));
		
	}
	public boolean isUserPresent(String phoneNumber){
		Service service = new ServiceImpl();
		return service.isUserPresent(phoneNumber);
	}
}
