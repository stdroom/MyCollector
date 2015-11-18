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

import org.hibernate.annotations.Table;

/**
 * 类名: Image <br/>
 * 功能: . <br/>
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

	private String contextPath = "";
	
	private String contextHtml = "";
	
	private int currentPage = 0;
	
	private String currentPageUrl = "";
	
	private int cata_id = 0;
	
	private int hasNext = 0;
	
	private String baseUrl = "";
	
	private int isParseError = 0;

	private String exception = "";
	
	
	// 本地 路径
	private String imgPaths = "";
	// 原始路径
	private String srcImgpaths = "";
	// 云存储路径
	private String yunImgPaths = "";
	
	// 原始路径
	private String thumbSrc = "";
	// 云存储路径
	private String thumbYun = "";
	// 本地路径
	private String thumbNail = "";
	
	private int width = 0;
	private int height = 0;
	
	private int zan = 0;
	private int favor = 0;
	
	
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

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getContextHtml() {
		return contextHtml;
	}

	public void setContextHtml(String contextHtml) {
		this.contextHtml = contextHtml;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getCurrentPageUrl() {
		return currentPageUrl;
	}

	public void setCurrentPageUrl(String currentPageUrl) {
		this.currentPageUrl = currentPageUrl;
	}

	public int getCata_id() {
		return cata_id;
	}

	public void setCata_id(int cata_id) {
		this.cata_id = cata_id;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public int getHasNext() {
		return hasNext;
	}

	public void setHasNext(int hasNext) {
		this.hasNext = hasNext;
	}

	public int getIsParseError() {
		return isParseError;
	}

	public void setIsParseError(int isParseError) {
		this.isParseError = isParseError;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getImgPaths() {
		return imgPaths;
	}

	public void setImgPaths(String imgPaths) {
		this.imgPaths = imgPaths;
	}

	public String getSrcImgpaths() {
		return srcImgpaths;
	}

	public void setSrcImgpaths(String srcImgpaths) {
		this.srcImgpaths = srcImgpaths;
	}

	public String getYunImgPaths() {
		return yunImgPaths;
	}

	public void setYunImgPaths(String yunImgPaths) {
		this.yunImgPaths = yunImgPaths;
	}

	public String getThumbSrc() {
		return thumbSrc;
	}

	public void setThumbSrc(String thumbSrc) {
		this.thumbSrc = thumbSrc;
	}

	public String getThumbYun() {
		return thumbYun;
	}

	public void setThumbYun(String thumbYun) {
		this.thumbYun = thumbYun;
	}

	public String getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getZan() {
		return zan;
	}

	public void setZan(int zan) {
		this.zan = zan;
	}

	public int getFavor() {
		return favor;
	}

	public void setFavor(int favor) {
		this.favor = favor;
	}
	
}

