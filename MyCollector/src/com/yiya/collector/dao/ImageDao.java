/**
 * 工程名: MyCollector
 * 文件名: ImageDao.java
 * 包名: com.yiya.collector.dao
 * 日期: 2015年11月6日上午11:24:28
 * QQ: 378640336
 *
*/

package com.yiya.collector.dao;

import java.util.List;

import com.yiya.collector.bean.ImageBean;

/**
 * 类名: ImageDao <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月6日 上午11:24:28 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public interface ImageDao {

	public List<ImageBean> queryAllImageBean();
	
	public void deleteImageBean(int id);
	
	public void insertImageBean(ImageBean bean);
	
}

