package com.venues.bms.po;

import java.util.Date;

public class SysLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_sys_log.Log_Id
     *
     * @mbggenerated
     */
    private Integer logId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_sys_log.Log_TypeId
     *
     * @mbggenerated
     */
    private Integer logTypeid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_sys_log.Log_UserId
     *
     * @mbggenerated
     */
    private Integer logUserid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_sys_log.Log_MenuId
     *
     * @mbggenerated
     */
    private Integer logMenuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_sys_log.Log_Info
     *
     * @mbggenerated
     */
    private String logInfo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_sys_log.Log_Timestamp
     *
     * @mbggenerated
     */
    private Date logTimestamp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_sys_log.Log_UserTypeId
     *
     * @mbggenerated
     */
    private Integer logUsertypeid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_sys_log.Log_Id
     *
     * @return the value of tbl_sys_log.Log_Id
     *
     * @mbggenerated
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_sys_log.Log_Id
     *
     * @param logId the value for tbl_sys_log.Log_Id
     *
     * @mbggenerated
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_sys_log.Log_TypeId
     *
     * @return the value of tbl_sys_log.Log_TypeId
     *
     * @mbggenerated
     */
    public Integer getLogTypeid() {
        return logTypeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_sys_log.Log_TypeId
     *
     * @param logTypeid the value for tbl_sys_log.Log_TypeId
     *
     * @mbggenerated
     */
    public void setLogTypeid(Integer logTypeid) {
        this.logTypeid = logTypeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_sys_log.Log_UserId
     *
     * @return the value of tbl_sys_log.Log_UserId
     *
     * @mbggenerated
     */
    public Integer getLogUserid() {
        return logUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_sys_log.Log_UserId
     *
     * @param logUserid the value for tbl_sys_log.Log_UserId
     *
     * @mbggenerated
     */
    public void setLogUserid(Integer logUserid) {
        this.logUserid = logUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_sys_log.Log_MenuId
     *
     * @return the value of tbl_sys_log.Log_MenuId
     *
     * @mbggenerated
     */
    public Integer getLogMenuid() {
        return logMenuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_sys_log.Log_MenuId
     *
     * @param logMenuid the value for tbl_sys_log.Log_MenuId
     *
     * @mbggenerated
     */
    public void setLogMenuid(Integer logMenuid) {
        this.logMenuid = logMenuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_sys_log.Log_Info
     *
     * @return the value of tbl_sys_log.Log_Info
     *
     * @mbggenerated
     */
    public String getLogInfo() {
        return logInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_sys_log.Log_Info
     *
     * @param logInfo the value for tbl_sys_log.Log_Info
     *
     * @mbggenerated
     */
    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo == null ? null : logInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_sys_log.Log_Timestamp
     *
     * @return the value of tbl_sys_log.Log_Timestamp
     *
     * @mbggenerated
     */
    public Date getLogTimestamp() {
        return logTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_sys_log.Log_Timestamp
     *
     * @param logTimestamp the value for tbl_sys_log.Log_Timestamp
     *
     * @mbggenerated
     */
    public void setLogTimestamp(Date logTimestamp) {
        this.logTimestamp = logTimestamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_sys_log.Log_UserTypeId
     *
     * @return the value of tbl_sys_log.Log_UserTypeId
     *
     * @mbggenerated
     */
    public Integer getLogUsertypeid() {
        return logUsertypeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_sys_log.Log_UserTypeId
     *
     * @param logUsertypeid the value for tbl_sys_log.Log_UserTypeId
     *
     * @mbggenerated
     */
    public void setLogUsertypeid(Integer logUsertypeid) {
        this.logUsertypeid = logUsertypeid;
    }
}