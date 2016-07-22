package com.venues.bms.service.impl.attr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.dao.AtAttrGroupMapper;
import com.venues.bms.dao.AtAttrMapper;
import com.venues.bms.po.AtAttrGroup;
import com.venues.bms.service.attr.AttrService;

@Service
public class AttrServiceImpl implements AttrService {

	@Autowired
	private AtAttrGroupMapper atAttrGroupMapper;

	@Autowired
	private AtAttrMapper atAttrMapper;

	@Override
	public List<AtAttrGroup> findAttrGroups() {
		List<AtAttrGroup> groups = atAttrGroupMapper.selectAll();
		for (AtAttrGroup group : groups) {
			group.setAttrs(atAttrMapper.selectByGroupId(group.getId()));
		}
		return groups;
	}

}
