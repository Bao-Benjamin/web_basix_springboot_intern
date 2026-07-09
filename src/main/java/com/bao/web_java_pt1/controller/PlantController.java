package com.bao.web_java_pt1.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.bao.web_java_pt1.dto.request.PlantRequest;
import com.bao.web_java_pt1.dto.response.ListPlantResponseAPI;
import com.bao.web_java_pt1.dto.response.PlantResponseAPI;
import com.bao.web_java_pt1.dto.response.PlantStatResponseAPI;
import com.bao.web_java_pt1.dto.response.PlantStatsDTO;
import com.bao.web_java_pt1.entity.Plant;

import com.bao.web_java_pt1.service.PlantService;






@RestController
@RequestMapping("/api/plants")
public class PlantController {

	@Autowired
	private PlantService plantService;

	@GetMapping("/")
//	@Operation(summary = "Lấy danh sách tất cả các cây")
	public ResponseEntity<List<PlantResponseAPI>> getAllPlant(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit  ){
		return new ResponseEntity(plantService.getAllPlants(page,limit), HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/")
	public ResponseEntity<PlantResponseAPI> addPlant(@RequestBody PlantRequest request) {
		System.out.println("request controller"+request );
		PlantResponseAPI responseData = plantService.addPlant(request);
		return new ResponseEntity<>(responseData, HttpStatusCode.valueOf(201));
	}
	@GetMapping("/{name}")
	public ResponseEntity<PlantResponseAPI> findPlantByName(@PathVariable String name){
		return new ResponseEntity<PlantResponseAPI>(plantService.findPlantByName(name), HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/update/{name}")
	public ResponseEntity<PlantResponseAPI> updatePlant(@PathVariable String name, @RequestBody PlantRequest request){
		return new ResponseEntity<PlantResponseAPI>(plantService.updatePlant(name, request), HttpStatusCode.valueOf(200));
	}
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<PlantResponseAPI> deletePlant(@PathVariable String name){
		PlantResponseAPI PlantResponseAPI = plantService.deletePlant(name);    
		if(PlantResponseAPI.getErrorCode()==404) {
			return ResponseEntity.status(404).body(PlantResponseAPI);
		}
	    return ResponseEntity.status(200).body(PlantResponseAPI);
	}
	@GetMapping("/search")
    public ResponseEntity<ListPlantResponseAPI> searchPlants(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "by", defaultValue = "name", required = false) String by,
            @RequestParam(value="order", defaultValue ="asc", required = false ) String order,
            @RequestParam(defaultValue = "1") int page, 
            @RequestParam(defaultValue = "5") int limit  
    		) {
        
		ListPlantResponseAPI results = plantService.searchPlants(keyword, category, by, order, limit, page);
        return ResponseEntity.ok(results);
    }
	
	@GetMapping("/sort")
	public ResponseEntity<ListPlantResponseAPI> getPlantsSorted(
			@RequestParam(value = "by", defaultValue = "name") String by,
            @RequestParam(value = "order", defaultValue = "asc") String order
            ){
		ListPlantResponseAPI results = plantService.getPlantsSorted(by, order);
        return ResponseEntity.ok(results);
	}
	@GetMapping("/most-expensive")
	public ResponseEntity<PlantResponseAPI> findMostExpensivePlant(){
		return ResponseEntity.status(200).body(plantService.findMostExpensivePlant());
	}
	@GetMapping("/inventory-value")
	public ResponseEntity<Double> calculateInventoryValue(){
		return ResponseEntity.status(200).body(plantService.calculateInventoryValue());
	}
	
	@DeleteMapping("/category/{category}")
	public ResponseEntity<PlantStatResponseAPI> deleteByCategory(@PathVariable String category){
		
		return ResponseEntity.status(200).body(plantService.deleteByCategory(category));
	}
	@GetMapping("/get-by-cate/{category}")
	public ResponseEntity<List<Plant>> getPlantsByCategory(@PathVariable String category){
		return ResponseEntity.status(200).body(plantService.getPlantsByCategory(category));
	}
	@GetMapping("/get-stats")
	public ResponseEntity<PlantStatResponseAPI> getPlantStats(){
		return ResponseEntity.status(200).body(plantService.getPlantStats());
	}
	
	@PutMapping("{name}/sell")
	public ResponseEntity<PlantResponseAPI> sellPlant(@PathVariable("name") String name, @RequestParam("param") Integer quantity) throws Exception{
		PlantResponseAPI plant = plantService.findPlantByName(name);
		return ResponseEntity.status(200).body(plantService.sellPlant(name, quantity));
		
	}
}
