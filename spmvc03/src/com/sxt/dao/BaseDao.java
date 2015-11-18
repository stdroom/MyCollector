/**
 * 工程名: spmvc03
 * 文件名: BaseDao.java
 * 包名: com.sxt.dao
 * 日期: 2015年11月18日上午7:33:59
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.sxt.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 * 类名: BaseDao <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月18日 上午7:33:59 <br/>
 *
 * @author   leixun
 * @version  	 
 */
@Component
public class BaseDao {
	@Resource
	protected HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}

