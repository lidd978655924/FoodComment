<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  		<link href="<%=path %>/css/Common.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript">
         function huiyuanzhongxin()
	        {
	            <s:if test="#session.user==null">
				     alert("请先登录");
				</s:if>
				<s:else>
				     var url="<%=path %>/qiantai/auser/index.jsp";
					 window.open(url);
				</s:else>  
	        }
	        function myXinxi()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                var url="<%=path %>/qiantai/userinfo/userXinxi.jsp";
	                var n="";
	                var w="480px";
	                var h="500px";
	                var s="resizable:no;help:no;status:no;scroll:yes";
				    openWin(url,n,w,h,s);
	            </s:else>
	        }
	        function myCart()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 var s="<%=path %>/myCart.action";
	                 window.location.href=s;
	            </s:else>
	        }
	        
	        function myOrder()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 var s="<%=path %>/myOrder.action";
	                 window.location.href=s;
	            </s:else>
	        }
	        
	        function liuyanAll()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 var url="<%=path %>/liuyanAll.action";
				     window.open(url,"_blank");
	            </s:else>
	        }
      </script>
  </head>
  
  <body>
  
        <center><img src="<%=path %>/img/banner.jpg" height="200" width="966"></center>
		<div class="topmenu cbody1">
			<ul>
				<li class="thisclass">
					<A href="<%=path %>/qiantai/default.jsp">首页</A>
				</li>
				<li class="thisclass">
		           <a href="<%=path %>/goodsAll.action">美食美文</a>
				</li>
				
				<li class="thisclass">
					<A href="#" onclick="huiyuanzhongxin()">用户中心</A>
				</li>
				
				<li class="thisclass">
		           <a href="<%=path %>/goodsAll.action">联系我们</a>
				</li>
			</ul>
		</div>
		
        
			<form id="searchForm" action="<%=path %>/productearch.action" method="post">
			<div class="topsearch">
				<div class="title"></div>
				<div id="page_search_left">
					<input class="inputText" id="productName" size="16" onKeyPress="if(event.keyCode==13){searchFormSubmit();return false;}" name="productName" type="text" />
				</div>
				<div id="page_search_btn">
					
								
									        <select name="productShrq" id="productShrq" >
								              <option value="0">请选择条件</option>
								               <option value="店铺名">店铺名</option>
								                <option value="关键字">关键字</option>
								                 
								                
						                  </select>
									        <input type="submit" value="搜索"><br/>
				</div>
				</div>
				
				<div style="clear: both"></div>
		
		</form>
	
  </body>
</html>
