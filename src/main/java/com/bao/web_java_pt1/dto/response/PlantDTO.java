package com.bao.web_java_pt1.dto.response;

import java.time.LocalDate;
import java.util.List;

import com.bao.web_java_pt1.entity.Category;

public class PlantDTO {
	private Integer id;
    private String name;
    private Double price;
    private LocalDate plantDate;
    private String img;
    private Integer quantity;
    private String description;
    private String category; 

    // Khởi tạo không tham số
    public PlantDTO() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public LocalDate getPlantDate() { return plantDate; }
    public void setPlantDate(LocalDate plantDate) { this.plantDate = plantDate; }
    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
