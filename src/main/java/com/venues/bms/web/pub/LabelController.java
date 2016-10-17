package com.venues.bms.web.pub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.PubLabel;
import com.venues.bms.service.pub.LabelService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/10/17.
 */
@Controller
@RequestMapping(value = "/pub/label")
public class LabelController extends BaseController {
	
	@Autowired
	private LabelService labelService;

	@RequestMapping(value = "/autocomplete")
	@ResponseBody
	public Object queryAutoComplete(String search) throws Exception {
		JSONArray arr = new JSONArray();
		if (StringUtils.isNotBlank(search)) {
			Map<String,Object> params = new HashMap<>();
			params.put("label", search);
			params.put("begin", 0);
			params.put("offset", 10);
			List<PubLabel> list = labelService.queryByParams(params);
			for (PubLabel pl : list) {
				JSONObject obj = new JSONObject();
				obj.put("id", pl.getID());
				obj.put("text", pl.getLabel());
				arr.add(obj);
			}
		}
		return arr;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage create(String labelName) {
		labelService.saveLabel(labelName);
		return this.ajaxDoneSuccess("创建成功");
	}
}
