package com.climate.decode.event.emissions.freightmaterial.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.climate.decode.event.emissions.exception.ResourceNotFoundException;
import com.climate.decode.event.emissions.freightmaterial.entity.FreightMaterialEmissionData;
import com.climate.decode.event.emissions.freightmaterial.repository.FreightMaterialEmissionDataRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class FreightMaterialEmissionDataServiceImpl implements FreightMaterialEmissionDataService {

	private final FreightMaterialEmissionDataRepository repo;
	
	@Override
	public FreightMaterialEmissionData createFreightMaterialEmissionData(FreightMaterialEmissionData freightMaterial) {
		log.info("FreightMaterialEmissionDataServiceImpl :: createFreightMaterialEmissionData");
		return repo.save(freightMaterial);
	}

	@Override
	public Optional<FreightMaterialEmissionData> getFreightMaterialEmissionDataByFreightMaterialId(Integer freightMaterialId) {
		log.info("FreightMaterialEmissionDataServiceImpl :: getFreightMaterialEmissionDataByFreightMaterialId");
		return repo.getByFreightMaterialId(freightMaterialId);
	}

	@Override
	public String deleteFreightMaterialEmissionData(Integer freightMaterialId) {
		log.info("FreightMaterialEmissionDataServiceImpl :: deleteFreightMaterialEmissionData");

		if (repo.getByFreightMaterialId(freightMaterialId).isPresent()) {
			repo.delete(repo.getByFreightMaterialId(freightMaterialId).get());
			return "Data Deleted Successfully";
		}
		throw new ResourceNotFoundException("FreightMaterial Emission not found with FreightMaterial ID " + freightMaterialId);

	}

	@Override
	public FreightMaterialEmissionData updateFreightMaterialEmissionData(FreightMaterialEmissionData freightMaterial) {
		log.info("FreightMaterialEmissionDataServiceImpl :: updateFreightMaterialEmissionData");

		if(repo.getByFreightMaterialId(freightMaterial.getFreightMaterialId()).isPresent()) {
			repo.save(freightMaterial);
			return repo.getByFreightMaterialId(freightMaterial.getFreightMaterialId()).get();
		}else {
			throw new ResourceNotFoundException(String.format("FreightMaterial not found For FreightMaterial ID {}", freightMaterial.getFreightMaterialId()));
		}
	}

}
