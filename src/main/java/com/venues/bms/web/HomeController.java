package com.venues.bms.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = "/index")
	public String index(ModelMap map) throws Exception {
		return "index";
	}

	@RequestMapping("/demo.do")
	public String demo() {
		return "demo";
	}

}
