/**
 * ������: spmvc03
 * �ļ���: ImageController.java
 * ����: com.sxt.action
 * ����: 2015��11��18������7:42:30
 * Copyright (c) 2015, �����ֵ� All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.sxt.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.sxt.bean.Image;
import com.sxt.service.ImageService;

/**
 * ����: ImageController <br/>
 * ����: TODO ��ӹ�������. <br/>
 * ����: 2015��11��18�� ����7:42:30 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Controller
public class ImageController {
	@Resource
	private ImageService imageService;
	
	@RequestMapping(params="method=add")
	public String add(){
		imageService.add();
		return "index";
	}

	@RequestMapping(params="method=get")
	public String get(){
		imageService.get();
		return "index";
	}
	
	@RequestMapping(value="/getimages")
	@ResponseBody
	public String getImages(@RequestParam("page") int page,@RequestParam("pageSize") int pageSize) throws Exception{
		ArrayList<Image> list= imageService.getImages(page, pageSize);
		Map<String,Object> map = new HashMap<String,Object>();
		for(Image ben:list){
			System.out.println(new String(ben.getTitle().getBytes("GB2312"),"UTF8"));
		}
		map.put("status", 1);
		if(list== null || list.size()==0){
			map.put("size", 0);
		}else{
			map.put("size", list.size());
		}
		map.put("data", list);
		return JSON.toJSONString(map);
	}
	
}

