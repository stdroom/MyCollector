/**
 * 工程名: spmvc03
 * 文件名: MessageConverter.java
 * 包名: com.sxt.interceptor
 * 日期: 2015年11月19日上午10:29:50
 * QQ: 378640336
 *
*/

package com.sxt.interceptor;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/**
 * 类名: MessageConverter <br/>
 * 功能: TODO 添加功能描述. <br/>
 * 日期: 2015年11月19日 上午10:29:50 <br/>
 *
 * @author   leixun
 * @version  	 
 */
public class MessageConverter extends AbstractHttpMessageConverter{
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
	
	@Override
	protected Object readInternal(Class arg0, HttpInputMessage arg1)
			throws IOException, HttpMessageNotReadableException {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean supports(Class arg0) {
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void writeInternal(Object arg0, HttpOutputMessage arg1)
			throws IOException, HttpMessageNotWritableException {
		
		// TODO Auto-generated method stub
		
	}

}

