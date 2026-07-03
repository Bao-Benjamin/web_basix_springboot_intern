package com.bao.web_java_pt1.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Plant {
    private Integer id;
    private String name;
    private Double price;
    private LocalDate plantDate; // Giữ nguyên tên này
    private String image;
    private Integer quantity;
    private String description;  // Giữ nguyên tên này)
    private Category category;

    public Plant() {
        super();
    }

    // --- GENERATE LẠI GETTER / SETTER CHUẨN XÁC THEO TÊN BIẾN ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    // Tên hàm phải là getPlantDate và setPlantDate để MyBatis nhận diện CamelCase
    public LocalDate getPlantDate() { return plantDate; }
    public void setPlantDate(LocalDate plantDate) { this.plantDate = plantDate; }

    public String getImg() { return image; }
    public void setImg(String img) { this.image = img; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    // Tên hàm phải là getDescription và setDescription (có đầy đủ chữ 'c')
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

	@Override
	public String toString() {
		return "Plant [id=" + id + ", name=" + name + ", price=" + price + ", plantDate=" + plantDate + ", img=" + image
				+ ", quantity=" + quantity + ", description=" + description + ", categories=" + category + "]";
	}
    
}