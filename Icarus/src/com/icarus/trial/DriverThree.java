package com.icarus.trial;

import com.icarus.control.ApplicationControl;
import com.icarus.control.ApplicationControlImpl;

public class DriverThree {

	public static void main(String [] args)
	{
		ApplicationControl control = new ApplicationControlImpl();
		System.out.println(control.updateLocation("123456789", "10.20", "10.20"));
	}
}
