package com.yiya.collector.RulesInterf;

import java.util.ArrayList;

import com.yiya.collector.bean.ColumnEachPageBean;
import com.yiya.collector.bean.ImageBean;

/**
 * Created by xiaoma on 2015/11/2.
 */
public interface ColumnImagePageParse {

    // 根据页面获取该页面的文章列表数据
    public ArrayList<ImageBean> getImageBeans(ColumnEachPageBean bean);

    // 根据页面javabean对象 递归判断 是否有下一页 并不断解析
    public ColumnEachPageBean getNextPage(ColumnEachPageBean pageBean);

    // 解析内容详情
    public void ParseImagesByImageBean(ImageBean bean);

    // 根据文章 javabean对象 递归判断 是否有下一页 并不断解析
    public ImageBean getNextPage(ImageBean bean);
}
