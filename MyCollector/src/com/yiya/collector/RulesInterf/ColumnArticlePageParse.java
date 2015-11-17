/**
 * 工程名: MyCollector
 * 文件名: ColumnArticlePageParse.java
 * 包名: com.yiya.collector.RulesInterf
 * 日期: 2015年11月14日下午3:46:40
 * QQ: 378640336
 *
*/

package com.yiya.collector.RulesInterf;

import java.util.ArrayList;

import com.yiya.collector.bean.ArticleBean;
import com.yiya.collector.bean.ColumnEachPageBean;

/**
 * 类名: ColumnArticlePageParse <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月14日 下午3:46:40 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public interface ColumnArticlePageParse {
	// 根据页面获取该页面的文章列表数据
    public ArrayList<ArticleBean> getArticleBeans(ColumnEachPageBean bean);

    // 根据页面javabean对象 递归判断 是否有下一页 并不断解析
    public ColumnEachPageBean getNextPage(ColumnEachPageBean pageBean);

    // 解析内容详情
    public void ParseContextByArticleBean(ArticleBean bean);

    // 根据文章 javabean对象 递归判断 是否有下一页 并不断解析
    public ArticleBean getNextPage(ArticleBean bean);
}

