/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : venues2

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2016-06-12 17:50:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_ad`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_ad`;
CREATE TABLE `tbl_ad` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADName` varchar(255) DEFAULT NULL,
  `ADImage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_ad
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_attr`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_attr`;
CREATE TABLE `tbl_attr` (
  `Id` int(11) NOT NULL,
  `AttrGroupId` int(11) DEFAULT NULL,
  `AttrName` varchar(64) DEFAULT NULL COMMENT '属性名称',
  `AttrEnName` varchar(64) DEFAULT NULL COMMENT '英文名称',
  `AttrCode` varchar(64) DEFAULT NULL,
  `AttrType` varchar(20) DEFAULT NULL COMMENT '属性类型（input,radio,checkbox,select,textarea,richtext,image,video）',
  `DataSource` varchar(64) DEFAULT NULL COMMENT '数据源（目前支持取字典的数据）',
  `Memo` varchar(255) DEFAULT NULL COMMENT '描述',
  `Sort` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_attr
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_attr_group`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_attr_group`;
CREATE TABLE `tbl_attr_group` (
  `Id` int(11) NOT NULL,
  `VenueType` varchar(20) DEFAULT NULL COMMENT '取字典表数据,场所类型,0代表公用基础属性组。',
  `AttrGroupName` varchar(64) DEFAULT NULL COMMENT '属性组名称',
  `Sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_attr_group
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_book`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_book`;
CREATE TABLE `tbl_book` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BookVenueID` int(11) DEFAULT NULL,
  `BookVenueSequence` varchar(255) DEFAULT NULL,
  `BookCreateTIme` datetime DEFAULT NULL,
  `BookBackgroundImg` varchar(255) DEFAULT NULL,
  `BookFacebookLink` varchar(255) DEFAULT NULL,
  `BookTwitterLink` varchar(255) DEFAULT NULL,
  `BookWeixinLink` varchar(255) DEFAULT NULL,
  `BookWeiboLink` varchar(255) DEFAULT NULL,
  `AllCurBookInfo` longtext,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_book
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_book_venue`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_book_venue`;
CREATE TABLE `tbl_book_venue` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BookID` int(11) DEFAULT NULL,
  `VenueID` int(11) DEFAULT NULL,
  `BookVenueSequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_book_venue
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_file`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_file`;
CREATE TABLE `tbl_file` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FileNameLocal` varchar(255) CHARACTER SET gb2312 DEFAULT NULL,
  `FileNameServer` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `FileUserID` int(11) NOT NULL DEFAULT '0',
  `FileUploadTime` datetime DEFAULT NULL,
  `Size` float(11,2) DEFAULT NULL,
  `Ext` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DescribeInfo` varchar(255) CHARACTER SET gb2312 DEFAULT NULL,
  `UserVenueTypeID` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `IsPass` int(1) DEFAULT NULL COMMENT '是否审核通过',
  PRIMARY KEY (`ID`,`FileUserID`)
) ENGINE=MyISAM AUTO_INCREMENT=287 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tbl_file
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_guest`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_guest`;
CREATE TABLE `tbl_guest` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GuestName` varchar(255) DEFAULT NULL,
  `GuestPassword` varchar(255) DEFAULT NULL,
  `GuestIP` varchar(255) DEFAULT NULL,
  `GuestEmail` varchar(255) DEFAULT NULL,
  `GuestContact` varchar(255) DEFAULT NULL,
  `GuestRemark` varchar(255) DEFAULT NULL,
  `GuestCreateTime` datetime DEFAULT NULL,
  `Region` varchar(255) DEFAULT NULL,
  `Sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_guest
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_guest_message`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_guest_message`;
CREATE TABLE `tbl_guest_message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `GuestID` int(11) DEFAULT NULL,
  `VenueID` int(11) DEFAULT NULL,
  `MessageTitle` varchar(255) DEFAULT NULL,
  `MessageContent` varchar(255) DEFAULT NULL,
  `MessageTime` datetime DEFAULT NULL,
  `EventName` varchar(255) DEFAULT NULL,
  `EventType` varchar(255) DEFAULT NULL,
  `EstimatedAttendees` varchar(255) DEFAULT NULL,
  `EventStartDate` varchar(255) DEFAULT NULL,
  `EventEndDate` varchar(255) DEFAULT NULL,
  `Eventrequirements` varchar(255) DEFAULT NULL,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `EmailAddress` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Organization` varchar(255) DEFAULT NULL,
  `OrganizationType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_guest_message
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_module`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_module`;
CREATE TABLE `tbl_module` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TemplateID` int(11) DEFAULT NULL,
  `ModuleType` int(11) DEFAULT NULL,
  `ModuleX` int(11) DEFAULT NULL,
  `ModuleY` int(11) DEFAULT NULL,
  `ModuleWidth` int(11) DEFAULT NULL,
  `ModuleHeight` int(11) DEFAULT NULL,
  `ModuleImage` varchar(255) DEFAULT NULL,
  `ModuleDescriptions` varchar(255) DEFAULT NULL,
  `ModuleCreatetime` datetime DEFAULT NULL,
  `ModuleDepth` int(11) DEFAULT NULL,
  `TextPrompt` varchar(255) DEFAULT NULL,
  `ReferModuleID` int(11) DEFAULT NULL COMMENT '参照模块ID',
  `ReferX` int(11) DEFAULT NULL COMMENT '参照模块X距离',
  `ReferY` int(11) DEFAULT NULL COMMENT '参照模块Y距离',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=532 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_module
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_module_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_module_attribute`;
CREATE TABLE `tbl_module_attribute` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ModuleID` int(11) DEFAULT NULL,
  `MAKey` int(11) DEFAULT NULL,
  `MAValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=1401 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_module_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_news`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_news`;
CREATE TABLE `tbl_news` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) DEFAULT NULL,
  `NewsPage` int(11) DEFAULT NULL,
  `NewsTitle` varchar(255) DEFAULT NULL,
  `NewsAuthor` varchar(255) DEFAULT NULL,
  `NewsSequence` int(11) DEFAULT NULL,
  `NewsCreateTime` datetime DEFAULT NULL,
  `SmallImage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_news
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_page`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_page`;
CREATE TABLE `tbl_page` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TemplateID` int(11) DEFAULT NULL,
  `VenueID` int(11) DEFAULT NULL,
  `PageName` varchar(255) DEFAULT NULL,
  `PageCreateTime` datetime DEFAULT NULL,
  `PageModifyTime` datetime DEFAULT NULL,
  `PageDescription` varchar(255) DEFAULT NULL,
  `PageState` int(11) DEFAULT NULL,
  `PagePublish` int(1) DEFAULT NULL,
  `PageTypeID` int(11) DEFAULT NULL,
  `Sequence` int(11) DEFAULT NULL,
  `LikeCount` int(11) DEFAULT NULL COMMENT '点赞数量',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_page
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_page_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_page_comment`;
CREATE TABLE `tbl_page_comment` (
  `ID` int(11) NOT NULL,
  `PageID` int(11) DEFAULT NULL,
  `GuestID` int(11) DEFAULT NULL,
  `Content` varchar(512) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_page_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_page_content`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_page_content`;
CREATE TABLE `tbl_page_content` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PageID` int(11) DEFAULT NULL,
  `TemplateID` int(11) DEFAULT NULL,
  `ModuleID` int(11) DEFAULT NULL,
  `ContentValue` varchar(4000) DEFAULT NULL,
  `ContentSequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=273 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_page_content
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_page_module_attribute`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_page_module_attribute`;
CREATE TABLE `tbl_page_module_attribute` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PageID` int(11) DEFAULT NULL,
  `TmplateID` int(11) DEFAULT NULL,
  `ModuleID` int(11) DEFAULT NULL,
  `MAKey` int(11) DEFAULT NULL,
  `MAValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_page_module_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_sales`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sales`;
CREATE TABLE `tbl_sales` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) DEFAULT NULL,
  `SalesPageID` int(11) DEFAULT NULL,
  `SalesTitle` varchar(255) DEFAULT NULL,
  `SalesVenueName` varchar(255) DEFAULT NULL,
  `SalesSequence` int(11) DEFAULT NULL,
  `SalesCreateTime` datetime DEFAULT NULL,
  `SalesPublishID` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbl_sales
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_sys_authority`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_authority`;
CREATE TABLE `tbl_sys_authority` (
  `AT_Id` int(11) NOT NULL AUTO_INCREMENT,
  `AT_MenuId` int(11) DEFAULT NULL,
  `AT_UserTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`AT_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=165 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_sys_authority
-- ----------------------------
INSERT INTO `tbl_sys_authority` VALUES ('2', '1', '1');
INSERT INTO `tbl_sys_authority` VALUES ('1', '2', '1');
INSERT INTO `tbl_sys_authority` VALUES ('154', '3', '1');
INSERT INTO `tbl_sys_authority` VALUES ('155', '4', '1');
INSERT INTO `tbl_sys_authority` VALUES ('156', '5', '1');
INSERT INTO `tbl_sys_authority` VALUES ('157', '6', '1');
INSERT INTO `tbl_sys_authority` VALUES ('158', '7', '1');
INSERT INTO `tbl_sys_authority` VALUES ('159', '8', '1');
INSERT INTO `tbl_sys_authority` VALUES ('160', '9', '1');
INSERT INTO `tbl_sys_authority` VALUES ('161', '10', '1');
INSERT INTO `tbl_sys_authority` VALUES ('162', '11', '1');
INSERT INTO `tbl_sys_authority` VALUES ('163', '12', '1');
INSERT INTO `tbl_sys_authority` VALUES ('164', '13', '1');

-- ----------------------------
-- Table structure for `tbl_sys_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_dictionary`;
CREATE TABLE `tbl_sys_dictionary` (
  `DA_Id` int(11) NOT NULL AUTO_INCREMENT,
  `DA_Name` varchar(255) DEFAULT NULL,
  `DA_Code` varchar(255) DEFAULT NULL,
  `DA_ParentId` int(11) DEFAULT NULL,
  `DA_Describe` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`DA_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_sys_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_log`;
CREATE TABLE `tbl_sys_log` (
  `Log_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Log_TypeId` int(11) DEFAULT NULL,
  `Log_UserId` int(11) DEFAULT NULL,
  `Log_MenuId` int(11) DEFAULT NULL,
  `Log_Info` varchar(1000) DEFAULT NULL,
  `Log_Timestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Log_UserTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Log_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3237 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_menu`;
CREATE TABLE `tbl_sys_menu` (
  `Menu_Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Menu_Name` varchar(255) DEFAULT NULL,
  `Menu_ParentId` int(11) DEFAULT NULL,
  `Menu_IsMenu` bit(1) DEFAULT b'1',
  `Menu_Url` varchar(1000) DEFAULT NULL,
  `Menu_Icon` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`Menu_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_sys_menu
-- ----------------------------
INSERT INTO `tbl_sys_menu` VALUES ('1', '系统管理', '0', '', null, 'fa-laptop');
INSERT INTO `tbl_sys_menu` VALUES ('2', '场所管理', '0', '', '/venue/list', 'fa-th-list');
INSERT INTO `tbl_sys_menu` VALUES ('0', '主菜单', null, '', null, null);
INSERT INTO `tbl_sys_menu` VALUES ('3', '用户管理', '1', '', '/sys/user/list', null);
INSERT INTO `tbl_sys_menu` VALUES ('4', '权限管理', '1', '', '/sys/auth/list', null);
INSERT INTO `tbl_sys_menu` VALUES ('5', '日志管理', '1', '', '/sys/log/list', null);
INSERT INTO `tbl_sys_menu` VALUES ('6', '资源管理', '0', '', '/sys/log/list', 'fa-book');
INSERT INTO `tbl_sys_menu` VALUES ('8', '模板管理', '0', '', '/sys/log/list', 'fa-tasks');
INSERT INTO `tbl_sys_menu` VALUES ('9', '页面管理', '0', '', '/page/list', 'fa-file-text');
INSERT INTO `tbl_sys_menu` VALUES ('10', '页面审核', '0', '', '/page/audit', 'fa-cogs');
INSERT INTO `tbl_sys_menu` VALUES ('11', '手册发布', '0', '', '/page/list', 'fa-bookmark');
INSERT INTO `tbl_sys_menu` VALUES ('12', '新闻管理', '0', '', '/news/list', 'fa-bullhorn');
INSERT INTO `tbl_sys_menu` VALUES ('13', '促销管理', '0', '', '/sale/list', 'fa-star');
INSERT INTO `tbl_sys_menu` VALUES ('7', '游客管理', '0', '', '/u', 'fa-users');

-- ----------------------------
-- Table structure for `tbl_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_user`;
CREATE TABLE `tbl_sys_user` (
  `User_Id` int(11) NOT NULL AUTO_INCREMENT,
  `User_LoginName` varchar(255) DEFAULT NULL,
  `User_Name` varchar(255) DEFAULT NULL,
  `User_Password` varchar(255) DEFAULT NULL,
  `User_TypeId` int(11) DEFAULT NULL COMMENT 'Ϊ1�ǹ���Ա',
  `ONLINE_CODE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`User_Id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_sys_user
-- ----------------------------
INSERT INTO `tbl_sys_user` VALUES ('1', 'admin', '系统管理员', '96e79218965eb72c92a549dd5a330112', '1', null);
INSERT INTO `tbl_sys_user` VALUES ('18', '', '', null, '1', null);
INSERT INTO `tbl_sys_user` VALUES ('19', '', '', null, '1', null);
INSERT INTO `tbl_sys_user` VALUES ('20', '', '', null, '1', null);
INSERT INTO `tbl_sys_user` VALUES ('21', '', '', null, '1', null);
INSERT INTO `tbl_sys_user` VALUES ('22', '', '', null, '1', null);
INSERT INTO `tbl_sys_user` VALUES ('23', '', '', null, '1', null);

-- ----------------------------
-- Table structure for `tbl_template`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_template`;
CREATE TABLE `tbl_template` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TemplateName` varchar(255) DEFAULT NULL,
  `TemplateType` int(11) DEFAULT NULL,
  `TemplateWidth` int(11) DEFAULT NULL,
  `TemplateHeight` int(11) DEFAULT NULL,
  `TemplateColor` int(11) DEFAULT NULL,
  `TemplateImage` varchar(255) DEFAULT NULL,
  `TemplateDescription` varchar(255) DEFAULT NULL,
  `TemplateCreateTime` datetime DEFAULT NULL,
  `smallImage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_template
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_theme`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_theme`;
CREATE TABLE `tbl_theme` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ThemeName` varchar(255) DEFAULT NULL,
  `ThemeImage` varchar(255) DEFAULT NULL,
  `Sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_theme
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_theme_salespage`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_theme_salespage`;
CREATE TABLE `tbl_theme_salespage` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ThemeID` int(11) DEFAULT NULL,
  `SalePageID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_theme_salespage
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_venue`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_venue`;
CREATE TABLE `tbl_venue` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VenueCode` varchar(64) DEFAULT NULL,
  `VenueManager` varchar(255) DEFAULT NULL,
  `VenueTypes` varchar(64) DEFAULT NULL COMMENT '场所类型，多个用逗号(,)隔开',
  `Languages` varchar(64) DEFAULT NULL COMMENT '语言，多个用逗号（,）分割',
  `StateId` int(11) DEFAULT NULL COMMENT '国家',
  `ProvinceId` int(11) DEFAULT NULL COMMENT '省',
  `CityId` int(11) DEFAULT NULL COMMENT '市',
  `Longitude` decimal(20,6) DEFAULT NULL COMMENT '经度',
  `Latitude` decimal(20,6) DEFAULT NULL COMMENT '纬度',
  `Seq` int(6) DEFAULT NULL COMMENT '排序',
  `ManagerId` int(11) DEFAULT NULL COMMENT '关联用户表id',
  `PayType` varchar(64) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `CreateUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_venue
-- ----------------------------
INSERT INTO `tbl_venue` VALUES ('29', '001', 'zhangsan', 'HOTEL', 'CN', '0', '1', '2', '11.110000', '22.220000', '1', null, 'PAY', '2016-06-07 20:10:26', '1');
INSERT INTO `tbl_venue` VALUES ('30', '002', 'lisi', 'HOTEL', 'EN', '0', '3', '4', '66.660000', '88.880000', '2', null, 'NOTNEED', '2016-06-08 09:48:16', '1');
INSERT INTO `tbl_venue` VALUES ('31', '003', 'wangwu', 'HOTEL', 'BRZ', '0', '5', '4', '44.333000', '22.340000', '3', null, 'PAY', '2016-06-08 09:49:04', '1');
INSERT INTO `tbl_venue` VALUES ('32', '004', 'zhaoqi', 'HOTEL', 'CN', '1', '4', '3', '55.770000', '77.990000', '4', null, 'PAY', '2016-06-08 09:49:57', '1');
INSERT INTO `tbl_venue` VALUES ('33', '005', 'wangba', 'HOTEL', 'LIUHAO', '6', '4', '33', '22.000000', '33.000000', '5', null, 'NOTNEED', '2016-06-08 09:50:50', '1');

-- ----------------------------
-- Table structure for `tbl_venue_attr`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_venue_attr`;
CREATE TABLE `tbl_venue_attr` (
  `Id` int(11) NOT NULL,
  `VenueId` int(11) DEFAULT NULL COMMENT '关联场所',
  `Language` varchar(20) DEFAULT NULL COMMENT '语言，关联字典',
  `VenueType` varchar(20) DEFAULT NULL COMMENT '场所类型，关联字典',
  `AttrId` int(11) DEFAULT NULL,
  `AttrCode` varchar(64) DEFAULT NULL,
  `AttrValue` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='场所动态属性值表';

-- ----------------------------
-- Records of tbl_venue_attr
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_venue_meetingroom`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_venue_meetingroom`;
CREATE TABLE `tbl_venue_meetingroom` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VenueID` int(11) DEFAULT NULL,
  `MRSequence` int(11) DEFAULT NULL,
  `FunctionRoom` varchar(255) DEFAULT NULL,
  `Dimensions` varchar(255) DEFAULT NULL,
  `Size` varchar(255) DEFAULT NULL,
  `Height` varchar(255) DEFAULT NULL,
  `Reception` varchar(255) DEFAULT NULL,
  `Banquet` varchar(255) DEFAULT NULL,
  `Theatre` varchar(255) DEFAULT NULL,
  `Classroom` varchar(255) DEFAULT NULL,
  `UShape` varchar(255) DEFAULT NULL,
  `Boardroom` varchar(255) DEFAULT NULL,
  `HollowSquare` varchar(255) DEFAULT NULL,
  `MeetingImage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_venue_meetingroom
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_venue_pages`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_venue_pages`;
CREATE TABLE `tbl_venue_pages` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `VenueID` int(11) DEFAULT NULL,
  `PageID` int(11) DEFAULT NULL,
  `PageTypeID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_venue_pages
-- ----------------------------

-- ----------------------------
-- Table structure for `tbl_venue_template`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_venue_template`;
CREATE TABLE `tbl_venue_template` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VenueID` int(11) DEFAULT NULL,
  `TemplateID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_venue_template
-- ----------------------------
