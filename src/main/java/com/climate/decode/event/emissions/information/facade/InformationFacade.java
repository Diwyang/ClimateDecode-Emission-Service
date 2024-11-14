package com.climate.decode.event.emissions.information.facade;

import java.util.List;

import com.climate.decode.event.emissions.information.dto.EventVenueDetailsDto;
import com.climate.decode.event.emissions.information.dto.InformationDto;

public interface InformationFacade {

	public InformationDto createInformationData(InformationDto informationDto);

	public InformationDto getInformationByEventId(Integer eventId);
	
	public List<InformationDto> getInformationDetails();
	
	public List<InformationDto> getInformationDetailsByOrg(Integer orgId);

	public String deleteInformationData(Integer eventId);

	public InformationDto updateInformationData(InformationDto informationDto);

	public EventVenueDetailsDto createVenueData(Integer eventId, EventVenueDetailsDto eventVenueDetailsDto);

	public List<EventVenueDetailsDto> getVenueDataByEventId(Integer venueId);
	
	public EventVenueDetailsDto getVenueDataByEventIdAndVenueId(Integer eventId, Integer venueId);

	public String deleteVenueData(Integer eventId, Integer venueId);

	public EventVenueDetailsDto updateVenueData(Integer eventId, EventVenueDetailsDto eventVenueDetailsDto);

}
