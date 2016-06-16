package com.venues.bms.web.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venues.bms.po.SysMenu;
import com.venues.bms.service.sys.AuthorityService;
import com.venues.bms.vo.Enums;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/15.
 */
@Controller
@RequestMapping(value = "/sys/auth")
public class SysAuthorityController extends BaseController {

	@Autowired
	private AuthorityService authorityService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Enums.USER_TYPE[] userTypes = Enums.USER_TYPE.values();
		Map<String, List<SysMenu>> menuMap = new HashMap<>();
		for (Enums.USER_TYPE userType : userTypes) {
			menuMap.put(userType.getCode().toString(), authorityService.queryAuthMenuTreeByUserType(userType.getCode()));
		}
		model.put("userTypes", userTypes);
		model.put("menuMap", menuMap);
		return "sys/auth/list";
	}
}
