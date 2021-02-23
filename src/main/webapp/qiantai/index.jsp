<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
	    <script type="text/javascript">
	    </script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
		    <!--左边的 -->
			<div class="page_main_msg left">
				<!-- 排行榜 -->
				<div class="left_row">
					<div class="list pic_news">
						<div class="list_bar">
							滁州当地美食
						</div>
						<div id="tw" class="list_content">
							<div style="width:100%;overflow:hidden;white-space:nowrap;">
								<table width="100%" align="left" cellpadding="0" cellspacing="0" border="0">
									<tr>
									    <s:iterator value="#request.picNewsList" id="picNews">
										<td>
											<table width="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td sytle="height:28px;">
														<dl style="width:100%;height:130px;padding-right:10px;">
															<dd style="margin-left:0;">
																<a href="<%=path %>/picNewsDetailQian.action?picNewsId=<s:property value="#picNews.picNewsId"/>">
																   <img width="105" height="72" src="<%=path %>/<s:property value="#picNews.fujian"/>"/>
																</a>
															</dd>
															<dt>
																<s:property value="#picNews.picNewsTitle"/>
															</dt>
															<dt>
															
															</dt>
														</dl>
													</td>
												</tr>
											</table>
										</td>
										</s:iterator>
									</tr>
								</table>
							</div>
						 </div>
					</div>
				</div>
				<!-- 排行榜 -->
				<!-- 特价 -->
				<div class="left_row">
					<div class="list pic_news">
						<div class="list_bar">
							 <span style="float:left">推荐店铺</span>
							 <span style="float:right"><a href="<%=path %>/productAllYesTejia.action?topage=1">更多>></a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
						</div>
						<div id="tw" class="list_content">
							<div style="width:100%;overflow:hidden;white-space:nowrap;">
								<table width="100%" align="left" cellpadding="0" cellspacing="0" border="0">
									<tr>
									    <s:iterator value="#request.productYesTejiaList" id="product">
										<td>
											<table width="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td sytle="height:28px;">
														<dl style="width:100%;height:130px;padding-right:10px;">
															<dd style="margin-left:0;">
																<a href="<%=path %>/productDetail.action?productId=<s:property value="#product.productId"/>">
																   <img width="105" height="72" src="<%=path %>/<s:property value="#product.productPic"/>"/>
																</a>
															</dd>
															<dt>
																<s:property value="#product.productName"/>
															</dt>
															<dt>
																<s>人均消费:<s:property value="#product.productShichangjia"/></s>
																(推荐优惠:<s:property value="#product.productTejia"/>)
															</dt>
														</dl>
													</td>
												</tr>
											</table>
										</td>
										</s:iterator>
									</tr>
								</table>
							</div>
						 </div>
					</div>
				</div>
				<!-- 特价 -->
				<!-- 新品上市 -->
				<div class="left_row">
					<div class="list pic_news">
						<div class="list_bar">
							 <span style="float:left">新加入店铺</span>
							 <span style="float:right"><a href="<%=path %>/productAllNoTejia.action?topage=1">更多>></a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
						</div>
						<div id="tw" class="list_content">
							<div style="width:100%;overflow:hidden;white-space:nowrap;">
								<table width="100%" align="left" cellpadding="0" cellspacing="0" border="0">
									<tr>
									    <s:iterator value="#request.productNoTejiaList" id="product">
										<td>
											<table width="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td sytle="height:28px;">
														<dl style="width:100%;height:130px;padding-right:10px;">
															<dd style="margin-left:0;">
																<a href="<%=path %>/productDetail.action?productId=<s:property value="#product.productId"/>">
																   <img width="105" height="72" src="<%=path %>/<s:property value="#product.productPic"/>"/>
																</a>
															</dd>
															<dt>
																<s:property value="#product.productName"/>
															</dt>
															<dt>
																人均消费:<s:property value="#product.productShichangjia"/>
															</dt>
														</dl>
													</td>
												</tr>
											</table>
										</td>
										</s:iterator>
									</tr>
								</table>
							</div>
						 </div>
					</div>
				</div>
				<!-- 新品上市 -->
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
