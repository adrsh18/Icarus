package com.icarus.trial;

import com.icarus.control.ApplicationControl;
import com.icarus.control.ApplicationControlImpl;

public class DriverSix {

	public static void main(String [] args)
	{
		ApplicationControl control = new ApplicationControlImpl();
		System.out.println(control.getNearestUsersRest("123456789", "10.30", "10.30", (long)1));
	}
}
