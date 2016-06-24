package com.venues.bms.web.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.venues.bms.core.utils.JSONResultUtils;
import com.venues.bms.service.file.FileService;

/**
 * 
 * Created by song on 2016/6/24.
 */
@Controller
@RequestMapping(value = "/upload")
public class FileUploadController {

	@Autowired
	private FileService fileService;

	@RequestMapping("/image")
	@ResponseBody
	public void uploadImage(@RequestParam("imgFile") CommonsMultipartFile localUrl, HttpServletResponse response) throws IOException {
		JSONObject obj = new JSONObject();
		File file = null;
		int error = 0;
		try {

			//localUrl.transferTo(file);
			DiskFileItem fileItem = (DiskFileItem) localUrl.getFileItem();
			file = new File(System.getProperty("java.io.tmpdir") + "/" + RandomStringUtils.randomNumeric(10) + "_" + fileItem.getName());
			IOUtils.copy(fileItem.getInputStream(), new FileOutputStream(file));
			//String path = FileClient.uploadImageToRemote(file, file.getName());
			//obj.put("url", Constant.getInstance().getProperty("image_host")+path);
		} catch (Exception ex) {
			error = 1;
			ex.printStackTrace();
			obj.put("message", ex.getMessage());
		} finally {
			if (file != null) {
				file.delete();
			}
		}
		obj.put("error", error);

		JSONResultUtils.output(response, obj);
	}

	@RequestMapping("/file/upload.do")
	@ResponseBody
	public void uploadFile(@RequestParam(required = true) String serviceType, @RequestParam("file") CommonsMultipartFile file, String sourceType, String sourceId, String sourceTable,
			String sourceField, HttpServletResponse response) throws IOException {
		JSONObject obj = new JSONObject();
		int error = 0;
		try {
			String fileName = file.getOriginalFilename();
			String fileType = "";
			if (fileName.contains(".")) {
				fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
			}
			/*ComFile comFile=new ComFile();
			comFile.setServiceType(serviceType);
			comFile.setBaisFile(file.getBytes());
			comFile.setFileName(fileName);
			comFile.setSuffix(fileType);
			comFile.setCreateTime(new Date());
			comFile.setSourceId(sourceId);
			comFile.setSourceTable(sourceTable);
			comFile.setSourceType(sourceType);
			comFile.setSourceField(sourceField);
			comFile.setDisplayName(fileName);
			comFile.setStatus("Y");
			Long fileId = comFileService.uploadFile(comFile);
			
			comFile.setFileId(fileId);
			obj.put("comFile", comFile);*/
		} catch (Exception ex) {
			error = 1;
			ex.printStackTrace();
			obj.put("message", "上传文件异常");
		} finally {
			if (file != null) {
				if (file.getInputStream() != null) {
					file.getInputStream().close();
				}
				if (file.getFileItem() != null) {
					file.getFileItem().delete();
				}
			}
		}
		obj.put("error", error);
		JSONResultUtils.output(response, obj);
	}
}
