package com.climate.decode.event.emissions.eventpreparation.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@JsonInclude(value = Include.NON_NULL)
@Table(name = "eventPreparation_emission_calculation")
public class EventPreparationEmissionData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private int id;
	
	@Column(name = "event_preparation_id")
	private int eventPreparationId;
	
	@Column(name = "calculation_type")
	private String calculationType;
	
	@Column(name = "emission_factor")
	private BigDecimal emissionFactor;
	
	@Column(name = "emission_factor_unit")
	private String emissionFactorUnit;
	
	@Column(name = "conversion_factor")
	private BigDecimal conversionFactor;
	
	@Column(name = "total_emission")
	private BigDecimal totalEmission;
	
	@Column(name = "total_emission_unit")
	private String totalEmissionUnit;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "created_date_time")
	private OffsetDateTime createdDateTime;
	
	@Column(name = "update_date_time")
	private OffsetDateTime updatedDateTime;
}
