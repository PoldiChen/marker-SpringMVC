package com.marker.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.marker.dao.inter.ILabelDao;
import com.marker.pojo.Label;

@Component("labelDao")
public class LabelDaoImpl extends BaseDaoImpl implements ILabelDao {

	@Override
	public List<Label> getAll() {
		String hql = "from Label l order by l.name";
		Query query = sessionFactory.openSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Label> labels = query.list();
		return labels;
	}

}
