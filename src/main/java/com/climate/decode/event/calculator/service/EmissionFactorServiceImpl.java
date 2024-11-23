package com.climate.decode.event.calculator.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.event.calculator.repository.AccomdationEmissionFactorRepository;
import com.climate.decode.event.calculator.repository.EmissionFactorProjection;
import com.climate.decode.event.calculator.repository.MealEmissionFactorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmissionFactorServiceImpl implements EmissionFactorService {

	private final AccomdationEmissionFactorRepository accomdationEmissionFactorRepository;
	private final MealEmissionFactorRepository mealEmissionFactorRepository;
	
	@Override
	public EmissionFactorProjection getEmissionFactorBySource(String source, String country) {
		log.info("EmissionFactorService :::   source >>>  "+source+" country >>>  "+country);
		Optional<EmissionFactorProjection> emissionFactor = java.util.Optional.empty();
		
		switch(source) {
		case "Accomdation":
			emissionFactor = accomdationEmissionFactorRepository.findByCountry(country);
		case "Meal":
			emissionFactor = mealEmissionFactorRepository.findByFoodStuffType(country);
			
		}
		
		if( !emissionFactor.isEmpty()) {
			return emissionFactor.get();
		}
		return null;
	}


}
