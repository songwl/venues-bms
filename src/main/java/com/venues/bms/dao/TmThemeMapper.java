package com.venues.bms.dao;

import java.util.List;
import java.util.Map;

import com.venues.bms.po.TmTheme;

public interface TmThemeMapper {
	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_theme
	 *
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer ID);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_theme
	 *
	 * @mbggenerated
	 */
	int insert(TmTheme record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_theme
	 *
	 * @mbggenerated
	 */
	int insertSelective(TmTheme record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_theme
	 *
	 * @mbggenerated
	 */
	TmTheme selectByPrimaryKey(Integer ID);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_theme
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(TmTheme record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_theme
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKey(TmTheme record);

	List<TmTheme> selectByParams(Map<String, Object> params);
}