package com.NimapCrud.task.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NimapCrud.task.CustomException.ObjectNotFoundException;
import com.NimapCrud.task.Service.CategoryService;
import com.NimapCrud.task.entities.Category;



@RestController
@RequestMapping("categoryapi")
public class CategoryController {
		
	@Autowired
	CategoryService service;
	
	@PostMapping("insertCategory")
	public Category saveAllData(@RequestBody Category category)
	{
		 service.saveAllData(category);
		 return category;
	}
	

	@RequestMapping("getAllCategory")
	public List<Category> getAllCategory()
	{
		return service.getAllCategory();
		
	}
	
	@RequestMapping("getCategory/{cid}")
	public Category getCategory(@PathVariable int cid)
	{
		Category category = service.getCategory(cid);
		
		if(category==null)
		{
			throw new ObjectNotFoundException("No Record Found With cid "+cid);
		}else
		{
			return category;
		}
		
	}
	
	
	
	@PutMapping("updateCategory")
	public Category updateCategory(@RequestBody Category category)
	{
		return service.updateCategory(category);
		
	}
	
	@RequestMapping("deleteCategory/{cid}")
	public Category deleteCategory(@PathVariable int cid)
	{
		return service.deleteCategory(cid);
		
	}
	

}
