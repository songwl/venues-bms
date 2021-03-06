package com.venues.bms.dao;

import java.util.List;
import java.util.Map;

import com.venues.bms.po.MoModule;

public interface MoModuleMapper {
	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_module
	 *
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer ID);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_module
	 *
	 * @mbggenerated
	 */
	int insert(MoModule record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_module
	 *
	 * @mbggenerated
	 */
	int insertSelective(MoModule record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_module
	 *
	 * @mbggenerated
	 */
	MoModule selectByPrimaryKey(Integer ID);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_module
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(MoModule record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_module
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKey(MoModule record);

	int selectCountByParams(Map<String, Object> params);

	List<MoModule> selectByParams(Map<String, Object> params);

	List<MoModule> selectByTemplateId(Integer templateId);
}