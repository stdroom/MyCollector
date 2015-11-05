package com.yiya.collector.runnable;

import com.yiya.collector.RulesInterf.ColumnPageParse;
import com.yiya.collector.bean.ArticleBean;

/**
 * Created by xiaoma on 2015/11/2.
 */
public class ParseContextRunnable implements Runnable {

    ColumnPageParse parse;
    ArticleBean bean;

    public ParseContextRunnable(ColumnPageParse parse,ArticleBean bean){
        this.parse = parse;
        this.bean = bean;
    }

    @Override
    public void run() {
    }
}
