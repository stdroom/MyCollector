/**
 * 工程名: MyCollector
 * 文件名: OneSixBbImagePage.java
 * 包名: com.yiya.collector.RuleImpl.image.onesixbb
 * 日期: 2015年12月1日下午9:18:41
 * Copyright (c) 2015, 暴走兄弟 All Rights Reserved.
 * 
 * Mail: leixun33@163.com
 * QQ: 378640336
 *
*/

package com.yiya.collector.RuleImpl.image.onesixbb;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.yiya.collector.RulesInterf.ColumnImagePageParse;
import com.yiya.collector.bean.ColumnEachPageBean;
import com.yiya.collector.bean.ImageBean;

/**
 * 类名: OneSixBbImagePage <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年12月1日 下午9:18:41 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class OneSixBbImagePageParse implements ColumnImagePageParse{

	@Override
	public ArrayList<ImageBean> getImageBeans(ColumnEachPageBean pageBean) {
		Document content = null;
        try {
            Document doc;
            if(pageBean.getCurrentNum() == 0 ){
                doc = Jsoup.connect(pageBean.getIndexUrl()).timeout(5000).get();
            }else{
                doc = Jsoup.connect(pageBean.getCurrentPageUrl()).timeout(5000).get();
            }
            content = Jsoup.parse(doc.toString());
        } catch (IOException e) {
            pageBean.setParseError(true);
            pageBean.setException(e.toString());
            pageBean.setHasNext(false);
            e.printStackTrace();
        }

        if(content == null){
            pageBean.setParseError(true);
            pageBean.setException("没请求到数据");
            return null;
        }

        pageBean.setDoc(content);
        Elements elemnts = content.getElementsByTag("body");
        Element elemnt = elemnts.first();
        Elements elements = elemnt.children();
        ArrayList<ImageBean> tempList = new ArrayList<ImageBean>();
        boolean parseFlag = false;
        for(Element lik : elements){
        	if(parseFlag == false){
        		if(lik.toString().contains("最近更新")){
            		parseFlag = true;
            	}
        	}else{
        		if(lik.toString().contains("下一页")){
        			break;
        		}
        		Elements ele = lik.getElementsByTag("a");
        		for(Element linkss:ele){
        			Elements titleImg = linkss.getElementsByTag("img");
        			if(titleImg!=null && titleImg.size()>0){
        				String title = "";
        				String imgUrl = "";
        				String link = "";
        				int width = 0;
        				int height = 0;
        				
        				
        				for(Element bean : titleImg){
        					if(bean.hasAttr("width")){
        						width=Integer.parseInt(bean.attr("width"));
        						height=Integer.parseInt(bean.attr("height"));
        					}
        					if("".equals(imgUrl)){
        						if(bean.hasAttr("src")){	// 图像地址
        							if(bean.attr("src").trim().contains("http")){
        								imgUrl = bean.attr("src").trim();
        							}else{
        								imgUrl = pageBean.getBaseUrl()+bean.attr("src").trim();
        							}
        						}
        					}
        				}
        				
        				Elements contentUrl = linkss.getElementsByClass("sDes");
        				if(linkss.hasAttr("title")){
        					title = linkss.attr("title");
        				}
        				if(linkss.hasAttr("href")){
        					if(linkss.attr("href").trim().contains("http")){
        						link = linkss.attr("href").trim();
        					}else{
        						link = pageBean.getBaseUrl()+linkss.attr("href").trim();
        					}
        				}
        				ImageBean bean = new ImageBean();
        				bean.setTitle(title);
        				bean.setThumbNail(imgUrl);
        				bean.setContextHtml(link);
        				bean.setWidth(width);
        				bean.setHeight(height);
        				bean.setBaseUrl(pageBean.getBaseUrl());
        				bean.setCata_id(pageBean.getCata_id());
        				tempList.add(bean);
        			}
        		}
        	}
        		
        	}
        	

        return tempList;
	}

	@Override
	public ColumnEachPageBean getNextPage(ColumnEachPageBean pageBean) {
		if(pageBean!=null && pageBean.getDoc()!=null){
            Document doc = pageBean.getDoc();
            Elements elemnts = doc.getElementsByTag("body");
            Element elemnt = elemnts.first();
            Elements eless = elemnt.children();
            boolean nextFlag = false;
            for(Element eles_m:eless){
            	if(eles_m.toString().contains("下一页")){
            		Elements eles = eles_m.getElementsByTag("a");
            		for(Element element : eles){
            			if("下一页".equals(element.text())){
            				pageBean.setHasNext(true);
            				int currentPageNum = pageBean.getCurrentNum();
            				pageBean.setCurrentNum(currentPageNum+1);
            				if(element.attr("href").trim().contains("http")){
            					pageBean.setCurrentPageUrl(element.attr("href").trim());
            				}else{
            					String indexUrl = pageBean.getIndexUrl().substring(0, pageBean.getIndexUrl().lastIndexOf('/'));
            					pageBean.setCurrentPageUrl(indexUrl+"/"+element.attr("href").trim());
            				}
            				nextFlag = true;
            				break;
            			}
            		}
            	}
            }
            if(!nextFlag){
                pageBean.setHasNext(false);
            }
        }else{
            pageBean.setHasNext(false);
        }

        return pageBean;
	}

	@Override
	public void ParseImagesByImageBean(ImageBean pageBean) {
		Document content = null;
        try {
            Document doc;
            if(pageBean.getCurrentPage() == 0 ){
                doc = Jsoup.connect(pageBean.getContextHtml()).timeout(5000).get();
            }else{
                doc = Jsoup.connect(pageBean.getCurrentPageUrl()).timeout(5000).get();
            }
            content = Jsoup.parse(doc.toString());
        } catch (IOException e) {
            pageBean.setParseError(true);
            pageBean.setException(e.toString());
            pageBean.setHasNext(false);
            e.printStackTrace();
        }

        if(content == null){
            pageBean.setParseError(true);
            pageBean.setException("没请求到数据");
        }

        pageBean.setDoc(content);
        Elements elemnts = content.getElementsByTag("body");
        Element elemnt = elemnts.first();
        Elements elements = elemnt.children();
        ArrayList<String> tempList;
        if(pageBean.getImgPath() == null){
        	tempList = new ArrayList<String>();
        	pageBean.setImgPath(tempList);
        }else{
        	tempList = pageBean.getImgPath();
        }
        int size = elements.size();
        boolean parseFlag = false;
        for(int i = 0 ;i < size;i++){
        	String imgUrl = "";
        	if(!parseFlag){
        		if(elements.get(i).tagName().equals("table")
        				&& elements.get(i+1).tagName().equals("p")){
        			parseFlag =true;
        			continue;
        		}
        	}else{
        		if(elements.get(i).tagName().equals("p")){
        			Elements ps = elements.get(i).children();
        			if(ps.size() >1){
        				break;
        			}else{
        				if(ps.get(0).hasAttr("src")){	// 图像地址
            				if(ps.get(0).attr("src").trim().contains("http")){
            					imgUrl = ps.get(0).attr("src").trim();
            				}else{
            					System.out.println("wrong,wrong");
//            					imgUrl = pageBean.getBaseUrl()+bean.attr("src").trim();
            				}
            			}
        				if(!"".equals(imgUrl)){
                			tempList.add(imgUrl);
                		}
        			}
        		}
        	}
        }
	}

	@Override
	public ImageBean getNextPage(ImageBean bean) {
		
		// TODO Auto-generated method stub
		return null;
	}

}

