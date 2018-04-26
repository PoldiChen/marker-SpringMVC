package com.marker.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marker.dao.inter.IUserDao;
import com.marker.pojo.Resp;
import com.marker.pojo.User;
import com.marker.util.MD5Encrypt;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private IUserDao userDao;
	
	@ResponseBody
	@RequestMapping(value = "/current_user", method = RequestMethod.GET)
	public Resp getCurrentUser(HttpServletRequest request, @CookieValue("JSESSIONID") String sessionId) {
		System.out.println("session id:" + sessionId);
		System.out.println(request.getSession().getAttribute("userInfo"));
		String userName = (String) request.getSession().getAttribute("userInfo");
		Resp resp = new Resp();
		resp.setData(userName);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Resp login(@RequestParam("user_name") String userName, 
			@RequestParam("password") String password,
			HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
		Resp resp = new Resp();
		int checkResult = checkLogin(userName, password);
		if (checkResult == 0) {
			String cookieVal = generateCookie();
			System.out.println("cookieVal:" + cookieVal);
			Cookie cookie = new Cookie("JSESSIONID", cookieVal);
			response.addCookie(cookie);
			request.getSession().setAttribute("userInfo", userName);
			resp.setData(userName);
		} else {
			if (checkResult == -1) {
				resp.setCode(-1);
				resp.setMessage("wrong password");
			} else {
				resp.setCode(-2);
				resp.setMessage("user not exist");
			}
		}
		return resp;
	}
	
	private String generateCookie() {
		 String cookie = UUID.randomUUID().toString();
		 return cookie;
	}
	
	private int checkLogin(String userName, String password) {
		User user = userDao.getByUserName(userName);
		int result = -2; // user name not exist
		System.out.println(user.getPassword());
		System.out.println(MD5Encrypt.encrypt(password));
		if (user != null) {
			if (MD5Encrypt.encrypt(password).equals(user.getPassword())) { // success
				result = 0;
			} else { // wrong password
				result = -1;
			}
		}
		return result;
		
	}

}
