/**
 * 工程名: spmvc03
 * 文件名: Image.java
 * 包名: com.sxt.bean
 * 日期: 2015年11月18日上午7:29:35
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.sxt.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 类名: Image <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月18日 上午7:29:35 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int pageNum;
	
	private String title;
	
	public Image(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}

