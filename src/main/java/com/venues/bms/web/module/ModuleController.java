package com.venues.bms.web.module;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/21.
 */
@Controller
@RequestMapping(value = "/module")
public class ModuleController extends BaseController {
	
	//@Autowired
	//private ModuleService moduleService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		
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
