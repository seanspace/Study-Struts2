<%@page import="java.util.List"%>
<%@page import="com.bin.tag.City"%>
<%@page import="java.util.ArrayList"%>
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
	<!-- 
	表单标签:
	1.使用和html标签感觉差不多.
	2.会生成一个table,已进行自动的排版.
	3.会自动回显.(实际是自动ognl栈顶的属性):从栈顶对象开始匹配属性,并把匹配的属性值赋到对应标签value中,若栈顶没有,一次往下找.
	 -->
	 <s:debug></s:debug>
	 <%
	 	List<City> cities = new ArrayList<City>() ;
	 	cities.add(new City(1001,"北京")) ;
	 	cities.add(new City(1002,"上海")) ;
	 	request.setAttribute("cities", cities) ;
	 	
	 	// 这也是一种修改表单的主题.
	 	request.setAttribute("theme", "simple") ;
	 %>
	<s:form action="%{#page.servletContext.contextPath }/helloworld/save.do" theme="simple">
		<s:hidden name="userID"></s:hidden>
		
		<s:textfield name="username" label="UserName" theme="simple"></s:textfield>
		<!--  showPassword="true"使密码回显 -->
		<s:password name="password" label="Password"></s:password>
		<s:textarea name="desc" label="Desc"></s:textarea>
		
		<!-- 复选框:值为true或false;这里底层一个复选框,被配了一个隐藏的checkbox,这样就可以保证值的正确性.因为html的checkbox实际上在没有打钩时,是不会提交的. -->
		<s:checkbox name="married" label="Married"></s:checkbox>
		
		<!-- checkBoxList -->
		<s:radio name="gender" list="#{'1':'Male','0':'Female' }" label="Gender"></s:radio>
		
		<!-- 注意:服务端,需要使用集合类型,以保证能够正常的回显. -->
		<s:checkboxlist name="city" list="#request.cities" listKey="cityId" listValue="cityName" label="City">
		</s:checkboxlist>
		
		<s:select list="{11,12,13,14,15,16,17,18,19,20}" headerKey="" headerValue="请选择"
			name="age" label="Age" >
			<!-- 
				s:optgroup可以用做s:select的子标签,用于显示更多的下拉框.
				注意:必须有键值对,而不能使用一个集合,让其值作为键,又作为值.
			-->
			<s:optgroup label="21-30" list="#{12:12,22:22}"></s:optgroup>
			<s:optgroup label="31-40" list="#{31:32}"></s:optgroup>
			<s:optgroup label="40-50" list="#request.cities" listKey="cityId" listValue="cityName"></s:optgroup>
		</s:select>
		
		<s:submit></s:submit>
	</s:form>


</body>
</html>