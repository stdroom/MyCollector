package com.yiya.collector.bean;

/**
 * Created by Administrator on 2015/11/1.
 *
 * 文章里面的图片爬取 还未考虑
 */
public class ArticleContextBean {
    ArticleBean article = null;

    // 原网站地址 未来增量爬取的时候 可以屏蔽这种已经爬过的网页
    // 按道理应该用hash方法优化一下
    String srcUrl = "";

    // 服务器上的网页路径
    String localPath = "";

    // 总共有多少页
    int totalPages = 0;

    // 当前进行的网页  爬取失败时要记录此项  方便继续爬取
    int currentPage = 0;

    // 是否有下一页
    boolean hasNextPage = true;

    // 是否解析完毕 完毕说明没有出异常 否则就是异常
    boolean parseError = true;


    // 解析异常 日志
    String exception = "";

    public ArticleBean getArticle() {
        return article;
    }

    public void setArticle(ArticleBean article) {
        this.article = article;
    }

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isParseError() {
        return parseError;
    }

    public void setParseError(boolean parseError) {
        this.parseError = parseError;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
