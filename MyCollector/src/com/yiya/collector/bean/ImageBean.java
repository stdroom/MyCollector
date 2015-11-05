package com.yiya.collector.bean;

import java.util.ArrayList;

import org.jsoup.nodes.Document;

/**
 * Created by xiaoma on 2015/11/5.
 */
public class ImageBean {

    // 主键
    int post_id = 0;
    // 图片题目
    String title = "";
    //文章内容 路径
    String contxtPath = "";
    // 文章原链接地址
    String contextHtml = "";
    //分类
    int cata_id = 0;
    //来源
    String fromUrl = "";

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

    // 图片路径
    ArrayList<String> imgPath = new ArrayList<String>();
    
    Document doc = null;

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContxtPath() {
		return contxtPath;
	}

	public void setContxtPath(String contxtPath) {
		this.contxtPath = contxtPath;
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

	public String getFromUrl() {
		return fromUrl;
	}

	public void setFromUrl(String fromUrl) {
		this.fromUrl = fromUrl;
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
	
}
