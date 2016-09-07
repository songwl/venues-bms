package com.venues.bms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.venues.bms.po.PgPage;

public interface PgPageMapper {
	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page
	 *
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer ID);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page
	 *
	 * @mbggenerated
	 */
	int insert(PgPage record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page
	 *
	 * @mbggenerated
	 */
	int insertSelective(PgPage record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page
	 *
	 * @mbggenerated
	 */
	PgPage selectByPrimaryKey(Integer ID);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(PgPage record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKey(PgPage record);

	int selectCountByParams(Map<String, Object> params);

	List<PgPage> selectByParams(Map<String, Object> params);

	int updatePublishByVenueIds(@Param(value = "venueIds") String venueIds);

	int updatePublishByIds(@Param(value = "ids") String ids);

	int updateAllPublishOff();
	
	Integer getMaxSequence();
}