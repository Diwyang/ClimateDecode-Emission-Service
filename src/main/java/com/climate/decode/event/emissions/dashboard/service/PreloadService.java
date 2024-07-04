package com.climate.decode.event.emissions.dashboard.service;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PreloadService {

    private final Map<String, String> preloadQueryMap = new HashMap<>();
    
    private final Map<String, String> organisationQueryMap = new HashMap<>();

    public void preloadData() {
        preloadQueryMap.put("Venue", "select sum(total_emission) from venue_details vd, venue_emission_calculation ve where vd.venue_id = ve.venue_id and vd.event_id = '<eventId>' and ve.calculation_type = '<calculationType>';");
        preloadQueryMap.put("Accomodation", "select sum(total_emission) from accommodation_details ad, accommodation_emission_calculation ee where ad.accommodation_id = ee.accommodation_id and ad.event_id = '<eventId>' and ee.calculation_type = '<calculationType>';");
        preloadQueryMap.put("Meal", "select sum(total_emission) from meal_details ad, meal_emission_calculation ee where ad.meal_id = ee.meal_id and ad.event_id = '<eventId>' and ee.calculation_type = '<calculationType>';");
    
        organisationQueryMap.put("Venue", "select sum(total_emission) from venue_details vd, venue_emission_calculation ve where vd.venue_id = ve.venue_id and ve.calculation_type = '<calculationType>' and vd.event_id in (select event_id from information_details where org_id ='<organisationId>');");
        organisationQueryMap.put("Accomodation", "select sum(total_emission) from accommodation_details ad, accommodation_emission_calculation ee where ad.accommodation_id = ee.accommodation_id and ee.calculation_type = '<calculationType>' and ad.event_id in (select event_id from information_details where org_id ='<organisationId>');");
        organisationQueryMap.put("Meal", "select sum(total_emission) from meal_details ad, meal_emission_calculation ee where ad.meal_id = ee.meal_id and ee.calculation_type = '<calculationType>' and ad.event_id in (select event_id from information_details where org_id ='<organisationId>');");
    
        
    }

    public Map<String, String> getPreloadMap() {
        return preloadQueryMap;
    }
    
    public Map<String, String> getOrganisationPreloadMap() {
        return organisationQueryMap;
    }
}
