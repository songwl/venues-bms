package com.venues.bms.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 后台导航栏VO类
 * created by song on 2016/6/7.
 *
 */
public class BmsNavigation implements Serializable {

	public static enum BmsNavType {
		MENU, URL
	}

	private Integer nid;

	private String name;

	private String type; //类型，区分 Menu还是url

	private String url; //url内容

	private String icon;

	private Integer parentId;

	private List<BmsNavigation> children;

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<BmsNavigation> getChildren() {
		return children;
	}

	public void setChildren(List<BmsNavigation> children) {
		this.children = children;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
