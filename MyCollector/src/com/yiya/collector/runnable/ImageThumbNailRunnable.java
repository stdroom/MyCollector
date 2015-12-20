/**
 * 工程名: MyCollector
 * 文件名: ImageThumbNailRunnable.java
 * 包名: com.yiya.collector.runnable
 * 日期: 2015年11月10日上午11:23:52
 * QQ: 378640336
 *
*/

package com.yiya.collector.runnable;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.JSONObject;
import com.ericsoft.bmob.restapi.Bmob;
import com.mysql.jdbc.StringUtils;
import com.yiya.collector.bean.BombFileJson;
import com.yiya.collector.bean.ImageBean;
import com.yiya.collector.dao.ImageDao;
import com.yiya.collector.utils.ApplicationContextUtils;
import com.yiya.collector.utils.FileUtils;
import com.yiya.collector.utils.ImageHelper;
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
		static int count = 0;
		ImageBean bean ; 
		
		public ImageThumbNailRunnable(ImageBean bean){
			this.bean = bean;
		}
		
		@Override
		public void run() {
			String path = "D://test/"+bean.getCata_id()+"/thumb/";
			
			File file = new File(path);
			file.mkdirs();
			String url = getThumb(bean);
			String name = url.substring(url.lastIndexOf("/")+1);
			String imgPath = path+bean.getId()+name;
			FileUtils.saveImageToLocal(url, imgPath);
			FileInputStream fis;
			try {
				File files = new File(imgPath);
				fis = new FileInputStream(files);
				BufferedImage bufferedImg = ImageIO.read(fis);
				int imgWidth = bufferedImg.getWidth();
				int imgHeight = bufferedImg.getHeight();
				if(imgWidth > 400){
					imgHeight = 400*imgHeight/imgWidth;
					ImageHelper.zoomImage(imgPath, path+bean.getId()+"_"+name, 400,imgHeight);
					imgPath = path+bean.getId()+"_"+name;
					imgWidth = 400;
				}
				bean.setWidth(imgWidth);
				bean.setHeight(imgHeight);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e){
				e.printStackTrace();
			} catch(Exception e){
				e.printStackTrace();
			}
			Bmob.initBmob("3d1ca7692abf3c88f1a9202a68bde16d",
					"92b90fae70efb396a2e02611e128923c");
			// 上传图片
			String res=Bmob.uploadFile(imgPath);
			BombFileJson json = JSONObject.parseObject(res, BombFileJson.class);
			bean.setThumbYun(json.getUrl());
			System.out.println(count++ +":"+bean.getId()+":"+bean.getWidth()+":"+bean.getCata_id()+ bean.getTitle()+bean.getThumbYun());
			ImageDao dao = (ImageDao)ApplicationContextUtils.context.getBean("imageDao");
			dao.updateImageThumbById(bean);
		}
		
		private String getThumb(ImageBean bean){
			if(!StringUtils.isNullOrEmpty(bean.getSrcImgPaths())){
				String[] src = bean.getSrcImgPaths().split(";");
				if(src.length>0){
					return src[0];
				}else{
					System.out.println("没有图片");
					return "";
				}
			}else{
				return "图片字段为空";
			}
		}
}

