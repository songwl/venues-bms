package com.venues.bms.web.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.SysMenu;
import com.venues.bms.po.SysUser;
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
			menuMap.put(userType.getCode().toString(), authorityService.queryAuthMenuByUserType(userType.getCode(),true));
		}
		model.put("userTypes", userTypes);
		model.put("menuMap", menuMap);
		return "sys/auth/list";
	}
	
	@RequestMapping(value = "/update/{userTypeId}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("userTypeId") java.lang.Integer userTypeId, ModelMap model) {
		List<SysMenu> list = authorityService.queryAuthMenuByUserType(userTypeId,false);
		List<Integer> userTypeMenuIds = new ArrayList<>();
		for(SysMenu menu : list){
			userTypeMenuIds.add(menu.getMenuId());
		}
		model.put("userTypeMenuIds", userTypeMenuIds);
		model.put("allMenuList", authorityService.queryAllMenuTree());
		model.put("userTypeId", userTypeId);
		return "sys/auth/edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage update(Integer userTypeId,String menuIds) {
		String[] arr = StringUtils.split(menuIds, ",");
		List<Integer> menuIdList = new ArrayList<>();
		for(String str :arr){
			menuIdList.add(NumberUtils.toInt(str));
		}
		authorityService.saveAuthorityMenus(userTypeId,menuIdList);
		return this.ajaxDoneSuccess("修改成功");
	}
}
