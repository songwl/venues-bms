package com.venues.bms.service.impl.sys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.venues.bms.core.cache.CacheHelper;
import com.venues.bms.core.cache.impl.MapCache;
import com.venues.bms.dao.SysAuthorityMapper;
import com.venues.bms.dao.SysMenuMapper;
import com.venues.bms.po.SysAuthority;
import com.venues.bms.po.SysMenu;
import com.venues.bms.service.sys.AuthorityService;
import com.venues.bms.vo.BmsNavigation;
import com.venues.bms.vo.CacheConstants;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Autowired
	private SysAuthorityMapper sysAuthorityMapper;

	@Override
	public List<BmsNavigation> queryBmsNavByUserType(Integer userType) {
		String key = CacheConstants.CACHE_BMS_NAVIGATION_BY_USERTYPE_ + userType;
		//后台导航缓存
		CacheHelper cacheHelper = MapCache.getInstance();
		if (cacheHelper.has(key)) { //缓存内取
			return (ArrayList<BmsNavigation>) cacheHelper.get(key);
		}
		//通过用户类型区分菜单权限
		SysAuthority sa = new SysAuthority();
		sa.setAtUsertypeid(userType);
		List<SysAuthority> authoritys = sysAuthorityMapper.selectBySysAuthority(sa);
		if (CollectionUtils.isEmpty(authoritys)) {
			return Collections.emptyList();
		}
		//查询菜单明细
		List<BmsNavigation> navs = new ArrayList<>();
		for (SysAuthority auth : authoritys) {
			SysMenu menu = sysMenuMapper.selectByPrimaryKey(auth.getAtMenuid());
			navs.add(convertMenu2BmsNavigation(menu));
		}
		List<BmsNavigation> navTree = getNavsByParentId(0, navs);

		cacheHelper.put(key, navTree);
		return navTree;
	}

	private BmsNavigation convertMenu2BmsNavigation(SysMenu menu) {
		BmsNavigation nav = new BmsNavigation();
		nav.setNid(menu.getMenuId());
		nav.setName(menu.getMenuName());
		nav.setParentId(menu.getMenuParentid());
		nav.setIcon(menu.getMenuIcon());
		if (menu.getMenuIsmenu()) { // menu
			nav.setType(BmsNavigation.BmsNavType.MENU.name());
		} else { // url
			nav.setType(BmsNavigation.BmsNavType.URL.name());
			nav.setUrl(menu.getMenuUrl());
		}
		return nav;
	}

	private List<BmsNavigation> getNavsByParentId(final Integer parentId, final List<BmsNavigation> navs) {
		List<BmsNavigation> chilren = new ArrayList<>();
		for (BmsNavigation nav : navs) {
			if (nav.getParentId().intValue() == parentId.intValue()) {
				chilren.add(nav);
			}
		}
		if (!chilren.isEmpty()) {
			for (BmsNavigation child : chilren) {
				if (BmsNavigation.BmsNavType.MENU.name().equalsIgnoreCase(child.getType())) {
					child.setChildren(getNavsByParentId(child.getNid(), navs));
				}
			}
		}
		return chilren;
	}

	@Override
	public List<SysMenu> queryAuthMenuByUserType(Integer userType,boolean isTree) {
		//通过用户类型区分菜单权限
		SysAuthority sa = new SysAuthority();
		sa.setAtUsertypeid(userType);
		List<SysAuthority> authoritys = sysAuthorityMapper.selectBySysAuthority(sa);
		if (CollectionUtils.isEmpty(authoritys)) {
			return Collections.emptyList();
		}
		//查询菜单明细
		List<SysMenu> menus = new ArrayList<>();
		for (SysAuthority auth : authoritys) {
			SysMenu menu = sysMenuMapper.selectByPrimaryKey(auth.getAtMenuid());
			menus.add(menu);
		}
		if(isTree){
			List<SysMenu> navTree = getMenusByParentId(0, menus);
			return navTree;
		}else{
			return menus;
		}
		
	}

	private List<SysMenu> getMenusByParentId(final Integer parentId, final List<SysMenu> menus) {
		List<SysMenu> chilren = new ArrayList<>();
		for (SysMenu menu : menus) {
			if (menu.getMenuParentid().intValue() == parentId.intValue()) {
				chilren.add(menu);
			}
		}
		if (!chilren.isEmpty()) {
			for (SysMenu child : chilren) {
				if (child.getMenuIsmenu()) {
					child.setChildren(getMenusByParentId(child.getMenuId(), menus));
				}
			}
		}
		return chilren;
	}

	@Override
	public List<SysMenu> queryAllMenuTree() {
		Map<String, Object> params = new HashMap<>();
		List<SysMenu> menus = sysMenuMapper.selectByParams(params);
		List<SysMenu> navTree = getMenusByParentId(0, menus);
		return navTree;
	}

	@Override
	public void saveAuthorityMenus(Integer userTypeId, List<Integer> menuIdList) {
		Assert.notNull(userTypeId,"userTypeId不能为空");
		//先删除旧的
		SysAuthority authParam = new SysAuthority();
		authParam.setAtUsertypeid(userTypeId);
		List<SysAuthority> oldAuthList = sysAuthorityMapper.selectBySysAuthority(authParam);
		if(!CollectionUtils.isEmpty(oldAuthList)){
			for(SysAuthority oldAuth : oldAuthList){
				sysAuthorityMapper.deleteByPrimaryKey(oldAuth.getAtId());
			}
		}
		
		if(!CollectionUtils.isEmpty(menuIdList)){
			for(Integer menuId : menuIdList){
				SysAuthority auth = new SysAuthority();
				auth.setAtUsertypeid(userTypeId);
				auth.setAtMenuid(menuId);
				sysAuthorityMapper.insert(auth);
			}
		}
		
		String key = CacheConstants.CACHE_BMS_NAVIGATION_BY_USERTYPE_ + userTypeId;
		//后台导航缓存
		CacheHelper cacheHelper = MapCache.getInstance();
		if (cacheHelper.has(key)) { //缓存清空
			cacheHelper.remove(key);
		}
	}
}
