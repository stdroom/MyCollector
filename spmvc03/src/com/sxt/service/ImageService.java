/**
 * ������: spmvc03
 * �ļ���: ImageService.java
 * ����: com.sxt.service
 * ����: 2015��11��18������7:39:30
 * Copyright (c) 2015, �����ֵ� All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.sxt.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sxt.bean.Image;
import com.sxt.dao.ImageDao;

/**
 * ����: ImageService <br/>
 * ����: TODO ��ӹ�������. <br/>
 * ����: 2015��11��18�� ����7:39:30 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Component
public class ImageService {
	@Resource
	ImageDao imageDao;

	public void add(){
		Image image = new Image();
		image.setTitle("hah");
		imageDao.addImage(image);
	}
	
	public void get(){
		imageDao.getImages();
	}

	public ImageDao getImageDao() {
		return imageDao;
	}

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
}

