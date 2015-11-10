/**
 * 工程名: MyCollector
 * 文件名: ImageThumbNailRunnable.java
 * 包名: com.yiya.collector.runnable
 * 日期: 2015年11月10日上午11:23:52
 * QQ: 378640336
 *
*/

package com.yiya.collector.runnable;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.yiya.collector.bean.ImageBean;
import com.yiya.collector.dao.ImageDao;
import com.yiya.collector.utils.ApplicationContextUtils;
import com.yiya.collector.utils.FileUtils;
import com.yiya.collector.utils.MD5Utils;

/**
 * 类名: ImageThumbNailRunnable <br/>
 * 功能: 缩略图 下载. <br/>
 * 日期: 2015年11月10日 上午11:23:52 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class ImageThumbNailRunnable	implements Runnable{

		ImageBean bean ; 
		
		public ImageThumbNailRunnable(ImageBean bean){
			this.bean = bean;
		}
		
		@Override
		public void run() {
			String path = "D://test/"+bean.getCata_id()+"/thumb/";
			
			File file = new File(path);
			file.mkdirs();
			String url = bean.getThumbNail();
			String name = MD5Utils.md5(bean.getTitle())+url.substring(url.lastIndexOf("/"));
			String imgPath = path+name;
			FileUtils.saveImageToLocal(url, imgPath);
			bean.setThumbNail("/thumb/"+name);
			FileInputStream fis;
			try {
				fis = new FileInputStream(file);
				BufferedImage bufferedImg = ImageIO.read(fis);
				int imgWidth = bufferedImg.getWidth();
				int imgHeight = bufferedImg.getHeight();
				bean.setWidth(imgWidth);
				bean.setHeight(imgHeight);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			}
			
			ImageDao dao = (ImageDao)ApplicationContextUtils.context.getBean("imageDao");
			dao.updateImageBeanById(bean);
		}
}

