package com.marker.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import com.marker.dao.inter.IMarkerDao;
import com.marker.pojo.Marker;

@Component("markerDao")
public class MarkerDaoImpl extends BaseDaoImpl implements IMarkerDao {

	@Override
	public Marker getById(int id) {
		String hql = "from Marker m where m.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (Marker) query.uniqueResult();
	}

	@Override
	public List<Marker> getAll() {
		String hql = "from Marker m order by m.updateDate desc";
//		Query query = sessionFactory.openSession().createQuery(hql);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Marker> markers = query.list();
//		session.close();
		return markers;
	}

	@Override
	public int create(Marker marker) {
//		Serializable serializable = sessionFactory.openSession().save(marker);
		Session session = sessionFactory.getCurrentSession();
		Serializable serializable = session.save(marker);
		System.out.println("serializable:" + serializable);
		return 0;
	}

	@Override
	public int update(int id, Marker marker) {
		System.out.println("MarkerDaoImpl@update");
		marker.setId(id);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(marker);
//		sessionFactory.openSession().saveOrUpdate("com.marker.pojo.Markera", marker);
		return 0;
	}

	@Override
	public int delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Marker marker = this.getById(id);
		System.out.println(marker);
		session.delete(marker);
		return 0;
	}

}
