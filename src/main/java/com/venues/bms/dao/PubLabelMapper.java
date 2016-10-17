package com.venues.bms.dao;

import java.util.List;
import java.util.Map;

import com.venues.bms.po.PubLabel;

public interface PubLabelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_label
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_label
     *
     * @mbggenerated
     */
    int insert(PubLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_label
     *
     * @mbggenerated
     */
    int insertSelective(PubLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_label
     *
     * @mbggenerated
     */
    PubLabel selectByPrimaryKey(Integer ID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_label
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PubLabel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_label
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PubLabel record);

	List<PubLabel> selectByParams(Map<String, Object> params);
}