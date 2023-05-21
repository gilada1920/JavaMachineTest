package com.NimapCrud.task.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NimapCrud.task.Dao.CategoryDao;
import com.NimapCrud.task.entities.Category;


@Service
public class CategoryService {

	@Autowired
	CategoryDao dao;
	
	public Category saveAllData(Category category)
	{
		return dao.saveAlldata(category);
	}
	
	public List<Category> getAllCategory()
	{
		return dao.getAllCategory();
		
	}
	public Category getCategory(int cid)
	{
		return dao.getCategory(cid);
	}
	
	public Category updateCategory(Category category)
	{
		return dao.updateCategory(category);
	}

	public Category deleteCategory(int cid) 
	{
		return dao.deleteCategory(cid);
	}
	
}
