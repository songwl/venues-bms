package com.venues.bms.service.impl.news;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.NeNewsMapper;
import com.venues.bms.dao.PgPageMapper;
import com.venues.bms.po.NeNews;
import com.venues.bms.service.news.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NeNewsMapper neNewsMapper;

	@Autowired
	private PgPageMapper pgPageMapper;

	@Override
	public Page<NeNews> findNewsPage(Page<NeNews> page, Map<String, Object> params) {
		int count = neNewsMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<NeNews> list = findNewsList(params);
			page.setItemList(list);
		}
		return page;
	}

	@Override
	public List<NeNews> findNewsList(Map<String, Object> params) {
		List<NeNews> newsList = neNewsMapper.selectByParams(params);
		for (NeNews news : newsList) {
			if (news.getNewsPage() != null) {
				news.setPage(pgPageMapper.selectByPrimaryKey(news.getNewsPage()));
			}
		}
		return newsList;
	}

	@Override
	public NeNews getNewsById(Integer id) {
		return neNewsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateNews(NeNews news) {
		return neNewsMapper.updateByPrimaryKey(news);
	}

}
