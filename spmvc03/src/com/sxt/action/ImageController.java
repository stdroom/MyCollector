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

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/image.do")
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
}

