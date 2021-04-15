<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>常用struts2UI标签库</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 引入struts2框架内置的一些js和css样式 -->
	<s:head/>
  </head>
  
  <body>
  	<!-- s:form
  		作用：产生一个html中的form标签。
  		属性：
  			method：默认值就是post
  			cssClass:样式类
  			cssStyle：样式
  	 -->
    <s:form action="action1">
    	<!-- 生成input type="text"的文本输入域 -->
    	<s:textfield name="username" label="用户名" requiredLabel="true" value="二狗子"></s:textfield>
    	<s:password name="password" label="密码" requiredLabel="true"></s:password>
    	<!-- s:radio
    			list:是一个ognl表达式。
    				 ognl可以创建list对象：{'男','v女'}
    				 ognl可以创建Map对象：井{key1:value1,key2:value2,...}
    			value:是一个OGNL表达式
    	 -->
    	<s:radio name="gender1" list="{'男','女'}" label="性别1"></s:radio>
    	<!-- 如果是map类型：value是key值；lable是value值 -->
    	<s:radio name="gender2" list="#{1:'男',0:'女'}" label="性别2"></s:radio>
    	<!-- 默认选中女 -->
    	<s:radio name="gender4" list="#{1:'男',0:'女'}" label="性别4" value="1"></s:radio>
    	<!-- 如果是map类型：value是value值；lable是key值
    		listKey:ognl表达式。获取当前元素的getKey作为html的value值
    		listValue:ognl表达式。获取当前元素的getValue作为html的lable值
    	 -->
    	<s:radio name="gender3" list="#{1:'男',0:'女'}" label="性别3" listKey="value" listValue="key"></s:radio>
    	<s:radio name="gender5" list="#{1:'男',0:'女'}" label="性别5" listKey="value" listValue="key" value="'女'"></s:radio>
    	
    	<s:checkboxlist name="hobby" list="#{'eat':'吃饭','sleep':'睡觉','java':'学java'}" label="爱好" value="{'sleep','eat'}"></s:checkboxlist>
    	<s:select name="address1" list="#{'BJ':'北京','SD':'山东','HB':'湖北'}" label="故乡1"></s:select>
    	<s:select name="address2" list="#{'BJ':'北京','SD':'山东','HB':'湖北'}" label="故乡2" headerKey="" headerValue="--请选择--"></s:select>
    	<s:select name="address3" list="#{'BJ':'北京','SD':'山东','HB':'湖北'}" label="故乡3" headerKey="" headerValue="--请选择--" value="'SD'"></s:select>
    	<s:textarea name="description" rows="3" cols="38" label="简介"></s:textarea>
    	<s:file name="photo" label="玉照"></s:file>
    	<s:submit value="保存"></s:submit>
    	<s:reset value="重置"></s:reset>
    </s:form>
  </body>
</html>
