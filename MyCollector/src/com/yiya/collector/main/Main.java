package com.yiya.collector.main;


import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yiya.collector.RuleImpl.image.uumn.UumnColumnImagePageParse;
import com.yiya.collector.bean.ColumnEachPageBean;
import com.yiya.collector.bean.ImageBean;
import com.yiya.collector.dao.ColumnEachPageDao;
import com.yiya.collector.dao.ImageDao;
import com.yiya.collector.runnable.ParseImagePageRunnable;
import com.yiya.collector.utils.ApplicationContextUtils;
import com.yiya.collector.utils.ExcutorServiceUtils;

public class Main {

    public static void main(String[] args) {
//        Document doc = null;
//        try {
//            doc = Jsoup.connect("http://www.fengdu100.com/paoniu/yuehui/list_66_27.html").get();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String charset1=Jsoup.connect("http://www.fengdu100.com/paoniu/yuehui/list_66_27.html").response().charset();
//        System.out.println(charset1);
//      //  Elements newsHeadlines = doc.select("a:contains('��һҳ')");
//        Elements newsHeadlines = doc.select("a:contains(1)");
//        System.out.println("haha"+newsHeadlines.toString());
	// write your code here
//    	
//        ColumnEachPageBean bean = new ColumnEachPageBean();
//        bean.setIndexUrl("http://www.fengdu100.com/paoniu/list_63_1.html");
//        bean.setBaseUrl("http://www.fengdu100.com/paoniu/");
//        ParseRunnable run = new ParseRunnable(bean,new FengDuCloumnPageParse());
    	
    	ColumnEachPageDao dao = (ColumnEachPageDao)ApplicationContextUtils.context.getBean("columnEachPageDao");
//    	String array[] = {"siwa/","xinggan/","rihan/","chemo/","qingchun/","zipai/"};
//    	int size = array.length;
//    	for(int i = 0 ; i < size ;i++){
//    		ColumnEachPageBean bean = new ColumnEachPageBean();
//    		bean.setIndexUrl("http://www.uumnt.com/"+array[i]);
//    		bean.setBaseUrl("http://www.uumnt.com/");
//    		bean.setType(0);
//    		dao.addColumnEachPageDao(bean);
//    	}
    	ArrayList<ColumnEachPageBean> beans = (ArrayList<ColumnEachPageBean>)dao.getColumnEachPageDaoList(0);
    	int size =  beans.size();
    	for(int i = 0 ; i < size ; i++){
    		ColumnEachPageBean bean = beans.get(i);
    		ParseImagePageRunnable run = new ParseImagePageRunnable(bean,new UumnColumnImagePageParse());
    		ExcutorServiceUtils.getInstance().getThreadPool().submit(run);
    	}
    	
//    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    	ColumnEachPageDao dao = (ColumnEachPageDao)context.getBean("columnEachPageDao");
//    	ArrayList<ColumnEachPageBean> list = (ArrayList<ColumnEachPageBean>)dao.getColumnEachPageDaoList();
//    	if(list == null){
//    		System.out.println("list is null");
//    	}else{
//    		for(ColumnEachPageBean bean : list){
//    			bean.println();
//    		}
//    	}
    	
//    	ImageDao dao  = (ImageDao)ApplicationContextUtils.context.getBean("imageDao");
//    	ImageBean bean = new ImageBean();
//    	bean.setBaseUrl("baseUrl");
//    	bean.setCata_id(1101);
//    	bean.setContextHtml(";asd;asd");
//    	dao.insertImageBean(bean);
    }

}
