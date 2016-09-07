package com.venues.bms.web.file;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.venues.bms.core.model.Constant;
import com.venues.bms.core.utils.JSONResultUtils;
import com.venues.bms.po.FiAttach;
import com.venues.bms.service.file.FileService;
import com.venues.bms.web.BaseController;

/**
 * 
 * Created by song on 2016/6/24.
 */
@Controller
@RequestMapping(value = "/file/upload")
public class FileUploadController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	public static final String UPLOAD_ROOT_FOLDER = "upload";

	@Autowired
	private FileService fileService;

	@RequestMapping("")
	@ResponseBody
	public void upload(@RequestParam("vfile") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject obj = new JSONObject();
		int error = 0;
		try {
			FiAttach attach = new FiAttach();
			attach.setCreateTime(Calendar.getInstance().getTime());
			attach.setSize(file.getSize());
			attach.setName(file.getOriginalFilename());
			attach.setExt(StringUtils.lowerCase(StringUtils.substringAfterLast(file.getOriginalFilename(), ".")));
			attach.setUrlPath(UPLOAD_ROOT_FOLDER + this.getStoragePath());

			DiskFileItem fileItem = (DiskFileItem) file.getFileItem();
			File toSave = new File(this.getAbsolutePath(request, attach.getDownloadPath()));
			logger.info("上传文件开始：" + file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(fileItem.getInputStream(), toSave);
			logger.info("上传文件结束：" + file.getOriginalFilename());

			fileService.saveAttach(attach);
			obj.put("attach", attach);
		} catch (Exception ex) {
			ex.printStackTrace();
			obj.put("message", "上传文件异常");
		} finally {
			if (file != null) {
				if (file.getInputStream() != null) {
					file.getInputStream().close();
				}
			}
		}
		obj.put("error", error);
		JSONResultUtils.output(response, obj);
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

	/**
	 * 将一个相对路径转化为硬盘上的绝对路径
	 * @param request
	 * @param path 相对路径  upload/xxx/xxx
	 * @return 绝对路径  D:/server/root/upload/xxx/xxx
	 */
	private String getAbsolutePath(HttpServletRequest request, String path) {
		//return request.getSession().getServletContext().getRealPath(path);
		return Constant.getInstance().getProperty("static_upload_path") + "/" + path;
	}

}
