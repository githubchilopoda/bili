package com.crawl.acfun.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Date parseDateTime(String dateStr){
		try {
			return df.parse(dateStr);
		}catch (Exception e){
			
		}
		return null;
	}
}
