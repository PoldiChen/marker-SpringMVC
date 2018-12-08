package com.marker.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.marker.dao.inter.IUserDao;
import com.marker.pojo.User;

@Component("userDao")
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

	@Override
	public User getByUserName(String userName) {
		System.out.println("UserDaoImpl@getByUserName");
		System.out.println("userName:"+userName);
		String hql = "from User u where u.name = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		return (User) query.uniqueResult();
	}

}
