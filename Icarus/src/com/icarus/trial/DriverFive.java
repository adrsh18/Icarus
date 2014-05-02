package com.icarus.trial;

import com.icarus.pojo.Location;
import com.icarus.service.Service;
import com.icarus.service.ServiceImpl;

public class DriverFive {

	public static void main(String [] args)
	{
		Service s = new ServiceImpl();
		Location l = s.getUserLocationByUserId((long)1);
		System.out.println(s.getNearestUsers(l, (long)1));
	}
}
