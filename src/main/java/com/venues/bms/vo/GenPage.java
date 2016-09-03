package com.venues.bms.vo;

import java.io.Serializable;
import java.util.List;

public class GenPage implements Serializable {

	private Integer pageId;

	private String pageName;

	private String pageDescription;

	private Integer likeCount;

	private Integer bodyWidth;

	private Integer bodyHeight;

	private Integer backgroundColor;

	private String backgroundImage;

	List<GenPageModule> modules;

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getPageDescription() {
		return pageDescription;
	}

	public void setPageDescription(String pageDescription) {
		this.pageDescription = pageDescription;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getBodyWidth() {
		return bodyWidth;
	}

	public void setBodyWidth(Integer bodyWidth) {
		this.bodyWidth = bodyWidth;
	}

	public Integer getBodyHeight() {
		return bodyHeight;
	}

	public void setBodyHeight(Integer bodyHeight) {
		this.bodyHeight = bodyHeight;
	}

	public Integer getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Integer backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public List<GenPageModule> getModules() {
		return modules;
	}

	public void setModules(List<GenPageModule> modules) {
		this.modules = modules;
	}

}
