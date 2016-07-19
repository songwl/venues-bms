package com.venues.bms.web.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.MoModule;
import com.venues.bms.service.module.ModuleService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/21.
 */
@Controller
@RequestMapping(value = "/module")
public class ModuleController extends BaseController {

	@Autowired
	private ModuleService moduleService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<MoModule> page = this.getPageRequest();
		Map<String, Object> params = this.getSearchRequest();

		List<String> orderBy = new ArrayList<>();
		orderBy.add("id desc");
		page.setOrderBy(orderBy);
		page = moduleService.findModulePage(page, params);
		model.put("page", page);
		model.put("searchParams", params);
		return "module/list";
	}

	@RequestMapping(value = "/main")
	public String main(ModelMap model) throws Exception {

		return "module/main";
	}

	@RequestMapping(value = "/edit")
	public String edit(ModelMap model) throws Exception {

		return "module/edit";
	}
}
