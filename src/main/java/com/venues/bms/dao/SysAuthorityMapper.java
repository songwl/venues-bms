package com.venues.bms.dao;

import java.util.List;

import com.venues.bms.po.SysAuthority;

public interface SysAuthorityMapper {
	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_authority
	 *
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer atId);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_authority
	 *
	 * @mbggenerated
	 */
	int insert(SysAuthority record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_authority
	 *
	 * @mbggenerated
	 */
	int insertSelective(SysAuthority record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_authority
	 *
	 * @mbggenerated
	 */
	SysAuthority selectByPrimaryKey(Integer atId);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_authority
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(SysAuthority record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_authority
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKey(SysAuthority record);

	List<SysAuthority> selectBySysAuthority(SysAuthority record);

}