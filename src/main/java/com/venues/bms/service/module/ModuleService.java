package com.venues.bms.service.module;

import java.util.List;
import java.util.Map;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.MoModule;

public interface ModuleService {

	Page<MoModule> findModulePage(Page<MoModule> page, Map<String, Object> params);

	List<MoModule> findModuleList(Map<String, Object> params);
}
