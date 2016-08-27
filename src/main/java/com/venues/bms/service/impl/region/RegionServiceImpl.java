package com.venues.bms.service.impl.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.dao.RegionMapper;
import com.venues.bms.po.Region;
import com.venues.bms.service.region.RegionService;

@Service("RegionService")
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionMapper regionMapper;

	@Override
	public List<Region> queryRegionByParentId(Integer pid) {
		return regionMapper.selectByParentId(pid);
	}

	@Override
	public Region getRegionById(Integer id) {
		return regionMapper.selectByPrimaryKey(id);
	}

}
