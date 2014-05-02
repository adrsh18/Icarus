package com.icarus.trial;

import com.icarus.pojo.Login;
import com.icarus.pojo.Organization;
import com.icarus.service.Service;
import com.icarus.service.ServiceImpl;

public class DriverFour {

	public static void main(String [] args)
	{
		ServiceImpl s = new ServiceImpl();
		Organization org = new Organization();
		org.setOrganizationName("Hammer Tech");
		org.setTypeId(0);
		org.setLatitude("10.10");
		org.setLongitude("10.10");
		Login l = new Login();
		Long id = s.registerOrganization(org, null);
		if(id!=null)
		{
			l.setOrganizationId(id);
			l.setLoginId("testIdTwo@gmail.com");
			l.setPassword("testPassword");
			s.registerOrganizationLogin(l);
			System.out.println(s.organizationLogin(l));
		}
	}
}
