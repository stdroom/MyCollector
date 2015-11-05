package com.yiya.collector.runnable;

import java.util.ArrayList;

import com.yiya.collector.RulesInterf.ColumnImagePageParse;
import com.yiya.collector.bean.ArticleBean;
import com.yiya.collector.bean.ColumnEachPageBean;
import com.yiya.collector.bean.ImageBean;
import com.yiya.collector.utils.ExcutorServiceUtils;

/**
 * Created by xiaoma on 2015/11/5.
 */
public class ParseImagePageRunnable implements Runnable{

    private ColumnEachPageBean bean ;
    private ColumnImagePageParse pageParse;

    public ParseImagePageRunnable(ColumnEachPageBean bean,ColumnImagePageParse parse){
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
    	ArrayList<ImageBean> imageBeans = pageParse.getImageBeans(bean);
        for(ImageBean bean : imageBeans){	//开始解析详情
            System.out.println(bean.getTitle());
            ParseImageRunnable task = new ParseImageRunnable(bean,pageParse);
            ExcutorServiceUtils.getInstance().getThreadPool().submit(task);
        }
    }
}
