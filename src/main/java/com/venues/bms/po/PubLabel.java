package com.venues.bms.po;

import java.util.Date;

public class PubLabel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_label.ID
     *
     * @mbggenerated
     */
    private Integer ID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_label.VenueID
     *
     * @mbggenerated
     */
    private Integer venueID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_label.LanguageCode
     *
     * @mbggenerated
     */
    private String languageCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_label.Label
     *
     * @mbggenerated
     */
    private String label;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_label.CreateTime
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_label.ID
     *
     * @return the value of tbl_label.ID
     *
     * @mbggenerated
     */
    public Integer getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_label.ID
     *
     * @param ID the value for tbl_label.ID
     *
     * @mbggenerated
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_label.VenueID
     *
     * @return the value of tbl_label.VenueID
     *
     * @mbggenerated
     */
    public Integer getVenueID() {
        return venueID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_label.VenueID
     *
     * @param venueID the value for tbl_label.VenueID
     *
     * @mbggenerated
     */
    public void setVenueID(Integer venueID) {
        this.venueID = venueID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_label.LanguageCode
     *
     * @return the value of tbl_label.LanguageCode
     *
     * @mbggenerated
     */
    public String getLanguageCode() {
        return languageCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_label.LanguageCode
     *
     * @param languageCode the value for tbl_label.LanguageCode
     *
     * @mbggenerated
     */
    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode == null ? null : languageCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_label.Label
     *
     * @return the value of tbl_label.Label
     *
     * @mbggenerated
     */
    public String getLabel() {
        return label;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_label.Label
     *
     * @param label the value for tbl_label.Label
     *
     * @mbggenerated
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_label.CreateTime
     *
     * @return the value of tbl_label.CreateTime
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_label.CreateTime
     *
     * @param createTime the value for tbl_label.CreateTime
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}