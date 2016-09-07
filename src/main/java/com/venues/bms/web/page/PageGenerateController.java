package com.venues.bms.web.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.venues.bms.core.model.Constant;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.VeVenue;
import com.venues.bms.service.page.PageService;
import com.venues.bms.service.venue.VenueService;
import com.venues.bms.vo.Enums;
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
	
	@Autowired
	private VenueService venueService;

	@RequestMapping(value = "/generate/{id}")
	public String generate(ModelMap model, @PathVariable Integer id) throws Exception {
		pageService.generatePage(id);
		return "redirect:"+Constant.getInstance().getProperty("static_host")+"/pages/" + id + ".html";
	}

	@RequestMapping(value = "/review/{id}", method = RequestMethod.GET)
	public String review(ModelMap model, @PathVariable Integer id) throws Exception {
		GenPage page = pageService.getPageDetail(id);
		model.put("page", page);
		return "pg/review";
	}
	
	@RequestMapping(value = "/buildHomePage", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage buildHomePage(@RequestParam Integer venueId,@RequestParam("languageCode") String languageCode) {
		//获取当然场所信息，将场所信息根据语种的不同生成默认的首页，若之前有首页则替换之前的首页
		VeVenue venue = venueService.getVenueById(venueId);
		pageService.buildHomePage(venue,languageCode);

		return this.ajaxDoneSuccess("成功");
	}

}
