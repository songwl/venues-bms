package com.venues.bms.dao;

import com.venues.bms.po.GuGuest;

public interface GuGuestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_guest
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_guest
     *
     * @mbggenerated
     */
    int insert(GuGuest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_guest
     *
     * @mbggenerated
     */
    int insertSelective(GuGuest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_guest
     *
     * @mbggenerated
     */
    GuGuest selectByPrimaryKey(Integer ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_guest
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(GuGuest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_guest
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(GuGuest record);
}