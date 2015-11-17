/**
 * 工程名: MyCollector
 * 文件名: PsForumWebParseMain.java
 * 包名: com.yiya.collector.main
 * 日期: 2015年11月14日下午4:05:59
 * QQ: 378640336
 *
*/

package com.yiya.collector.main;

import com.yiya.collector.RuleImpl.article.ps.PsForumColumnPageParse;
import com.yiya.collector.bean.ColumnEachPageBean;
import com.yiya.collector.runnable.ParseArticlePageRunnable;
import com.yiya.collector.utils.ExcutorServiceUtils;

/**
 * 类名: PsForumWebParseMain <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月14日 下午4:05:59 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class PsForumWebParseMain {
	public static void main(String[] args) {
      ColumnEachPageBean bean = new ColumnEachPageBean();
      bean.setIndexUrl("http://www.16xx8.com/photoshop/xinshoujiaocheng/jiqiao/");
      //　拼接地址用
      bean.setBaseUrl("http://www.16xx8.com/photoshop/xinshoujiaocheng/jiqiao/");
      ParseArticlePageRunnable run = new ParseArticlePageRunnable(bean,new PsForumColumnPageParse());
      ExcutorServiceUtils.getInstance().getThreadPool().submit(run);
	}
}

