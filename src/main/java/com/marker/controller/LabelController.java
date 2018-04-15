package com.marker.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.marker.dao.inter.ILabelDao;
import com.marker.pojo.Label;
import com.marker.pojo.Resp;

@Controller
@RequestMapping(value = "/label")
public class LabelController {
	
	@Autowired
	private ILabelDao labelDao;
	
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Resp getAll() {
		Resp resp = new Resp();
		List<Label> labels = labelDao.getAll();
		resp.setData(labels);
		return resp;
	}

}
