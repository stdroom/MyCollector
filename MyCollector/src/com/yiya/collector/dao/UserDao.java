/**
 * 工程名: MyCollector
 * 文件名: UserDao.java
 * 包名: com.yiya.collector.dao
 * 日期: 2015年11月6日上午7:14:16
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.yiya.collector.dao;

import com.yiya.collector.bean.UserBean;

/**
 * 类名: UserDao <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月6日 上午7:14:16 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public interface UserDao {

	public UserBean getUser();
	public void addUser(UserBean userBean);
	public void updateUser(UserBean userbean);
	public void deleteUser(int userId);
}

