package com.venues.bms.po;

import java.io.Serializable;

/**
 * 
 * @author yang
 *
 */
public class Region implements Serializable {
	private java.lang.Integer id;
	private java.lang.String regionCode;//区域代码
	private java.lang.String regionName;//区域名称
	private java.lang.Integer regionLevel;//区域等级
	private java.lang.Integer regionSort;//区域顺序
	private java.lang.String regionNameEn;//区域英文名称
	private java.lang.String regionShortnameEn;//区域英文名称缩写
	private java.lang.Integer parentId;

	private Region parent;//父级区域

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(java.lang.String regionCode) {
		this.regionCode = regionCode;
	}

	public java.lang.String getRegionName() {
		return regionName;
	}

	public void setRegionName(java.lang.String regionName) {
		this.regionName = regionName;
	}

	public java.lang.Integer getRegionLevel() {
		return regionLevel;
	}

	public void setRegionLevel(java.lang.Integer regionLevel) {
		this.regionLevel = regionLevel;
	}

	public java.lang.Integer getRegionSort() {
		return regionSort;
	}

	public void setRegionSort(java.lang.Integer regionSort) {
		this.regionSort = regionSort;
	}

	public java.lang.String getRegionNameEn() {
		return regionNameEn;
	}

	public void setRegionNameEn(java.lang.String regionNameEn) {
		this.regionNameEn = regionNameEn;
	}

	public java.lang.String getRegionShortnameEn() {
		return regionShortnameEn;
	}

	public void setRegionShortnameEn(java.lang.String regionShortnameEn) {
		this.regionShortnameEn = regionShortnameEn;
	}

	public java.lang.Integer getParentId() {
		return parentId;
	}

	public void setParentId(java.lang.Integer parentId) {
		this.parentId = parentId;
	}

	public Region getParent() {
		return parent;
	}

	public void setParent(Region parent) {
		this.parent = parent;
	}

}
