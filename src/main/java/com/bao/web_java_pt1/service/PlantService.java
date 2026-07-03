package com.bao.web_java_pt1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bao.web_java_pt1.dto.request.PlantRequest;
import com.bao.web_java_pt1.dto.response.ListPlantResponseAPI;
import com.bao.web_java_pt1.dto.response.PlantDTO;
import com.bao.web_java_pt1.dto.response.PlantResponseAPI;
import com.bao.web_java_pt1.dto.response.PlantStatResponseAPI;
import com.bao.web_java_pt1.dto.response.PlantStatsDTO;
import com.bao.web_java_pt1.entity.Category;
import com.bao.web_java_pt1.entity.Plant;
import com.bao.web_java_pt1.repository.CategoryRepository;
import com.bao.web_java_pt1.repository.PlantRepository;

@Service
public class PlantService {
	@Autowired
	PlantRepository plantRepository ;
	@Autowired
	CategoryRepository categoryRepository;
	@Transactional
	public PlantResponseAPI addPlant (PlantRequest request) {
		System.out.println("request"+request );
		Plant plant = new Plant();
		plant.setName(request.getName());
		plant.setPrice(request.getPrice());
		plant.setImg(request.getImg());
		plant.setQuantity(request.getQuantity());
		plant.setDescription(request.getDescription());
		plant.setPlantDate(request.getPlantDate());
		Category category =
				categoryRepository.findCategoryByID(request.getCategory());
		plant.setCategory(category);
		plantRepository.insertPlant(plant);
//		System.out.println(categories);
		PlantDTO response = new PlantDTO();
        response.setId(plant.getId()); // ID này lấy từ object plant sau khi insert thành công
        response.setName(plant.getName());
        response.setPrice(plant.getPrice());
        response.setPlantDate(plant.getPlantDate());
        response.setImg(plant.getImg());
        response.setQuantity(plant.getQuantity());
        response.setDescription(plant.getDescription());
        response.setCategory(category.getName());
        PlantResponseAPI plantResponseAPI = new PlantResponseAPI();
        plantResponseAPI.setErrorCode(201);
        plantResponseAPI.setPlantDTO(response);

        return plantResponseAPI;
	}
	public ListPlantResponseAPI getAllPlants() {
	    List<PlantDTO> list = new ArrayList<>();
	    for (Plant plant : plantRepository.getAllPlants()) {
	    	System.out.println("plant in loop: "+ plant);
	        list.add(toPlantDTO(plant));
	    }
	    ListPlantResponseAPI response = new ListPlantResponseAPI();
	    response.setPlantDTO(list);
	    response.setMessageError("No Error");
	    response.setErrorCode(200);
	    return response;
	}
	public PlantResponseAPI findPlantByName(String name) {
		PlantDTO plantDTO = toPlantDTO((plantRepository.findPlantByName(name)));
		PlantResponseAPI plantResponseAPI = new PlantResponseAPI();
		plantResponseAPI.setPlantDTO(plantDTO);
		plantResponseAPI.setErrorCode(200);
//		plantResponseAPI.setMessageError("No Error");
		return plantResponseAPI;
	}
	
	@Transactional
	public PlantResponseAPI updatePlant(String name ,PlantRequest request) {
//		Plant plant = plantRepository.findPlantByName(name);
		Plant plantUpdate = toPlant(request);
		int result = plantRepository.updatePlant(name,plantUpdate);
		PlantResponseAPI plantResponseAPI = new PlantResponseAPI();
		if(result == 0) {
			plantResponseAPI.setErrorCode(500);
			plantResponseAPI.setMessageError("Error in updatePlant");
			throw new RuntimeException();
		}
		plantResponseAPI.setErrorCode(200);
//		plantResponseAPI.setMessageError("No Error");
		plantResponseAPI.setPlantDTO(toPlantDTO(plantUpdate));
		return plantResponseAPI;
		
	}
	public PlantResponseAPI deletePlant(String name) {
		PlantResponseAPI plantResponseAPI = new PlantResponseAPI();
		int result = plantRepository.deletePlant(name);
		if(result == 0) {
			plantResponseAPI.setErrorCode(404);
			plantResponseAPI.setMessageError("Error during deletePlant");
		}
		plantResponseAPI.setErrorCode(200);
		return plantResponseAPI;
	}
	
	public ListPlantResponseAPI searchPlants(String keyword, String category) {
		List<PlantDTO> result = new ArrayList<>();
		ListPlantResponseAPI response = new ListPlantResponseAPI();
		for(Plant plant : plantRepository.searchPlants(keyword, category)) {
			PlantDTO plantDTO =  toPlantDTO(plant);
			result.add(plantDTO);
		}
		response.setPlantDTO(result);
		response.setErrorCode(200);
		return response;
	}
	public ListPlantResponseAPI getPlantsSorted(String by, String order){
		List<PlantDTO> result = new ArrayList<>();
		for(Plant plant : plantRepository.getPlantsSorted(by,order)) {
			PlantDTO plantResponse =  toPlantDTO(plant);
			result.add(plantResponse);
		}
		ListPlantResponseAPI listPlantResponseAPI = new ListPlantResponseAPI();
		listPlantResponseAPI.setPlantDTO(result);
		listPlantResponseAPI.setErrorCode(200);
		return listPlantResponseAPI;
	}
	public PlantResponseAPI findMostExpensivePlant() {
		PlantResponseAPI plantResponseAPI = new PlantResponseAPI();
		PlantDTO plantDTO = toPlantDTO(plantRepository.findMostExpensivePlant()) ;
		plantResponseAPI.setPlantDTO(plantDTO);
		plantResponseAPI.setErrorCode(200);
		return plantResponseAPI;
	}
	
	public double calculateInventoryValue() {
		return plantRepository.calculateInventoryValue();
	}
	private PlantDTO toPlantDTO(Plant plant) {
		PlantDTO response = new PlantDTO();

        response.setId(plant.getId());
        response.setName(plant.getName());
        response.setPrice(plant.getPrice());
        response.setPlantDate(plant.getPlantDate());
        response.setImg(plant.getImg());
        response.setQuantity(plant.getQuantity());
        response.setDescription(plant.getDescription());
        System.out.println("plant.getCate(): "+ plant.getCategory());
//        Category category = categoryRepository.findCategoryByID(plant.getCategory().getId());
//        response.setCategory(plant.getCategory().getName());
        if (plant.getCategory() != null) {
            response.setCategory(plant.getCategory().getName());
        } else {
            response.setCategory("Chưa phân loại");
        }

        return response;
	}
	private Plant toPlant (PlantRequest request) {
		Plant plant = new Plant();
		plant.setName(request.getName());
		plant.setPrice(request.getPrice());
		plant.setImg(request.getImg());
		plant.setQuantity(request.getQuantity());
		plant.setDescription(request.getDescription());
		plant.setPlantDate(request.getPlantDate());
		Category category =
				categoryRepository.findCategoryByID(request.getCategory());
		plant.setCategory(category);
		return plant;
	}
	
	public PlantStatResponseAPI deleteByCategory(String category) {
		List<Plant> list = plantRepository.getPlantByCategory(category);
		for(Plant plant : list) {
			plantRepository.deletePlant(plant.getName());
		}
		PlantStatsDTO plantStatsDTO = new PlantStatsDTO();
		 plantStatsDTO.setAmountOfDeletedPlants(list.size());
		 PlantStatResponseAPI plantStatResponseAPI = new PlantStatResponseAPI();
		 plantStatResponseAPI.setPlantStatsDTO(plantStatsDTO);
		 return plantStatResponseAPI;
	}
	public PlantStatResponseAPI getPlantStats() {
        PlantStatsDTO stats = new PlantStatsDTO();
        
        // 1. Tổng số cây (Long thay vì long nguyên thủy để tránh lỗi Null)
        stats.setTotalPlants(plantRepository.countTotalPlants());
        
        // 2. Số lượng theo từng danh mục
        List<Map<String, Object>> rows = plantRepository.countPlantsByCategory();
        java.util.Map<String, Object> categoryMap = new java.util.HashMap<>();
        
        for (Map<String, Object> row : rows) {
            // Lấy ra alias "categoryName" đã đặt ở SQL XML
            String catName = (String) row.get("categoryName");
            if (catName == null) {
                catName = "Chưa phân loại";
            }
            
            // Lấy alias "total", ép kiểu an toàn thông qua Number tránh lỗi xung đột Long/Integer của Driver DB
            Integer total = 0;
            if (row.get("total") != null) {
                total = ((Number) row.get("total")).intValue();
            }
            
            categoryMap.put(catName, total);
        }
        stats.setCategoryStats(categoryMap);
        
        // 3. Cây được thêm gần nhất
        Plant latest = plantRepository.findLatestPlant();
        stats.setLatestPlant(toPlantDTO(latest)); 
        
        PlantStatResponseAPI plantStatResponseAPI = new PlantStatResponseAPI();
        plantStatResponseAPI.setPlantStatsDTO(stats);
        plantStatResponseAPI.setErrorCode(200);
        return plantStatResponseAPI;
    }
	
	public PlantResponseAPI sellPlant(String name, int amount) throws Exception {
		PlantResponseAPI plantResponseAPI = new PlantResponseAPI();
		Plant plant = plantRepository.findPlantByName(name); 
		if (plant == null) {
			plantResponseAPI.setErrorCode(400);
			plantResponseAPI.setMessageError("list is null in sellPlant");
//			throw new Exception("Không tìm thấy cây có tên: " + name);
			return plantResponseAPI;
		}
		
		if (plant.getQuantity() > amount) {
			int updatedStock = plant.getQuantity() - amount;
			plant.setQuantity(updatedStock);
			
			// Cập nhật số lượng mới vào DB
			plantRepository.updatePlant(plant.getName(), plant);
			plantResponseAPI.setPlantDTO(toPlantDTO(plant));
			plantResponseAPI.setErrorCode(200);
			return plantResponseAPI;
			
		} else if (plant.getQuantity() == amount) {
			plantResponseAPI.setErrorCode(200);
			plantRepository.deletePlant(plant.getName());
			plant.setQuantity(0); // Set về 0 để response hiển thị đúng thực trạng
			return plantResponseAPI;
			
		} else {
			plantResponseAPI.setErrorCode(400);
			plantResponseAPI.setMessageError("the quatity wanted deleted less than reality quantity in sellPlant");
			return plantResponseAPI;
//			throw new Exception("Requested quantity exceeds available stock");
			
		}
	}
	
	public List<Plant> getPlantsByCategory(String category) {
		return plantRepository.getPlantByCategory(category);
	}
	public Plant findPlantByID(int id) {
		return plantRepository.findPlantByID(id);
	}
	
}
