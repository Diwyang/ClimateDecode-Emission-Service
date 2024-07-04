package com.climate.decode.event.emissions.dashboard.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.climate.decode.event.emissions.dashboard.dao.EmissionDataDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmissionDataServiceImpl implements EmissionDataService {

	private final EmissionDataDao dao;

	@Override
	public Double getEmissionDataByEventId(Integer eventId, String calculationType, String key, Map<String, String> catMap) {
		log.info("EmissionDataServiceImpl :: getEmissionDataByEventId");

		log.info("key  ::  " + key + "  Value ::  " + catMap.get(key));
		return dao.getDashboardDataByEventId(eventId.toString(), calculationType, catMap.get(key));

	}

	@Override
	public Double getEmissionDataByOrganisationId(Integer orgId, String calculationType, String key,
			Map<String, String> catMap) {
		log.info("EmissionDataServiceImpl :: getEmissionDataByOrganisationId");

		log.info("key  ::  " + key + "  Value ::  " + catMap.get(key));
		return dao.getDashboardDataByOrganisationId(orgId.toString(), calculationType, catMap.get(key));

	}

}
