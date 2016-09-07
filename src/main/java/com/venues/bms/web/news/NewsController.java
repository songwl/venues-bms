package com.venues.bms.web.news;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.venues.bms.core.model.Constant;
import com.venues.bms.core.model.Page;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.NeNews;
import com.venues.bms.service.news.NewsService;
import com.venues.bms.vo.Enums;
import com.venues.bms.vo.FlexParam;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/8/10.
 */
@Controller
@RequestMapping(value = "/news")
public class NewsController extends BaseController {

	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<NeNews> page = this.getPageRequest();
		Map<String, Object> params = this.getSearchRequest();

		page.setPageSize(200);
		page = newsService.findNewsPage(page, params);
		model.put("page", page);
		model.put("searchParams", params);
		return "news/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(ModelMap model) throws Exception {
		FlexParam param = new FlexParam();
		param.setTpType(FlexParam.TP_TYPE.page.name());
		param.setIsNewOrModify(0);
		param.setIsOnlyView(0);
		param.setPageTypeID(Enums.PAGE_TYPE.NewsPage.getCode());
		param.setUserId(this.getCurrentAccountId());
		param.setUserType(this.getCurrentAccount().getLoginUserType());
		return "redirect:" + Constant.getInstance().getProperty("flex_url") + "?" + param.toString();
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") java.lang.Integer id, ModelMap model) {
		FlexParam param = new FlexParam();
		param.setTpType(FlexParam.TP_TYPE.page.name());
		param.setTpID(id);
		param.setIsNewOrModify(1);
		param.setIsOnlyView(0);
		param.setPageTypeID(Enums.PAGE_TYPE.NewsPage.getCode());
		param.setUserId(this.getCurrentAccountId());
		param.setUserType(this.getCurrentAccount().getLoginUserType());
		return "redirect:" + Constant.getInstance().getProperty("flex_url") + "?" + param.toString();
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") java.lang.Integer id, ModelMap model) {
		NeNews news = newsService.getNewsById(id);
		FlexParam param = new FlexParam();
		param.setTpType(FlexParam.TP_TYPE.page.name());
		param.setTpID(news.getNewsPage());
		param.setIsNewOrModify(1);
		param.setIsOnlyView(1);
		param.setPageTypeID(Enums.PAGE_TYPE.NewsPage.getCode());
		param.setUserId(this.getCurrentAccountId());
		param.setUserType(this.getCurrentAccount().getLoginUserType());
		return "redirect:" + Constant.getInstance().getProperty("flex_url") + "?" + param.toString();
	}

	@RequestMapping(value = "/exchange", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage exchange(Integer orgId, Integer destId) {
		NeNews org = newsService.getNewsById(orgId);
		NeNews dest = newsService.getNewsById(destId);
		int temp = org.getNewsSequence();
		org.setNewsSequence(dest.getNewsSequence());
		dest.setNewsSequence(temp);
		newsService.updateNews(org);
		newsService.updateNews(dest);
		return this.ajaxDoneSuccess("");
	}
}
