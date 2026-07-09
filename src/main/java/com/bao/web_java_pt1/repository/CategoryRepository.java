package com.bao.web_java_pt1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bao.web_java_pt1.entity.Category;
import com.bao.web_java_pt1.mapper.CategoryMapper;

@Repository
public class CategoryRepository {
	@Autowired
	CategoryMapper categoryMapper;
	public Category findCategoryByID(int id) {
		return categoryMapper.findCategoryByID(id);
	};
	
	public Category findCategoryByName(String name) {
		return categoryMapper.findCategoryByName(name);
	};
	public List<Category> getAllCategory(){
		return categoryMapper.getAllCategory();
	}
	
}
