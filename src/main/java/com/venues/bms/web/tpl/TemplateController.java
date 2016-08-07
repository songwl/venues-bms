package com.venues.bms.web.tpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.venues.bms.core.model.Constant;
import com.venues.bms.core.model.Page;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.TmpTemplate;
import com.venues.bms.po.TplTemplate;
import com.venues.bms.service.sys.LogService;
import com.venues.bms.service.tpl.TemplateService;
import com.venues.bms.vo.Enums;
import com.venues.bms.vo.FlexParam;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/7/3.
 */
@Controller
@RequestMapping(value = "/template")
public class TemplateController extends BaseController {

	@Autowired
	private TemplateService templateService;

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<TmpTemplate> page = this.getPageRequest();
		Map<String, Object> params = this.getSearchRequest();

		List<String> orderBy = new ArrayList<>();
		orderBy.add("id desc");
		page.setOrderBy(orderBy);
		page = templateService.findTemplatePage(page, params);
		model.put("page", page);
		model.put("searchParams", params);
		return "template/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(ModelMap model) throws Exception {
		FlexParam param = new FlexParam();
		param.setTpType(FlexParam.TP_TYPE.template.name());
		param.setIsNewOrModify(0);
		param.setIsOnlyView(0);
		param.setUserId(this.getCurrentAccountId());
		param.setUserType(this.getCurrentAccount().getLoginUserType());
		return "redirect:" + Constant.getInstance().getProperty("flex_url") + "?" + param.toString();
	}

	/*@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String createForm(ModelMap model) throws Exception {
		model.put("template", new TplTemplate());
		model.put("action", "create");
		return "template/editBasic";
	}*/

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") java.lang.Integer id, ModelMap model) {
		FlexParam param = new FlexParam();
		param.setTpType(FlexParam.TP_TYPE.template.name());
		param.setTpID(id);
		param.setIsNewOrModify(1);
		param.setIsOnlyView(0);
		param.setUserId(this.getCurrentAccountId());
		param.setUserType(this.getCurrentAccount().getLoginUserType());
		return "redirect:" + Constant.getInstance().getProperty("flex_url") + "?" + param.toString();
	}
	/*
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") java.lang.Integer id, ModelMap model) {
		model.put("template", templateService.getTemplate(id));
		model.put("action", "update");
		return "template/editBasic";
	}*/

	@RequestMapping(value = "/editFrame/{id}", method = RequestMethod.GET)
	public String editFrame(ModelMap model, @PathVariable("id") java.lang.Integer id) throws Exception {
		model.put("id", id);
		return "template/editFrame";
	}

	@RequestMapping(value = "/editContent/{id}", method = RequestMethod.GET)
	public String editContent(ModelMap model, @PathVariable("id") java.lang.Integer id) throws Exception {
		model.put("template", templateService.getTemplate(id));
		return "template/editContent";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage create(TplTemplate template) {
		template.setTemplateCreateTime(new Date());
		template.setTemplateUpdateTime(new Date());
		template.setUserId(this.getCurrentAccountId());
		//template = templateService.saveTemplate(template);

		logService.saveLog(Enums.LOG_TYPE.NEW, this.getCurrentAccount().getLoginUsername(), "用户管理", JSONObject.toJSONString(template));
		return this.ajaxDoneSuccess("创建成功", template.getId());
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage update(TplTemplate template) {
		template.setTemplateUpdateTime(new Date());
		//templateService.updateTemplate(template);

		logService.saveLog(Enums.LOG_TYPE.UPDATE, this.getCurrentAccount().getLoginUsername(), "用户管理", JSONObject.toJSONString(template));
		return this.ajaxDoneSuccess("修改成功");
	}

	@RequestMapping(value = "/saveContent", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage saveContent(ModelMap model, TplTemplate template) throws Exception {
		//TplTemplate dbObj = templateService.getTemplate(template.getId());
		//dbObj.setTemplateContent(template.getTemplateContent());
		//templateService.updateTemplate(dbObj);

		return this.ajaxDoneSuccess("保存成功");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage delete(@PathVariable("id") Integer userId) {
		/*userService.deleteSysUserByUserId(userId);
		
		logService.saveLog(Enums.LOG_TYPE.DELETE, this.getCurrentAccount().getLoginUsername(), "用户管理", "删除：userId=" + userId);*/
		return this.ajaxDoneSuccess("删除成功");
	}

}
