package com.crawl.util;

import java.nio.charset.Charset;
import java.util.Base64;

public class StringUtils {
	public static boolean isEmpty(String str) {
		return str == null || str.equals("");
	}

	public static int countOccurrencesOf(String statement, String sub) {
		return statement.split(sub).length - 1;
	}
	
	public static int parseInt(String strValue) {
		
		if (strValue.equals("-")){
			return 0;
		}
		strValue = strValue.replace(",", "");
		int pos = strValue.indexOf("万");
		if (pos < 0) {
			pos = strValue.indexOf("w");
		}
		if (pos > 0) {
			return Integer.parseInt(strValue.substring(0, pos)) * 10000;
		}
		return Integer.parseInt(strValue);
	}
	
	public static double parseDouble(String strValue) {
		return Double.parseDouble(strValue);
	}

	public static long parseLong(String strValue) {
		return Long.parseLong(strValue);
	}

	public static String base64Decode(String src) {
		return new String(Base64.getDecoder().decode(src), Charset.forName("utf-8"));
	}
}
