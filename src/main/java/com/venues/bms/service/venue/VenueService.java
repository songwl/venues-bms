package com.venues.bms.service.venue;

import java.util.List;
import java.util.Map;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.VeVenue;

public interface VenueService {

	Page<VeVenue> findVenuePage(Page<VeVenue> page, Map<String, Object> params);

	List<VeVenue> findVenueList(Map<String, Object> params);
}
