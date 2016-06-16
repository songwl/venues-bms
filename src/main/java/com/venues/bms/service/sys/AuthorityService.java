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
	 * 查询用户角色下的所有菜单
	 * @param userType
	 * @param isTree 是否需要树状结构
	 * @return
	 */
	List<SysMenu> queryAuthMenuByUserType(Integer userType,boolean isTree);

	/**
	 * 查询所有的菜单tree
	 * @return
	 */
	List<SysMenu> queryAllMenuTree();

	/**
	 * 保存权限菜单
	 * @param userTypeId
	 * @param menuIdList
	 */
	void saveAuthorityMenus(Integer userTypeId, List<Integer> menuIdList);
}
