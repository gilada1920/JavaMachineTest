package com.NimapCrud.task.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.NimapCrud.task.Dao.ProductDao;
import com.NimapCrud.task.entities.Product;
import com.NimapCrud.task.entities.ProductInfo;




@Service
public class ProductService {
	
	@Autowired
	ProductDao dao;
	public Product addProduct(@RequestBody Product product,@PathVariable int cid)
	{
		
		return dao.addProduct(product, cid);
		
	}
	
	
	public Product updateProduct(@RequestBody Product clientProduct)
	{
				return dao.updateProduct(clientProduct);

	}
	
	public List<Product> allProducts()
	{
		return dao.allProducts();
	}
	

	public List<ProductInfo> allProductsWithCategory(int pid)
	{
		return dao.allProductsWithCategory(pid);
	}
	
	public Product deleteProduct(int pid)
	{
		return dao.deleteProduct(pid);
	}
	

}
