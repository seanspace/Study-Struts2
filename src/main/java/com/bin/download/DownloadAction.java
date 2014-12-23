package com.bin.download;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport{

	private static final long serialVersionUID = -3208009828090810347L;
	public String contentType ;
	public int contentLength ;
	public String contentDisposition ;
	private InputStream inputStream ;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public String getContentType() {
		return contentType;
	}
	public int getContentLength() {
		return contentLength;
	}
	public String getContentDisposition() {
		return contentDisposition;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		// 确定各个成员变量的值.
		contentType = "text/java" ;
		contentDisposition = "attachment;filename=hidden.html" ;
		
		ServletContext servletContext = ServletActionContext.getServletContext() ;
		
		String fileName = servletContext.getRealPath("files_upload/IDCard.java") ;
		inputStream = new FileInputStream(fileName) ;
		contentLength = inputStream.available() ;
		
		
		return SUCCESS;
	}
	

}
