package com.yiya.collector.bean;

import org.jsoup.nodes.Document;

/**
 * Created by xiaoma on 2015/11/5.
 */
public class ColumnEachImagePageBean {

    //栏目分类id
    private int cate_id = 0;

    // 网站域名
    private String baseUrl = "";

    // 栏目首页 地址
    private String indexUrl = "";

    // 是否有下一页
    private boolean hasNext = false;

    //  总共有多少页
    private int totalNum = 0;

    // 当前的解析的页码
    private int currentNum = 0;

    // 正在解析的网页
    private String currentPageUrl = "";

    // 是否发生解析异常
    private boolean isParseError = false;

    // 解析异常日志
    private String exception  = "";

    public Document doc;

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getIndexUrl() {
        return indexUrl;
    }

    public void setIndexUrl(String indexUrl) {
        this.indexUrl = indexUrl;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public String getCurrentPageUrl() {
        return currentPageUrl;
    }

    public void setCurrentPageUrl(String currentPageUrl) {
        this.currentPageUrl = currentPageUrl;
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

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

}
