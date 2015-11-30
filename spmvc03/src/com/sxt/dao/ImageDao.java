/**
 * ������: spmvc03
 * �ļ���: ImageDao.java
 * ����: com.sxt.dao
 * ����: 2015��11��18������7:32:58
 * Copyright (c) 2015, �����ֵ� All Rights Reserved.
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
 * ����: ImageDao <br/>
 * ����: TODO ���ӹ�������. <br/>
 * ����: 2015��11��18�� ����7:32:58 <br/>
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
