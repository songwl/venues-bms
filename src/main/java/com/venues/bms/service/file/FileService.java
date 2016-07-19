package com.venues.bms.service.file;

import java.util.List;
import java.util.Map;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.FiAttach;
import com.venues.bms.po.FiFile;

public interface FileService {

	FiAttach saveAttach(FiAttach attach);

	Page<FiFile> findFilePage(Page<FiFile> page, Map<String, Object> params);

	List<FiFile> findFileList(Map<String, Object> params);

	FiFile saveFile(FiFile file);

	FiFile getFile(Integer fileId);

	int deleteFile(Integer fileId);

	int updatePassFile(Integer fileId);
}
