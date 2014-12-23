package com.bin.conversion.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {
	
	private DateFormat dateFormat ;
	
	
	public DateConverter() {
		System.out.println("dateConverter' constructor");
		
	}
	
	/**
	 * web.xml中的context参数在没有加载完的时候,这个类就可能已将实例化,所以此方法的功能不能放在构造器里.
	 */
	public DateFormat getDateFormat(){
		if (dateFormat == null) {
			// 获取当前WEB应用的初始化参数pattern.
			ServletContext servletContext = ServletActionContext.getServletContext() ;
			String pattern = servletContext.getInitParameter("pattern") ;
			dateFormat = new SimpleDateFormat(pattern) ;
		}
		return dateFormat;
	}

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// 格式错误的话,最好抛出异常.
		System.out.println("convertFromString...");
		if (toClass == Date.class) {
			if (values != null && values.length > 0) {
				String value = values[0] ;
				try {
					return getDateFormat().parseObject(value) ;
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		
		// 若没有转换成功,则返回values
		return values;
	}

	@Override
	public String convertToString(Map context, Object o) {
		System.out.println("converToString..");
		if (o instanceof Date) {
			Date date = (Date) o;
			return dateFormat.format(date) ;
		}
		// 若转换失败,返回null
		return null;
	}

}
