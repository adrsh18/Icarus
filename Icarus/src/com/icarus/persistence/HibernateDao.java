package com.icarus.persistence;

import java.util.List;

import com.icarus.pojo.PersistentPojo;

public interface HibernateDao {

	public <T extends PersistentPojo> boolean create(T pojo);
	public <T extends PersistentPojo> List<T> findAll(final Class<T> type);
	public <T extends PersistentPojo> T findById(final Class<T> type, final Long id);
	//public <T extends PersistentPojo> List<T> findByMultipleIds(final Class<T> type, final Long...id);
	public <T extends PersistentPojo> List<T> findByNamedQuery(String namedQuery, Object...params);
	public <T extends PersistentPojo> boolean remove(T pojo);
	//public <T extends PersistentPojo> boolean removeById(final Class<T> type, final Long id);
	public <T extends PersistentPojo> boolean update(T pojo);
}
