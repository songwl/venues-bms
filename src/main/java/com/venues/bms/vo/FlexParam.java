package com.venues.bms.vo;

/**
 * 
 * @author song on 2016/8/3.
 *
 */
public class FlexParam {
	public static enum TP_TYPE {
		template, page;
	}

	private String tpType;//类型，template 模板，page 页面
	private Integer tpID;//模板id、页面id
	private Integer isOnlyView;//是否为预览页面    0：否； 1：是
	private Integer isNewOrModify;//是新增还是编辑操作   0:新增 ;1:编辑
	private Integer pageTypeID;//页面类型
	private Integer userId;//当前用户id
	private String userType;//当前用户类型

	public String getTpType() {
		return tpType;
	}

	public void setTpType(String tpType) {
		this.tpType = tpType;
	}

	public Integer getTpID() {
		return tpID;
	}

	public void setTpID(Integer tpID) {
		this.tpID = tpID;
	}

	public Integer getIsOnlyView() {
		return isOnlyView;
	}

	public void setIsOnlyView(Integer isOnlyView) {
		this.isOnlyView = isOnlyView;
	}

	public Integer getIsNewOrModify() {
		return isNewOrModify;
	}

	public void setIsNewOrModify(Integer isNewOrModify) {
		this.isNewOrModify = isNewOrModify;
	}

	public Integer getPageTypeID() {
		return pageTypeID;
	}

	public void setPageTypeID(Integer pageTypeID) {
		this.pageTypeID = pageTypeID;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("_o=" + super.hashCode());
		if (this.tpType != null) {
			sb.append("&tpType=" + this.tpType);
		}
		if (this.tpID != null) {
			sb.append("&tpID=" + this.tpID);
		}
		if (this.isOnlyView != null) {
			sb.append("&isOnlyView=" + this.isOnlyView);
		}
		if (this.isNewOrModify != null) {
			sb.append("&isNewOrModify=" + this.isNewOrModify);
		}
		if (this.pageTypeID != null) {
			sb.append("&pageTypeID=" + this.pageTypeID);
		}
		if (this.userId != null) {
			sb.append("&userId=" + this.userId);
		}
		if (this.userType != null) {
			sb.append("&userType=" + this.userType);
		}
		return sb.toString();
	}

}
