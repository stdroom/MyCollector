/**
 * ������: spmvc03
 * �ļ���: BaseDao.java
 * ����: com.sxt.dao
 * ����: 2015��11��18������7:33:59
 * Copyright (c) 2015, �����ֵ� All Rights Reserved.
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
 * ����: BaseDao <br/>
 * ����: TODO ��ӹ�������. <br/>
 * ����: 2015��11��18�� ����7:33:59 <br/>
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

