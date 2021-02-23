<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'gonggaoQian5.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
      <table width="100%">
	          <tr>
	             <td align="left">
	                 <form action="<%=path %>/goodSearch.action" name="form1" method="post">
	                    名称：<input type="text" name="goodsName" size="8">
	                    <input type="submit" value="搜索" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;">
	                 </form>
                 </td>
	          </tr>
	  </table>
  </body>
</html>
