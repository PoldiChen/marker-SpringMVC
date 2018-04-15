package com.marker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.marker.dao.inter.IMarkerDao;
import com.marker.pojo.Marker;
import com.marker.pojo.Resp;

@Controller
@RequestMapping(value = "/marker")
public class MarkerController {
	
	@Autowired
	private IMarkerDao markerDao;
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView teamPage() {
        System.out.println("page");
        ModelAndView view = new ModelAndView("home");
        return view;
    }
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Resp getById(@PathVariable("id") int id) {
		System.out.println("MarkerController@getById");
		Marker marker = markerDao.getById(id);
		Resp resp = new Resp();
		resp.setData(marker);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Resp getAll() {
		System.out.println("MarkerController@getAll");
		List<Marker> markers = markerDao.getAll();
		Resp resp = new Resp();
		resp.setData(markers);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Resp create(@RequestBody String markerStr) {
		System.out.println("MarkerController@create");
		Resp resp = new Resp();
		Marker marker = JSON.parseObject(markerStr, Marker.class);
		int ret = markerDao.create(marker);
		resp.setData(ret);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Resp update(@PathVariable("id") int id, @RequestBody String markerStr) {
		Resp resp = new Resp();
		Marker marker = JSON.parseObject(markerStr, Marker.class);
		int ret = markerDao.update(id, marker);
		resp.setData(ret);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Resp delete(@PathVariable("id") int id) {
		Resp resp = new Resp();
		markerDao.delete(id);
		return resp;
	}

}
