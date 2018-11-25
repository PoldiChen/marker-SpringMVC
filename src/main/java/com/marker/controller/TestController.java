package com.marker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marker.pojo.Resp;

@Controller
@RequestMapping(value="/test")
public class TestController {

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Resp test() {
		Resp resp = new Resp();
		return resp;
	}

}
