package com.climate.decode.event.emissions.calculator.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.event.emissions.calculator.repository.AccomdationEmissionFactorRepository;
import com.climate.decode.event.emissions.calculator.repository.EmissionFactorProjection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmissionFactorServiceImpl implements EmissionFactorService {

	private final AccomdationEmissionFactorRepository accomdationEmissionFactorRepository;
	
	@Override
	public EmissionFactorProjection getEmissionFactorBySource(String source, String country) {
		log.info("EmissionFactorService :::   source >>>  "+source+" country >>>  "+country);
		Optional<EmissionFactorProjection> emissionFactor = java.util.Optional.empty();
		
		switch(source) {
		case "Accomdation":
			emissionFactor = accomdationEmissionFactorRepository.findByCountry(country);
			
		}
		
		if( !emissionFactor.isEmpty()) {
			return emissionFactor.get();
		}
		return null;
	}


}
