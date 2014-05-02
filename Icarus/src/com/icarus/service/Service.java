package com.icarus.service;

import java.util.List;

import com.icarus.pojo.Location;
import com.icarus.pojo.Login;
import com.icarus.pojo.Organization;
import com.icarus.pojo.OrganizationData;
import com.icarus.pojo.ServiceUnit;
import com.icarus.pojo.Transaction;
import com.icarus.pojo.Type;
import com.icarus.pojo.User;
import com.icarus.pojo.UserData;

public interface Service {

	public boolean isUserPresent(String phoneNumber);
	public long getUserIdByPhoneNumber(String phoneNumber);
	public User getUserByPhoneNumber(String phoneNumber);
	public List<Type> getAllTypes();
	public boolean updateLocation(Location location);
	public Long registerOrganization(Organization org, OrganizationData orgData);
	public boolean registerOrganizationLogin(Login login);
	public Long organizationLogin(Login login);
	public OrganizationData getOrganizationData(Long id);
	public Long addUser(User user, UserData data);
	public boolean addServiceUnit(ServiceUnit unit, Location location);
	public List<User> getUsersByOrganizationId(Long id);
	public List<Location> getUserLocationByOrganizationId(Long id);
	public List<ServiceUnit> getServiceUnitsByOrganizationId(Long id);
	public Location getUserLocationByUserId(Long id);
	public List<Location> getNearestUsers(Location location, Long typeId);
	public List<User> getNearestUserBasicData(Location location, Long typeId);
	public boolean createTransaction(Transaction transaction);
	public Organization getOrganizationById(Long id);
	public List<UserData> getUserDataByOrganizationId(Long id);
}
