package com.bao.web_java_pt1.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bao.web_java_pt1.dto.response.PlantResponseAPI;
import com.bao.web_java_pt1.entity.Category;
import com.bao.web_java_pt1.entity.Plant;

@Mapper
public interface PlantMapper {
	
	
	List<Plant> getAllPlants(@Param("limit") int limit, @Param("offset") int offset);
	long countAllPlants();
	
	void insertPlant(Plant plant) ;
	
	Plant findPlantByName(String name);
	
	int updatePlant(@Param("name") String name, @Param("req") Plant plant);

	int deletePlant(String name);
	
	List<Plant> searchPlants(@Param("keyword")String keyword, @Param("category") String category, @Param("sortByField") String sortByField, 
			@Param("sortOrder") String sortOrder, @Param("limit") int limit, @Param("offset") int offset);
	
	Long countSearchPlants(@Param("keyword") String keyword, @Param("category") String category);
	
	List<Plant> getPlantsSorted(@Param("sortByField") String sortByField, @Param("sortOrder") String sortOrder);
	Plant findMostExpensivePlant();
	double calculateInventoryValue();
	List<Plant> getPlantsByCategory(@Param("category") String categoryName);
	long countTotalPlants ();
	List<Map<String, Object>> countPlantsByCategory();
	Plant findLatestPlant();
	
	Plant findPlantByID(int id);
}
