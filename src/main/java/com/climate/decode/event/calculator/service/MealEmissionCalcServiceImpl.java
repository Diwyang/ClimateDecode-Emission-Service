package com.climate.decode.event.calculator.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.climate.decode.event.dataentry.entity.meal.MealDetails;
import com.climate.decode.event.dataentry.repository.meal.MealDetailsRepository;
import com.climate.decode.event.calculator.repository.EmissionFactorProjection;
import com.climate.decode.event.calculator.repository.MealEmissionFactorRepository;
import com.climate.decode.event.emissions.meal.dto.MealEmissionDataDto;
import com.climate.decode.event.emissions.meal.facade.MealEmissionDataFacade;
import com.climate.decode.event.enums.CalculationType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MealEmissionCalcServiceImpl implements MealEmissionCalcService {

	private final MealEmissionDataFacade mealEmissionFacade;
	private final MealDetailsRepository mealDetailsRepository;
	private final MealEmissionFactorRepository mealEmissionFactorRepository;
	private final GHGCalculationService ghgCalcService;
	private final EmissionFactorService efService;
	
	@Override
	public void calculateEmission(String eventId, CalculationType calculationType) {
		
		log.info("MealEmissionCalcService ::  calculateEmission");
		
		boolean existingObj = true;
		MealEmissionDataDto dto = null;
		List<MealDetails> detailLst = mealDetailsRepository.getByEventId(Integer.getInteger(eventId));
		for (MealDetails details : detailLst) {
			
			dto = mealEmissionFacade.getMealEmissionDataByMealId(details.getMealId());
			EmissionFactorProjection  efProject = efService.getEmissionFactorBySource("Meal", details.getMealType().name());
			
			if(dto == null) {
				existingObj = false;
				dto = new MealEmissionDataDto();
				dto.setMealId(details.getMealId());
				dto.setCalculationType(calculationType);
				dto.setCreatedDateTime(OffsetDateTime.now());
			}
			
			dto = ghgCalcService.calculateMealEmissions(details, efProject, dto);
			dto.setUpdatedDateTime(OffsetDateTime.now());
			
			log.info("MealEmissionCalcService ::  calculateEmission after calculation dto >>>>  " + dto);
			if(existingObj) {
				dto = mealEmissionFacade.updateMealEmissionData(dto);
			} else {
				dto = mealEmissionFacade.createMealEmissionData(null, dto);
			}
			log.info("MealEmissionCalcService ::  calculateEmission after saving dto >>>>  " + dto);
		}
	

	}

}
