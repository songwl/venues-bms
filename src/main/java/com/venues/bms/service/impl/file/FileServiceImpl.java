package com.venues.bms.service.impl.file;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.FiAttachMapper;
import com.venues.bms.dao.FiFileMapper;
import com.venues.bms.po.FiAttach;
import com.venues.bms.po.FiFile;
import com.venues.bms.service.file.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FiFileMapper fiFileMapper;
	
	@Autowired
	private FiAttachMapper fiAttachMapper;

	@Override
	public FiAttach saveAttach(FiAttach attach) {
		fiAttachMapper.insert(attach);
		return attach;
	}
	
	@Override
	public Page<FiFile> findFilePage(Page<FiFile> page, Map<String, Object> params) {
		int count = fiFileMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<FiFile> list = findFileList(params);
			page.setItemList(list);
		}
		return page;
	}

	@Override
	public List<FiFile> findFileList(Map<String, Object> params) {
		List<FiFile> list = fiFileMapper.selectByParams(params);
		for(FiFile file : list){
			file.setAttach(fiAttachMapper.selectByPrimaryKey(file.getAttachId()));
		}
		return list;
	}

}
