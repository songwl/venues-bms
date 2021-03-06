package com.venues.bms.po;

import java.util.Date;

public class PgPageComment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_page_comment.ID
     *
     * @mbggenerated
     */
    private Integer ID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_page_comment.PageID
     *
     * @mbggenerated
     */
    private Integer pageID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_page_comment.GuestID
     *
     * @mbggenerated
     */
    private Integer guestID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_page_comment.Content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_page_comment.CreateTime
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_page_comment.ID
     *
     * @return the value of tbl_page_comment.ID
     *
     * @mbggenerated
     */
    public Integer getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_page_comment.ID
     *
     * @param ID the value for tbl_page_comment.ID
     *
     * @mbggenerated
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_page_comment.PageID
     *
     * @return the value of tbl_page_comment.PageID
     *
     * @mbggenerated
     */
    public Integer getPageID() {
        return pageID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_page_comment.PageID
     *
     * @param pageID the value for tbl_page_comment.PageID
     *
     * @mbggenerated
     */
    public void setPageID(Integer pageID) {
        this.pageID = pageID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_page_comment.GuestID
     *
     * @return the value of tbl_page_comment.GuestID
     *
     * @mbggenerated
     */
    public Integer getGuestID() {
        return guestID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_page_comment.GuestID
     *
     * @param guestID the value for tbl_page_comment.GuestID
     *
     * @mbggenerated
     */
    public void setGuestID(Integer guestID) {
        this.guestID = guestID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_page_comment.Content
     *
     * @return the value of tbl_page_comment.Content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_page_comment.Content
     *
     * @param content the value for tbl_page_comment.Content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_page_comment.CreateTime
     *
     * @return the value of tbl_page_comment.CreateTime
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_page_comment.CreateTime
     *
     * @param createTime the value for tbl_page_comment.CreateTime
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}