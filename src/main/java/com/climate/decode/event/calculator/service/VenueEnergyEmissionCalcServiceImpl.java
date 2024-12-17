package com.climate.decode.event.calculator.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.climate.decode.event.calculator.repository.EmissionFactorProjection;
import com.climate.decode.event.dataentry.dto.information.InformationDto;
import com.climate.decode.event.dataentry.entity.venue.VenueDetails;
import com.climate.decode.event.dataentry.facade.information.InformationFacade;
import com.climate.decode.event.dataentry.repository.venue.VenueDetailsRepository;
import com.climate.decode.event.emissions.accommodation.dto.AccommodationEmissionDataDto;
import com.climate.decode.event.emissions.venue.dto.VenueEmissionDataDto;
import com.climate.decode.event.emissions.venue.facade.VenueEmissionDataFacade;
import com.climate.decode.event.enums.CalculationType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class VenueEnergyEmissionCalcServiceImpl implements VenueEnergyEmissionCalcService {

	private final VenueEmissionDataFacade venueEmissionFacade;
	private final VenueDetailsRepository venueDetailsRepository;
	private final GHGCalculationService ghgCalcService;
	private final InformationFacade informationFacade;
	private final EmissionFactorService efService;
	
	@Override
	public void calculateEmission(String eventId, CalculationType calculationType) {
		
		log.info("VenueEnergyEmissionCalcService ::  calculateEmission");
		
		boolean existingObj = true;
		VenueEmissionDataDto dto = null;
		
		InformationDto infoDto = informationFacade.getInformationByEventId(Integer.getInteger(eventId));
		
		EmissionFactorProjection  efProject = efService.getEmissionFactorBySource("Venue", infoDto.getEventHostedCountry());
		
		
		List<VenueDetails> detailLst = venueDetailsRepository.getByEventId(Integer.getInteger(eventId));
		for (VenueDetails details : detailLst) {
			
			dto = venueEmissionFacade.getVenueEmissionDataByVenueId(details.getVenueId());
			if(dto == null) {
				existingObj = false;
				dto = new VenueEmissionDataDto();
				dto.setVenueId(details.getVenueId());
				dto.setCalculationType(calculationType);
				dto.setCreatedDateTime(OffsetDateTime.now());
			}
			
			dto = ghgCalcService.calculateVenueEmissions(details, efProject, dto);
			dto.setUpdatedDateTime(OffsetDateTime.now());
			
			log.info("AccomdationEmissionCalcService ::  calculateEmission after calculation dto >>>>  " + dto);
			if(existingObj) {
				dto = venueEmissionFacade.updateVenueEmissionData(dto);
			} else {
				dto = venueEmissionFacade.createVenueEmissionData(null, dto);
			}
			log.info("AccomdationEmissionCalcService ::  calculateEmission after saving dto >>>>  " + dto);
		}
	

	}

}
