package com.marker.dao.inter;

import com.marker.pojo.User;

public interface IUserDao extends IBaseDao {
	
	public User getByUserName(String userName);

}
