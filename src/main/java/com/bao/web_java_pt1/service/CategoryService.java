package com.bao.web_java_pt1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bao.web_java_pt1.dto.response.CategoryDTO;
import com.bao.web_java_pt1.dto.response.CategoryResponseAPI;
import com.bao.web_java_pt1.dto.response.ListCategoryResponseAPI;
import com.bao.web_java_pt1.entity.Category;
import com.bao.web_java_pt1.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public CategoryResponseAPI findCategoryByName(String name) {
		CategoryResponseAPI categoryResponseAPI = new CategoryResponseAPI();	
		Category category =  categoryRepository.findCategoryByName(name);
		CategoryDTO categoryDTO = toCategoryDTO(category);
		categoryResponseAPI.setCategoryDTO(categoryDTO);
		return categoryResponseAPI;
	}
	public ListCategoryResponseAPI getAllCategory(){
		ListCategoryResponseAPI listCategoryResponseAPI = new ListCategoryResponseAPI();
		List<CategoryDTO> list = new ArrayList<>();
		for(Category category: categoryRepository.getAllCategory()) {
			list.add(toCategoryDTO(category));
		}
		listCategoryResponseAPI.setCategoryDTO(list);
		return listCategoryResponseAPI;
	}
	private CategoryDTO toCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO(category.getName());
		return categoryDTO;
	}
}
