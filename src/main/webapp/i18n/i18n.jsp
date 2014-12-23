<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- request_locale会被持久化到session中. -->
	<a href="testI18n.action?request_locale=en_US">English</a>
	<a href="testI18n.action?request_locale=zh_CN">中文</a>
	<s:form action="" theme="simple">
	
	<!-- 
		label 若标签使用%{getText('username')}的方式也可以从国际化资源文件中获取value值了.
		因为此时在对象栈中有DefultTextProvidor的一个实例,该对象中提供了访问国际化资源文件的getText()方法
		同时还需要通知struts2框架label中放入的不再是一个普通字符串,而是一个ognl表达式.
	 -->
	<!-- key的方式是直接上资源文件取值 -->
	<!-- simple主题上面两种方式都不行使用s:text标签 -->
	<!-- 
		页面上可以直接使用<s:text name="" />标签来访问国际化资源文件中的值.这个标签任何主题都有效.
	 -->
	 	<s:text name="time">
	 		<!-- 这是填充占位符 -->
	 		<%-- <s:param value="date"></s:param> --%>
	 	</s:text>
	 	<br>
	 	<s:text name="time2"></s:text>
		<s:text name="username"></s:text><s:textfield name="username" label="%{getText('username')}"></s:textfield>
		<s:text name="username"></s:text><s:textfield name="username" key="username"></s:textfield>
		
		<s:text name="password"></s:text><s:password name="password" key="password"></s:password>
		
		
		
		<s:submit key="submit" value="%{getText('submit')}"></s:submit>
	</s:form>
	<s:debug></s:debug>
</body>
</html>