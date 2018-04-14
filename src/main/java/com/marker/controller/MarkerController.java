package com.marker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.marker.dao.inter.IMarkerDao;
import com.marker.pojo.Resp;

@Controller
@RequestMapping(value = "/marker")
public class MarkerController {
	
	@Autowired
	private IMarkerDao markerDao;
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Resp getById(@PathVariable("id") int id) {
		Resp resp = new Resp();
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Resp getAll() {
		Resp resp = new Resp();
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Resp create(@RequestBody String markerStr) {
		Resp resp = new Resp();
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Resp update(@PathVariable("id") int id, @RequestBody String markerStr) {
		Resp resp = new Resp();
		return resp;
	}

}
