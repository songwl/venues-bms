package com.venues.bms.web.file;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.FiFile;
import com.venues.bms.service.file.FileService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/24.
 */
@Controller
@RequestMapping(value = "/file")
public class FileController extends BaseController{

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/list")
	public String list(ModelMap model) throws Exception {
		Page<FiFile> page = this.getPageRequest();
		Map<String, Object> params = this.getSearchRequest();

		page = fileService.findFilePage(page, params);
		model.put("page", page);
		return "file/list";
	}
}
