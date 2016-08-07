package com.venues.bms.web.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.venues.bms.core.freemarker.IDictDataLoader;
import com.venues.bms.core.model.LabelValue;
import com.venues.bms.po.VeVenue;
import com.venues.bms.po.VeVenueAttr;
import com.venues.bms.service.venue.VenueService;
import com.venues.bms.vo.Enums;

@Component("venueComponent")
public class VenueComponent implements IDictDataLoader {

	@Autowired
	private VenueService venueService;

	@Override
	public List<LabelValue> loadDataList(String keyCode) {
		List<LabelValue> list = new ArrayList<>();
		if (StringUtils.isNotBlank(keyCode)) {
			Integer id = NumberUtils.toInt(keyCode);
			VeVenue venue = venueService.getVenueById(id);
			if (venue != null && venue.getAttrs() != null) {
				String key = "DEFAULT_" + Enums.LANGUAGE.CHINESE.name() + "_venueName";
				String label = getValue(venue.getAttrs(), key);
				if (StringUtils.isBlank(label)) { //中文名称不存在，取英文名称
					key = "DEFAULT_" + Enums.LANGUAGE.ENGLISH.name() + "_venueName";
					label = getValue(venue.getAttrs(), key);
				}
				LabelValue lv = new LabelValue(label, venue.getId().toString());
				list.add(lv);
			}

		}
		return list;
	}

	private String getValue(Map<String, VeVenueAttr> attrs, String key) {
		if (attrs.containsKey(key)) {
			return attrs.get(key).getAttrValue();
		}
		return null;
	}

}
