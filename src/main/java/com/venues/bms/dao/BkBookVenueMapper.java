package com.venues.bms.dao;

import com.venues.bms.po.BkBookVenue;

public interface BkBookVenueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_book_venue
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_book_venue
     *
     * @mbggenerated
     */
    int insert(BkBookVenue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_book_venue
     *
     * @mbggenerated
     */
    int insertSelective(BkBookVenue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_book_venue
     *
     * @mbggenerated
     */
    BkBookVenue selectByPrimaryKey(Integer ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_book_venue
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BkBookVenue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_book_venue
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BkBookVenue record);
}