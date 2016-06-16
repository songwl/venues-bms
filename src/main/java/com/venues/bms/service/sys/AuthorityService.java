package com.venues.bms.service.sys;

import java.util.List;

import com.venues.bms.po.SysMenu;
import com.venues.bms.vo.BmsNavigation;

public interface AuthorityService {

	/**
	 * 获取后台权限导航
	 * @param userId
	 * @return
	 */
	List<BmsNavigation> queryBmsNavByUserType(Integer userType);

	/**
	 * 查询用户角色下的所有菜单tree
	 * @param userType
	 * @return
	 */
	List<SysMenu> queryAuthMenuTreeByUserType(Integer userType);

	/**
	 * 查询所有的菜单tree
	 * @return
	 */
	List<SysMenu> queryAllMenuTree();
}
