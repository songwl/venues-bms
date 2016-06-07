package com.venues.bms.core.utils;

public abstract class HtmlUtils {

	public static String parseHtml(String str) {
		if (org.apache.commons.lang3.StringUtils.isEmpty(str)) {
			return str;
		}

		str = str.replaceAll("&", "&amp");
		str = str.replaceAll(" ", "&nbsp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("\r\n", "<br/>");
		str = str.replaceAll("\r", "<br/>");
		str = str.replaceAll("\n", "<br/>");
		return str;
	}
}
