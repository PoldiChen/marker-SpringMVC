package com.marker.dao.inter;


import java.util.List;

import com.marker.pojo.Marker;

public interface IMarkerDao extends IBaseDao {
	
	public Marker getById(int id);
	
	public List<Marker> getAll();
	
	public int create(Marker marker);
	
	public int update(int id, Marker marker);
	
	public int delete(int id);

}
