<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		 <script language="JavaScript" src="<%=path %>/js/popup.js" type="text/javascript"></script>
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		<link href="css/Common.css" rel="stylesheet" type="text/css" />
		<link href="css/sitegeneric08.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		<script type="text/javascript">
	        function buy1(productKucun)
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            <s:else>
	            if(document.buy.quantity.value=="")
	            {
	                alert("请输入购买数量");
	                return false;
	            }
	            if(document.buy.quantity.value>productKucun)
	            {
	                alert("库存不足");
	                return false;
	            }
	            
	            document.buy.submit();
	            </s:else>
	        }
	         function pingjia(productId)
       {
                <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                var url="<%=path %>/qiantai/pingjia/pingjiaAdd.jsp?productId="+productId;
	                var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
		            pop.setContent("contentUrl",url);
		            pop.setContent("title","评价");
		            pop.build();
		            pop.show();
	            </s:else>
      }
	    </script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
			<!--左边的 -->
			<div class="page_main_msg left">		
		        <div class="left_row">
		            <div class="list pic_news">
		  	                <div class="list_bar">&nbsp;详情</div>
						  	<form action="<%=path %>/addToCart.action" method="post" name="buy">
                                  <table border="0" align="center" cellpadding="6">
                                   <tr><td width="30"></td><td style="font-size: 11px;">&nbsp;</td>
                                   <td style="font-size: 11px;"><div align="center"><img width="200" height="200" src="<%=path %>/<s:property value="#request.picNews.fujian"/>"/></div></td></tr>
                                     
                                       
                                      
                                      <tr><td width="30"></td><td style="font-size: 11px;">简介：</td><td style="font-size: 11px;"><div align="left">
                                       <s:property value="#request.picNews.picNewsContent" escape="false"/><hr/>
                                      </div>
                                        <div align="left"></div></td></tr>
                                     
                                      
                                     
                                     
                                  </table>
                      </form>
		             </div>
		              <div id="ccc" class="Sub">
				<div class="NewContainer770">
					
					<div class="Slot">
                         <div class="list_bar">
							 
					  </div>
                      
                    </div>
                    
				</div>
		 </div>
		         </div>	
	        </div>
			<!--左边的 -->
			<!-- 右边的用户登录。留言。投票 -->
			<div class="page_other_msg right">
				<div class="left_row">
					<div class="list">
						<div class="list_bar">
							用户登录
						</div>
						<div class="list_content">
							<div id="div">
								<jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
                <div class="left_row">
				    <div class="list">
				        <div class="list_bar">热门分类</div>
				        <div class="list_content">
				            <div id="div"> 
				                   <div style="overflow:hidden;height:200px;">
							             <div style="overflow:hidden;height:200px;">
										     <s:action name="catelogAll" executeResult="true" flush="true"></s:action>
							             </div>
						                 <div id="roll-copy-1607838439"></div>
				                   </div>
					        </div>
					    </div>
				    </div>
				</div>
				<div class="left_row">
				    <div class="list">
				        <div class="list_bar">网站公告</div>
				        <div class="list_content">
				            <div id="div"> 
				                   <div style="overflow:hidden;height:150px;">
							             <div id="roll-orig-1607838439">
										 <s:action name="gonggaoQian5" executeResult="true" flush="true"></s:action>
							             </div>
						                 <div id="roll-copy-1607838439"></div>
				                   </div>
					        </div>
					    </div>
				    </div>
				</div>
			</div>
			<div style="clear: both"></div>
			<!-- 右边的用户登录。留言。投票 -->
		</div>
		
		<div class="foot">
		   <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	    </div>
	</body>
</html>
