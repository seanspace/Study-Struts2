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
	<s:debug></s:debug>
	<br>
	<%-- <s:property  value="exceptionStack"/> --%>
	<br>
	<s:property value="exception"/>
	${exception }
	<br>
	<s:property value="exception.message"/>
	${exception.message }
	<font size="10" color=""></font>
	<form action="${pageContext.servletContext.contextPath }/helloworld/product-save.action" method="post">
		ProductName:<input type="text" name="productName"/>
		<br>
		ProductDesc:<input type="text" name="productDesc"/>
		<br>
		ProductPrice:<input type="text" name="productPrice"/>
		<br>
		<input type="submit" name="Submit">
	</form>
</body>
</html>