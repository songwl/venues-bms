package com.venues.bms.web.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.PgPage;
import com.venues.bms.po.VeVenue;
import com.venues.bms.service.page.PageService;
import com.venues.bms.service.sys.LogService;
import com.venues.bms.service.venue.VenueService;
import com.venues.bms.vo.Enums;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/7/25.
 */
@Controller
@RequestMapping(value = "/page/publish")
public class PagePublishController extends BaseController {
	@Autowired
	private PageService pageService;

	@Autowired
	private VenueService venueService;

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model, @RequestParam(required = false) Integer stateId, @RequestParam(required = false) Integer provinceId, @RequestParam(required = false) Integer cityId)
			throws Exception {
		Map<String, Object> params = this.getSearchRequest();
		params.put("pageState", Enums.PAGE_STATUS.AuditPass.getCode());

		List<PgPage> list = pageService.findPageList(params);
		Set<Integer> venueIds = new HashSet<>();
		for (PgPage pg : list) {
			venueIds.add(pg.getVenueID());
		}

		if (!venueIds.isEmpty()) {
			String ids = StringUtils.join(venueIds, ",");
			Map<String, Object> map = new HashMap<>();
			map.put("ids", ids);
			map.put("stateId", stateId);
			map.put("provinceId", provinceId);
			map.put("cityId", cityId);
			List<String> orderBy = new ArrayList<>();
			orderBy.add("seq desc");
			map.put("orderBy", orderBy);
			List<VeVenue> itemLists = venueService.findVenueList(map);
			model.put("itemList", itemLists);
			model.put("searchParams", map);
		}
		return "pg/publish_list";
	}

	/**
	 * 通过场所发布
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/batchPublish", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage batchPublishByVenueIds(String ids) {
		pageService.updatePublishByVenueIds(ids);
		//logService.saveLog(Enums.LOG_TYPE.UPDATE, this.getCurrentAccount().getLoginUsername(), "页面审核", "批量页面审核通过：资源ID=" + ids);
		return this.ajaxDoneSuccess("发布成功");
	}

	/**
	 * 通过页面发布
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/pagePublish", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage pagePublish(String ids) {
		pageService.updatePublish(ids);
		//logService.saveLog(Enums.LOG_TYPE.UPDATE, this.getCurrentAccount().getLoginUsername(), "页面审核", "批量页面审核通过：资源ID=" + ids);
		return this.ajaxDoneSuccess("发布成功");
	}

	@RequestMapping(value = "/exchange", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage exchange(Integer orgId, Integer destId) {
		VeVenue org = venueService.getVenueById(orgId);
		VeVenue dest = venueService.getVenueById(destId);
		int temp = org.getSeq();
		org.setSeq(dest.getSeq());
		dest.setSeq(temp);
		venueService.updateVenue(org);
		venueService.updateVenue(dest);
		return this.ajaxDoneSuccess("");
	}

	@RequestMapping(value = "/top", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage top(Integer topId, Integer oldId) {
		VeVenue page = venueService.getVenueById(topId);
		VeVenue old = venueService.getVenueById(oldId);
		page.setSeq(old.getSeq() + 1);
		venueService.updateVenue(page);
		return this.ajaxDoneSuccess("");
	}
}
