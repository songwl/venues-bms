package com.venues.bms.service.impl.page;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.PgPageMapper;
import com.venues.bms.po.PgPage;
import com.venues.bms.service.page.PageService;

@Service
public class PageServiceImpl implements PageService{

	@Autowired
	private PgPageMapper pgPageMapper;
	
	@Override
	public Page<PgPage> findPgPages(Page<PgPage> page, Map<String, Object> params) {
		
		int count = pgPageMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<PgPage> list = findPageList(params);
			page.setItemList(list);
		}
		return page;
	}

	@Override
	public List<PgPage> findPageList(Map<String, Object> params) {
		return pgPageMapper.selectByParams(params);
	}

}
