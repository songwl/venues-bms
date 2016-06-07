package com.venues.bms.service.sys;

import java.util.List;

import com.venues.bms.po.SysUser;
import com.venues.bms.vo.BmsNavigation;

public interface UserService {

	/**
	 * 根据用户登录名查询
	 * @param loginName
	 * @return
	 */
	SysUser getSysUserByLoginname(String loginName);

	/**
	 * 根据用户id查询
	 * @param userId
	 * @return
	 */
	SysUser getSysUserByUserId(Integer userId);

	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	SysUser saveSysUser(SysUser user);

	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	int updateSysUser(SysUser user);

	/**
	 * 获取用户后台导航
	 * @param userId
	 * @return
	 */
	List<BmsNavigation> queryUserMenuByUserId(Integer userId);

}
