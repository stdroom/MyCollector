package com.yiya.collector.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/1.
 *
 */
public class ArticleBean {
    // 主键
    int post_id = 0;
    //标题
    String title = "";
    //文章内容 路径
    String contxtPath = "";
    // 文章原链接地址
    String contextHtml = "";
    //分类
    int cata_id = 0;
    //来源
    String fromUrl = "";
    //文章有几页
    int pageNum = 0;
    //创建日期
    String created_at = "";

    //更新日期
    String updateed_at = "";
    // 缩略图地址
    String imgPath = "";
    // 作者
    String author = "";
    // 文章摘要
    String contextSummary = "";
    // 标签
    ArrayList<String> tags = new ArrayList<String>();

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

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContextSummary() {
        return contextSummary;
    }

    public void setContextSummary(String contextSummary) {
        this.contextSummary = contextSummary;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getContextHtml() {
        return contextHtml;
    }

    public void setContextHtml(String contextHtml) {
        this.contextHtml = contextHtml;
    }
}
