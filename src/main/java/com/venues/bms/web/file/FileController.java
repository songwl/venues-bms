package com.venues.bms.web.file;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.venues.bms.core.model.Page;
import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.FiFile;
import com.venues.bms.service.file.FileService;
import com.venues.bms.service.sys.LogService;
import com.venues.bms.vo.Enums;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/24.
 */
@Controller
@RequestMapping(value = "/file")
public class FileController extends BaseController {

	@Autowired
	private FileService fileService;

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<FiFile> page = this.getPageRequest();
		Map<String, Object> params = this.getSearchRequest();
		params.put("isDelete", 0);
		if (!isAdmin()) {
			params.put("userID", getCurrentAccountId());
		}

		List<String> orderBy = new ArrayList<>();
		orderBy.add("id desc");
		page.setOrderBy(orderBy);
		page = fileService.findFilePage(page, params);
		model.put("page", page);
		model.put("searchParams", params);
		model.put("isAdmin", isAdmin());
		return "file/list";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public ResultMessage create(FiFile file) {
		file.setUserID(getCurrentAccountId());
		file.setFileUploadTime(new Date());
		file.setIsPass(0);
		file.setIsDelete(0);
		fileService.saveFile(file);
		logService.saveLog(Enums.LOG_TYPE.NEW, this.getCurrentAccount().getLoginUsername(), "资源管理", JSONObject.toJSONString(file));
		return this.ajaxDoneSuccess("创建成功");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage delete(@PathVariable("id") Integer fileId) {
		fileService.deleteFile(fileId);
		logService.saveLog(Enums.LOG_TYPE.DELETE, this.getCurrentAccount().getLoginUsername(), "资源管理", "删除：资源ID=" + fileId);
		return this.ajaxDoneSuccess("删除成功");
	}

	@RequestMapping(value = "/pass/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage pass(@PathVariable("id") Integer fileId) {
		fileService.updatePassFile(fileId);
		logService.saveLog(Enums.LOG_TYPE.DELETE, this.getCurrentAccount().getLoginUsername(), "资源管理", "审核通过：资源ID=" + fileId);
		return this.ajaxDoneSuccess("审核成功");
	}

	@RequestMapping(value = "/batchDelete", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage batchDelete(String ids) {
		String[] arr = ids.split(",");
		for (String str : arr) {
			int id = NumberUtils.toInt(str);
			if (id > 0) {
				fileService.deleteFile(id);
			}
		}
		logService.saveLog(Enums.LOG_TYPE.DELETE, this.getCurrentAccount().getLoginUsername(), "资源管理", "批量删除：资源ID=" + ids);
		return this.ajaxDoneSuccess("批量删除成功");
	}

	@RequestMapping(value = "/batchPass", method = RequestMethod.GET)
	@ResponseBody
	public ResultMessage batchPass(String ids) {
		String[] arr = ids.split(",");
		for (String str : arr) {
			int id = NumberUtils.toInt(str);
			if (id > 0) {
				fileService.updatePassFile(id);
			}
		}
		logService.saveLog(Enums.LOG_TYPE.UPDATE, this.getCurrentAccount().getLoginUsername(), "资源管理", "批量审核通过：资源ID=" + ids);
		return this.ajaxDoneSuccess("批量审核成功");
	}

	@RequestMapping(value = "/select")
	public String select(ModelMap model, @RequestParam String groupId) throws Exception {
		Page<FiFile> page = this.getPageRequest();
		Map<String, Object> params = this.getSearchRequest();
		params.put("isDelete", 0);
		params.put("isPass", 1);
		if (!isAdmin()) {
			params.put("userID", getCurrentAccountId());
		}

		List<String> orderBy = new ArrayList<>();
		orderBy.add("id desc");
		page.setOrderBy(orderBy);
		page = fileService.findFilePage(page, params);
		model.put("groupId", groupId);
		model.put("page", page);
		model.put("searchParams", params);
		model.put("isAdmin", isAdmin());
		return "file/select";
	}
}
