package com.venues.bms.po;

import com.venues.bms.core.model.LoginAccount;

public class SysUser extends LoginAccount {
	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_sys_user.User_Id
	 *
	 * @mbggenerated
	 */
	private Integer userId;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_sys_user.User_LoginName
	 *
	 * @mbggenerated
	 */
	private String userLoginname;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_sys_user.User_Name
	 *
	 * @mbggenerated
	 */
	private String userName;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_sys_user.User_Password
	 *
	 * @mbggenerated
	 */
	private String userPassword;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_sys_user.User_TypeId
	 *
	 * @mbggenerated
	 */
	private Integer userTypeid;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_sys_user.ONLINE_CODE
	 *
	 * @mbggenerated
	 */
	private String onlineCode;

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_sys_user.User_Id
	 *
	 * @return the value of tbl_sys_user.User_Id
	 *
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_sys_user.User_Id
	 *
	 * @param userId the value for tbl_sys_user.User_Id
	 *
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_sys_user.User_LoginName
	 *
	 * @return the value of tbl_sys_user.User_LoginName
	 *
	 * @mbggenerated
	 */
	public String getUserLoginname() {
		return userLoginname;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_sys_user.User_LoginName
	 *
	 * @param userLoginname the value for tbl_sys_user.User_LoginName
	 *
	 * @mbggenerated
	 */
	public void setUserLoginname(String userLoginname) {
		this.userLoginname = userLoginname == null ? null : userLoginname.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_sys_user.User_Name
	 *
	 * @return the value of tbl_sys_user.User_Name
	 *
	 * @mbggenerated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_sys_user.User_Name
	 *
	 * @param userName the value for tbl_sys_user.User_Name
	 *
	 * @mbggenerated
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_sys_user.User_Password
	 *
	 * @return the value of tbl_sys_user.User_Password
	 *
	 * @mbggenerated
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_sys_user.User_Password
	 *
	 * @param userPassword the value for tbl_sys_user.User_Password
	 *
	 * @mbggenerated
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword == null ? null : userPassword.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_sys_user.User_TypeId
	 *
	 * @return the value of tbl_sys_user.User_TypeId
	 *
	 * @mbggenerated
	 */
	public Integer getUserTypeid() {
		return userTypeid;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_sys_user.User_TypeId
	 *
	 * @param userTypeid the value for tbl_sys_user.User_TypeId
	 *
	 * @mbggenerated
	 */
	public void setUserTypeid(Integer userTypeid) {
		this.userTypeid = userTypeid;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_sys_user.ONLINE_CODE
	 *
	 * @return the value of tbl_sys_user.ONLINE_CODE
	 *
	 * @mbggenerated
	 */
	public String getOnlineCode() {
		return onlineCode;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_sys_user.ONLINE_CODE
	 *
	 * @param onlineCode the value for tbl_sys_user.ONLINE_CODE
	 *
	 * @mbggenerated
	 */
	public void setOnlineCode(String onlineCode) {
		this.onlineCode = onlineCode == null ? null : onlineCode.trim();
	}

	@Override
	public Integer getLoginUserId() {
		return this.userId;
	}

	@Override
	public String getLoginUsername() {
		return this.userLoginname;
	}

	@Override
	public String getLoginPassword() {
		return this.userPassword;
	}

	@Override
	public String getLoginUserType() {
		return this.userTypeid.toString();
	}
}