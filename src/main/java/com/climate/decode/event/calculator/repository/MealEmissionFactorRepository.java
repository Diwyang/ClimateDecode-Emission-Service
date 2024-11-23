package com.climate.decode.event.calculator.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.calculator.entity.MealEmissionFactorEntity;

public interface MealEmissionFactorRepository extends JpaRepository<MealEmissionFactorEntity, Long>{

	Optional<EmissionFactorProjection> findByFoodStuffType(String foodStuffType);
	
}
