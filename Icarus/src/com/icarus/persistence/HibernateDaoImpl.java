package com.icarus.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.icarus.pojo.PersistentPojo;

public class HibernateDaoImpl implements HibernateDao {

	private SessionFactory sessionFactory;
	public HibernateDaoImpl()
	{
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	public <T extends PersistentPojo> boolean create(T pojo)
	{
		boolean result = false;
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			session.save(pojo);
			tx.commit();
			result=true;
			//session.flush();
			//session.close();
		}catch(Exception e)
		{
			if(tx!=null)
			 tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	public <T extends PersistentPojo> List<T> findAll(final Class<T> type)
	{
		List<T> results = null;
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			Criteria criteria = session.createCriteria(type);
			results = criteria.list();
			tx.commit();
			//session.flush();
			//session.close();
		}catch(Exception e)
		{
			if(tx!=null)
			 tx.rollback();
			e.printStackTrace();
		}
		return results;
	}
	public <T extends PersistentPojo> boolean remove(T pojo)
	{
		boolean result = false;
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			session.delete(pojo);
			tx.commit();
			result=true;
			//session.flush();
			//session.close();
		}catch(Exception e)
		{
			if(tx!=null)
			 tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	public <T extends PersistentPojo> boolean update(T pojo)
	{
		boolean result = false;
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(pojo);
			tx.commit();
			result=true;
			//session.flush();
			//session.close();
		}catch(Exception e)
		{
			if(tx!=null)
			 tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	public <T extends PersistentPojo> T findById(final Class<T> type, final Long id)
	{
		T result = null;
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			result = (T) session.get(type, id);
			tx.commit();
			//session.flush();
			//session.close();
		}catch(Exception e)
		{
			if(tx!=null)
			 tx.rollback();
			e.printStackTrace();
		}
		return result;
	}
	public <T extends PersistentPojo> List<T> findByNamedQuery(String namedQuery, Object...params)
	{
		List<T> results= null;
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.getCurrentSession();
			tx = session.getTransaction();
			tx.begin();
			Query q = session.getNamedQuery(namedQuery);
			for(int i = 0;i<params.length;i++)
			{
				q.setParameter(i, params[i]);
			}
			results = (List<T>) q.list();
			tx.commit();
		}catch(Exception e)
		{
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		return results;
	}
}
