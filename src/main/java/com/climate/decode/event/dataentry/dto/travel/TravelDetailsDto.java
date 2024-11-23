/**
 * 
 */
package com.climate.decode.event.dataentry.dto.travel;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.climate.decode.event.enums.PeopleTravelType;
import com.climate.decode.event.enums.TransportType;
import com.climate.decode.event.enums.TravelDistanceType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

/**
 * @author diwya
 *
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TravelDetailsDto {

	private int travelId;
	
	private int eventId;
	
	private TravelDistanceType travelDistanceType;
	
	private TransportType typeOfTransport;
	
	private BigDecimal percentageTravelling;
	
	private PeopleTravelType peopleTravelling;
	
	private String comments;
	
	private OffsetDateTime eventDateTime;
	
	private OffsetDateTime updatedDateTime;
}
