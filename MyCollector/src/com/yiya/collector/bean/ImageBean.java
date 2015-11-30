package com.yiya.collector.bean;

import java.util.ArrayList;

import org.jsoup.nodes.Document;

/**
 * Created by xiaoma on 2015/11/5.
 */
public class ImageBean {

    // 主键
    int id = 0;
    //创建日期
    String created_at = "";

    //更新日期
    String updateed_at = "";
    
    // 原图片路径
    ArrayList<String> imgPath = new ArrayList<String>();
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
	// �ƴ洢·��
	private String thumbYun = "";
	// ����·��
	private String thumbNail = "";
	
	private Integer width = 0;
	private Integer height = 0;
	
	private Integer zan = 0;
	private Integer favor = 0;
	
	
	private Integer pageNum;
	
	private String title;
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
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

	public Integer getZan() {
		return zan;
	}

	public void setZan(Integer zan) {
		this.zan = zan;
	}

	public Integer getFavor() {
		return favor;
	}

	public void setFavor(Integer favor) {
		this.favor = favor;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setCata_id(Integer cata_id) {
		this.cata_id = cata_id;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public String getSrcImgPaths() {
		return srcImgPaths;
	}

	public void setSrcImgPaths(String srcImgPaths) {
		this.srcImgPaths = srcImgPaths;
	}

	public void println(){
//		#{cata_id},#{title},#{thumbNail},#{pageNum}#{imgPaths},#{contextPath},#{contextHtml},#{currentPageUrl},#{baseUrl
		if("".equals(thumbNail)
	|| "".equals(title)
	|| "".equals(pageNum)
	|| "".equals(imgPaths)
	|| "".equals(srcImgPaths)
	|| "".equals(contextHtml)
	|| "".equals(currentPageUrl)
	|| "".equals(baseUrl)
	|| "".equals(cata_id)){
			System.out.println("cateId:"+cata_id
					+"\n"+"title:"+title
					+"\n"+"thumbNail:"+thumbNail
					+"\n"+"pageNum:"+pageNum
					+"\n"+"srcImgpaths"+srcImgPaths
					+"\n"+"imgPaths:"+imgPaths
					+"\n"+"contextHtml:"+contextHtml
					+"\n"+"currentPageUrl:"+currentPageUrl
					+"\n"+"baseUrl:"+baseUrl);
		}
	}
	
	
}
