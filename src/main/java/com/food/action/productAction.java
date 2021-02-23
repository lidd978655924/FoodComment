package com.food.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import com.food.dao.TCatelogDAO;
import com.food.dao.TProductDAO;
import com.food.model.TCatelog;
import com.food.model.TProduct;
import com.food.dao.TPingjiaDAO;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
public class productAction extends ActionSupport
{
	private int productId;
	private int productCatelogId;
	private String productName;
	private String productMiaoshu;
	private String fujian;
	private String productYanse;
	private int productShichangjia;
	private int productTejia;
	private String productShrq;
	private int catelogId;
	private int productKucun;

	private String message;
	private String path;

	private TProductDAO productDAO;
	private TCatelogDAO catelogDAO;
	private TPingjiaDAO pingjiaDAO;
	private int rukushuliang;

	public String productNoTejiaAdd()
	{
		TProduct product=new TProduct();
		product.setproductCatelogId(productCatelogId);
		product.setproductName(productName);
		product.setproductMiaoshu(productMiaoshu);
		product.setproductPic(fujian);
		product.setproductShichangjia(productShichangjia);
		if(productTejia==0)//特格为0表示没有特价
		{
			product.setproductTejia(productShichangjia);// 如果不是特价商品。把这个商品的特价设置为市场价格
			product.setproductIsnottejia("no");
		}
		else
		{
			product.setproductTejia(productTejia);
			product.setproductIsnottejia("yes");
		}

		product.setproductKucun(productKucun);
		product.setproductShrq(productShrq);
		product.setproductDel("no");
		product.setproducthaoping(0);
		product.setproductzhongping(0);
		product.setproductchaping(0);

		productDAO.save(product);
		this.setMessage("操作成功");
		this.setPath("productManaNoTejia.action");
		return "succeed";

	}
	public String importexcel()
	{
		HttpServletRequest request1=  ServletActionContext.getRequest();
		String fujian=request1.getParameter("fujian");
		fujian=ServletActionContext.getServletContext().getRealPath("/")+fujian;
		System.out.println(">>fujian>>"+fujian);
		File file = new File(fujian);//找到要导入的excel文件
		try{
			Workbook wb=Workbook.getWorkbook(file);
			//Workbook wb = Workbook.getWorkbook(file);//通过要导入的excel文件来生成一个workbook
			int sheetNum = wb.getSheets().length;
			for(int i = 0 ; i < sheetNum ; i++){
				Sheet sheet = wb.getSheet(i);
				int rowNum = sheet.getRows();
				//如果有标题列名的话，需要从第一行算起，不能包括第一行
				for(int j = 1 ; j < rowNum ; j++){
					//这里注意的是，sheet.getCell(列数，行数),不要把里面的参数搞反了
					//因为在数据库的id的自动增长的，所以在excel的这一列序号不需要写进来
					//String cellString1 = sheet.getCell(0, j).getContents();   
					String cellString2 = sheet.getCell(1, j).getContents();
					String cellString3 = sheet.getCell(2, j).getContents();
					//创建一个临时对象，而且用一个list来保存，然后到DAO层批量的插入
					TProduct product=new TProduct();
					product.setproductCatelogId(Integer.parseInt(cellString3));
					product.setproductName(cellString2);


					productDAO.save(product);
				}
			}
		}catch(Exception e)
		{

		}
		this.setMessage("操作成功");
		this.setPath("productManaNoTejia.action");
		return "succeed";

	}
	public String productNoTejiaDel()
	{
		TProduct product=productDAO.findById(productId);
		product.setproductDel("yes");
		productDAO.attachDirty(product);
		this.setMessage("操作成功");
		this.setPath("productManaNoTejia.action");
		return "succeed";
	}

	public String productManaNoTejia()
	{
		String sql="from TProduct where productDel='no' order by productIsnottejia";
		List productList=productDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<productList.size();i++)
		{
			TProduct product=(TProduct)productList.get(i);
			System.out.println(product.getproductCatelogId());
			product.setproductCatelogName(catelogDAO.findById(product.getproductCatelogId()).getCatelogName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("productList", productList);
		return ActionSupport.SUCCESS;
	}

	public String productShezhiTejia()
	{
		TProduct product=productDAO.findById(productId);
		product.setproductIsnottejia("yes");
		product.setproductTejia(productTejia);
		productDAO.attachDirty(product);
		return ActionSupport.SUCCESS;
	}


	public String productKucun()
	{
		String sql="from TProduct where productDel='no' order by productIsnottejia";
		List productList=productDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("productList", productList);
		return ActionSupport.SUCCESS;
	}

	public String productRuku()
	{
		TProduct product=productDAO.findById(productId);
		product.setproductKucun(product.getproductKucun()+rukushuliang);
		product.setproductTejia(productTejia);
		productDAO.attachDirty(product);
		return ActionSupport.SUCCESS;
	}
	
	/*public String productYesTejiaAdd()
	{
		TProduct product=new TProduct();
		product.setproductCatelogId(productCatelogId);
		product.setproductName(productName);
		product.setproductMiaoshu(productMiaoshu);
		product.setproductPic(fujian);
		product.setproductYanse(productYanse);
		product.setproductShichangjia(productShichangjia);
		product.setproductTejia(productTejia);
		product.setproductIsnottejia("yes");
		product.setproductDel("no");
		productDAO.save(product);
		this.setMessage("操作成功");
		this.setPath("productManaYesTejia.action");
		return "succeed";
		
	}
	
	public String productYesTejiaDel()
	{
		TProduct product=productDAO.findById(productId);
		product.setproductDel("yes");
		productDAO.attachDirty(product);
		this.setMessage("操作成功");
		this.setPath("productManaYesTejia.action");
		return "succeed";
	}
	
	
	public String productManaYesTejia()
	{
		String sql="from TProduct where productDel='no' and productIsnottejia='yes' order by productCatelogId";
		List productList=productDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<productList.size();i++)
		{
			TProduct product=(TProduct)productList.get(i);
			product.setproductCatelogName(catelogDAO.findById(product.getproductCatelogId()).getCatelogName());
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("productList", productList);
		return ActionSupport.SUCCESS;
	}*/

	public String productDetailHou()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");

		TProduct product=productDAO.findById(productId);
		request.put("product", product);
		return ActionSupport.SUCCESS;
	}



	public String productDetail()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");

		TProduct product=productDAO.findById(productId);
		product.setPingjiaList(pingjiaDAO.getHibernateTemplate().find("from TPingjia where del='no' and productId="+product.getproductId()));
		request.put("product", product);
		return ActionSupport.SUCCESS;
	}


	public String productAllYesTejia()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		List productYesTejiaList1=new ArrayList();

		String sql="from TProduct where productDel='no' and productIsnottejia='yes' order by productCatelogId";
		List productYesTejiaList=productDAO.getHibernateTemplate().find(sql);

		int pagesize=3;
		int pagecount=0;
		int zongcount=productYesTejiaList.size();
		if(zongcount% pagesize==0)
			pagecount=zongcount/pagesize;
		else
			pagecount=zongcount/pagesize+1;
		int topage= Integer.parseInt( ServletActionContext.getRequest().getParameter("topage"));
		int kaishi=(topage-1)*pagesize;
		int j=0;
		int showpage=topage;

		for(int i=0;i<productYesTejiaList.size();i++)
		{
			if(i>=kaishi && j<3)
			{
				TProduct product=(TProduct)productYesTejiaList.get(i);

				j++;
				productYesTejiaList1.add(product);
			}

		}


		request.put("showpage",showpage);
		request.put("pagecount",pagecount);
		request.put("productYesTejiaList", productYesTejiaList1);
		return ActionSupport.SUCCESS;
	}


	public String productAllNoTejia()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");

		List productYesTejiaList1=new ArrayList();
		String sql="from TProduct where productDel='no' and productIsnottejia='no' order by productCatelogId";
		List productYesTejiaList=productDAO.getHibernateTemplate().find(sql);



		int pagesize=3;
		int pagecount=0;
		int zongcount=productYesTejiaList.size();
		if(zongcount% pagesize==0)
			pagecount=zongcount/pagesize;
		else
			pagecount=zongcount/pagesize+1;
		int topage= Integer.parseInt( ServletActionContext.getRequest().getParameter("topage"));
		int kaishi=(topage-1)*pagesize;
		int j=0;
		int showpage=topage;

		for(int i=0;i<productYesTejiaList.size();i++)
		{
			if(i>=kaishi && j<3)
			{
				TProduct product=(TProduct)productYesTejiaList.get(i);

				j++;
				productYesTejiaList1.add(product);
			}

		}

		request.put("productYesTejiaList", productYesTejiaList1);
		request.put("showpage",showpage);
		request.put("pagecount",pagecount);
		return ActionSupport.SUCCESS;
	}


	public String productByCatelog()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");

		String sql="from TProduct where productDel='no' and productCatelogId=? order by productCatelogId";
		Object[] con={catelogId};
		List productByCatelogList=productDAO.getHibernateTemplate().find(sql,con);
		request.put("productByCatelogList", productByCatelogList);

		System.out.println(productByCatelogList.size()+"^^^"+productCatelogId);
		return ActionSupport.SUCCESS;
	}


	public String productearch()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		String sql="";
		if(catelogId==0)
		{
			System.out.println(productShrq);
			if(productShrq.equalsIgnoreCase("0"))
			{
				sql="from TProduct where productDel='no'  and productName like '%"+productName+"%'"+" order by productCatelogId";
			}
			else
			{
				sql="from TProduct where productDel='no' and  productShrq='"+productShrq+"' and productName like '%"+productName+"%'"+" order by productCatelogId";
			}
			System.out.println(sql);
		}
		else
		{
			sql="from TProduct where productDel='no' and productCatelogId="+catelogId+" and productName like '%"+productName+"%'"+" order by productCatelogId";
		}

		List productList=productDAO.getHibernateTemplate().find(sql);
		request.put("productList", productList);

		return ActionSupport.SUCCESS;
	}

	public int getCatelogId()
	{
		return catelogId;
	}

	public void setCatelogId(int catelogId)
	{
		this.catelogId = catelogId;
	}

	public int getproductCatelogId()
	{
		return productCatelogId;
	}
	public void setproductCatelogId(int productCatelogId)
	{
		this.productCatelogId = productCatelogId;
	}
	public TProductDAO getProductDAO()
	{
		return productDAO;
	}
	public void setProductDAO(TProductDAO productDAO)
	{
		this.productDAO = productDAO;
	}

	public int getRukushuliang()
	{
		return rukushuliang;
	}

	public void setRukushuliang(int rukushuliang)
	{
		this.rukushuliang = rukushuliang;
	}

	public int getproductId()
	{
		return productId;
	}
	public void setproductId(int productId)
	{
		this.productId = productId;
	}
	public String getproductMiaoshu()
	{
		return productMiaoshu;
	}
	public void setproductMiaoshu(String productMiaoshu)
	{
		this.productMiaoshu = productMiaoshu;
	}
	public String getproductName()
	{
		return productName;
	}

	public String getFujian()
	{
		return fujian;
	}

	public int getproductKucun()
	{
		return productKucun;
	}

	public void setproductKucun(int productKucun)
	{
		this.productKucun = productKucun;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public void setproductName(String productName)
	{
		this.productName = productName;
	}

	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}

	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}

	public int getproductShichangjia()
	{
		return productShichangjia;
	}
	public void setproductShichangjia(int productShichangjia)
	{
		this.productShichangjia = productShichangjia;
	}
	public int getproductTejia()
	{
		return productTejia;
	}
	public void setproductTejia(int productTejia)
	{
		this.productTejia = productTejia;
	}
	public String getproductYanse()
	{
		return productYanse;
	}
	public void setproductYanse(String productYanse)
	{
		this.productYanse = productYanse;
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
	//new edit
	public void setproductShrq(String productShrq)
	{
		this.productShrq= productShrq;
	}

	public String getproductShrq()
	{
		return this.productShrq;
	}
	public TPingjiaDAO getPingjiaDAO()
	{
		return pingjiaDAO;
	}

	public void setPingjiaDAO(TPingjiaDAO pingjiaDAO)
	{
		this.pingjiaDAO = pingjiaDAO;
	}
}
