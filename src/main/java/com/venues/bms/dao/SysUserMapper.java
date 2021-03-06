package com.venues.bms.dao;

import java.util.List;
import java.util.Map;

import com.venues.bms.po.SysUser;

public interface SysUserMapper {
	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_user
	 *
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer userId);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_user
	 *
	 * @mbggenerated
	 */
	int insert(SysUser record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_user
	 *
	 * @mbggenerated
	 */
	int insertSelective(SysUser record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_user
	 *
	 * @mbggenerated
	 */
	SysUser selectByPrimaryKey(Integer userId);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_user
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(SysUser record);

	/**
	 * This method was generated by MyBatis Generator.
	 * This method corresponds to the database table tbl_sys_user
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKey(SysUser record);

	SysUser selectByLoginname(String loginname);

	int selectCountByParams(Map<String, Object> params);

	List<SysUser> selectByParams(Map<String, Object> params);
}