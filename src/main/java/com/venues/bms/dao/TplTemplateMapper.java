package com.venues.bms.dao;

import java.util.List;
import java.util.Map;

import com.venues.bms.po.TplTemplate;

public interface TplTemplateMapper {
	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_tpl_template
	 *
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_tpl_template
	 *
	 * @mbggenerated
	 */
	int insert(TplTemplate record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_tpl_template
	 *
	 * @mbggenerated
	 */
	int insertSelective(TplTemplate record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_tpl_template
	 *
	 * @mbggenerated
	 */
	TplTemplate selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_tpl_template
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(TplTemplate record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_tpl_template
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(TplTemplate record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_tpl_template
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKey(TplTemplate record);

	int selectCountByParams(Map<String, Object> params);

	List<TplTemplate> selectByParams(Map<String, Object> params);
}