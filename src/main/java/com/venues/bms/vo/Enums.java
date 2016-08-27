package com.venues.bms.vo;

/**
 * 枚举常量定义
 * created by song on 2016/6/12.
 *
 */
public abstract class Enums {

	public static enum USER_TYPE {
		SYS_ADMIN(1, "系统管理员"), VENUE_MANAGER(2, "场所管理员");

		private Integer code;
		private String cnName;

		USER_TYPE(Integer code, String cnName) {
			this.code = code;
			this.cnName = cnName;
		}

		public String getValue() {
			return this.code.toString();
		}

		public String getLabel() {
			return this.cnName;
		}

		public Integer getCode() {
			return this.code;
		}

		public static String getCnName(String t) {
			for (USER_TYPE s : values()) {
				if (s.name().equalsIgnoreCase(t)) {
					return s.getLabel();
				}
			}
			return t;
		}
	}

	public static enum LOG_TYPE {
		ERROR("错误"), NEW("新增"), UPDATE("修改"), DELETE("删除");

		private String cnName;

		LOG_TYPE(String cnName) {
			this.cnName = cnName;
		}

		public String getValue() {
			return this.name();
		}

		public String getLabel() {
			return this.cnName;
		}

		public static String getCnName(String t) {
			for (LOG_TYPE s : values()) {
				if (s.name().equalsIgnoreCase(t)) {
					return s.getLabel();
				}
			}
			return t;
		}
	}

	public static enum FILE_EXT {
		JPG, PNG, FLV;

		public String getValue() {
			return this.name();
		}

		public String getLabel() {
			return this.name();
		}

		public static String getCnName(String t) {
			for (FILE_EXT s : values()) {
				if (s.name().equalsIgnoreCase(t)) {
					return s.getLabel();
				}
			}
			return t;
		}
	}

	public static enum TEMPLATE_TYPE {
		FREE(29, "免费"), PAY(30, "付费");

		private int code;
		private String cnName;

		TEMPLATE_TYPE(int code, String cnName) {
			this.code = code;
			this.cnName = cnName;
		}

		public String getValue() {
			return String.valueOf(this.code);
		}

		public String getLabel() {
			return this.cnName;
		}

		public static String getCnName(String t) {
			for (TEMPLATE_TYPE s : values()) {
				if (s.name().equalsIgnoreCase(t)) {
					return s.getLabel();
				}
			}
			return t;
		}
	}

	public static enum VENUE_TYPE {
		HOTEL("酒店"), MEETING("会议中心"), SPECIAL("特殊场所"), LANDMARK("地标");

		private String cnName;

		VENUE_TYPE(String cnName) {
			this.cnName = cnName;
		}

		public String getValue() {
			return this.name();
		}

		public String getLabel() {
			return this.cnName;
		}

		public static String getCnName(String t) {
			for (VENUE_TYPE s : values()) {
				if (s.name().equalsIgnoreCase(t)) {
					return s.getLabel();
				}
			}
			return t;
		}
	}

	public static enum LANGUAGE {
		CHINESE("中文"), ENGLISH("英文");

		private String cnName;

		LANGUAGE(String cnName) {
			this.cnName = cnName;
		}

		public String getValue() {
			return this.name();
		}

		public String getLabel() {
			return this.cnName;
		}

		public static String getCnName(String t) {
			for (LANGUAGE s : values()) {
				if (s.name().equalsIgnoreCase(t)) {
					return s.getLabel();
				}
			}
			return t;
		}
	}

	public static enum PAGE_TYPE {
		HomePage(40, "首页"), OverviewPage(43, "概述页"), PromotionPage(41, "促销页"), NewsPage(42, "新闻页"), GalleryPage(58, "画廊页"), VideoPage(59, "视频页"), MeetingPage(64, "会议室页"), MapPage(72,
				"地图页"), PlanePage(73, "平面图");

		private Integer code;
		private String cnName;

		PAGE_TYPE(int code, String cnName) {
			this.code = code;
			this.cnName = cnName;
		}

		public Integer getCode() {
			return this.code;
		}

		public String getValue() {
			return this.code.toString();
		}

		public String getLabel() {
			return this.cnName;
		}

		public static String getCnName(String t) {
			for (PAGE_TYPE s : values()) {
				if (s.name().equalsIgnoreCase(t)) {
					return s.getLabel();
				}
			}
			return t;
		}
	}

	public static enum PAGE_STATUS {
		Submit(36, "提交"), AuditPass(37, "审核通过"), AuditNotPass(38, "审核不通过");

		private Integer code;
		private String cnName;

		PAGE_STATUS(int code, String cnName) {
			this.code = code;
			this.cnName = cnName;
		}

		public Integer getCode() {
			return this.code;
		}

		public String getValue() {
			return this.code.toString();
		}

		public String getLabel() {
			return this.cnName;
		}

		public static String getCnName(String t) {
			for (PAGE_STATUS s : values()) {
				if (s.name().equalsIgnoreCase(t)) {
					return s.getLabel();
				}
			}
			return t;
		}
	}
}
