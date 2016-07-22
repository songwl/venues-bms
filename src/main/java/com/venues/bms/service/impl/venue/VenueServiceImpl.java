package com.venues.bms.service.impl.venue;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.VeVenueAttrMapper;
import com.venues.bms.dao.VeVenueMapper;
import com.venues.bms.po.VeVenue;
import com.venues.bms.po.VeVenueAttr;
import com.venues.bms.service.venue.VenueService;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VeVenueMapper veVenueMapper;

	@Autowired
	private VeVenueAttrMapper veVenueAttrMapper;

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

	@Override
	public VeVenue save(VeVenue venue, Collection<VeVenueAttr> attrs) {
		veVenueMapper.insert(venue);

		int venueId = venue.getId();
		for (VeVenueAttr attr : attrs) {
			attr.setVenueId(venueId);
			veVenueAttrMapper.insert(attr);
		}
		return venue;
	}

	@Override
	public VeVenue getVenueById(Integer id) {
		VeVenue venue = veVenueMapper.selectByPrimaryKey(id);
		if (venue != null) {
			List<VeVenueAttr> attrs = veVenueAttrMapper.selectByVenueId(venue.getId());

			Map<String, VeVenueAttr> attrMap = convert2Map(attrs);
			venue.setAttrs(attrMap);
		}
		return venue;
	}

	@Override
	public int update(VeVenue venue, Collection<VeVenueAttr> attrs) {
		veVenueMapper.updateByPrimaryKeySelective(venue);

		int venueId = venue.getId();
		List<VeVenueAttr> dbAttrs = veVenueAttrMapper.selectByVenueId(venueId);
		for (VeVenueAttr attr : dbAttrs) {
			veVenueAttrMapper.deleteByPrimaryKey(attr.getId());
		}

		for (VeVenueAttr attr : attrs) {
			attr.setVenueId(venueId);
			veVenueAttrMapper.insert(attr);
		}
		return 0;
	}

	private Map<String, VeVenueAttr> convert2Map(List<VeVenueAttr> attrs) {
		Map<String, VeVenueAttr> attrMap = new HashMap<>();

		for (VeVenueAttr attr : attrs) {
			//key = VenueType_Language_AttrCode
			String key = attr.getVenueType() + "_" + attr.getLanguage() + "_" + attr.getAttrCode();
			attrMap.put(key, attr);
		}
		return attrMap;
	}

}
