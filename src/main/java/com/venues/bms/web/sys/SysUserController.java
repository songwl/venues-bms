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

import com.alibaba.fastjson.JSONObject;
import com.venues.bms.core.crypto.CryptoUtils;
import com.venues.bms.core.model.Page;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.SysUser;
import com.venues.bms.service.sys.LogService;
import com.venues.bms.service.sys.UserService;
import com.venues.bms.vo.Enums;
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

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<SysUser> page = this.getPageRequest();
		Map<String, Object> searchParams = this.getSearchRequest();

		page = userService.findSysUserPage(page, searchParams);
		model.put("page", page);
		model.put("searchParams", searchParams);
		return "sys/user/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(ModelMap model) throws Exception {
		model.put("sysUser", new SysUser());
		model.put("action", "create");
		return "sys/user/edit";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage create(SysUser sysUser) {
		SysUser su = userService.getSysUserByLoginname(sysUser.getUserLoginname());
		if (su != null) {
			return this.ajaxDoneError("登录名已存在");
		}
		//初始密码都默认为123456
		sysUser.setUserPassword(CryptoUtils.md5("123456"));
		userService.saveSysUser(sysUser);

		logService.saveLog(Enums.LOG_TYPE.NEW, this.getCurrentAccount().getLoginUsername(), "用户管理", JSONObject.toJSONString(sysUser));
		return this.ajaxDoneSuccess("创建成功");
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") java.lang.Integer id, Model model) {
		model.addAttribute("sysUser", userService.getSysUserByUserId(id));
		model.addAttribute("action", "update");
		return "sys/user/edit";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") java.lang.Integer id, Model model) {
		model.addAttribute("sysUser", userService.getSysUserByUserId(id));
		return "sys/user/view";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage update(SysUser sysUser) {
		SysUser dbUser = userService.getSysUserByUserId(sysUser.getUserId());
		dbUser.setUserName(sysUser.getUserName());
		dbUser.setUserTypeid(sysUser.getUserTypeid());
		userService.updateSysUser(dbUser);

		logService.saveLog(Enums.LOG_TYPE.UPDATE, this.getCurrentAccount().getLoginUsername(), "用户管理", JSONObject.toJSONString(sysUser));
		return this.ajaxDoneSuccess("修改成功");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage delete(@PathVariable("id") Integer userId) {
		userService.deleteSysUserByUserId(userId);

		logService.saveLog(Enums.LOG_TYPE.DELETE, this.getCurrentAccount().getLoginUsername(), "用户管理", "删除：userId=" + userId);
		return this.ajaxDoneSuccess("删除成功");
	}

	/**
	 * 重置密码
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/reset/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage reset(@PathVariable("id") Integer userId) {
		SysUser dbUser = userService.getSysUserByUserId(userId);
		dbUser.setUserPassword(CryptoUtils.md5("123456"));
		userService.updateSysUser(dbUser);

		logService.saveLog(Enums.LOG_TYPE.UPDATE, this.getCurrentAccount().getLoginUsername(), "用户管理", "重置密码：userId=" + userId);
		return this.ajaxDoneSuccess("重置成功");
	}
}
