package com.yiya.collector.RulesInterf;

import java.util.ArrayList;

import com.yiya.collector.bean.ArticleBean;
import com.yiya.collector.bean.ColumnEachPageBean;

/**
 * Created by xiaoma on 2015/11/2.
 */
public interface ColumnPageParse {

    // 根据页面获取该页面的文章列表数据
    public ArrayList<ArticleBean> getArticleBean(ColumnEachPageBean bean);

    // 根据页面javabean对象 递归判断 是否有下一页 并不断解析
    public ColumnEachPageBean getNextPage(ColumnEachPageBean pageBean);

    // 解析内容详情
    public void ParseContextByArticleBean(ArticleBean bean);

    // 根据文章 javabean对象 递归判断 是否有下一页 并不断解析
    public ArticleBean getNextPage(ArticleBean bean);
}
