<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>title</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <s:form action="action1" namespace="/resubmit">
    	<s:token/>
    	<s:textfield name="name" label="姓名"></s:textfield>
    	<s:submit value="保存" onclick="forbidenBtn(this)"></s:submit>
    </s:form>
    <script type="text/javascript">
    	function forbidenBtn(btn){
    		btn.disabled=true;
    		document.forms[0].submit();
    	}
    </script>
  </body>
</html>
