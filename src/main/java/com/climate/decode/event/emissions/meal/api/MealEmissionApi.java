package com.climate.decode.event.emissions.meal.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.climate.decode.event.emissions.meal.dto.MealEmissionDataDto;
import com.climate.decode.event.emissions.response.ApiResponse;


@RequestMapping("/emission/meals")
public interface MealEmissionApi {

	@PostMapping("/{mealId}")
	public ApiResponse<MealEmissionDataDto> createMealEmissionData(@PathVariable(value = "mealId") Integer mealId, @RequestBody MealEmissionDataDto mealDetailsDto);
	
	
	@GetMapping("/{mealId}")
	public ApiResponse<MealEmissionDataDto> getMealEmissionDataByMealId(@PathVariable(value = "mealId") Integer mealId);

	
	@DeleteMapping("/{mealId}")
	public ApiResponse<String> deleteMealEmissionData(@PathVariable(value = "mealId") Integer mealId);
	
	@PatchMapping("")
	public ApiResponse<MealEmissionDataDto> updateMealEmissionData(@PathVariable(value = "mealId") Integer mealId, @RequestBody MealEmissionDataDto mealDetailsDto);
	
	
}
