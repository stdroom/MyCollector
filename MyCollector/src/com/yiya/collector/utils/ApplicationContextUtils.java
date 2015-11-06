/**
 * 工程名: MyCollector
 * 文件名: ApplicationContextUtils.java
 * 包名: com.yiya.collector.utils
 * 日期: 2015年11月6日下午3:53:49
 * QQ: 378640336
 *
*/

package com.yiya.collector.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 类名: ApplicationContextUtils <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月6日 下午3:53:49 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class ApplicationContextUtils {
	public static ApplicationContext context;
	
	private ApplicationContextUtils(){
	}
	
	static{
		context  = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}

