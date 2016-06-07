package com.venues.bms.service.impl.sys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.venues.bms.dao.SysAuthorityMapper;
import com.venues.bms.dao.SysMenuMapper;
import com.venues.bms.dao.SysUserMapper;
import com.venues.bms.po.SysAuthority;
import com.venues.bms.po.SysMenu;
import com.venues.bms.po.SysUser;
import com.venues.bms.service.sys.UserService;
import com.venues.bms.vo.BmsNavigation;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Autowired
	private SysAuthorityMapper sysAuthorityMapper;

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
	public List<BmsNavigation> queryUserMenuByUserId(Integer userId) {
		SysUser user = sysUserMapper.selectByPrimaryKey(userId);
		Integer userType = user.getUserTypeid();
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
		return navTree;
	}

	private BmsNavigation convertMenu2BmsNavigation(SysMenu menu) {
		BmsNavigation nav = new BmsNavigation();
		nav.setNid(menu.getMenuId());
		nav.setName(menu.getMenuName());
		nav.setParentId(menu.getMenuParentid());
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
}
