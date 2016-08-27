package com.venues.bms.service.news;

import java.util.List;
import java.util.Map;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.NeNews;

public interface NewsService {

	Page<NeNews> findNewsPage(Page<NeNews> page, Map<String, Object> params);

	List<NeNews> findNewsList(Map<String, Object> params);

	NeNews getNewsById(Integer id);

	int updateNews(NeNews news);

}
