package com.bao.web_java_pt1.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bao.web_java_pt1.dto.response.PlantResponseAPI;
import com.bao.web_java_pt1.entity.Category;
import com.bao.web_java_pt1.entity.Plant;
import com.bao.web_java_pt1.mapper.PlantMapper;

@Repository
public class PlantRepository {
	@Autowired
	private PlantMapper plantMapper;
	
	public void insertPlant(Plant plant) {
		plantMapper.insertPlant(plant);
	}
	public List<Plant> getAllPlants(int size, int offset){
		return plantMapper.getAllPlants(size, offset);
	}
	public long countAllPlants() {
		return plantMapper.countAllPlants();
	}
	public Plant findPlantByName(String name) {
		return plantMapper.findPlantByName(name);
	}
	public int updatePlant(String name, Plant plant) {
		return plantMapper.updatePlant(name, plant);
	}
	public int deletePlant(String name) {
		return plantMapper.deletePlant(name);
	}
	public List<Plant> searchPlants(String keyword, String category, String sortedField, String sortedByField, int limit, int offset) {
		return plantMapper.searchPlants(keyword, category,sortedField,sortedByField,limit, offset);
	}
	public long countSearchPlants(String keyword, String category) {
		return plantMapper.countSearchPlants(keyword, category);
	}
	public List<Plant> getPlantsSorted(String by, String order){
		return plantMapper.getPlantsSorted(by, order);
	}
	public Plant findMostExpensivePlant() {
		return plantMapper.findMostExpensivePlant();
	}
	public double calculateInventoryValue() {
		return plantMapper.calculateInventoryValue();
	}
	public List<Plant> getPlantByCategory(String category){
		return plantMapper.getPlantsByCategory(category);
	}
	public long countTotalPlants() {
		return plantMapper.countTotalPlants();
	}
	public List<Map<String, Object>> countPlantsByCategory(){
		return plantMapper.countPlantsByCategory();
	}
	public Plant findLatestPlant() {
		return plantMapper.findLatestPlant();
	}
	public Plant findPlantByID(int id) {
		return plantMapper.findPlantByID(id);
	}
}
