package com.icarus.control;

import java.util.List;

import com.icarus.pojo.Location;
import com.icarus.pojo.Organization;
import com.icarus.pojo.OrganizationData;
import com.icarus.pojo.ServiceUnit;
import com.icarus.pojo.Type;
import com.icarus.pojo.User;
import com.icarus.pojo.UserData;
import com.icarus.view.Login;
import com.icarus.view.Unit;

public interface ApplicationControl {

	public boolean updateLocation(String phoneNumber, String latitude, String longitude);
	public String updateLocationRest(String phoneNumber, String latitude, String longitude);
	public List<UserBean> getNearestUsers(String phoneNumber, String latitude, String longitude, Long typeId);
	public String getNearestUsersRest(String phoneNumber, String latitude, String longitude, Long typeId);
	public Long startTransaction(String sourcePhoneNumber, String destinationPhoneNumber);
	public String startTransactionRest(String sourcePhoneNumber, String destinationPhoneNumber);
	public List<Type> getAllTypes();
	public Long login(Login login);
	public List<User> getUsersByOrganizationId(Long id);
	public List<Location> getUserLocationByOrganizationId(Long id);
	public List<ServiceUnit> getServiceUnitsByOrganizationId(Long id);
	public OrganizationData getOrganizationData(Long id);
	public Organization getOrganizationById(Long id);
	public List<UserData> getUserDataByOrganizationId(Long id);
	public boolean addUnit(Unit unit, Long id);
	public boolean isUserPresent(String phoneNumber);
}
