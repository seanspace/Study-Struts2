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
	<!--  
		> 问题1:如何覆盖默认的错误消息?
			--在对应的 Action 类所在的包中新建  ActionClassName.properties 文件, 
				ClassName 即为包含着输入字段的 Action 类的类名
			--在文件中定义键值对:invalid.fieldvalue.fieldName=XXX
				如:参考ConversionAction.properties
		> 问题2:如果是simpl主题,会显示错误消息吗?如果不会显示,怎么办?
			-- 不会显示,需要使用标签(ognl或el)显示.如:${fieldErrors.age[0] }
			   * 在Action类的属性中有错误提示.这个属性叫fieldErrors,是一个Map<String,List<String>>键: 字段(属性名),值:错误消息组成的List.
				  所以使用${fieldErrors.age[0] }显示错误消息.
			-- 还可以使用s:fieldErrors标签来显示.可以通过fieldName属性显示指定字段的错误.
				如:<s:fielderror fieldName="age"></s:fielderror>
				* 不过这个标签在simple主题下有,样式和ul标签中.影响排版,怎么解决?
					Struts的core包中,template.simple下面的fielderror.ftl模板中定义simple主题下的s:fielderror标签显示错误消息的样式.
					所以修改配置文件即可,在src下新建template.simple包,新建fielderror.ftl文件,把原生的的文件内容,复制到fielderror.ftl中,然后剔除ul,li,span部分即可.
	-->
	
	<s:form action="%{servletContext.contextPath }/testConversion" theme="simple">
		Age:<s:textfield name="age" label="Age"></s:textfield>
		<br><br>
		值栈中的数据:fieldErrors	{age=[Age needs to be between 20 and 50]}
		${fieldErrors.age[0] }
		<br><br>
		<s:fielderror fieldName="age"></s:fielderror>
		<br><br>
		Birth:<s:textfield name="birth" label="Birth"></s:textfield>
		<s:fielderror fieldName="birth"></s:fielderror>
		<br><br>
		<br><br>
		
		<s:submit></s:submit>
	</s:form>
	<s:debug></s:debug>
</body>
</html>