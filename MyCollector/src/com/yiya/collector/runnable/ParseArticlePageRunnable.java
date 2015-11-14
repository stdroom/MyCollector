/**
 * 工程名: MyCollector
 * 文件名: ParseArticlePageRunnable.java
 * 包名: com.yiya.collector.runnable
 * 日期: 2015年11月14日下午5:29:53
 * QQ: 378640336
 *
*/

package com.yiya.collector.runnable;

import java.util.ArrayList;

import com.yiya.collector.RulesInterf.ColumnArticlePageParse;
import com.yiya.collector.RulesInterf.ColumnImagePageParse;
import com.yiya.collector.bean.ArticleBean;
import com.yiya.collector.bean.ColumnEachPageBean;
import com.yiya.collector.bean.ImageBean;
import com.yiya.collector.utils.ExcutorServiceUtils;

/**
 * 类名: ParseArticlePageRunnable <br/>
 * 功能: 文章列表页解析. <br/>
 * 日期: 2015年11月14日 下午5:29:53 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class ParseArticlePageRunnable implements Runnable{

    private ColumnEachPageBean bean ;
    private ColumnArticlePageParse pageParse;

    public ParseArticlePageRunnable(ColumnEachPageBean bean,ColumnArticlePageParse parse){
        this.bean = bean;
        this.pageParse = parse;
    }

    @Override
    public void run() {
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
    	ArrayList<ArticleBean> articleBeans = pageParse.getArticleBeans(bean);
        for(ArticleBean bean : articleBeans){	//开始解析详情
            System.out.println(bean.getTitle());
//            ParseImageRunnable task = new ParseImageRunnable(bean,pageParse);
//            ExcutorServiceUtils.getInstance().getThreadPool().submit(task);
        }
    }
}

