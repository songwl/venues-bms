package com.venues.bms.vo;

/**
 * 枚举常量定义
 * created by song on 2016/6/12.
 *
 */
public abstract class Enums {

	public static enum USER_TYPE {
		SYS_ADMIN(1, "系统管理员"), VENUE_MANAGER(2, "场所管理员");

		private Integer value;
		private String cnName;

		USER_TYPE(Integer value, String cnName) {
			this.value = value;
			this.cnName = cnName;
		}

		public String getValue() {
			return this.value.toString();
		}

		public String getLabel() {
			return this.cnName;
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
		ERROR("错误"), NEW("新增"), UPDATE("修改");

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
}
