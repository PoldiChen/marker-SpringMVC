package com.marker.dao.inter;

import java.util.List;

import com.marker.pojo.Label;

public interface ILabelDao extends IBaseDao {
	
	List<Label> getAll();

}
