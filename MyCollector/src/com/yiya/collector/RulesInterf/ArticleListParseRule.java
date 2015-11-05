package com.yiya.collector.RulesInterf;

import java.util.ArrayList;

import org.jsoup.nodes.Document;

import com.yiya.collector.bean.ArticleBean;

/**
 * Created by Administrator on 2015/11/1.
 */
public interface ArticleListParseRule {

    ArrayList<ArticleBean> getArticleBean(Document doc);    // 获取文章 描述信息；
}
