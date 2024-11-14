package com.climate.decode.event.emissions.information.repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.emissions.information.enity.Information;

public interface InformationRepository extends JpaRepository<Information, Long> {

	Optional<Information> getByEventId(Integer eventId);

	List<Information> getByOrgId(Integer orgId);
}
