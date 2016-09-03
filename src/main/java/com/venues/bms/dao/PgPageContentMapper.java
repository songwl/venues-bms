package com.venues.bms.dao;

import java.util.List;
import java.util.Map;

import com.venues.bms.po.PgPageContent;

public interface PgPageContentMapper {
	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page_content
	 *
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer ID);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page_content
	 *
	 * @mbggenerated
	 */
	int insert(PgPageContent record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page_content
	 *
	 * @mbggenerated
	 */
	int insertSelective(PgPageContent record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page_content
	 *
	 * @mbggenerated
	 */
	PgPageContent selectByPrimaryKey(Integer ID);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page_content
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(PgPageContent record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_page_content
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKey(PgPageContent record);

	List<PgPageContent> selectByPageId(Integer pageId);

	List<PgPageContent> selectByPageIdAndModuleId(Map<String, Object> param);
}