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

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
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
	
	public List getListForPage(final String hql, final int offset,     
		    final int length) {     
	   List list = hibernateTemplate.executeFind(new HibernateCallback() {     
	    public Object doInHibernate(Session session)     
	      throws HibernateException, SQLException {     
	     Query query = session.createQuery(hql);     
	     query.setFirstResult(offset);     
	     query.setMaxResults(length);     
	     List list = query.list();     
	     return list;     
	    }     
	   });     
	   return list;     
	}
}

