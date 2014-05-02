package com.icarus.trial;

import java.util.Date;
import java.util.List;

import com.icarus.persistence.HibernateDao;
import com.icarus.persistence.HibernateDaoImpl;
import com.icarus.pojo.Location;
import com.icarus.pojo.Type;
import com.icarus.pojo.User;

public class DriverTwo {

	public static void main(String [] args)
	{
		Location l = new Location();
		l.setUserId(1);
		l.setLatitude("10.10");
		l.setLongitude("10.10");
		l.setTimeLogged(new Date());
		HibernateDao dao = new HibernateDaoImpl();
		//List<User> list = dao.findByNamedQuery(User.FIND_USER_BY_PHONE_NUMBER, "123456789");
		if(dao.update(l))
		{
			System.out.println("Success..");
		}else
		{
			System.out.println("Disappointment..");
		}
		
	}
}
