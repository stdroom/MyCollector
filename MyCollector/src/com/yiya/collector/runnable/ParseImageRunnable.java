package com.yiya.collector.runnable;

import java.util.ArrayList;

import com.yiya.collector.RulesInterf.ColumnImagePageParse;
import com.yiya.collector.bean.ArticleBean;
import com.yiya.collector.bean.ColumnEachImagePageBean;
import com.yiya.collector.bean.ImageBean;
import com.yiya.collector.utils.ExcutorServiceUtils;

/**
 * Created by xiaoma on 2015/11/5.
 */
public class ParseImageRunnable implements Runnable{

    private ImageBean bean ;
    private ColumnImagePageParse pageParse;

    public ParseImageRunnable(ImageBean bean,ColumnImagePageParse parse){
        this.bean = bean;
        this.pageParse = parse;
    }

    @Override
    public void run() {
        if(bean!=null && !"".equals(bean.getContextHtml())){

            parseList();

            pageParse.getNextPage(bean);
            while(bean!=null && bean.isHasNext()){
                System.out.println(bean.getCurrentPageUrl());
                parseList();
                pageParse.getNextPage(bean);
            }
            if(!bean.isParseError() && bean.getImgPath()!=null && bean.getImgPath().size()>0){
            	ImageDownloadRunable task = new ImageDownloadRunable(bean);
            	ExcutorServiceUtils.getInstance().getThreadPool().submit(task);
            }
            System.out.println(bean.getCurrentPageUrl());
        }
    }

    private void parseList(){
    	pageParse.ParseImagesByImageBean(bean);
    }
}
