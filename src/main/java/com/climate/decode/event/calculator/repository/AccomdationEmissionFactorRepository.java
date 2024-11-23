package com.climate.decode.event.calculator.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.calculator.entity.AccomdationEmissionFactorEntity;

public interface AccomdationEmissionFactorRepository extends JpaRepository<AccomdationEmissionFactorEntity, Long>{

	Optional<EmissionFactorProjection> findByCountry(String country);
	
}
