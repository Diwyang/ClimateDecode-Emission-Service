/**
 * 
 */
package com.climate.decode.event.dataentry.dto.transport;

import java.time.OffsetDateTime;

import com.climate.decode.event.enums.FuelType;
import com.climate.decode.event.enums.ModeOfTransportType;
import com.climate.decode.event.enums.PeopleTravelType;
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
public class TransportDetailsDto {

	private int transportId;

	private int eventId;

	private PeopleTravelType transportBy;

	private ModeOfTransportType modeOfTransport;

	private String modeOfTransportOther;

	private int noOfTravellers;

	private String origin;

	private String destination;

	private int distanceTravelled;

	private String distanceTravelledUnit ="km";
	
	private int fuelConsumption;

	private String fuelConsumptionUnit = "m3";
	
	private FuelType fuelType;

	private String fuelTypeOther;

	private String comments;
	
	private OffsetDateTime eventDateTime;
	
	private OffsetDateTime updatedDateTime;
	
}
