package com.venues.bms.service.impl.sys;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venues.bms.core.model.Page;
import com.venues.bms.dao.SysUserMapper;
import com.venues.bms.po.SysUser;
import com.venues.bms.service.sys.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser getSysUserByLoginname(String loginName) {
		return sysUserMapper.selectByLoginname(loginName);
	}

	@Override
	public SysUser getSysUserByUserId(Integer userId) {
		return sysUserMapper.selectByPrimaryKey(userId);
	}

	@Override
	public SysUser saveSysUser(SysUser user) {
		sysUserMapper.insert(user);
		return user;
	}

	@Override
	public int updateSysUser(SysUser user) {
		return sysUserMapper.updateByPrimaryKey(user);
	}

	@Override
	public Page<SysUser> findSysUserPage(Page<SysUser> page, Map<String, Object> params) {
		int count = sysUserMapper.selectCountByParams(params);
		if (count > 0) {
			page.setTotalCount(count);

			params.put("begin", page.getBeginRow());
			params.put("offset", page.getPageSize());
			params.put("orderBy", page.getOrderBy());
			List<SysUser> list = findSysUserList(params);
			page.setItemList(list);
		}
		return page;
	}

	private List<SysUser> findSysUserList(Map<String, Object> params) {
		return sysUserMapper.selectByParams(params);
	}

	@Override
	public int deleteSysUserByUserId(Integer userId) {
		return sysUserMapper.deleteByPrimaryKey(userId);
	}
}
