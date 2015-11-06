/**
 * 工程名: MyCollector
 * 文件名: ColumnEachPageDao.java
 * 包名: com.yiya.collector.dao
 * 日期: 2015年11月6日上午10:21:45
 * QQ: 378640336
 *
*/

package com.yiya.collector.dao;

import java.util.ArrayList;
import java.util.List;

import com.yiya.collector.bean.ColumnEachPageBean;

/**
 * 类名: ColumnEachPageDao <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月6日 上午10:21:45 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public interface ColumnEachPageDao {

	/**
	 * 
	 * getColumnEachPageDaoList:(获取爬虫节点列表). <br/>
	 *
	 * @author leixun
	 * 2015年11月6日上午10:23:56
	 * @return
	 * @since 1.0
	 */
	public List<ColumnEachPageBean> getColumnEachPageDaoList();
	
	/**
	 * 
	 * updateColumnEachPageDao:(更新爬虫节点). <br/>
	 *
	 * 2015年11月6日上午10:25:57
	 * @param bean
	 * @since 1.0
	 */
	public void updateColumnEachPageDao(ColumnEachPageBean bean);
	
	
}

