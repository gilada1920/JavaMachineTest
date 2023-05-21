package com.NimapCrud.task.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.NimapCrud.task.entities.Category;
import com.NimapCrud.task.entities.Product;
import com.NimapCrud.task.entities.ProductInfo;



@Repository
public class ProductDao {
	
	@Autowired
	SessionFactory factory;
	
	public Product addProduct(@RequestBody Product product,@PathVariable int cid)
	{
		System.out.println("Category id is " + cid);
		
		Session session=factory.openSession();
		
		Category category=session.load(Category.class,cid);
		
		System.out.println("Products from given catergory are :- " + category.getProduct());
		
		List<Product> productlist=category.getProduct();
					
		Transaction transaction=session.beginTransaction();
		
		productlist.add(product);
						
		transaction.commit();
				
		System.out.println("product added into database");
		
		return product;
		
	}

	public Product updateProduct(@RequestBody Product clientProduct)
	{
				Session session=factory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.update(clientProduct);
								
				transaction.commit();
								
				return clientProduct;

	}
	
	public List<Product> allProducts()
	{
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> list=criteria.list();
		return list;
		
	}
	
	
	public List<ProductInfo> allProductsWithCategory(int pid)
	{
		Session session=factory.openSession();
		
		Query query=session.createSQLQuery("select product.pid,product.p_name,product.p_price,product.p_discount,category.cid,category.cname from product join category on product.cid=category.cid and pid="+pid);
		
		List<Object[]> list=query.list();
		
		List<ProductInfo> arrayList=new ArrayList<ProductInfo>();
					
		for (Object[] array : list) 
		{
			arrayList.add(new ProductInfo((int)array[0], (String)array[1], (int)array[2],(String)array[3], (int)array[4], (String)array[5]));
		}
		
		return arrayList;
	}
	
	
	public Product deleteProduct(int pid)
	{
		Session session=factory.openSession();
		Product product=session.get(Product.class,pid);
		
		Transaction tx=session.beginTransaction();
				session.delete(product);
		tx.commit();
		
		return product;
	}
}
