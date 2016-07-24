package com.venues.bms.web.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.PgPage;
import com.venues.bms.service.page.PageService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/7/24.
 */
@Controller
@RequestMapping(value = "/page")
public class PageController extends BaseController {

	@Autowired
	private PageService pageService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<PgPage> page = this.getPageRequest();
		Map<String, Object> params = this.getSearchRequest();

		List<String> orderBy = new ArrayList<>();
		orderBy.add("id desc");
		page.setOrderBy(orderBy);
		page = pageService.findPgPages(page, params);
		model.put("page", page);
		model.put("searchParams", params);
		return "pg/list";
	}

}
