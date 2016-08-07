package com.venues.bms.web.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.Region;
import com.venues.bms.service.region.RegionService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/21.
 */
@Controller
@RequestMapping(value = "/region")
public class RegionController extends BaseController {
	@Autowired
	private RegionService regionService;

	@RequestMapping(value = "/queryByPid", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage queryByPid(@RequestParam Integer pid) {
		List<Region> items = regionService.queryRegionByParentId(pid);
		return this.ajaxDoneSuccess("创建成功", items);
	}
}
