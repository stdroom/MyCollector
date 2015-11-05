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
import com.yiya.collector.utils.FileUtils;

/**
 * 类名: ImageDownloadRunable <br/>
 * 功能: 图片下载线程. <br/>
 * 日期: 2015年11月5日 下午2:28:13 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class ImageDownloadRunable implements Runnable{

	ImageBean bean ; 
	
	public ImageDownloadRunable(ImageBean bean){
		this.bean = bean;
	}
	
	@Override
	public void run() {
		String path = "D://test/"+bean.getCata_id()+"/"+bean.getTitle().trim()+"/";
		File file = new File(path);
		file.mkdirs();
		ArrayList<String> urls = bean.getImgPath();
		for(String url:urls){
			String name = url.substring(url.lastIndexOf("/"));
			String imgPath = path+name;
			FileUtils.saveImageToLocal(url, imgPath);
		}
	}

}

