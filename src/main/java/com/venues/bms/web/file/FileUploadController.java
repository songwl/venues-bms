package com.venues.bms.web.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.venues.bms.core.model.ResultMessage;
import com.venues.bms.po.FiAttach;
import com.venues.bms.service.file.FileService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/24.
 */
@Controller
@RequestMapping(value = "/file/upload")
public class FileUploadController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	public static final String UPLOAD_ROOT_FOLDER = "upload";

	@Autowired
	private FileService fileService;

	@RequestMapping("")
	@ResponseBody
	public ResultMessage upload(@RequestParam("vfile") CommonsMultipartFile localUrl, HttpServletResponse response) throws IOException {
		File file = null;
		try {
			DiskFileItem fileItem = (DiskFileItem) localUrl.getFileItem();
			String path = UPLOAD_ROOT_FOLDER + this.getStoragePath();
			file = new File(path);
			
			logger.info("上传文件开始：" + localUrl.getOriginalFilename());
			IOUtils.copy(fileItem.getInputStream(), new FileOutputStream(file));
			logger.info("上传文件结束：" + localUrl.getOriginalFilename());
			
			FiAttach attach = new FiAttach();
			attach.setCreateTime(Calendar.getInstance().getTime());
			attach.setSize(localUrl.getSize());
			attach.setName(localUrl.getOriginalFilename());
			attach.setExt(StringUtils.lowerCase(StringUtils.substringAfterLast(localUrl.getOriginalFilename(), ".")));
			attach.setUrlPath(path);
			
			fileService.saveAttach(attach);
			return this.ajaxDoneSuccess("上传成功",attach);
		} catch (Exception ex) {
			return this.ajaxDoneError("message", ex.getMessage());
		} finally {
			if (file != null) {
				file.delete();
			}
		}
	}

	
	
	/**
	 * 按当前日期生产路径：/2008_2/5_20/，/年_季/月_日/
	 * 
	 * @return 相对路径
	 */
	private String getStoragePath() {
		StringBuilder sb = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		sb.append("/").append(cal.get(Calendar.YEAR)).append('_').append(cal.get((Calendar.MONTH)) / 3 + 1).append("/").append(cal.get(Calendar.MONTH) + 1).append('_')
				.append(cal.get(Calendar.DAY_OF_MONTH)).append("/");
		return sb.toString();
	}
}
