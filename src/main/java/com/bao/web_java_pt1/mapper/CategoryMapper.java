package com.bao.web_java_pt1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bao.web_java_pt1.entity.Category;

@Mapper
public interface CategoryMapper {
	public Category findCategoryByID(int id);
	public Category findCategoryByName(String name);
	public List<Category> getAllCategory();
}
