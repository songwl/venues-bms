package com.venues.bms.web.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.venues.bms.service.page.PageService;
import com.venues.bms.vo.GenPage;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/7/24.
 */
@Controller
@RequestMapping(value = "/page")
public class PageGenerateController extends BaseController {

	@Autowired
	private PageService pageService;

	@RequestMapping(value = "/generate/{id}")
	public String generate(ModelMap model, @PathVariable Integer id) throws Exception {
		pageService.generatePage(id);
		return "redirect:/upload/" + id + ".html";
	}

	@RequestMapping(value = "/review/{id}", method = RequestMethod.GET)
	public String review(ModelMap model, @PathVariable Integer id) throws Exception {
		GenPage page = pageService.getPageDetail(id);
		model.put("page", page);
		return "pg/review";
	}

}
