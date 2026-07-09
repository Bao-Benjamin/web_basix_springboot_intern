package com.bao.web_java_pt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bao.web_java_pt1.dto.response.CategoryResponseAPI;
import com.bao.web_java_pt1.dto.response.ListCategoryResponseAPI;
import com.bao.web_java_pt1.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/{name}")
	public CategoryResponseAPI findCategoryByName(@PathVariable String name) {
		return categoryService.findCategoryByName(name);
	}
	@GetMapping
	public ListCategoryResponseAPI getAllCategory() {
		return categoryService.getAllCategory();
	}
}
