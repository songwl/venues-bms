package com.venues.bms.service.page;

import java.util.List;
import java.util.Map;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.PgPage;

public interface PageService {

	Page<PgPage> findPgPages(Page<PgPage> page, Map<String, Object> params);

	List<PgPage> findPageList(Map<String, Object> params);
}
