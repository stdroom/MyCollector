package com.yiya.collector.runnable;

import java.util.ArrayList;

import com.yiya.collector.RulesInterf.ColumnPageParse;
import com.yiya.collector.bean.ArticleBean;
import com.yiya.collector.bean.ColumnEachPageBean;

/**
 * Created by xiaoma on 2015/11/2.
 *
 * 解析文章列表
 */
public class ParseRunnable implements Runnable{
    private ColumnEachPageBean bean;
    private ColumnPageParse pageParse;
    public ParseRunnable(ColumnEachPageBean bean,ColumnPageParse pageParse){
        this.bean = bean;
        this.pageParse = pageParse;
    }

    @Override
    public void run(){
            // 文章列表 及内容 解析逻辑
        if(bean!=null && !"".equals(bean.getIndexUrl())){

            parseList();

            pageParse.getNextPage(bean);
            while(bean!=null && bean.isHasNext()){
                System.out.println(bean.getCurrentPageUrl());
                System.out.println(bean.getCurrentNum());
                parseList();
                pageParse.getNextPage(bean);
            }
            System.out.println(bean.getCurrentPageUrl());
        }
    }

    private void parseList(){
        ArrayList<ArticleBean> articles = pageParse.getArticleBean(bean);
        for(ArticleBean bean : articles){
            System.out.println(bean.getTitle());
        }
    }
}
