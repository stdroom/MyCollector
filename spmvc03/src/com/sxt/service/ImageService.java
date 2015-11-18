/**
 * 工程名: spmvc03
 * 文件名: ImageService.java
 * 包名: com.sxt.service
 * 日期: 2015年11月18日上午7:39:30
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.sxt.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sxt.bean.Image;
import com.sxt.dao.ImageDao;

/**
 * 类名: ImageService <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月18日 上午7:39:30 <br/>
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
		image.setTitle("hahs");
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
	
	public ArrayList<Image> getImages(int page,int pageSize){
		return imageDao.getImages(page, pageSize);
	}
}

