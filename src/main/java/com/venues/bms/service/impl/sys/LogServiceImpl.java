package com.venues.bms.service.impl.sys;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.SysLogMapper;
import com.venues.bms.po.SysLog;
import com.venues.bms.po.SysUser;
import com.venues.bms.service.sys.LogService;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private SysLogMapper syslogMapper;

	@Override
	public Page<SysLog> findSysLogPage(Page<SysLog> page,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		int count = syslogMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<SysLog> list = findSysLogList(params);
			page.setItemList(list);
		}
		return page;
	}
	private List<SysLog> findSysLogList(Map<String, Object> params) {
		return syslogMapper.selectByParams(params);
	}
	
	@Override
	public int deleteSysLogByLogId(Integer logId) {
		// TODO Auto-generated method stub
		return syslogMapper.deleteByPrimaryKey(logId);
	}
	
	
}
