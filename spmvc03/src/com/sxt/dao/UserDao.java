package com.sxt.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.sxt.bean.User;

@Component
public class UserDao extends BaseDao{
	
	public void add(User u){
		System.out.println("UserDao.add()");
		hibernateTemplate.save(u);
	}

}
