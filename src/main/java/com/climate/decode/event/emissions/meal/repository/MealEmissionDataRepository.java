/**
 * 
 */
package com.climate.decode.event.emissions.meal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.emissions.meal.entity.MealEmissionData;

/**
 * @author diwya
 *
 */
public interface MealEmissionDataRepository extends JpaRepository<MealEmissionData, Long>  {

	Optional<MealEmissionData> getByMealId(Integer mealId);

}
