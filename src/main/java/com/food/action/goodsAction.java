package com.food.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.food.dao.TCatelogDAO;
import com.food.dao.TGoodsDAO;
import com.food.dao.TPingjiaDAO;
import com.food.model.TCatelog;
import com.food.model.TGoods;
import com.food.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

public class goodsAction extends ActionSupport
{
	private int goodsId;
	private int goodsCatelogId;
	private String goodsName;
	private String goodsMiaoshu;
	private String fujian;
	private String goodsYanse;
	private String goodsIsnottuijian;
	private int catelogId;
	
	private String message;
	private String path;
	
	private TGoodsDAO goodsDAO;
	private TCatelogDAO catelogDAO;
	private TPingjiaDAO pingjiaDAO;
	
	public String goodsAdd()
	{
		TGoods goods=new TGoods();
		goods.setGoodsCatelogId(goodsCatelogId);
		goods.setGoodsName(goodsName);
		goods.setGoodsMiaoshu(goodsMiaoshu);
		goods.setGoodsPic(fujian);
		goods.setGoodsYanse(goodsYanse);
		goods.setGoodsIsnottuijian(goodsIsnottuijian);
		goods.setGoodsTejia(0);//�����
		
		goods.setGoodsDel("no");
		goodsDAO.save(goods);
		this.setMessage("操作成功");
		this.setPath("goodsMana.action");
		return "succeed";
		
	}
	
	public String goodsDel()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		goods.setGoodsDel("yes");
		goodsDAO.attachDirty(goods);
		this.setMessage("操作成功");
		this.setPath("goodsMana.action");
		return "succeed";
	}
	
	public String goodsMana()
	{
		String sql="from TGoods where goodsDel='no' ";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<goodsList.size();i++)
		{
			TGoods goods=(TGoods)goodsList.get(i);
			//System.out.println(goods.getGoodsCatelogId());
		//	goods.setGoodsCatelogName(catelogDAO.findById(goods.getGoodsCatelogId()).getCatelogName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String goodsDetail()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TGoods goods=goodsDAO.findById(goodsId);
		goods.setGoodsTejia(goods.getGoodsTejia()+1);
		goodsDAO.attachDirty(goods);
		
		//goods.setPingjiaList(pingjiaDAO.getHibernateTemplate().find("from TPingjia where del='no' and goodsId="+goods.getGoodsId()));
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsDetailHou()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TGoods goods=goodsDAO.findById(goodsId);
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	public String goodsTuijian()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		goods.setGoodsIsnottuijian("yes");
		goodsDAO.attachDirty(goods);
		this.setMessage("操作成功");
		this.setPath("goodsMana.action");
		return "succeed";
	}
	
	public String goodsTuijianQuxiao()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		goods.setGoodsIsnottuijian("no");
		goodsDAO.attachDirty(goods);
		this.setMessage("操作成功");
		this.setPath("goodsMana.action");
		return "succeed";
	}
	
	public String goodsAll()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		String sql="from TGoods where goodsDel='no' order by goodsCatelogId";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsAllTui()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		
		String sql="from TGoods where goodsDel='no' and goodsIsnottuijian='yes' order by goodsCatelogId";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsByCatelog()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TGoods where goodsDel='no' and goodsCatelogId=? order by goodsCatelogId";
		Object[] con={catelogId};
		List goodsList=goodsDAO.getHibernateTemplate().find(sql,con);
		request.put("goodsList", goodsList);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodSearch()
	{
		System.out.println(goodsName);
        Map request=(Map)ServletActionContext.getContext().get("request");
        String sql="from TGoods where goodsDel='no' and goodsName like '%"+goodsName.trim()+"%'"+" order by goodsCatelogId";
		
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsList", goodsList);
		
		return ActionSupport.SUCCESS;
	}
	
	

	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}


	public TPingjiaDAO getPingjiaDAO()
	{
		return pingjiaDAO;
	}

	public void setPingjiaDAO(TPingjiaDAO pingjiaDAO)
	{
		this.pingjiaDAO = pingjiaDAO;
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

	public String getFujian()
	{
		return fujian;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public int getGoodsCatelogId()
	{
		return goodsCatelogId;
	}

	public void setGoodsCatelogId(int goodsCatelogId)
	{
		this.goodsCatelogId = goodsCatelogId;
	}

	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}

	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}

	public int getGoodsId()
	{
		return goodsId;
	}

	public void setGoodsId(int goodsId)
	{
		this.goodsId = goodsId;
	}

	public String getGoodsIsnottuijian()
	{
		return goodsIsnottuijian;
	}

	public void setGoodsIsnottuijian(String goodsIsnottuijian)
	{
		this.goodsIsnottuijian = goodsIsnottuijian;
	}

	public String getGoodsMiaoshu()
	{
		return goodsMiaoshu;
	}

	public void setGoodsMiaoshu(String goodsMiaoshu)
	{
		this.goodsMiaoshu = goodsMiaoshu;
	}

	public String getGoodsName()
	{
		return goodsName;
	}

	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}

	public String getGoodsYanse()
	{
		return goodsYanse;
	}

	public void setGoodsYanse(String goodsYanse)
	{
		this.goodsYanse = goodsYanse;
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
	
}
