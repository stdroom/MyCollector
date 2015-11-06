/**
 * 工程名: MyCollector
 * 文件名: UserBean.java
 * 包名: com.yiya.collector.bean
 * 日期: 2015年11月5日下午9:46:54
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.yiya.collector.bean;
/**
 * 类名: UserBean <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月5日 下午9:46:54 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class UserBean {

	private String username ;
	
	private String password;
	private int id;
	
	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void sayHello(){
		System.out.println(username);
	}
}

