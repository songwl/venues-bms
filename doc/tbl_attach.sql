/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : venues2

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-07-02 15:39:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_attach
-- ----------------------------
DROP TABLE IF EXISTS `tbl_attach`;
CREATE TABLE `tbl_attach` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `UrlPath` varchar(255) DEFAULT NULL,
  `Ext` varchar(64) DEFAULT NULL,
  `Size` bigint(20) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tbl_file
-- ----------------------------
DROP TABLE IF EXISTS `tbl_file`;
CREATE TABLE `tbl_file` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `AttachId` int(11) DEFAULT NULL,
  `UserID` int(11) NOT NULL DEFAULT '0',
  `FileUploadTime` datetime DEFAULT NULL,
  `DescribeInfo` varchar(255) CHARACTER SET gb2312 DEFAULT NULL,
  `IsPass` int(1) DEFAULT NULL COMMENT '是否审核通过',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=287 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
