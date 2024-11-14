package com.climate.decode.event.emissions.calculator.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "accomdation_emission_factors")
@Data
public class AccomdationEmissionFactorEntity {
	
	@Id
	private long id;
	
	@Column(name = "country")
    private String country;

	@Column(name = "emission_factor")
    private String emissionFactor;

	@Column(name = "unit")
    private String unit;

	@Column(name = "region")
    private String region;
	
	@Column(name = "reference")
    private String reference;
	
}
