package com.climate.decode.event.emissions.meal.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.meal.entity.MealEmissionData;
import com.climate.decode.event.emissions.meal.repository.MealEmissionDataRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class MealEmissionDataServiceImpl implements MealEmissionDataService {

	private final MealEmissionDataRepository repo;
	
	@Override
	public MealEmissionData createMealEmissionData(MealEmissionData meal) {
		log.info("MealEmissionDataServiceImpl :: createMealEmissionData");
		return repo.save(meal);
	}

	@Override
	public Optional<MealEmissionData> getMealEmissionDataByMealId(Integer mealId) {
		log.info("MealEmissionDataServiceImpl :: getMealEmissionDataByMealId");
		return repo.getByMealId(mealId);
	}

	@Override
	public String deleteMealEmissionData(Integer mealId) {
		log.info("MealEmissionDataServiceImpl :: deleteMealEmissionData");

		if (repo.getByMealId(mealId).isPresent()) {
			repo.delete(repo.getByMealId(mealId).get());
			return "Data Deleted Successfully";
		}
		throw new ResourceNotFoundException("Meal Emission not found with Meal ID " + mealId);

	}

	@Override
	public MealEmissionData updateMealEmissionData(MealEmissionData meal) {
		log.info("MealEmissionDataServiceImpl :: updateMealEmissionData");

		if(repo.getByMealId(meal.getMealId()).isPresent()) {
			repo.save(meal);
			return repo.getByMealId(meal.getMealId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("Meal not found For Meal ID {}", meal.getMealId()));
		}
	}

}
