package com.climate.decode.event.emissions.dashboard.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.dashboard.dto.EmissionDataDto;
import com.climate.decode.event.emissions.dashboard.mapper.DashboardMapper;
import com.climate.decode.event.emissions.dashboard.service.EmissionDataService;
import com.climate.decode.event.emissions.dashboard.service.PreloadService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@RequiredArgsConstructor
@Slf4j
public class EmissionDataFacadeImpl implements EmissionDataFacade {

	private final EmissionDataService service;
	
	private final PreloadService preService;
	
	private final DashboardMapper mapper;

	@Override
	public List<EmissionDataDto> getEmissionDataByEventId(Integer eventId, String calculationType) {
		log.info("EmissionDataFacade :: getEmissionDataByEventId");

		Map<String, String> catMap = preService.getPreloadMap();

		List<EmissionDataDto> dtoLst = new ArrayList<>();

		for (String key : catMap.keySet()) // using map.entrySet() for iteration
		{
			log.info("key  ::  " + key);
			dtoLst.add(mapper.convertResultSetToChargeBoxResponse(key,
					service.getEmissionDataByEventId(eventId, calculationType, key, catMap)));
		}

		return dtoLst;
	}

	@Override
	public List<EmissionDataDto> getEmissionDataByOrganisationId(Integer orgId, String calculationType) {
		log.info("EmissionDataFacade :: getEmissionDataByOrganisationId");

		Map<String, String> catMap = preService.getOrganisationPreloadMap();

		List<EmissionDataDto> dtoLst = new ArrayList<>();

		for (String key : catMap.keySet()) // using map.entrySet() for iteration
		{
			log.info("key  ::  " + key);
			dtoLst.add(mapper.convertResultSetToChargeBoxResponse(key,
					service.getEmissionDataByOrganisationId(orgId, calculationType, key, catMap)));
		}

		return dtoLst;
	}

}
