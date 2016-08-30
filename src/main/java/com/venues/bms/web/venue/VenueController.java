package com.venues.bms.web.venue;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.venues.bms.core.crypto.CryptoUtils;
import com.venues.bms.core.model.Page;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.NeNews;
import com.venues.bms.po.SysUser;
import com.venues.bms.po.VeVenue;
import com.venues.bms.po.VeVenueAttr;
import com.venues.bms.po.VeVenueMeetingroom;
import com.venues.bms.service.attr.AttrService;
import com.venues.bms.service.sys.LogService;
import com.venues.bms.service.sys.UserService;
import com.venues.bms.service.venue.VenueService;
import com.venues.bms.vo.Enums;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/7.
 */
@Controller
@RequestMapping(value = "/venue")
public class VenueController extends BaseController {

	@Autowired
	private VenueService venueService;

	@Autowired
	private LogService logService;

	@Autowired
	private AttrService attrService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<VeVenue> page = this.getPageRequest();
		Map<String, Object> params = this.getSearchRequest();
		if (!isAdmin()) {
			params.put("createUserId", getCurrentAccountId());
		}
		page = venueService.findVenuePage(page, params);
		model.put("page", page);
		model.put("searchParams", params);
		return "venue/list";
	}
	
	@RequestMapping(value = "/meetinglist")
	public String meetingList(ModelMap model,@RequestParam Integer venueID) throws Exception {
		Map<String, Object> params = this.getSearchRequest();
		params.put("venueID", venueID);
		List<VeVenueMeetingroom> list =  venueService.findMeetingList(params);
		model.put("list", list);
		model.put("searchParams", params);
		model.put("venueID", venueID);
		return "venue/meetinglist";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(ModelMap model) throws Exception {
		model.put("venue", new VeVenue());
		model.put("attrGroups", attrService.findAttrGroups());
		model.put("action", "create");
		return "venue/edit";
	}
	
	@RequestMapping(value = "/newMeeting/{venueID}", method = RequestMethod.GET)
	public String createMeetingForm(ModelMap model,@PathVariable Integer venueID) throws Exception {
		VeVenueMeetingroom meeting=new VeVenueMeetingroom();
		meeting.setVenueID(venueID);
		model.put("meeting", meeting);
		model.put("action", "createMeeting");
		return "venue/editMeeting";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage create(VeVenue venue) {
		venue.setCreateTime(new Date());
		venue.setCreateUserId(getCurrentAccountId());

		String userLoginname = venue.getVenueManager();
		if (StringUtils.isNotEmpty(userLoginname)) {
			SysUser su = userService.getSysUserByLoginname(userLoginname);
			if (su != null) {
				return this.ajaxDoneError("场所管理员名已存在");
			}
			int managerId = registSysUser(userLoginname);
			venue.setManagerId(managerId);
		}

		venueService.save(venue, venue.getAttrs().values());

		logService.saveLog(Enums.LOG_TYPE.NEW, this.getCurrentAccount().getLoginUsername(), "创所管理", JSONObject.toJSONString(venue));
		return this.ajaxDoneSuccess("创建成功");
	}
	
	@RequestMapping(value = "/createMeeting", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage createMeeting(VeVenueMeetingroom venue) {
		venueService.saveMeeting(venue);
		logService.saveLog(Enums.LOG_TYPE.NEW, this.getCurrentAccount().getLoginUsername(), "会议室管理", JSONObject.toJSONString(venue));
		return this.ajaxDoneSuccess("创建成功");
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") java.lang.Integer id, ModelMap model) {
		model.put("venue", venueService.getVenueById(id));
		model.put("attrGroups", attrService.findAttrGroups());
		model.put("action", "update");
		return "venue/edit";
	}

	@RequestMapping(value = "/updateMeeting/{id}", method = RequestMethod.GET)
	public String updateMeetingForm(@PathVariable("id") java.lang.Integer id, ModelMap model) {
		model.put("meeting", venueService.getVenueMeetingroomById(id));
		model.put("action", "updateMeeting");
		return "venue/editMeeting";
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") java.lang.Integer id, Model model) {
		model.addAttribute("venue", venueService.getVenueById(id));
		return "venue/view";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage update(VeVenue venue) {
		venueService.update(venue, venue.getAttrs().values());

		logService.saveLog(Enums.LOG_TYPE.UPDATE, this.getCurrentAccount().getLoginUsername(), "场所管理", JSONObject.toJSONString(venue));
		return this.ajaxDoneSuccess("修改成功");
	}
	
	@RequestMapping(value = "/updateMeeting", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage updateMeeting(VeVenueMeetingroom venue) {
		venueService.updateMeeting(venue);

		logService.saveLog(Enums.LOG_TYPE.UPDATE, this.getCurrentAccount().getLoginUsername(), "会议室管理", JSONObject.toJSONString(venue));
		return this.ajaxDoneSuccess("修改成功");
	}

	/*@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage delete(@PathVariable("id") Integer userId) {
		venueService.deleteSysUserByUserId(userId);
	
		logService.saveLog(Enums.LOG_TYPE.DELETE, this.getCurrentAccount().getLoginUsername(), "用户管理", "删除：userId=" + userId);
		return this.ajaxDoneSuccess("删除成功");
	}*/

	private int registSysUser(String userLoginname) {
		SysUser sysUser = new SysUser();
		sysUser.setUserLoginname(userLoginname);
		sysUser.setUserName(userLoginname);
		//初始密码都默认为123456
		sysUser.setUserPassword(CryptoUtils.md5("123456"));
		sysUser.setUserTypeid(Enums.USER_TYPE.VENUE_MANAGER.getCode());
		sysUser = userService.saveSysUser(sysUser);
		return sysUser.getUserId();
	}

	@RequestMapping(value = "/queryAutoComplete")
	@ResponseBody
	public Object queryAutoComplete(String search) throws Exception {
		JSONArray arr = new JSONArray();
		if (StringUtils.isNotBlank(search)) {
			List<VeVenueAttr> list = venueService.searchAttrValue("venueName", search);
			for (VeVenueAttr attr : list) {
				JSONObject obj = new JSONObject();
				obj.put("id", attr.getVenueId());
				obj.put("text", attr.getAttrValue());
				arr.add(obj);
			}
		}
		return arr;
	}
	
	@RequestMapping(value = "/exchangeMeeting", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage exchange(Integer orgId, Integer destId) {
		VeVenueMeetingroom org = venueService.getVenueMeetingroomById(orgId);
		VeVenueMeetingroom dest = venueService.getVenueMeetingroomById(destId);
		int temp = org.getMRSequence();
		org.setMRSequence(dest.getMRSequence());
		dest.setMRSequence(temp);
		venueService.updateMeeting(org);
		venueService.updateMeeting(dest);
		return this.ajaxDoneSuccess("");
	}
}
