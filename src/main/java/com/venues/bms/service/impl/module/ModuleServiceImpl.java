package com.venues.bms.service.impl.module;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.MoModuleMapper;
import com.venues.bms.po.MoModule;
import com.venues.bms.service.module.ModuleService;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private MoModuleMapper moModuleMapper;

	@Override
	public Page<MoModule> findModulePage(Page<MoModule> page, Map<String, Object> params) {
		int count = moModuleMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<MoModule> list = findModuleList(params);
			page.setItemList(list);
		}
		return page;
	}

	@Override
	public List<MoModule> findModuleList(Map<String, Object> params) {
		return moModuleMapper.selectByParams(params);
	}

}
