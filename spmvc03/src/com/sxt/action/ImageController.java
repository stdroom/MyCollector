/**
 * 工程名: spmvc03
 * 文件名: ImageController.java
 * 包名: com.sxt.action
 * 日期: 2015年11月18日上午7:42:30
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
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
 * 类名: ImageController <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月18日 上午7:42:30 <br/>
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

