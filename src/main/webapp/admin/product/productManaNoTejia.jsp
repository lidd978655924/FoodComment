<%@ page language="java" pageEncoding="UTF-8"%>
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

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function productDetailHou(productId)
           {
                 var url="<%=path %>/productDetailHou.action?productId="+productId;
                 var n="";
                 var w="480px";
                 var h="500px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
				 openWin(url,n,w,h,s);
           }
           
           function productNoTejiaDel(productId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/productNoTejiaDel.action?productId="+productId;
               }
           }
           
           function productNoTejiaAdd()
           {
                 var url="<%=path %>/admin/product/productNoTejiaAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           
           function productShezhiTejia(productId)
           {
                var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path %>/admin/product/productShezhiTejia.jsp?productId="+productId);
	            pop.setContent("title","文件上传");
	            pop.build();
	            pop.show();
           }
           
           function over(picPath)
	       {
			  if (picPath=="")picPath="/images/default.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }		
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="9" background="<%=path %>/images/tbg.gif">&nbsp;店铺管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">ID</td>
					<td width="10%">店铺名称</td>
					<td width="10%">店铺简介</td>
					<td width="10%">菜系</td>
					<td width="10%">店铺图片</td>
					<td width="10%">人均消费</td>
					<td width="10%">推荐店铺</td>
					<td width="10%">可接待人数</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.productList" id="product">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#product.productId"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#product.productName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a href="#" onclick="productDetailHou(<s:property value="#product.productId"/>)" class="pn-loperator">商品描述</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#product.productCatelogName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   <div onmouseover = "over('<%=path %>/<s:property value="#product.productPic"/>')" onmouseout = "out()" style="cursor:hand;">
								查看图片
					   </div>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					     <s:property value="#product.productShichangjia"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					     <s:if test="#product.productIsnottejia=='no'">不推荐&nbsp;&nbsp;&nbsp;
					         <a href="#" style="color: red" onclick="productShezhiTejia(<s:property value="#product.productId"/>)">推荐</a>
					     </s:if>
					     <s:if test="#product.productIsnottejia=='yes'">
					        <s:property value="#product.productTejia"/>
					     </s:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					     <s:property value="#product.productKucun"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="productNoTejiaDel(<s:property value="#product.productId"/>)" class="pn-loperator">删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <input type="button" value="添加" style="width: 80px;" onclick="productNoTejiaAdd()" />
			    </td>
			  </tr>
		    </table>
		    <div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
			<TABLE id="tipTable" border="0" bgcolor="#ffffee">
				<TR align="center">
					<TD><img id="photo" src="" height="80" width="80"></TD>
				</TR>
			</TABLE>
		</div>
	</body>
</html>
