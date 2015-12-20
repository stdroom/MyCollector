/**
 * 工程名: MyCollector
 * 文件名: OneSixParse.java
 * 包名: com.yiya.collector.main
 * 日期: 2015年12月2日上午6:37:05
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.yiya.collector.main;

import com.yiya.collector.RuleImpl.image.onesixbb.OneSixBbImagePageParse;
import com.yiya.collector.RuleImpl.image.uumn.UumnColumnImagePageParse;
import com.yiya.collector.bean.ColumnEachPageBean;
import com.yiya.collector.runnable.ParseImagePageRunnable;
import com.yiya.collector.utils.ExcutorServiceUtils;

/**
 * 类名: OneSixParse <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年12月2日 上午6:37:05 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class OneSixParse {

	public static void main(String[] args) {
//    	ColumnEachPageBean bean = new ColumnEachPageBean();
//    	bean.setBaseUrl("http://www.169bb.com/");
//    	// 高跟丝袜
//    	bean.setIndexUrl("http://www.169bb.com/info/4_1.htm");
//    	bean.setCata_id(1204);
//    	// 性感美女
//    	bean.setIndexUrl("http://www.169bb.com/info/1_1.htm");
//    	bean.setCata_id(1203);
    	// 西洋美女
//    	bean.setIndexUrl("http://www.169bb.com/info/5_1.htm");
//    	bean.setCata_id(1201);
    	//网友自拍
//    	bean.setIndexUrl("http://www.169bb.com/info/2_1.htm");
//    	bean.setCata_id(1202);
    	
//    	bean.setBaseUrl("http://www.169mt.com/");
//    	// 美女明星
//    	bean.setIndexUrl("http://www.169mt.com/mnmx/index.htm");
//    	bean.setCata_id(1304);
    	String[] index = {"http://www.169mt.com/wlhr/index.htm",
    			"http://www.169mt.com/xgmn/index.htm","http://www.169mt.com/swmt/index.htm"};
    	for(int i = 0;i<3;i++){
    		ColumnEachPageBean bean = new ColumnEachPageBean();
    		bean.setIndexUrl(index[i]);
    		bean.setBaseUrl("http://www.169mt.com/");
    		bean.setCata_id(1301+i);
    		ParseImagePageRunnable run = new ParseImagePageRunnable(bean,new OneSixBbImagePageParse());
    		ExcutorServiceUtils.getInstance().getThreadPool().submit(run);
    	}
	}

}

