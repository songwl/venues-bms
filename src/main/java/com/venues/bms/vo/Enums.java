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
		FREE("免费模版"), PAY("付费模版");

		private String cnName;

		TEMPLATE_TYPE(String cnName) {
			this.cnName = cnName;
		}

		public String getValue() {
			return this.name();
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
		HOTEL("酒店"), MEETING("会所"), SPECIAL("特殊场所"), LANDMARK("地标");

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
}
