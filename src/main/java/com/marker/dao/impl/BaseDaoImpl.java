package com.marker.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.marker.dao.inter.IBaseDao;

public class BaseDaoImpl implements IBaseDao {

    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
