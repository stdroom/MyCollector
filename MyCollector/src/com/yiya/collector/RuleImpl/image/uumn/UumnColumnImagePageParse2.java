package com.yiya.collector.RuleImpl.image.uumn;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.yiya.collector.RulesInterf.ColumnImagePageParse;
import com.yiya.collector.bean.ArticleBean;
import com.yiya.collector.bean.ColumnEachPageBean;
import com.yiya.collector.bean.ImageBean;
/**
 * 
 * 类名: UumnColumnImagePageParse <br/>
 * 功能描述: 优优美图解析. <br/>
 * 日期: 2015年11月5日 下午3:06:55 <br/>
 *
 * @author leixun
 * @version
 */
public class UumnColumnImagePageParse2 implements ColumnImagePageParse{

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
        Element elemnt = content.getElementById("mainbodypul");
        Elements elements = elemnt.children();
        ArrayList<ImageBean> tempList = new ArrayList<ImageBean>();
        for(Element lik : elements){
            Elements ele = lik.getElementsByTag("a");
            if(ele.size()>0){
            	Element linkss = ele.get(0);
                    String title = "";
                    String imgUrl = "";
                    String link = "";
                    Elements titleImg = linkss.getElementsByTag("img");
                    for(Element bean : titleImg){
                        if(bean.hasAttr("alt")){	// 标题
                            title = bean.attr("alt");
                        }
                        if(bean.hasAttr("data-original")){	// 图像地址
                        	if(bean.attr("data-original").trim().contains("http")){
                        		imgUrl = bean.attr("data-original").trim();
                            }else{
                            	imgUrl = pageBean.getBaseUrl()+bean.attr("data-original").trim();
                            }
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

                    Elements contentBean = linkss.getElementsByTag("a");
                    for(Element bean2:contentBean){
                        if(bean2.hasAttr("href")){	// 跳转链接
                            if(bean2.attr("href").trim().contains("http")){
                            	link = bean2.attr("href").trim();
                            }else{
                            	link = pageBean.getBaseUrl()+bean2.attr("href").trim();
                            }
                        }
                    }
                    ImageBean bean = new ImageBean();
                    bean.setTitle(title);
                    bean.setThumbNail(imgUrl);
                    bean.setContextHtml(link);
                    bean.setBaseUrl(pageBean.getBaseUrl());
                    bean.setCata_id(pageBean.getCata_id());
                    tempList.add(bean);
            }
        }

        return tempList;
	}

	@Override
	public ColumnEachPageBean getNextPage(ColumnEachPageBean pageBean) {
		if(pageBean!=null && pageBean.getDoc()!=null){
            Document doc = pageBean.getDoc();
            Elements eless = doc.select(".page.both");
            boolean nextFlag = false;
            for(Element eles_m:eless){
                Elements eles = eles_m.getElementsByTag("a");
                for(Element element : eles){
                    if("下一页".equals(element.text())){
                        pageBean.setHasNext(true);
                        int currentPageNum = pageBean.getCurrentNum();
                        pageBean.setCurrentNum(currentPageNum+1);
                        if(element.attr("href").trim().contains("http")){
                            pageBean.setCurrentPageUrl(element.attr("href").trim());
                        }else{
                            pageBean.setCurrentPageUrl(pageBean.getIndexUrl()+element.attr("href").trim());
                        }
                        nextFlag = true;
                        break;
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
        Elements ele = content.select(".bg-white").select(".center");
        Elements elements = ele.get(0).children();
        ArrayList<String> tempList;
        if(pageBean.getImgPath() == null){
        	tempList = new ArrayList<String>();
        }else{
        	tempList = pageBean.getImgPath();
        }
        for(Element lik : elements){
        	if(lik.tagName().equals("a")){
        		String imgUrl = "";
        		Elements titleImg = lik.select("img[src]");
        		for(Element bean : titleImg){
        			if(bean.hasAttr("src")){	// 图像地址
        				if(bean.attr("src").trim().contains("http")){
        					imgUrl = bean.attr("src").trim();
        				}else{
//        					imgUrl = pageBean.getBaseUrl()+bean.attr("src").trim();
        				}
        			}
        		}
        		if(!"".equals(imgUrl)){
        			tempList.add(imgUrl);
        		}
        	}
        }

	}

	@Override
	public ImageBean getNextPage(ImageBean pageBean) {
		if(pageBean!=null && pageBean.getDoc()!=null){
            Document doc = pageBean.getDoc();
            Elements eless = doc.select(".page");
            boolean nextFlag = false;
            for(Element eles_m:eless){
                Elements eles = eles_m.getElementsByTag("a");
                for(Element element : eles){
                    if("下一页".equals(element.text())){
                        pageBean.setHasNext(true);
                        int currentPageNum = pageBean.getCurrentPage();
                        pageBean.setCurrentPage(currentPageNum+1);
                        if("#".equals(element.attr("href"))){
                        	nextFlag = false;
                        }else{
                        	if(element.attr("href").contains("http")){
                        		pageBean.setCurrentPageUrl(element.attr("href"));
                        	}else{
                        		String url = pageBean.getContextHtml().substring(0,pageBean.getContextHtml().lastIndexOf("/"));
                        		pageBean.setCurrentPageUrl(url+"/"+element.attr("href"));
                        	}
                        	nextFlag = true;
                        }
                        break;
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

}
