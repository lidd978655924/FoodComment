package com.food.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.food.model.TProduct;

/**
 * Data access object (DAO) for domain model class TProduct.
 * 
 * @see com.food.model.TProduct
 * @author MyEclipse Persistence Tools
 */

public class TProductDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TProductDAO.class);

	// property constants
	public static final String product_NAME = "productName";

	public static final String product_MIAOSHU = "productMiaoshu";

	public static final String product_PIC = "productPic";

	public static final String product_YANSE = "productYanse";

	public static final String product_SHICHANGJIA = "productShichangjia";

	public static final String product_TEJIA = "productTejia";

	public static final String product_ISNOTTEJIA = "productIsnottejia";

	public static final String product_ISNOTTUIJIAN = "productIsnottuijian";

	public static final String product_CATELOG_ID = "productCatelogId";
	public static final String product_SHRQ= "productShrq";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TProduct transientInstance)
	{
		log.debug("saving TProduct instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TProduct persistentInstance)
	{
		log.debug("deleting TProduct instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TProduct findById(java.lang.Integer id)
	{
		log.debug("getting TProduct instance with id: " + id);
		try
		{
			TProduct instance = (TProduct) getHibernateTemplate().get(
					"com.food.model.TProduct", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TProduct instance)
	{
		log.debug("finding TProduct instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TProduct instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TProduct as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByproductName(Object productName)
	{
		return findByProperty(product_NAME, productName);
	}

	public List findByproductMiaoshu(Object productMiaoshu)
	{
		return findByProperty(product_MIAOSHU, productMiaoshu);
	}

	public List findByproductPic(Object productPic)
	{
		return findByProperty(product_PIC, productPic);
	}

	public List findByproductYanse(Object productYanse)
	{
		return findByProperty(product_YANSE, productYanse);
	}

	public List findByproductShichangjia(Object productShichangjia)
	{
		return findByProperty(product_SHICHANGJIA, productShichangjia);
	}

	public List findByproductTejia(Object productTejia)
	{
		return findByProperty(product_TEJIA, productTejia);
	}

	public List findByproductIsnottejia(Object productIsnottejia)
	{
		return findByProperty(product_ISNOTTEJIA, productIsnottejia);
	}

	public List findByproductIsnottuijian(Object productIsnottuijian)
	{
		return findByProperty(product_ISNOTTUIJIAN, productIsnottuijian);
	}

	public List findByproductCatelogId(Object productCatelogId)
	{
		return findByProperty(product_CATELOG_ID, productCatelogId);
	}
	
	public List findByproductShrq(Object productShrq)
	{
		return findByProperty(product_SHRQ, productShrq);
	}

	public List findAll()
	{
		log.debug("finding all TProduct instances");
		try
		{
			String queryString = "from TProduct";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TProduct merge(TProduct detachedInstance)
	{
		log.debug("merging TProduct instance");
		try
		{
			TProduct result = (TProduct) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TProduct instance)
	{
		log.debug("attaching dirty TProduct instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TProduct instance)
	{
		log.debug("attaching clean TProduct instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TProductDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TProductDAO) ctx.getBean("TProductDAO");
	}
}