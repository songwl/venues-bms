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

import com.venues.bms.core.crypto.CryptoUtils;
import com.venues.bms.core.model.Page;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.SysLog;
import com.venues.bms.service.sys.LogService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/13.
 */
@Controller
@RequestMapping(value = "/sys/log")
public class SysLogController extends BaseController {

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<SysLog> page = this.getPageRequest();
		Map<String, Object> searchParams = this.getSearchRequest();

		page = logService.findSysLogPage(page, searchParams);
		model.put("page", page);
		model.put("searchParams", searchParams);
		return "sys/log/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage delete(@PathVariable("id") Integer logId) {
		logService.deleteSysLogByLogId(logId);
		return this.ajaxDoneSuccess("删除成功");
	}

}
