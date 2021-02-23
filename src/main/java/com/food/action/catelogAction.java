package com.food.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.food.dao.TCatelogDAO;
import com.food.dao.TProductDAO;
import com.food.model.TCatelog;
import com.opensymphony.xwork2.ActionSupport;

public class catelogAction extends ActionSupport
{
	private int catelogId;
	private String catelogName;
	private String catelogMiaoshu;
	
	private String message;
	private String path;
	
	private TCatelogDAO catelogDAO;
	private TProductDAO productDAO;
	
	
	public String catelogMana()
	{
		String sql="from TCatelog where catelogDel='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cateLogList", cateLogList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String catelogAll()
	{
		String sql="from TCatelog where catelogDel='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cateLogList", cateLogList);
		return ActionSupport.SUCCESS;
	}
	public String catelogAll1()
	{
		String sql="from TCatelog where catelogDel='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("cateLogList", cateLogList);
		return ActionSupport.SUCCESS;
	}
	
	public String catelogAdd()
	{
		TCatelog catelog=new TCatelog();
		catelog.setCatelogName(catelogName);
		catelog.setCatelogMiaoshu(catelogMiaoshu);
		catelog.setCatelogDel("no");
		catelogDAO.save(catelog);
		this.setMessage("操作成功");
		this.setPath("catelogMana.action");
		return "succeed";
	}
	
	public String catelogDel()
	{
		String sql="from TProduct where productDel='no' and productCatelogId="+catelogId;
		List productList=productDAO.getHibernateTemplate().find(sql);
		if(productList.size()>0)
		{
			this.setMessage("请先删除此类别下的商品");
			this.setPath("catelogMana.action");
		}
		else
		{
			TCatelog catelog=catelogDAO.findById(catelogId);
			catelog.setCatelogDel("yes");
			catelogDAO.attachDirty(catelog);
			this.setMessage("操作成功");
			this.setPath("catelogMana.action");
		}
		return "succeed";
	}
	
	
	public String catelogEditPre()
	{
			TCatelog catelog=catelogDAO.findById(catelogId);
			Map request=(Map)ServletActionContext.getContext().get("request");
			request.put("catelog", catelog);
			return ActionSupport.SUCCESS;
	}
	
	public String catelogEdit()
	{
		TCatelog catelog=catelogDAO.findById(catelogId);
		catelog.setCatelogName(catelogName);
		catelog.setCatelogMiaoshu(catelogMiaoshu);
		catelog.setCatelogDel("no");
		catelogDAO.attachDirty(catelog);
		this.setMessage("操作成功");
		this.setPath("catelogMana.action");
		return "succeed";
	}
	

	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}

	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}

	public int getCatelogId()
	{
		return catelogId;
	}

	public void setCatelogId(int catelogId)
	{
		this.catelogId = catelogId;
	}

	public String getCatelogMiaoshu()
	{
		return catelogMiaoshu;
	}

	public void setCatelogMiaoshu(String catelogMiaoshu)
	{
		this.catelogMiaoshu = catelogMiaoshu;
	}

	public String getCatelogName()
	{
		return catelogName;
	}

	public void setCatelogName(String catelogName)
	{
		this.catelogName = catelogName;
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



	public TProductDAO getProductDAO()
	{
		return productDAO;
	}



	public void setProductDAO(TProductDAO productDAO)
	{
		this.productDAO = productDAO;
	}
	

}
