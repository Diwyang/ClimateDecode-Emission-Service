package com.climate.decode.event.emissions.accommodation.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.climate.decode.event.emissions.enums.CalculationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccommodationEmissionDataDto {

	private int id;
	private int accommodationId;
	private CalculationType calculationType;
	private BigDecimal emissionFactor;
	private String emissionFactorUnit;
	private BigDecimal conversionFactor;
	private BigDecimal totalEmission;
	private String totalEmissionUnit;
	private String comments;
	private OffsetDateTime createdDateTime;
	private OffsetDateTime updatedDateTime;
}
