package com.venues.bms.web.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.venues.bms.core.cache.CacheHelper;
import com.venues.bms.core.cache.impl.MapCache;
import com.venues.bms.core.crypto.CryptoUtils;
import com.venues.bms.core.model.LoginAccount;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.core.utils.ServletUtil;
import com.venues.bms.service.sys.UserService;
import com.venues.bms.vo.CacheConstants;
import com.venues.bms.web.BaseController;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * Created by song on 2016/6/2.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

	public static final String V_PATH_LOGIN = "/login";
	public static final String V_PATH_AJAX_LOGIN = "/unauthorized";

	@Autowired
	private UserService userService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		return V_PATH_LOGIN;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String dologin(@RequestParam String loginName, @RequestParam String password, @RequestParam(required = false, defaultValue = "false") boolean rememberMe, Model model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (StringUtils.isNotEmpty(loginName) && StringUtils.isNotEmpty(password)) {
			LoginAccount account = userService.getSysUserByLoginname(loginName);
			if (account != null && account.getLoginPassword().equals(CryptoUtils.md5(password))) {
				boolean flag = executeLogin(request, response, account);
				if (flag) {
					return "redirect:/index";
				} else {
					model.addAttribute("loginFailureMessage", "系统异常");
				}
			} else {
				model.addAttribute("loginName", loginName);
				model.addAttribute("loginFailureMessage", "用户名密码错误");
			}
		} else {
			model.addAttribute("loginFailureMessage", "用户名密码不能为空");
		}

		return V_PATH_LOGIN;
	}

	@RequestMapping(value = "ajax", method = RequestMethod.POST)
	public ResultMessage ajaxlogin(@RequestParam String loginName, @RequestParam String password, @RequestParam(required = false, defaultValue = "false") boolean rememberMe,
			HttpServletRequest request, HttpServletResponse response) {
		String loginFailureMessage = "";
		if (StringUtils.isNotEmpty(loginName) && StringUtils.isNotEmpty(password)) {
			LoginAccount account = userService.getSysUserByLoginname(loginName);
			if (account != null && account.getLoginPassword().equals(CryptoUtils.md5(password))) {
				boolean flag = executeLogin(request, response, account);
				if (flag) {
					return this.ajaxDoneSuccess("登录成功");
				} else {
					loginFailureMessage = "系统异常";
				}
			} else {
				loginFailureMessage = "用户名密码错误";
			}
		} else {
			loginFailureMessage = "用户名密码不能为空";
		}
		return this.ajaxDoneError("登录失败", loginFailureMessage);

	}

	@RequestMapping(value = "unauthorized", method = RequestMethod.GET)
	public String unauthorized(HttpServletRequest request) {
		return V_PATH_LOGIN;
	}

	private boolean executeLogin(HttpServletRequest request, HttpServletResponse response, LoginAccount account) {
		try {
			ServletUtil.initMaidouSessionId(request, response);
			ServletUtil.putSession(request, response, ServletUtil.SESSION_USER, account);
			//后台导航缓存
			CacheHelper cacheHelper = MapCache.getInstance();
			String key = CacheConstants.CACHE_BMS_NAVIGATION_BY_USERTYPE_ + account.getLoginUserType();
			if (!cacheHelper.has(key)) { //缓存
				cacheHelper.put(key, userService.queryUserMenuByUserId(account.getLoginUserId()));
			}
		} catch (Exception e) {
			//登陆失败
			return false;
		}
		return true;
	}

}
