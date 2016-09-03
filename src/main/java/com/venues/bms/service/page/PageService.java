package com.venues.bms.service.page;

import java.util.List;
import java.util.Map;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.PgPage;
import com.venues.bms.vo.GenPage;

public interface PageService {

	Page<PgPage> findPgPages(Page<PgPage> page, Map<String, Object> params);

	List<PgPage> findPageList(Map<String, Object> params);

	int updatePageStatus(int id, Integer code);

	int updatePublishByVenueIds(String ids);

	int updatePublish(String ids);

	PgPage getPgPageById(int id);

	int update(PgPage page);

	int deletePage(Integer id);

	GenPage getPageDetail(int id);

	int generatePage(int id);
}
