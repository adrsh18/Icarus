package com.icarus.trial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.icarus.pojo.Location;
import com.icarus.pojo.User;

public class DriverOne {

	public static void main(String [] args)
	{
		try{
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");         
	        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
	        sb.applySettings(cfg.getProperties());
	        StandardServiceRegistry standardServiceRegistry = sb.build();                   
	        SessionFactory sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
			Location l = new Location();
			l.setUserId(0);
			l.setLatitude("10.10");
			l.setLongitude("10.10");
			l.setTimeLogged();
			Session s = sessionFactory.openSession();
			Transaction tx = s.getTransaction();
			tx.begin();
			s.save(l);
			tx.commit();
			s.flush();
			s.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
