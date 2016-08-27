package com.venues.bms.web.component;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.venues.bms.core.freemarker.IDictDataLoader;
import com.venues.bms.core.model.LabelValue;
import com.venues.bms.po.Region;
import com.venues.bms.service.region.RegionService;

@Component("regionComponent")
public class RegionComponent implements IDictDataLoader {

	@Autowired
	private RegionService regionService;

	@Override
	public List<LabelValue> loadDataList(String keyCode) {
		List<LabelValue> list = new ArrayList<>();
		if (StringUtils.isNotBlank(keyCode)) {
			String[] arr = keyCode.split(",");
			for (String str : arr) {
				Integer id = NumberUtils.toInt(str);
				Region region = regionService.getRegionById(id);
				if (region != null) {
					LabelValue lv = new LabelValue(region.getRegionName(), str);
					list.add(lv);
				}
			}

		}
		return list;
	}
}
