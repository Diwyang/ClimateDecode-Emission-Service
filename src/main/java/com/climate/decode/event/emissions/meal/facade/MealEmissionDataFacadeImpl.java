package com.climate.decode.event.emissions.meal.facade;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.meal.converter.MealEmissionConverter;
import com.climate.decode.event.emissions.meal.dto.MealEmissionDataDto;
import com.climate.decode.event.emissions.meal.entity.MealEmissionData;
import com.climate.decode.event.emissions.meal.service.MealEmissionDataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@RequiredArgsConstructor
@Slf4j
public class MealEmissionDataFacadeImpl implements MealEmissionDataFacade {

	private final MealEmissionConverter mealEmissionConverter;
	private final MealEmissionDataService mealEmissionService;
	
	@Override
	public MealEmissionDataDto createMealEmissionData(Integer mealId, MealEmissionDataDto mealEmissionDataDto) {
		log.info("MealEmissionDataFacade :: createMealEmissionData");
		MealEmissionData mealEmission = mealEmissionConverter.toEntity(mealEmissionDataDto);
		mealEmission.setCreatedDateTime(OffsetDateTime.now());
		mealEmission.setUpdatedDateTime(OffsetDateTime.now());
		mealEmission = mealEmissionService.createMealEmissionData(mealEmission);
		return mealEmissionConverter.toDto(mealEmission);
	}
	
	@Override
	public MealEmissionDataDto getMealEmissionDataByMealId(Integer mealId) {
		log.info("MealEmissionDataFacade :: getMealEmissionDataByMealId");
		Optional<MealEmissionData> optMealEmissionData = mealEmissionService.getMealEmissionDataByMealId(mealId);
		
		MealEmissionData mealEmissionData = !optMealEmissionData.isEmpty()? optMealEmissionData.get(): null ;
		
		if (null == mealEmissionData) {
			throw new ResourceNotFoundException(String.format("Record Not Found with mealId {%x}", mealId));
		}
		
		return mealEmissionConverter.toDto(mealEmissionData);
	}
	
	@Override
	public String deleteMealEmissionData(Integer mealId) {
		log.info("MealEmissionDataFacade :: deleteMealEmissionData");
		return mealEmissionService.deleteMealEmissionData(mealId);
	}
	
	@Override
	public MealEmissionDataDto updateMealEmissionData(MealEmissionDataDto meal) {
		log.info("MealEmissionDataFacade :: updateMealEmissionData");
		MealEmissionData mealEmission = mealEmissionConverter.toEntity(meal);
		mealEmission.setUpdatedDateTime(OffsetDateTime.now());
		mealEmission = mealEmissionService.updateMealEmissionData(mealEmission);
		return mealEmissionConverter.toDto(mealEmission);
	}
	
	

}
