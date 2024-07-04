/**
 * 
 */
package com.climate.decode.event.emissions.meal.service;

import java.util.Optional;

import com.climate.decode.event.emissions.meal.entity.MealEmissionData;

/**
 * @author diwya
 *
 */
public interface MealEmissionDataService {

	public MealEmissionData createMealEmissionData(MealEmissionData meal);

	public Optional<MealEmissionData> getMealEmissionDataByMealId(Integer mealId);

	public String deleteMealEmissionData(Integer mealId);

	public MealEmissionData updateMealEmissionData(MealEmissionData meal);
}
