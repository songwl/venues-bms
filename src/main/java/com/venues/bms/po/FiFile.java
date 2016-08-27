package com.venues.bms.po;

import java.util.Date;

public class FiFile {
	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_file.ID
	 *
	 * @mbggenerated
	 */
	private Integer id;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_file.AttachId
	 *
	 * @mbggenerated
	 */
	private Integer attachId;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_file.UserID
	 *
	 * @mbggenerated
	 */
	private Integer userID;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_file.FileUploadTime
	 *
	 * @mbggenerated
	 */
	private Date fileUploadTime;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_file.DescribeInfo
	 *
	 * @mbggenerated
	 */
	private String describeInfo;

	/**
	 * This field was generated by MyBatis Generator.
	 * This field corresponds to the database column tbl_file.IsPass
	 *
	 * @mbggenerated
	 */
	private Integer isPass;

	private Integer isDelete;

	private Integer venueId;

	private FiAttach attach;

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_file.ID
	 *
	 * @return the value of tbl_file.ID
	 *
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_file.ID
	 *
	 * @param ID the value for tbl_file.ID
	 *
	 * @mbggenerated
	 */
	public void setId(Integer ID) {
		this.id = ID;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_file.AttachId
	 *
	 * @return the value of tbl_file.AttachId
	 *
	 * @mbggenerated
	 */
	public Integer getAttachId() {
		return attachId;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_file.AttachId
	 *
	 * @param attachId the value for tbl_file.AttachId
	 *
	 * @mbggenerated
	 */
	public void setAttachId(Integer attachId) {
		this.attachId = attachId;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_file.UserID
	 *
	 * @return the value of tbl_file.UserID
	 *
	 * @mbggenerated
	 */
	public Integer getUserID() {
		return userID;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_file.UserID
	 *
	 * @param userID the value for tbl_file.UserID
	 *
	 * @mbggenerated
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_file.FileUploadTime
	 *
	 * @return the value of tbl_file.FileUploadTime
	 *
	 * @mbggenerated
	 */
	public Date getFileUploadTime() {
		return fileUploadTime;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_file.FileUploadTime
	 *
	 * @param fileUploadTime the value for tbl_file.FileUploadTime
	 *
	 * @mbggenerated
	 */
	public void setFileUploadTime(Date fileUploadTime) {
		this.fileUploadTime = fileUploadTime;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_file.DescribeInfo
	 *
	 * @return the value of tbl_file.DescribeInfo
	 *
	 * @mbggenerated
	 */
	public String getDescribeInfo() {
		return describeInfo;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_file.DescribeInfo
	 *
	 * @param describeInfo the value for tbl_file.DescribeInfo
	 *
	 * @mbggenerated
	 */
	public void setDescribeInfo(String describeInfo) {
		this.describeInfo = describeInfo == null ? null : describeInfo.trim();
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method returns the value of the database column tbl_file.IsPass
	 *
	 * @return the value of tbl_file.IsPass
	 *
	 * @mbggenerated
	 */
	public Integer getIsPass() {
		return isPass;
	}

	/**
	 * This method was generated by MyBatis Generator.
	 * This method sets the value of the database column tbl_file.IsPass
	 *
	 * @param isPass the value for tbl_file.IsPass
	 *
	 * @mbggenerated
	 */
	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}

	public FiAttach getAttach() {
		return attach;
	}

	public void setAttach(FiAttach attach) {
		this.attach = attach;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getVenueId() {
		return venueId;
	}

	public void setVenueId(Integer venueId) {
		this.venueId = venueId;
	}

}