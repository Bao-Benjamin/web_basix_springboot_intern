package com.bao.web_java_pt1.dto.response;

import java.util.List;
import java.util.Map;

public class PlantStatsDTO {
	private Long totalPlants;                      
    private Map<String,Object> categoryStats; 
    private PlantDTO latestPlant;
    private Double totalInventoryValue;
    private int amountOfDeletedPlants;
	public PlantStatsDTO() {
		super();
	}

	public PlantStatsDTO(Long totalPlants, Map<String,Object> categoryStats, PlantDTO latestPlant, int amountOfDeletedPlants) {
		super();
		this.totalPlants = totalPlants;
		this.categoryStats = categoryStats;
		this.latestPlant = latestPlant;
		this.amountOfDeletedPlants = amountOfDeletedPlants;
	}

	public Long getTotalPlants() {
		return totalPlants;
	}

	public void setTotalPlants(Long totalPlants) {
		this.totalPlants = totalPlants;
	}

	public Map<String,Object> getCategoryStats() {
		return categoryStats;
	}

	public void setCategoryStats(Map<String,Object> categoryStats) {
		this.categoryStats = categoryStats;
	}

	public PlantDTO getLatestPlant() {
		return latestPlant;
	}

	public void setLatestPlant(PlantDTO latestPlant) {
		this.latestPlant = latestPlant;
	}

	public Double getTotalInventoryValue() {
		return totalInventoryValue;
	}

	public void setTotalInventoryValue(Double totalInventoryValue) {
		this.totalInventoryValue = totalInventoryValue;
	}

	public int getAmountOfDeletedPlants() {
		return amountOfDeletedPlants;
	}

	public void setAmountOfDeletedPlants(int amountOfDeletedPlants) {
		this.amountOfDeletedPlants = amountOfDeletedPlants;
	}
	
	
    
    
}

