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
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function goodsDel(goodsId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/goodsDel.action?goodsId="+goodsId;
               }
           }



           function goodsAdd()
           {
                 var url="<%=path %>/admin/goods/goodsAdd.jsp";
				 window.location.href=url;
           }

           function goodsTuijian(goodsId)
           {
                 var url="<%=path %>/goodsTuijian.action?goodsId="+goodsId;
				 window.location.href=url;
           }

           function goodsTuijianQuxiao(goodsId)
           {
                 var url="<%=path %>/goodsTuijianQuxiao.action?goodsId="+goodsId;
				 window.location.href=url;
           }

           function over(picPath)
	       {
			  if (picPath=="")picPath="/img/default.jpg";
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
		   function xiangqin(goodsId)
	       {
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:400});
	            pop.setContent("contentUrl","<%=path %>/goodsDetailHou.action?goodsId="+goodsId);
	            pop.setContent("title","文章详细介绍");
	            pop.build();
	            pop.show();
	       }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background="<%=path %>/img/tbg.gif">&nbsp;文章管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="30%">文章名称</td>
					<td width="10%">文章描述</td>

					<td width="10%">文章图片</td>

					<td width="10%">浏览量</td>
					<td width="10%">操作</td>
		        </tr>
				<s:iterator value="#request.goodsList" id="goods">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#goods.goodsName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a href="#" onclick="xiangqin(<s:property value="#goods.goodsId"/>)">查看文章详情</a>
					</td>

					<td bgcolor="#FFFFFF" align="center">
					   <div onmouseover = "over('<%=path %>/<s:property value="#goods.goodsPic"/>')" onmouseout = "out()" style="cursor:hand;">
								查看图片
					   </div>
					</td>

					<td bgcolor="#FFFFFF" align="center">
					     <s:property value="#goods.goodsTejia"/>&nbsp;&nbsp;

					     <s:if test="#goods.goodsIsnottuijian=='no'">
					          <a href="#" style="color: red;font-size: 10px;" onclick="goodsTuijian(<s:property value="#goods.goodsId"/>)">推荐</a>
                         </s:if>
                         &nbsp;&nbsp;
					     <s:if test="#goods.goodsIsnottuijian=='yes'">
					          <a href="#" style="color: red;font-size: 10px;" onclick="goodsTuijianQuxiao(<s:property value="#goods.goodsId"/>)">取消推荐</a>
                         </s:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="goodsDel(<s:property value="#goods.goodsId"/>)" class="pn-loperator">删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>

			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <input type="button" value="添加" style="width: 80px;" onclick="goodsAdd()" />
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
