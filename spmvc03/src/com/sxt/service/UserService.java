package com.sxt.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sxt.bean.User;
import com.sxt.dao.UserDao;

@Component
public class UserService {
	@Resource
	private UserDao userDao;
	
	public void add(String uname){
		System.out.println("UserService.add()");
		User u = new User();
		u.setUname(uname);
		userDao.add(u);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
