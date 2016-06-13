package com.venues.bms.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venues.bms.core.cache.impl.MapCache;
import com.venues.bms.core.model.LoginAccount;
import com.venues.bms.vo.CacheConstants;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = "/index")
	public String index(ModelMap model) throws Exception {
		Map<String, Object> bms = new HashMap<>();
		LoginAccount account = this.getCurrentAccount();
		bms.put("account", account);
		bms.put("bmsNavigationList", MapCache.getInstance().get(CacheConstants.CACHE_BMS_NAVIGATION_BY_USERTYPE_ + account.getLoginUserType()));
		model.addAttribute("bmsModel", bms);
		return "index";
	}

	@RequestMapping("/demo.do")
	public String demo() {
		return "demo";
	}

}
