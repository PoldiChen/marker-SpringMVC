package com.marker.dao.impl;

import java.util.List;
import org.springframework.stereotype.Component;
import com.marker.dao.inter.IMarkerDao;
import com.marker.pojo.Marker;

@Component("markerDao")
public class MarkerDaoImpl extends BaseDaoImpl implements IMarkerDao {

	@Override
	public Marker getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marker> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Marker marker) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id, Marker marker) {
		// TODO Auto-generated method stub
		return 0;
	}

}
