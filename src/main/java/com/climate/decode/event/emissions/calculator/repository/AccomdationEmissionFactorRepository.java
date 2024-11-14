package com.climate.decode.event.emissions.calculator.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.emissions.calculator.entity.AccomdationEmissionFactorEntity;

public interface AccomdationEmissionFactorRepository extends JpaRepository<AccomdationEmissionFactorEntity, Long>{

	Optional<EmissionFactorProjection> findByCountry(String country);
	
}
