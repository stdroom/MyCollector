/**
 * 工程名: MyCollector
 * 文件名: PsjiaoChengArticleTest.java
 * 包名: test
 * 日期: 2015年11月14日下午3:57:06
 * QQ: 378640336
 *
*/

package test;

import static org.junit.Assert.*;

import org.jsoup.nodes.Document;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * 类名: PsjiaoChengArticleTest <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月14日 下午3:57:06 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class PsjiaoChengArticleTest extends TestCase{
	
	private String testurl="http://www.fengdu100.com/paoniu/yuehui/33849.html";
	public void setUp() throws Exception {
	
	}
	
	public void tearDown() throws Exception {
	
	}

    @Test
    public void testGetQueryTitleExpression() throws Exception {
//        String titleExpression =new FengDuArticleParseRule().getQueryTitleExpression();
//        String expecturl="http://www.fengdu100.com/paoniu/yuehui/33849_2.html";
//        Document doc = Jsoup.connect(expecturl).timeout(5000).get();
//        String title = doc.select(titleExpression).first().text();
//
//        assertTrue(title.contains("宅男约会"));
//        assertEquals(title,"宅男约会变魅力提升法则 做个有魅力的男人(2)");
    }

    @Test
    public void testGetQueryContentExpression() throws Exception {

    }

    @Test
    public void testGetPageurl() throws Exception {
//        String getPageurl=new FengDuArticleParseRule().getPageurl(testurl,2);
//        String expecturl="http://www.fengdu100.com/paoniu/yuehui/33849_2.html";
//        assertEquals(expecturl,getPageurl);
    }

    @Test
    public void testHasNextPageExpression() throws Exception {

    }


}

