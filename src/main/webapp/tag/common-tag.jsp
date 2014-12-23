<%@page import="java.util.Date"%>
<%@page import="com.bin.tag.PersonComparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.bin.tag.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 这个页面访问路径:http://localhost:8080/Struts2_atguigu/helloworld/testTag.do?name=atguigu -->
	<s:debug></s:debug>
	<br>
	s:property:打印值栈中属性值的;
	<br>
	productName:<s:property value="productName"/>
	<br>
	对于Map栈,打印request,session,application的某个值:
	<s:property value="#session.requestKey"/>
	<br>
	对于请求参数:name--<s:property value="#parameters.name"/>
	<br>
	s:url标签: 创建一个URL字符串的.
	<br>
	<br>
	<!-- 自动不解析,请求参数中value属性,因为已经确认数字不可能解析. -->
	<s:url value="/getProduct" var="url">
		<s:param name="productId" value="1001"></s:param>
	</s:url>
	${url }
	<br>
	<br>
	value是值栈中的ID:
	<s:url value="/getProduct" var="url2">
		<!-- 对于value值会自动的进行ognl解析! -->
		<s:param name="productId" value="productId"></s:param>
		<s:param name="date" value="#session.date"></s:param>
	</s:url>
	${url2 }
	<br>
	<br>
	value是直接写的,不使用ognl解析:
	<s:url value="/getProduct" var="url3">
		<!-- 这里value给的值不是int类型,所以无法生成参数,也无法ognl解析. 若不希望进行ognl解析,则使用单引号-->
		<s:param name="productId" value="'abcdefg'"></s:param>
	</s:url>
	${url3 }
	<br>
	<!-- 构建一个请求action的地址 -->
	<s:url action="testAction" namespace="/helloWorld" method="save" var="url4"></s:url>
	构建一个请求action的地址:${url4 }<!-- /Struts2_atguigu/helloWorld/testAction!save.do  -->
	<br><br>
	是否包含当前页面请求参数作为此url的参数.
	<s:url value="testUrl" var="url5" includeParams="get"></s:url>
	${url5 }
	<br><br>
	是否包含请求参数.all,会把get和post请求的参数都带上
	<s:url value="testUrl" var="url6" includeParams="all"></s:url>
	${url6 }
	<br><br>
	s:set :向page,request,session,application域对象中加入一个属性值.
	<!-- 这里的value也会自动进行ognl解析. -->
	<s:set name="productName" value="productName" scope="request"></s:set>
	product:${requestScope.productName }
	<br><br>
	s:push :把一个对象在标签开始后压入到值栈中,标签结束时弹出值栈.
	<%
		Person person = new Person() ;
		person.setName("atguigu") ;
		person.setAge(10) ;
		request.setAttribute("person", person) ;
	%>
	<s:push value="#request.person">
	${name }
	</s:push>
	<br>
	---${name }---这个值已经没有了.
	<br><br>
	s:if,s:else,s:elseif:
	
	<br><br>
	<!-- 可以直接使用值栈中的属性 -->
	<s:if test="productPrice > 1000">
		I7处理器
	</s:if>
	<s:elseif test="productPrice > 800">
		I5处理器
	</s:elseif>
	<s:else>
		I3处理器
	</s:else>
	<br><br>
	<s:if test="#request.person.age > 10">
		大于10岁
	</s:if>
	<s:else>
		小于等于 10 岁
	</s:else>
	<br><br>
	s:iterator:遍历集合的.把这个遍历对象的每一个元素压入和弹出值栈
	<br><br>
	<%
		List<Person> persons = new ArrayList<Person>() ;
		persons.add(new Person("AA",10)) ;
		persons.add(new Person("EE",50)) ;
		persons.add(new Person("BB",20)) ;
		persons.add(new Person("DD",40)) ;
		persons.add(new Person("CC",30)) ;
		request.setAttribute("persons", persons) ;
	%>
	<s:iterator value="#request.persons" status="status">
		index:${status.index}-count:${status.count}-
		-测试status是在Map栈中:<s:property value="#status.index"/>--
		${name } - ${age }<br><!-- name和age是直接在栈顶取值的.栈顶中有一个person对象 -->
	</s:iterator>
	<br><br>
	<s:iterator value="[0].persons">
		${name } - ${age }<br><!-- name和age是直接在栈顶取值的. -->
	</s:iterator>
	<br><br>
	s:sort标签用来对一个可遍历对象里的元素进行排序.
	<br><br>
	<%
		PersonComparator pc = new PersonComparator() ;
		request.setAttribute("comparator", pc) ;
	%>
	<s:sort comparator="#request.comparator" source="[0].persons" var="persons2">
	</s:sort>
	<!-- #attr是按照这个顺序查找属性，顺序是page--->request----->session---->application； -->
	<s:iterator value="#attr.persons2">
		${name }--${age }<br>
	</s:iterator>
	<br><br>
	s:date可以对Date对象进行排版
	<br><br>
	<%
		Date date = new Date() ;
		session.setAttribute("date", date) ;
	%>
	<s:date name="#session.date" format="yyy-MM-dd hh:mm:ss" var="date2"/>
	${date2 }
	<br><br>
	a标签:构建一个
	<br><br>
	<!-- href属性不支持EL表达式,可以通过%{}把属性包装起来,使其进行强制的ognl解析-->
	<s:iterator value="persons">
		<s:a href="getPerson.action?name=%{name}" >${name }</s:a>
	</s:iterator>
	<br><br>
	<br><br>
	<br><br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>