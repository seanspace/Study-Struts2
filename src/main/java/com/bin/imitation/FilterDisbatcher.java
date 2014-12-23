package com.bin.imitation;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterDisbatcher implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request ;
		
		// 1.获取servletPath
		String servletPath = req.getServletPath() ;
		System.out.println(servletPath);
		
		String path = null ;
		// 2.根据ServletPath判断,若等于"/product-input.action",则转发到WEB-INF/pages/input.jsp
		if ("/imitationStruts2/product-input.action".equals(servletPath)) {
			path = "/WEB-INF/pages/input.jsp" ;
		}
		// 3.若其等于"/product-save.action",则
		if ("/imitationStruts2/product-save.action".equals(servletPath)) {
			//  1).获取请求参数
			String productName = request.getParameter("productName") ;
			String productDesc = req.getParameter("productDesc") ;
			String productPrice = req.getParameter("productPrice") ;
			//  2)封装成一个Product对象
			Product product = new Product(null, productName,productDesc, productPrice) ;
			//  3).执行保存操作
			System.out.println("Save product:" + product);
			//  4).把Product对象保存到request中.${param.productName) -> ${requestScope.productName}
			req.setAttribute("product", product);
			path = "/WEB-INF/pages/details.jsp" ;
		}

		if (path != null) {
			req.getRequestDispatcher(path).forward(req, response); ;
			return ;
		}
		chain.doFilter(req, response);
		
	}

	@Override
	public void destroy() {
		
	}

}
