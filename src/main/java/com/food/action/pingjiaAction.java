package com.food.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import com.food.dao.TGonggaoDAO;
import com.food.dao.TPingjiaDAO;
import com.food.dao.TProductDAO;

import com.food.model.TAdmin;
import com.food.model.TGonggao;
import com.food.model.TPingjia;
import com.food.model.TUser;
import com.food.model.TProduct;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.food.model.TUser;
public class pingjiaAction extends ActionSupport
{
	private TProductDAO productDAO;
	
	
	private int id;
	private String content1;
	
	private int productId;
	private String message;
	private String path;
	private Integer haoping;

	private Integer zhongping;
	private Integer chaping;
	private TPingjiaDAO pingjiaDAO;
	
	public String pingjiaAdd()
	{
       Map session=ActionContext.getContext().getSession();
       HttpServletRequest request1 =ServletActionContext.getRequest();
     
       
       int userid=0;
       int flag=0;//用来标识是否卖过此商品
		if(session.get("user")!=null)
		{
			TUser user=(TUser)session.get("user");
			userid=user.getUserId();
		}
		String sql="from TOrderItem  where productId="+productId;
		
			  String pingjiafen=request1.getParameter("pingjiafen");
			  int temphaoping=0;
			  int tempzhongping=0;
			  int tempchaping=0;
			 
		   TPingjia pingjia=new TPingjia();
		   if("好评".equals(pingjiafen))
			  {
			   temphaoping=1;
				 pingjia.setHaoping(1);
				 pingjia.setZhongping(0);
				 pingjia.setChaping(0);
			  }
		   if("中评".equals(pingjiafen))
			  {
			      tempzhongping=1;
				 pingjia.setHaoping(0);
				 pingjia.setZhongping(1);
				 pingjia.setChaping(0);
			  }
		   if("差评".equals(pingjiafen))
			  {
			     tempchaping=1;
				 pingjia.setHaoping(0);
				 pingjia.setZhongping(0);
				 pingjia.setChaping(1);
			  }
		   
		   
		   pingjia.setContent(content1);
		   pingjia.setShijian(new Date().toLocaleString());
		   pingjia.setproductId(productId);
		   pingjia.setDel("no");
		   pingjia.setUserId(userid);
		   pingjiaDAO.save(pingjia);

		//更改信息里评价的统计
		   productDAO.getHibernateTemplate().bulkUpdate("update TProduct set producthaoping=producthaoping+"+temphaoping + ",productzhongping=productzhongping+" + tempzhongping+ ",productchaping=productchaping+" + tempchaping+   " where productId="+productId);
		   //
		   return ActionSupport.SUCCESS;
		
	}
	
	
	public String pingjiaMana()
	{
		String sql="from TPingjia where del='no'";
		List pingjiaList =pingjiaDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("pingjiaList", pingjiaList);
		return ActionSupport.SUCCESS;
	}
	
	public String pingjiaDel()
	{
		TPingjia pingjia=pingjiaDAO.findById(id);
		pingjia.setDel("yes");
		pingjiaDAO.attachDirty(pingjia);
		this.setMessage("删除完毕");
		this.setPath("pingjiaMana.action");
		return "succeed";
	}




	public String getContent1()
	{
		return content1;
	}


	public void setContent1(String content1)
	{
		this.content1 = content1;
	}


	public int getproductId()
	{
		return productId;
	}


	public void setproductId(int productId)
	{
		this.productId = productId;
	}


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public String getMessage()
	{
		return message;
	}


	public void setMessage(String message)
	{
		this.message = message;
	}


	public String getPath()
	{
		return path;
	}


	public void setPath(String path)
	{
		this.path = path;
	}


	public TPingjiaDAO getPingjiaDAO()
	{
		return pingjiaDAO;
	}


	public void setPingjiaDAO(TPingjiaDAO pingjiaDAO)
	{
		this.pingjiaDAO = pingjiaDAO;
	}
	
	public void setProductDAO(TProductDAO productDAO)
	{
		this.productDAO = productDAO;
	}
	public TProductDAO getProductDAO()
	{
		return productDAO;
	}
	
	public Integer getHaoping() {
		return haoping;
	}

	public void setHaoping(Integer haoping) {
		this.haoping = haoping;
	}

	public Integer getZhongping() {
		return zhongping;
	}

	public void setZhongping(Integer zhongping) {
		this.zhongping = zhongping;
	}

	public Integer getChaping() {
		return chaping;
	}

	public void setChaping(Integer chaping) {
		this.chaping = chaping;
	}
}
