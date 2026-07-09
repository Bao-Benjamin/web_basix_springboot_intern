package com.bao.web_java_pt1.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PlantRequest {
	private String name;
	private Double price;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate plantDate;
	private String img;
	private Integer  quantity;
	private String description;
	private String category;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDate getPlantDate() {
		return plantDate;
	}
	public void setPlantDate(LocalDate plantDate) {
		this.plantDate = plantDate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void getCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "PlantRequest [name=" + name + ", price=" + price + ", plantDate=" + plantDate + ", img=" + img
				+ ", quantity=" + quantity + ", description=" + description + ", categories=" + category + "]";
	}
	
	
}
