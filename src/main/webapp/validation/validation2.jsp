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
	值栈中的错误提示:值栈中的数据:fieldErrors	{age=[Age needs to be between 20 and 50]}
	<s:form action="testValidation" theme="simple">
		<s:textfield name="age" label="Age"></s:textfield>
		<s:submit></s:submit>
	</s:form>
	<s:debug></s:debug>
</body>
</html>