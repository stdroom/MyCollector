package com.yiya.collector.RuleImpl.article.fengdu;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.yiya.collector.RulesInterf.ColumnPageParse;
import com.yiya.collector.bean.ArticleBean;
import com.yiya.collector.bean.ColumnEachPageBean;

/**
 * Created by xiaoma on 2015/11/2.
 */
public class FengDuCloumnPageParse implements ColumnPageParse{

    /**
     * 风度男人网的栏目解析
     * @return
     */
    @Override
    public ArrayList<ArticleBean> getArticleBean(ColumnEachPageBean pageBean) {
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
        Elements elements = content.getElementsByClass("clearfix");
        ArrayList<ArticleBean> tempList = new ArrayList<ArticleBean>();
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

                    Elements contentUrl = linkss.getElementsByClass("sDes");
                    for(Element bean:contentUrl){
                        if(bean.hasAttr("class")){	// 内容摘要
                            summary = bean.text();
                        }
                        Elements contentBean = bean.getElementsByTag("a");
                        for(Element bean2:contentBean){
                            if(bean2.hasAttr("href")){	// 跳转链接
                                link = bean2.attr("href");
                            }
                        }
                    }
                    String time = "";
                    ArrayList<String> tags = new ArrayList<String>();
                    Elements timeTag = linkss.getElementsByClass("time");
                    for(Element links: timeTag){
                        Elements spans = links.getElementsByTag("span");
                        for(Element bean:spans){
                            if(bean.hasAttr("class")){
                                if("time".equals(bean.attr("class"))){
                                    time = bean.text();
                                    continue;
                                }
                            }
                        }
                    }
                    ArticleBean bean = new ArticleBean();
                    bean.setTitle(title);
                    bean.setCreated_at(time);
                    bean.setImgPath(imgUrl);
                    bean.setContextSummary(summary);
                    bean.setContextHtml(link);
                    bean.setTags(tags);
                    tempList.add(bean);
                }
            }
        }

        return tempList;
    }

    /**
     * 风度男人网的 下一页解析
     * @param pageBean
     * @return
     */
    @Override
    public ColumnEachPageBean getNextPage(ColumnEachPageBean pageBean) {
        if(pageBean!=null && pageBean.getDoc()!=null){
            Document doc = pageBean.getDoc();
            Elements eless = doc.getElementsByClass("linle-pag");
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

    /**
     * 风度男人解析内容详情页
     * @param bean
     */
    @Override
    public void ParseContextByArticleBean(ArticleBean bean) {
        Document content = null;
        try {
            Document doc = Jsoup.connect(bean.getContextHtml()).timeout(5000).get();
            content = Jsoup.parse(doc.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 开始按手机端要求 解析文章内容详情 并存放到相应位置 并写入数据库
        
    }

    /**
     * 风度男人 内容详情是否有下一页
     * @param bean
     * @return
     */
    @Override
    public ArticleBean getNextPage(ArticleBean bean) {
        return null;
    }
}
