package com.venues.bms.service.impl.page;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.PgPageContentMapper;
import com.venues.bms.dao.PgPageMapper;
import com.venues.bms.po.PgPage;
import com.venues.bms.service.page.PageService;

@Service
public class PageServiceImpl implements PageService {

	@Autowired
	private PgPageMapper pgPageMapper;

	@Autowired
	private PgPageContentMapper pgPageContentMapper;

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

	@Override
	public int updatePageStatus(int id, Integer code) {
		// TODO Auto-generated method stub
		PgPage page = new PgPage();
		page.setId(id);
		page.setPageState(code);
		return pgPageMapper.updateByPrimaryKeySelective(page);
	}

	@Override
	public int updatePublishByVenueIds(String ids) {
		pgPageMapper.updateAllPublishOff();
		return pgPageMapper.updatePublishByVenueIds(ids);
	}

	@Override
	public int updatePublish(String ids) {
		return pgPageMapper.updatePublishByIds(ids);
	}

	@Override
	public PgPage getPgPageById(int id) {
		return pgPageMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(PgPage page) {
		return pgPageMapper.updateByPrimaryKey(page);
	}

	@Override
	public int deletePage(Integer id) {
		return pgPageMapper.deleteByPrimaryKey(id);
	}

}
