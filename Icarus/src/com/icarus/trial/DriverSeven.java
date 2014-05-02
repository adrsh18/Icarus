package com.icarus.trial;

import com.icarus.control.ApplicationControl;
import com.icarus.control.ApplicationControlImpl;

public class DriverSeven {

	public static void main(String [] args)
	{
		ApplicationControl control = new ApplicationControlImpl();
		System.out.println(control.startTransactionRest("123456789", "123456789"));
	}
}
