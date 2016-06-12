package com.venues.bms.web.sys;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.venues.bms.core.model.Page;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.SysUser;
import com.venues.bms.service.sys.UserService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/7.
 */
@Controller
@RequestMapping(value = "/sys/user")
public class SysUserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<SysUser> page = this.getPageRequest();
		Map<String, Object> searchParams = this.getSearchRequest();

		page = userService.findSysUserPage(page, searchParams);
		model.put("page", page);
		model.put("params", searchParams);
		return "sys/user/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(ModelMap model) throws Exception {
		model.put("sysUser", new SysUser());
		model.put("action", "create");
		return "sys/user/edit";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage create(SysUser sysUser) {
		userService.saveSysUser(sysUser);
		return this.ajaxDoneSuccess("创建成功");
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") java.lang.Integer id, Model model) {
		model.addAttribute("vm", userService.getSysUserByUserId(id));
		model.addAttribute("action", "update");
		return "sys/user/edit";
	}

	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") java.lang.Integer id, Model model) {
		model.addAttribute("vm", userService.getSysUserByUserId(id));
		return "sys/user/view";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage update(SysUser sysUser) {
		userService.saveSysUser(sysUser);
		return this.ajaxDoneSuccess("修改成功");
	}
}
