package com.climate.decode.event.dataentry.repository.information;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.dataentry.entity.information.Information;

public interface InformationRepository extends JpaRepository<Information, Long> {

	Optional<Information> getByEventId(Integer eventId);

	List<Information> getByOrgId(Integer orgId);
}
