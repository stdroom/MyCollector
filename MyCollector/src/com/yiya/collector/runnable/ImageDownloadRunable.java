/**
 * 工程名: InterfaceWare
 * 文件名: ImageDownloadRunable.java
 * 包名: com.yiya.collector.runnable
 * 日期: 2015年11月5日下午2:28:13
 * QQ: 378640336
 *
*/

package com.yiya.collector.runnable;

import java.io.File;
import java.util.ArrayList;

import com.yiya.collector.bean.ImageBean;
import com.yiya.collector.dao.ImageDao;
import com.yiya.collector.utils.ApplicationContextUtils;
import com.yiya.collector.utils.FileUtils;
import com.yiya.collector.utils.MD5Utils;

/**
 * 类名: ImageDownloadRunable <br/>
 * 功能: 图片下载线程. <br/>
 * 日期: 2015年11月5日 下午2:28:13 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class ImageDownloadRunable implements Runnable{
	static int taoshu = 1;
	ImageBean bean ; 
	
	public ImageDownloadRunable(ImageBean bean){
		this.bean = bean;
	}
	
	@Override
	public void run() {
//		String path = "D://test/"+bean.getCata_id()+"/";
		String contextPath = MD5Utils.md5(bean.getTitle())+"/";
//		path = path +contextPath;
		
//		File file = new File(path);
//		file.mkdirs();
		ArrayList<String> urls = bean.getImgPath();
		bean.setPageNum(urls.size());
		StringBuffer contextPaths = new StringBuffer();
		StringBuffer srcPaths = new StringBuffer();
		int size = urls.size();
		for(int i = 0 ; i < size;i++){
			String url = urls.get(i);
			String name = url.substring(url.lastIndexOf("/"));
			if(i == 0){
				contextPaths.append(contextPath+name);
			}else{
				contextPaths.append(";"+contextPath+name);
			}
			if(i == 0){
				srcPaths.append(url);
			}else{
				srcPaths.append(";"+url);
			}
//			String imgPath = path+name;
//			FileUtils.saveImageToLocal(url, imgPath);
		}
//		bean.setImgPaths(contextPaths.toString());
		bean.setSrcImgPaths(srcPaths.toString());
		ImageDao dao = (ImageDao)ApplicationContextUtils.context.getBean("imageDao");
//		if(dao.findByContextHtml(bean)==1){
//			dao.updateImageSrcPath(bean);
//			bean.println();
//		}else{
			System.out.println("哈哈taoshu:"+taoshu++);
			dao.insertImageBean(bean);
//		}
	}

}

