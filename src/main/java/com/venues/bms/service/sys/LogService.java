package com.venues.bms.service.sys;

import java.util.Map;

import com.venues.bms.core.model.Page;
import com.venues.bms.po.SysLog;

public interface LogService {
	/**
	 * 分页查询
	 * @param page
	 * @param params
	 * @return
	 */
	Page<SysLog> findSysLogPage(Page<SysLog> page, Map<String, Object> params);

	/**
	 * 删除日志
	 * @param log
	 * @return
	 */
	int deleteSysLogByLogId(Integer logId);
}
