package com.venues.bms.service.venue;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.VeVenue;
import com.venues.bms.po.VeVenueAttr;

public interface VenueService {

	Page<VeVenue> findVenuePage(Page<VeVenue> page, Map<String, Object> params);

	List<VeVenue> findVenueList(Map<String, Object> params);

	VeVenue save(VeVenue venue, Collection<VeVenueAttr> attrs);

	VeVenue getVenueById(Integer id);

	int update(VeVenue venue, Collection<VeVenueAttr> attrs);

	int updateVenue(VeVenue venue);

	List<VeVenueAttr> searchAttrValue(String attrCode, String attrValue);
}
