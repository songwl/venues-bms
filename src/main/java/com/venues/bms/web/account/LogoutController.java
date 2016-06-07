package com.venues.bms.web.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venues.bms.core.utils.ServletUtil;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/2.
 */
@Controller
@RequestMapping(value = "/logout")
public class LogoutController extends BaseController {
	//视图地址映射
	public static final String V_PATH = "/login";

	@RequestMapping(value = "")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		ServletUtil.removeSession(request, response, ServletUtil.SESSION_USER);
		return V_PATH;
	}

}
