<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:debug></s:debug>
ProductId:<%-- ${requestScope.product.productId } --%>
<br>
<!-- 这里是使用OGNL表达式,从值栈中获取对象属性,对象名都不写,productName是对应的Action对象的属性. -->
productName:${productName }
<br>
productDesc:<s:property value="[1].productDesc"/>
<br>
<!-- 这个和el表达式是一样的,都是获取值栈中第一个对象的属性. -->
productPrice:<%=request.getAttribute("productPrice") %>
<br>
<!-- 下面是使用property标签显示值栈的值. -->
<!-- 不去掉下标 -->
下面是使用property标签显示值栈的值.
ProductPrice:<s:property value="[0].productPrice"/>
<br>
<!-- 去掉下标 -->
ProductPrice:<s:property value="productPrice"/>
<br>
ProductName-session:${sessionScope.product.productName }
<br>使用property标签取出session的map栈的值:<s:property value="#session.product.productName"/>
<br>
ProductName-request:${requestScope.test.productName }
<br>使用property便签取出request的map栈的值:<s:property value="#request.test.productName"/>
<br>
<!-- 任何一个java类的静态字段或方法. -->
<s:property value="@java.lang.Math@PI"/>
<br>
<s:property value="@java.lang.Math@cos(0)"/>
<br>
<!-- 调用数组对象属性. -->
<% 
	String [] names = new String[]{"aa","bb","cc","dd"} ;
	request.setAttribute("names", names) ;
%>
length：<s:property value="#attr.names.length"/>
<!-- attr并不指定具体request,session,application中的值. -->
<br>
name[2] :<s:property value="#attr.names[2]"/>
<br>

<%
	Map<String,String> letters = new HashMap<String,String>() ;
	request.setAttribute("letters", letters) ;
	letters.put("AA", "a") ;
	letters.put("BB", "b") ;
	letters.put("CC", "c") ;
%>
<!-- 使用OGNL访问Map -->
map的长度:<s:property value="#attr.letters.size"/>
<br>
AA:<s:property value="#attr.letters['AA']"/>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</body>
</html>