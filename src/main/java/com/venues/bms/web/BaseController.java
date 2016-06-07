package com.venues.bms.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.venues.bms.core.cache.impl.MapCache;
import com.venues.bms.core.model.LoginAccount;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.core.spring.interceptor.BaseCommController;
import com.venues.bms.core.spring.interceptor.HttpLocalThread;
import com.venues.bms.core.utils.ServletUtil;
import com.venues.bms.vo.CacheConstants;

/**
 * 
 * Created by song on 2016/6/2.
 *
 */
public abstract class BaseController extends BaseCommController {

	protected LoginAccount getCurrentAccount() {
		return (LoginAccount) getSession(ServletUtil.SESSION_USER);
	}

	protected Integer getCurrentAccountId() {
		LoginAccount account = getCurrentAccount();
		if (account != null) {
			return account.getLoginUserId();
		}
		return null;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
	}

	protected void clearResponseCache() {
		//防止缓存
		HttpLocalThread.getResponse().setDateHeader("expires", 0);
		HttpLocalThread.getResponse().setHeader("Cache-Control", "no-cache");
		HttpLocalThread.getResponse().setHeader("pragma", "no-cache");
	}

	protected ResultMessage ajaxDone(int statusCode, String message, Object data) {
		ResultMessage mav = ResultMessage.create();
		mav.setCode(statusCode);
		mav.setMessage(message);
		mav.put("status", statusCode);
		mav.put("message", message);
		if (data != null) {
			mav.put("data", data);
		}
		return mav;
	}

	protected ResultMessage ajaxDoneSuccess(String message) {
		return ajaxDone(ResultMessage.SUCCESS_CODE, message, null);
	}

	protected ResultMessage ajaxDoneError(String message) {
		return ajaxDone(ResultMessage.ERROR_CODE, message, null);
	}

	protected ResultMessage ajaxDoneError(String message, Object data) {
		return ajaxDone(ResultMessage.ERROR_CODE, message, data);
	}

	protected ResultMessage ajaxDoneSuccess(String message, Object data) {
		return ajaxDone(ResultMessage.SUCCESS_CODE, message, data);
	}

	@ModelAttribute
	public void loadBms(Model model, @RequestParam(defaultValue = "0") Integer navId) {
		Map<String, Object> bms = new HashMap<>();
		bms.put("navId", navId);
		LoginAccount account = this.getCurrentAccount();
		if (account != null) {
			bms.put("account", account);
			bms.put("bmsNavigationList", MapCache.getInstance().get(CacheConstants.CACHE_BMS_NAVIGATION_BY_USERTYPE_ + account.getLoginUserType()));
		}
		model.addAttribute("bmsModel", bms);
	}
}
