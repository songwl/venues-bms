package com.venues.bms.service.impl.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.dao.FiAttachMapper;
import com.venues.bms.po.FiAttach;
import com.venues.bms.service.file.FileService;

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FiAttachMapper fiAttachMapper;

	@Override
	public FiAttach saveAttach(FiAttach attach) {
		fiAttachMapper.insert(attach);
		return attach;
	}

}
