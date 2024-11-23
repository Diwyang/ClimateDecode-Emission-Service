/**
 * 
 */
package com.climate.decode.event.dataentry.repository.virtualevent;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.climate.decode.event.dataentry.entity.virtualevent.VirtualEventDetails;

/**
 * @author diwya
 *
 */
public interface VirtualEventDetailsRepository extends JpaRepository<VirtualEventDetails, Long>  {

	List<VirtualEventDetails> getByEventId(Integer eventId);

	Optional<VirtualEventDetails> getByVirtualEventId(Integer virtualEventId);

	Optional<VirtualEventDetails> getVirtualEventDataByEventIdAndVirtualEventId(Integer eventId, Integer virtualEventId);
	
}
