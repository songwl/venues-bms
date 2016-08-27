package com.venues.bms.web.guest;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.venues.bms.core.model.Page;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.GuGuest;
import com.venues.bms.po.GuGuestMessage;
import com.venues.bms.service.guest.GuestService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/8/10.
 */
@Controller
@RequestMapping(value = "/guest")
public class GuestController extends BaseController {

	@Autowired
	private GuestService guestService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<GuGuest> page = this.getPageRequest();
		Map<String, Object> params = this.getSearchRequest();

		page = guestService.findGuestPage(page, params);
		model.put("page", page);
		model.put("searchParams", params);
		return "guest/list";
	}

	@RequestMapping(value = "/view/{id}")
	public String view(ModelMap model, @PathVariable Integer id) throws Exception {
		List<GuGuestMessage> guestMessages = guestService.findGuestMessageByGuestId(id);
		model.put("guestMessages", guestMessages);
		return "guest/message_list";
	}

	@RequestMapping(value = "/batchDelete")
	@ResponseBody
	public ResultMessage delete(ModelMap model, @RequestParam String ids) throws Exception {
		String[] idArr = ids.split(",");
		for (String str : idArr) {
			Integer id = NumberUtils.toInt(str);
			guestService.deleteGuest(id);
		}

		return ajaxDoneSuccess("删除成功！");
	}

	@RequestMapping(value = "／message/batchDelete")
	@ResponseBody
	public ResultMessage deleteMessage(ModelMap model, @RequestParam String ids) throws Exception {
		String[] idArr = ids.split(",");
		for (String str : idArr) {
			Integer id = NumberUtils.toInt(str);
			guestService.deleteGuestMessage(id);
		}
		return ajaxDoneSuccess("删除成功！");
	}

}
