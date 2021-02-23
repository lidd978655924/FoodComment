package com.food.action;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.food.dao.TCatelogDAO;
import com.food.dao.TProductDAO;

import com.food.model.TProduct;

import com.food.dao.TCatelogDAO;
import com.food.dao.TPicNewsDAO;
import com.food.model.TCatelog;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private TProductDAO productDAO;


	private TCatelogDAO catelogDAO;
	private TPicNewsDAO picNewsDAO;

	public TPicNewsDAO getPicNewsDAO() {
		return picNewsDAO;
	}


	public void setPicNewsDAO(TPicNewsDAO picNewsDAO) {
		this.picNewsDAO = picNewsDAO;
	}


	public String index()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");

		List picNewsList =picNewsDAO.findAll();

		request.put("picNewsList", picNewsList);


		String sql="from TProduct where productDel='no' and productIsnottejia='yes' order by productId desc";
		List productYesTejiaList=productDAO.getHibernateTemplate().find(sql);
		if(productYesTejiaList.size()>5)
		{
			productYesTejiaList=productYesTejiaList.subList(0, 5);
		}
		request.put("productYesTejiaList", productYesTejiaList);



		sql="from TProduct where productDel='no' and productIsnottejia='no' order by productId desc";
		List productNoTejiaList=productDAO.getHibernateTemplate().find(sql);
		if(productNoTejiaList.size()>5)
		{
			productNoTejiaList=productNoTejiaList.subList(0, 5);
		}
		request.put("productNoTejiaList", productNoTejiaList);


		//paihangbang
		//	List productList=new ArrayList();
		//	sql="select sum(productQuantity),productId from TOrderItem group by productId order by sum(productQuantity) desc";
		//	List list=orderItemDAO.getHibernateTemplate().find(sql);
		//	for(int i=0;i<list.size();i++)
		//{
		//	Object[] b=(Object[])list.get(i);
		//int productId=Integer.parseInt(b[1].toString());
		//	System.out.println(productId+"&&");
		//TProduct product=productDAO.findById(productId);
		//	productList.add(product);
		//	}
		//	if(productList.size()>5)
		//{
		//	productList=productList.subList(0, 5);
		//	}
		//	request.put("productList", productList);
		//类别
		sql="from TCatelog where catelogDel='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);

		request.put("cateLogList", cateLogList);

		return ActionSupport.SUCCESS;
	}


	public TProductDAO getProductDAO()
	{
		return productDAO;
	}

	public void setProductDAO(TProductDAO productDAO)
	{
		this.productDAO = productDAO;
	}



	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}

	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}

}