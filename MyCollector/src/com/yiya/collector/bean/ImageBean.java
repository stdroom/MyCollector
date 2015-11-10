package com.yiya.collector.bean;

import java.util.ArrayList;

import org.jsoup.nodes.Document;

/**
 * Created by xiaoma on 2015/11/5.
 */
public class ImageBean {

    // 主键
    int img_id = 0;
    // 图片题目
    String title = "";
    // 本地路径
    String contextPath = "";
    
    // 文章原链接地址首页
    String contextHtml = "";
    
    //分类
    int cata_id = 0;

    //图片有几页 并非有多少张图片
    int pageNum = 0;

    // 当前正在解析的页面
    int currentPage = 0;
    
    // 当前解析网页的地址
    String currentPageUrl = "";

    boolean hasNext = false;

    private String baseUrl = "";
    
    // 是否发生解析异常
    private boolean isParseError = false;

    // 解析异常日志
    private String exception  = "";

    //创建日期
    String created_at = "";

    //更新日期
    String updateed_at = "";
    
    // 缩略图地址
    String thumbNail = "";

    // 原图片路径
    ArrayList<String> imgPath = new ArrayList<String>();
    // 本地图片路径
    ArrayList<String> localPath = new ArrayList<String>();
    
    // 服务端用
    String imgPaths  = "";
    String localPaths = "";
    
    Document doc = null;
    
    int width = 0;
    int height = 0;

	public int getImg_id() {
		return img_id;
	}

	public void setPost_id(int img_id) {
		this.img_id = img_id;
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

	public int getCata_id() {
		return cata_id;
	}

	public void setCata_id(int cata_id) {
		this.cata_id = cata_id;
	}


	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	

	public boolean isHasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public boolean isParseError() {
		return isParseError;
	}

	public void setParseError(boolean isParseError) {
		this.isParseError = isParseError;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdateed_at() {
		return updateed_at;
	}

	public void setUpdateed_at(String updateed_at) {
		this.updateed_at = updateed_at;
	}

	public String getThumbNail() {
		return thumbNail;
	}

	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}

	public ArrayList<String> getImgPath() {
		return imgPath;
	}

	public void setImgPath(ArrayList<String> imgPath) {
		this.imgPath = imgPath;
	}

	public String getCurrentPageUrl() {
		return currentPageUrl;
	}

	public void setCurrentPageUrl(String currentPageUrl) {
		this.currentPageUrl = currentPageUrl;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public ArrayList<String> getLocalPath() {
		return localPath;
	}

	public void setLocalPath(ArrayList<String> localPath) {
		this.localPath = localPath;
	}

	public String getImgPaths() {
		return imgPaths;
	}

	public void setImgPaths(String imgPaths) {
		this.imgPaths = imgPaths;
	}

	public String getLocalPaths() {
		return localPaths;
	}

	public void setLocalPaths(String localPaths) {
		this.localPaths = localPaths;
	}

	public void setImg_id(int img_id) {
		this.img_id = img_id;
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
	
	
	
}
