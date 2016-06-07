package com.venues.bms.service.impl.venue;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.VeVenueMapper;
import com.venues.bms.po.VeVenue;
import com.venues.bms.service.venue.VenueService;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VeVenueMapper veVenueMapper;

	@Override
	public Page<VeVenue> findVenuePage(Page<VeVenue> page, Map<String, Object> params) {
		int count = veVenueMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<VeVenue> list = findVenueList(params);
			page.setItemList(list);
		}
		return page;
	}

	@Override
	public List<VeVenue> findVenueList(Map<String, Object> params) {
		return veVenueMapper.selectByParams(params);
	}

}
