<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
      <table width="100%">
	     <s:iterator value="#request.picNewsList" id="picNews">
	          <tr>
	             <td align="left"><img src="<%=path %>/img/head-mark3.gif" align="middle" class="img-vm" border="0"/><a href="<%=path %>/picNewsDetailQian.action?picNewsId=<s:property value="#picNews.picNewsId"/>"><s:property value="#picNews.picNewsTitle"/></a></td>
	          </tr>
	     </s:iterator>
	  </table>
  </body>
</html>
