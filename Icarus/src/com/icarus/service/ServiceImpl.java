package com.icarus.service;
import java.util.List;

import com.icarus.persistence.HibernateDao;
import com.icarus.persistence.HibernateDaoImpl;
import com.icarus.pojo.Location;
import com.icarus.pojo.Login;
import com.icarus.pojo.Organization;
import com.icarus.pojo.OrganizationData;
import com.icarus.pojo.PersistentPojo;
import com.icarus.pojo.ServiceUnit;
import com.icarus.pojo.Transaction;
import com.icarus.pojo.Type;
import com.icarus.pojo.User;
import com.icarus.pojo.UserData;

public class ServiceImpl implements Service{
	
	public boolean isUserPresent(String phoneNumber)
	{
		boolean result = false;
		if(getUserByPhoneNumber(phoneNumber)!=null)
		{
			result = true;
		}
		return result;
	}
	public User getUserByPhoneNumber(String phoneNumber)
	{
		User user = null;
		HibernateDao dao = new HibernateDaoImpl();
		List<User> list = dao.findByNamedQuery(User.FIND_USER_BY_PHONE_NUMBER, phoneNumber);
		if(list.size()!=0)
		{
			user = list.get(0);
		}
		return user;
	}
	public long getUserIdByPhoneNumber(String phoneNumber)
	{
		Long userId = null;
		User user = getUserByPhoneNumber(phoneNumber);
		if(user!=null)
		{
			userId = user.getUserId();
		}
		return userId;
	}
	public boolean updateLocation(Location location)
	{
		boolean result = false;
		HibernateDao dao = new HibernateDaoImpl();
		if(dao.update(location))
		{
			result = true;
		}
		return result;
	}
	public List<Type> getAllTypes()
	{
		List<Type> results = null;
		HibernateDao dao = new HibernateDaoImpl();
		results = dao.findAll(Type.class);
		return results;
 	}
	public Long registerOrganization(Organization org, OrganizationData orgData)
	{
		Long result = null;
		HibernateDao dao = new HibernateDaoImpl();
		dao.create(org);
		result = org.getOrganizationId();
		return result;
	}
	public boolean registerOrganizationLogin(Login login)
	{
		boolean result = false;
		HibernateDao dao = new HibernateDaoImpl();
		result = dao.create(login);
		return result;
	}
	public Long organizationLogin(Login login)
	{
		Long result = null;
		HibernateDao dao = new HibernateDaoImpl();
		Login auth = (Login) dao.findByNamedQuery(Login.FIND_LOGIN_BY_LOGIN_ID, login.getLoginId()).get(0);
		if(login.getPassword().equals(auth.getPassword()))
		{
			result = auth.getOrganizationId();
		}
		return result;
	}
	public OrganizationData getOrganizationData(Long id)
	{
		OrganizationData data = null;
		return data;
	}
	public Long addUser(User user, UserData data)
	{
		Long id = null;
		HibernateDao dao = new HibernateDaoImpl();
		if(dao.create(user))
		{
			id = user.getUserId();
			data.setUserId(id);
			dao.create(data);
		}
		return id;
	}
	public boolean addServiceUnit(ServiceUnit unit, Location location)
	{
		boolean result = false;
		HibernateDao dao = new HibernateDaoImpl();
		result = dao.create(unit)&dao.create(location);
		return result;
	}
	public List<User> getUsersByOrganizationId(Long id)
	{
		List<User> results = null;
		HibernateDao dao = new HibernateDaoImpl();
		results = dao.findByNamedQuery(Organization.FIND_USERS_BY_ORGANIZATION_ID, id);
		System.out.println(results.size());
		return results;
	}
	public List<UserData> getUserDataByOrganizationId(Long id)
	{
		List<UserData> results = null;
		HibernateDao dao = new HibernateDaoImpl();
		results = dao.findByNamedQuery(Organization.FIND_USER_DATA_BY_ORGANIZATION_ID, id);
		System.out.println(results.size());
		return results;
	}
	public List<Location> getUserLocationByOrganizationId(Long id)
	{
		List<Location> results = null;
		HibernateDao dao = new HibernateDaoImpl();
		results = dao.findByNamedQuery(Organization.FIND_USER_LOCATION_BY_ORGANIZATION_ID, id);
		System.out.println(results.size());
		return results;
	}
	public Location getUserLocationByUserId(Long id)
	{
		Location location = null;
		HibernateDao dao = new HibernateDaoImpl();
		location = (Location) dao.findById(Location.class, id);
		return location;
	}
	public List<ServiceUnit> getServiceUnitsByOrganizationId(Long id)
	{
		List<ServiceUnit> results = null;
		HibernateDao dao = new HibernateDaoImpl();
		results = dao.findByNamedQuery(ServiceUnit.FIND_SERVICE_UNITS_BY_ORGANIZATION_ID, id);
		System.out.println(results.size());
		return results;
	}
	public List<Location> getNearestUsers(Location location, Long typeId)
	{
		List<Location> results = null;
		HibernateDao dao = new HibernateDaoImpl();
		results = dao.findByNamedQuery(Location.FIND_NEAREST_USERS, typeId, location.getLatitude(), location.getLongitude());
		return results;
	}
	public List<User> getNearestUserBasicData(Location location, Long typeId)
	{
		List<User> results = null;
		HibernateDao dao = new HibernateDaoImpl();
		results = dao.findByNamedQuery(Location.FIND_NEAREST_USER_BASIC_DATA, typeId, location.getLatitude(), location.getLongitude());
		return results;
	}
	public boolean createTransaction(Transaction transaction)
	{
		HibernateDao dao = new HibernateDaoImpl();
		return dao.create(transaction);
	}
	public Organization getOrganizationById(Long id)
	{
		Organization org = null;
		HibernateDao dao = new HibernateDaoImpl();
		org = (Organization) dao.findById(Organization.class, id);
		System.out.println(org.getOrganizationName());
		return org;
	}
}
