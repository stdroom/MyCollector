package com.yiya.collector.main;


import com.yiya.collector.RuleImpl.image.uumn.UumnColumnImagePageParse;
import com.yiya.collector.bean.ColumnEachPageBean;
import com.yiya.collector.runnable.ParseImagePageRunnable;
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
    	
    	ColumnEachPageBean bean = new ColumnEachPageBean();
    	bean.setIndexUrl("http://www.uumnt.com/sheji/list_1.html");
    	bean.setBaseUrl("http://www.uumnt.com/");
    	ParseImagePageRunnable run = new ParseImagePageRunnable(bean,new UumnColumnImagePageParse());

        ExcutorServiceUtils.getInstance().getThreadPool().submit(run);
    }

}
