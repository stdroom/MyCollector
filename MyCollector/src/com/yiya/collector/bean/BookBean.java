/**
 * 工程名: MyCollector
 * 文件名: BookBean.java
 * 包名: com.yiya.collector.bean
 * 日期: 2016年4月14日上午11:20:36
 * Copyright (c) 2016, 北京新东方迅程网络科技有限公司 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.yiya.collector.bean;

import java.util.ArrayList;

import org.jsoup.nodes.Document;

/**
 * 类名: BookBean <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2016年4月14日 上午11:20:36 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class BookBean {
	// 主键
    int id = 0;
    //创建日期
    String created_at = "";

    //更新日期
    String updateed_at = "";
    
    // 本地图片路径
    ArrayList<String> localPath = new ArrayList<String>();
    
    String localPaths = "";
    
    Document doc = null;
    
    private String contextPath = "";
	
	private String contextHtml = "";
	
	private Integer currentPage = 0;
	
	private String currentPageUrl = "";
	
	private Integer cata_id = 0;
	
	private boolean hasNext = false;
	
	private String baseUrl = "";
	
	private boolean isParseError = false;

	private String exception = "";
	
	
	// 本地图片路径
	private String imgPaths = "";
	//原图片 路径
	private String srcImgPaths = "";
	// 云图片路径
	private String yunImgPaths = "";
	
	// 
	private String thumbSrc = "";
	private String thumbYun = "";
	private String thumbNail = "";
	
	private Integer width = 0;
	private Integer height = 0;
	
	private Integer zan = 0;
	private Integer favor = 0;
	
	
	private Integer pageNum;
	
	private String title;
}

