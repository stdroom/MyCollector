/**
 * 工程名: MyCollector
 * 文件名: YdcxMain.java
 * 包名: com.yiya.collector.main
 * 日期: 2016年4月14日上午11:18:20
 * Copyright (c) 2016, 北京新东方迅程网络科技有限公司 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.yiya.collector.main;

import java.util.ArrayList;

import com.yiya.collector.bean.ImageBean;
import com.yiya.collector.dao.ImageDao;
import com.yiya.collector.runnable.ImageThumbNailRunnable;
import com.yiya.collector.utils.ApplicationContextUtils;
import com.yiya.collector.utils.ExcutorServiceUtils;

/**
 * 类名: YdcxMain <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2016年4月14日 上午11:18:20 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class YdcxMain {
	 public static void main(String[] args) {
		 ImageDao dao  = (ImageDao)ApplicationContextUtils.context.getBean("imageDao");
		 ArrayList<ImageBean> beans = (ArrayList<ImageBean>)dao.queryAllImageBean();
		 if(beans!=null){
			 System.out.println("beans:"+beans.size());
			 int size = beans.size();
			 for(int i=0;i<size;i++){
				 ImageThumbNailRunnable run = new ImageThumbNailRunnable(beans.get(i));
				 ExcutorServiceUtils.getInstance().getThreadPool().submit(run);
			 }
		 }else{
			 System.out.println("beans is null");
		 }
	 }

}

