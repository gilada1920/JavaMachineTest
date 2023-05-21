package com.NimapCrud.task.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NimapCrud.task.Service.ProductService;
import com.NimapCrud.task.entities.Product;
import com.NimapCrud.task.entities.ProductInfo;



@RestController
@RequestMapping("productapi")
public class ProductController {

	
	@Autowired
	 ProductService service;
	
	@PostMapping("insertProduct/{cid}")
	public Product addProduct(@RequestBody Product product,@PathVariable int cid)
	{
		
		return service.addProduct(product, cid);
	}
	
	
	@PutMapping("updateProduct")
	public Product updateProduct(@RequestBody Product clientProduct)
	{
		return service.updateProduct(clientProduct);

	}
	
	
	
	@RequestMapping("getAllProducts")
	public List<Product> allProducts()
	{
		
		return service.allProducts();
	}
	
	@RequestMapping("getProductById/{pid}")
	public List<ProductInfo> allProductsWithCategory(@PathVariable int pid)
	{
		return service.allProductsWithCategory(pid);
	}
	
	@RequestMapping("deleteProduct/{pid}")
	public Product deleteProduct(@PathVariable int pid)
	{
		return service.deleteProduct(pid);
	}

}
