package com.venues.bms.service.region;

import java.util.List;

import com.venues.bms.po.Region;

public interface RegionService {

	List<Region> queryRegionByParentId(Integer pid);

}
