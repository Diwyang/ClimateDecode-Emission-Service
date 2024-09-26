package com.climate.decode.event.emissions.meal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.climate.decode.event.emissions.meal.api.MealEmissionApi;
import com.climate.decode.event.emissions.meal.dto.MealEmissionDataDto;
import com.climate.decode.event.emissions.meal.facade.MealEmissionDataFacade;
import com.climate.decode.event.emissions.response.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@Slf4j
public class MealEmissionController implements MealEmissionApi {

	private final MealEmissionDataFacade mealEmissionFacade;
	
	@Override
	public ApiResponse<MealEmissionDataDto> createMealEmissionData(Integer mealId, MealEmissionDataDto mealEmissionDataDto) {
		log.info("MealEmissionController :: createMealEmissionData");
		return ApiResponse.ofSuccess(mealEmissionFacade.createMealEmissionData(mealId, mealEmissionDataDto),
				"Data save successfully");
	}

	@Override
	public ApiResponse<MealEmissionDataDto> getMealEmissionDataByMealId(Integer mealId) {
		log.info("MealEmissionController :: getMealEmissionDataByMealId");
		return ApiResponse.ofSuccess(mealEmissionFacade.getMealEmissionDataByMealId(mealId));
	}

	@Override
	public ApiResponse<String> deleteMealEmissionData(Integer mealId) {
		log.info("MealEmissionController :: deleteMealEmissionData");
		return ApiResponse.ofSuccess(mealEmissionFacade.deleteMealEmissionData(mealId));
	}

	@Override
	public ApiResponse<MealEmissionDataDto> updateMealEmissionData(Integer mealId, MealEmissionDataDto mealDetailsDto) {
		log.info("MealEmissionController :: updateMealEmissionData");
		return ApiResponse.ofSuccess(mealEmissionFacade.updateMealEmissionData(mealDetailsDto), "Data Successfully Updated");
	}

}
