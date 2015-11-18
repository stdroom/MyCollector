/**
 * 工程名: spmvc03
 * 文件名: ImageDao.java
 * 包名: com.sxt.dao
 * 日期: 2015年11月18日上午7:32:58
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.sxt.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sxt.bean.Image;

/**
 * 类名: ImageDao <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月18日 上午7:32:58 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Component
public class ImageDao extends BaseDao{
	
	public void addImage(Image image){
		System.out.println(image.getTitle());
		hibernateTemplate.save(image);
	}
	
	public void getImages(){
		List<Image> list =hibernateTemplate.find("select * from Image");
		for(int i = 0 ;i < list.size();i++){
			System.out.println(list.get(i).getId()+":"+list.get(i).getTitle());
		}
	}
}

