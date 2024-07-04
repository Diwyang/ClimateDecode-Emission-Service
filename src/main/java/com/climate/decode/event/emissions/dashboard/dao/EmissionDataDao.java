/**
 * 
 */
package com.climate.decode.event.emissions.dashboard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

/**
 * @author diwya
 *
 */

@Repository
@Slf4j
public class EmissionDataDao  {

	@Autowired
    EntityManager entityManager;
	
	public Double getDashboardDataByEventId(String eventId, String calculationType, String sql) {
		
		sql = sql.replace("<eventId>", eventId);
		sql = sql.replace("<calculationType>", calculationType);
		log.info("SQL Query ::: "+sql);
		
		return  (Double)entityManager.createNativeQuery(sql, Double.class).getSingleResult();
	}
	
public Double getDashboardDataByOrganisationId(String orgId, String calculationType, String sql) {
		
		sql = sql.replace("<organisationId>", orgId);
		sql = sql.replace("<calculationType>", calculationType);
		log.info("SQL Query ::: "+sql);
		
		return  (Double)entityManager.createNativeQuery(sql, Double.class).getSingleResult();
	}

}
