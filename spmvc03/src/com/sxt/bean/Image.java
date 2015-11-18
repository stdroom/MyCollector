/**
 * ������: spmvc03
 * �ļ���: Image.java
 * ����: com.sxt.bean
 * ����: 2015��11��18������7:29:35
 * Copyright (c) 2015, �����ֵ� All Rights Reserved.
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
 * ����: Image <br/>
 * ����: TODO ��ӹ�������. <br/>
 * ����: 2015��11��18�� ����7:29:35 <br/>
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

