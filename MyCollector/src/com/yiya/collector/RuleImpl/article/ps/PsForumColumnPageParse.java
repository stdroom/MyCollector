/**
 * 工程名: MyCollector
 * 文件名: PsForumColumnPageParse.java
 * 包名: com.yiya.collector.RuleImpl.article.ps
 * 日期: 2015年11月14日下午3:49:24
 * QQ: 378640336
 *
*/

package com.yiya.collector.RuleImpl.article.ps;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.yiya.collector.RulesInterf.ColumnArticlePageParse;
import com.yiya.collector.bean.ArticleBean;
import com.yiya.collector.bean.ColumnEachPageBean;

/**
 * 类名: PsForumColumnPageParse <br/>
 * 功能: http://www.16xx8.com/ 网站解析器. <br/>
 * 日期: 2015年11月14日 下午3:49:24 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class PsForumColumnPageParse implements ColumnArticlePageParse{

	/**
	 * 
	 * TODO ps教程论坛 栏目解析）.
	 * @see com.yiya.collector.RulesInterf.ColumnArticlePageParse#getArticleBean(com.yiya.collector.bean.ColumnEachPageBean)
	 */
	@Override
	public ArrayList<ArticleBean> getArticleBeans(ColumnEachPageBean pageBean) {
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
	            e.printStackTrace();
	        }

	        if(content == null){
	            pageBean.setParseError(true);
	            pageBean.setException("没请求到数据");
	            return null;
	        }

	        pageBean.setDoc(content);
	        Elements elementss = content.getElementsByClass("feed-page");
	        ArrayList<ArticleBean> tempList = new ArrayList<ArticleBean>();
	        // ul节点 即为 文章列表
	        Element e1 = elementss.get(0).children().first();
	        Elements elements = e1.children();
	        for(Element lik : elements){
	            Elements ele = lik.getElementsByTag("li");
	            if(ele.size()>0){
	                for(Element linkss : ele)
	                {
	                    String title = "";
	                    String imgUrl = "";
	                    String summary = "";
	                    String link = "";
	                    Elements titleImg = linkss.getElementsByTag("img");
	                    for(Element bean : titleImg){
	                        if(bean.hasAttr("alt")){	// 标题
	                            title = bean.attr("alt");
	                        }
	                        if(bean.hasAttr("src")){	// 图像地址
	                            imgUrl = bean.attr("src");
	                        }
	                    }

	                    Elements contentUrl = linkss.select(".feed-item-content");
	                    for(Element bean:contentUrl){
	                    	Elements bean1 = bean.select(".description");
	                    	for(Element bean2:bean1){
	                    		if(bean2.hasAttr("class") && "div".equals(bean2.tagName()) && bean2.attr("class").contains("description")){	// 内容摘要
		                            summary = bean2.text();	// 需要去掉<p>标签 
		                        }
	                    	}
	                        
	                        Elements contentBean = bean.select(".title.yt-uix-sessionlink");
	                        for(Element bean2:contentBean){
	                            if(bean2.hasAttr("href")){	// 跳转链接  抓取详情时需要此数据
	                                link = bean2.attr("href");
	                            }
	                        }
	                    }
	                    String time = "";
//	                    ArrayList<String> tags = new ArrayList<String>();
	                    Elements timeTag = linkss.getElementsByClass("view-count");
                    	for(Element links: timeTag){
                    		if(links.text().contains("日期")){
                    			if(links.text().contains("font")){
                    				Elements links1 = links.getElementsByTag("font");
                    				for(Element links2: links1){
                    					if(links2.hasAttr("color") && "font".equals(links2.tagName())){
                    						time = links.text();
                    						break;
                    					}
                    				}
                    			}else{
                    				time = links.text().replace("日期", "");
                    				time = time.replace("：", "");
                    			}
                    		}
                    		
                    	}
	                    ArticleBean bean = new ArticleBean();
	                    bean.setTitle(title);
	                    bean.setContextTime(time);
	                    bean.setImgPath(imgUrl);
	                    bean.setContextSummary(summary);
	                    bean.setContextHtml(link);
//	                    bean.setTags(tags);
	                    tempList.add(bean);
	                }
	            }
	        }

	        return tempList;
	}

	@Override
	public ColumnEachPageBean getNextPage(ColumnEachPageBean pageBean) {
		if(pageBean!=null && pageBean.getDoc()!=null){
            Document doc = pageBean.getDoc();
            Elements eless = doc.getElementsByClass("pagelist");
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
                            pageBean.setCurrentPageUrl(pageBean.getBaseUrl()+element.attr("href").trim());
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
	public void ParseContextByArticleBean(ArticleBean bean) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArticleBean getNextPage(ArticleBean bean) {
		
		return null;
	}

}

