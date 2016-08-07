package com.venues.bms.web.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.venues.bms.core.model.Page;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.PgPage;
import com.venues.bms.service.page.PageService;
import com.venues.bms.service.sys.LogService;
import com.venues.bms.vo.Enums;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/7/25.
 */
@Controller
@RequestMapping(value = "/page/audit")
public class PageAuditController extends BaseController {

	@Autowired
	private PageService pageService;

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<PgPage> page = this.getPageRequest();
		Map<String, Object> params = this.getSearchRequest();

		List<String> orderBy = new ArrayList<>();
		orderBy.add("id desc");
		page.setOrderBy(orderBy);
		page = pageService.findPgPages(page, params);
		model.put("page", page);
		model.put("searchParams", params);
		return "pg/audit_list";
	}

	@RequestMapping(value = "/batchPass", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage batchPass(String ids) {
		String[] arr = ids.split(",");
		for (String str : arr) {
			int id = NumberUtils.toInt(str);
			if (id > 0) {
				pageService.updatePageStatus(id, Enums.PAGE_STATUS.AuditPass.getCode());
			}
		}
		logService.saveLog(Enums.LOG_TYPE.UPDATE, this.getCurrentAccount().getLoginUsername(), "页面审核", "批量页面审核通过：资源ID=" + ids);
		return this.ajaxDoneSuccess("批量审核成功");
	}

	@RequestMapping(value = "/batchUnPass", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage batchUnPass(String ids) {
		String[] arr = ids.split(",");
		for (String str : arr) {
			int id = NumberUtils.toInt(str);
			if (id > 0) {
				pageService.updatePageStatus(id, Enums.PAGE_STATUS.AuditNotPass.getCode());
			}
		}
		logService.saveLog(Enums.LOG_TYPE.UPDATE, this.getCurrentAccount().getLoginUsername(), "页面审核", "批量页面审核不通过：页面ID=" + ids);
		return this.ajaxDoneSuccess("批量审核成功");
	}

}
