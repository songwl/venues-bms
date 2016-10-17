package com.venues.bms.web.pub;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/10/17.
 */
@Controller
@RequestMapping(value = "/pub/tag")
public class TagController extends BaseController {

	@RequestMapping(value = "/autocomplete")
	@ResponseBody
	public Object queryAutoComplete(String search) throws Exception {
		JSONArray arr = new JSONArray();
		if (StringUtils.isNotBlank(search)) {
			//			List<VeVenueAttr> list = venueService.searchAttrValue("venueName", search);
			//			for (VeVenueAttr attr : list) {
			//				JSONObject obj = new JSONObject();
			//				obj.put("id", attr.getVenueId());
			//				obj.put("text", attr.getAttrValue());
			//				arr.add(obj);
			//			}
		}
		return arr;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage create(String tagName) {
		return this.ajaxDoneSuccess("创建成功");
	}
}
