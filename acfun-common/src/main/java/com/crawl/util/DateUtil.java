package com.crawl.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 用户中心日期工具类。
 * 
 * @author wangguolin
 * @version 1.0 Created on 2014-4-29, 19:22:20
 */
public class DateUtil {

	/**
	 * 时间格式map。
	 */
	// private static Map<String, DateFormat> mapDateFormat;

	/** 锁对象 */
	private static final Object lockObj = new Object();

	/** 存放不同的日期模板格式的sdf的Map */
	private static Map<String, ThreadLocal<DateFormat>> mapDateFormat = null;

	private synchronized static void initDateFormat() {
		if (mapDateFormat == null) {
			mapDateFormat = new ConcurrentHashMap<String, ThreadLocal<DateFormat>>();
		}
	}

	/**
	 * 获取当前日期的字符串
	 * 
	 * @param pattern
	 *            --格式
	 * @return
	 */
	public static String getCurrentDateStr(String pattern) {
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		Date dt = new Date(System.currentTimeMillis());
		return sf.format(dt);
	}

	/**
	 * 将long类型时间戳转换Date类型时间。
	 * 
	 * @param dateTime
	 *            long类型时间
	 * @return Date类型时间
	 */
	public final static Date long2Date(long dateTime) {
		Date date = new Date(dateTime * 1000);
		return date;
	}

	/**
	 * 将Date类型时间转换成为long类型时间戳（以秒为单位）。
	 * 
	 * @param date
	 *            Date类型时间
	 * @return long类型时间戳
	 */
	public final static long date2Long(Date date) {
		return date.getTime() / 1000;
	}

	public static long getWebsiteDatetime() {
		try {
			URL url = new URL("http://www.baidu.com");// 取得资源对象
			URLConnection uc = url.openConnection();// 生成连接对象
			uc.connect();// 发出连接
			long ld = uc.getDate();// 读取网站日期时间
			return ld;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取指定的时间格式化器。
	 * 
	 * @param formatKey
	 *            时间格式key
	 * @return 格式化器
	 */
	public static DateFormat getDateFormat(final String pattern) {
		initDateFormat();
		ThreadLocal<DateFormat> tl = mapDateFormat.get(pattern);
		if (tl == null) {
			synchronized (lockObj) {
				tl = mapDateFormat.get(pattern);
				if (tl == null) {
					// 只有Map中还没有这个pattern的sdf才会生成新的sdf并放入map
					// System.out.println("put new sdf of pattern " + pattern +
					// " to map");

					// 这里是关键,使用ThreadLocal<SimpleDateFormat>替代原来直接new
					// SimpleDateFormat
					tl = new ThreadLocal<DateFormat>() {

						@Override
						protected SimpleDateFormat initialValue() {
							System.out.println("thread: " + Thread.currentThread() + " init pattern: " + pattern);
							return new SimpleDateFormat(pattern);
						}
					};
					mapDateFormat.put(pattern, tl);
				}
			}
		}
		return tl.get();
	}

	/**
	 * 修改日期时间对象的时间部分为 00:00:00.0000
	 * 
	 * @param oDate
	 *            日期
	 * @return 修改时间部分后的日期
	 */
	public static Date getDateOnly(final Date oDate) {
		if (null == oDate) {
			return oDate;
		}
		final Calendar c = Calendar.getInstance();
		c.setTime(oDate);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取格式化的当前日期时间。
	 * 
	 * @return 格式化后的当前日期时间，日期时间格式为：YYYY-MM-DD HH:MM:SS
	 */
	public final static String getCurrentDatetime() {
		return formatDateTime(Calendar.getInstance().getTime());
	}

	/**
	 * 获取格式化的当前日期。
	 * 
	 * @param formatKey
	 *            格式化key
	 * @return 格式化后的当前日期
	 */
	public static String getCurrentDate(String formatKey) {
		return formatDate(Calendar.getInstance().getTime(), formatKey);
	}

	/**
	 * 获取日期中指定字段的数值，如获取月份。
	 * 
	 * @param date
	 *            日期
	 * @param field
	 *            指定字段
	 * @return 数值
	 */
	private static int getCalendarField(Date date, int field) {
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(field);
		}
		return 0;
	}

	/**
	 * 获取日期字符串的日期风格，失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 日期风格
	 */
	public static DateStyle getDateStyle(String date) {
		DateStyle dateStyle = null;
		Map<Long, DateStyle> map = new HashMap<Long, DateStyle>();
		List<Long> timestamps = new ArrayList<Long>();
		for (DateStyle style : DateStyle.values()) {
			Date dateTmp = parseDate(date, style.getValue());
			if (dateTmp != null) {
				timestamps.add(dateTmp.getTime());
				map.put(dateTmp.getTime(), style);
			}
		}
		dateStyle = map.get(getAccurateDate(timestamps).getTime());
		return dateStyle;
	}

	/**
	 * 获取下一个时间。
	 * 
	 * @param date
	 *            原始时间对象
	 * @param field
	 *            增量字段
	 * @param amount
	 *            增量
	 * @return 应用增量后的时间
	 */
	private static String getNextDate(String date, int field, int amount) {
		String dateString = null;
		DateStyle dateStyle = getDateStyle(date);
		if (dateStyle != null) {
			Date myDate = parseDate(date, dateStyle.getValue());
			myDate = getNextDate(myDate, field, amount);
			dateString = formatDate(myDate, dateStyle.getValue());
		}
		return dateString;
	}

	/**
	 * 获取下一个时间。
	 * 
	 * @param date
	 *            原始时间对象
	 * @param field
	 *            增量字段
	 * @param amount
	 *            增量
	 * @return 应用增量后的时间
	 */
	public static Date getNextDate(Date date, int field, int amount) {
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(field, amount);

			return calendar.getTime();
		}
		return null;
	}

	/**
	 * 获取以当前时间为基准的下一个时间。
	 * 
	 * @param field
	 *            增量字段
	 * @param amount
	 *            增量
	 * @return 应用增量后的时间
	 */
	public static Date getNextDate(int field, int amount) {
		return getNextDate(new Date(), field, amount);
	}

	/**
	 * 获取精确的日期。
	 * 
	 * @param timestamps
	 *            时间戳集合
	 * @return 日期
	 */
	private static Date getAccurateDate(List<Long> timestamps) {
		Date date = null;
		long timestamp = 0;
		Map<Long, long[]> map = new HashMap<Long, long[]>();
		List<Long> absoluteValues = new ArrayList<Long>();

		if (timestamps != null && timestamps.size() > 0) {
			if (timestamps.size() > 1) {
				for (int i = 0; i < timestamps.size(); i++) {
					for (int j = i + 1; j < timestamps.size(); j++) {
						long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));
						absoluteValues.add(absoluteValue);
						long[] timestampTmp = { timestamps.get(i), timestamps.get(j) };
						map.put(absoluteValue, timestampTmp);
					}
				}

				// 有可能有相等的情况。如2012-11和2012-11-01。时间戳是相等的
				long minAbsoluteValue = -1;
				if (!absoluteValues.isEmpty()) {
					// 如果timestamps的size为2，这是差值只有一个，因此要给默认值
					minAbsoluteValue = absoluteValues.get(0);
				}

				for (int i = 0; i < absoluteValues.size(); i++) {
					for (int j = i + 1; j < absoluteValues.size(); j++) {
						if (absoluteValues.get(i) > absoluteValues.get(j)) {
							minAbsoluteValue = absoluteValues.get(j);
						} else {
							minAbsoluteValue = absoluteValues.get(i);
						}
					}
				}

				if (minAbsoluteValue != -1) {
					long[] timestampsLastTmp = map.get(minAbsoluteValue);
					if (absoluteValues.size() > 1) {
						timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
					} else if (absoluteValues.size() == 1) {
						// 当timestamps的size为2，需要与当前时间作为参照
						long dateOne = timestampsLastTmp[0];
						long dateTwo = timestampsLastTmp[1];
						if ((Math.abs(dateOne - dateTwo)) < 100000000000L) {
							timestamp = Math.max(timestampsLastTmp[0], timestampsLastTmp[1]);
						} else {
							long now = new Date().getTime();
							if (Math.abs(dateOne - now) <= Math.abs(dateTwo - now)) {
								timestamp = dateOne;
							} else {
								timestamp = dateTwo;
							}
						}
					}
				}
			} else {
				timestamp = timestamps.get(0);
			}
		}

		if (timestamp != 0) {
			date = new Date(timestamp);
		}
		return date;
	}

	/**
	 * 判断指定的文本是否为日期格式。
	 * 
	 * @param date
	 *            文本内容
	 * @return true:是日期格式 false:非日期格式
	 */
	public static boolean isDate(String date) {
		boolean isDate = false;
		if (date != null) {
			if (parseDate(date) != null) {
				isDate = true;
			}
		}
		return isDate;
	}

	/**
	 * 解析指定的文本为日期对象。解析异常则返回null。
	 * 
	 * @param date
	 *            文本内容
	 * @return 日期对象
	 */
	public static Date parseDate(String date) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		try {
			return getDateFormat(DateStyle.YYYY_MM_DD.getValue()).parse(date);
		} catch (ParseException exp) {
			return null;
		}
	}

	public static Date parseDateAdaptive(String date) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}

		date = date.replace("/", "");
		date = date.replace("-", "");
		date = date.replace(":", "");
		date = date.replace(" ", "");

		String formatKey = null;
		if (date.length() == DateStyle.YYYYMMDD.getValue().length()) {
			formatKey = DateStyle.YYYYMMDD.getValue();
		} else {
			formatKey = DateStyle.YYYYMMDDHHMMSS.getValue();
		}
		return parseDate(date, formatKey);
	}

	/**
	 * 解析指定的文本为日期对象。解析异常则返回null。
	 * 
	 * @param date
	 *            文本内容
	 * @param formatKey
	 *            时间格式key
	 * @return 日期对象
	 */
	public static Date parseDate(String date, String formatKey) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		try {
			return getDateFormat(formatKey).parse(date);
		} catch (Exception exp) {
			return null;
		}
	}

	/**
	 * 解析指定的文本为日期对象。解析异常则返回null。
	 * 
	 * @param date
	 *            文本内容：格式必须是yyyy-MM-dd HH:mm:ss或yyyy-MM-dd
	 *            HH:mm:ss:SSS或yyyy/MM/dd HH:mm:ss或yyyy/MM/dd HH:mm:ss:SSS
	 * @return 日期对象
	 */
	public static Date parseDateTime(String dateTime) {
		if (StringUtils.isEmpty(dateTime)) {
			return null;
		}
		Date date = parseDate(dateTime, DateStyle.YYYY_MM_DD_HH_MM_SS.getValue());
		if (date == null) {
			date = parseDate(dateTime, DateStyle.YYYY_MM_DD_HH_MM_SS_EN.getValue());
		}
		if (date == null) {
			date = parseDate(dateTime, DateStyle.YYYY_MM_DD_HH_MM.getValue());
		}
		if (date == null) {
			date = parseDate(dateTime, DateStyle.YYYY_MM_DD_HH_MM_SS_SSS.getValue());
		}
		if (date == null) {
			date = parseDate(dateTime, DateStyle.YYYY_MM_DD_HH_MM_SS_SSS_EN.getValue());
		}
		return date;
	}

	public static Time parseTime(String time) {
		if (StringUtils.isEmpty(time)) {
			return null;
		}
		int occurs = StringUtils.countOccurrencesOf(time, ":");
		if (occurs == 1) {
			time = time + ":00";
		} else if (occurs == 0) {
			time = time + ":00:00";
		}
		Time sTime = Time.valueOf(time);
		return sTime;
	}

	/**
	 * 格式化指定的日期时间。
	 * 
	 * @param date
	 *            待格式化的日期时间
	 * @return 格式化后的日期时间，日期时间格式为：YYYY-MM-DD HH:MM:SS
	 */
	public static String formatDateTime(Date date) {
		if (date != null) {
			return getDateFormat(DateStyle.YYYY_MM_DD_HH_MM_SS.getValue()).format(date);
		}
		return "";
	}

	/**
	 * 格式化指定的日期时间。
	 * 
	 * @param date
	 *            待格式化的日期时间
	 * @return 格式化后的日期时间，日期时间格式为：YYYY-MM-DD HH:MM:SS:SSS
	 */
	public static String formatMilliDateTime(Date date) {
		if (date != null) {
			return getDateFormat(DateStyle.YYYY_MM_DD_HH_MM_SS_SSS.getValue()).format(date);
		}
		return "";
	}

	/**
	 * 格式化指定的日期。
	 * 
	 * @param date
	 *            待格式化的日期
	 * @return 格式化后的日期，日期格式为：YYYY-MM-DD
	 */
	public static String formatDate(Date date) {
		if (date != null) {
			return getDateFormat(DateStyle.YYYY_MM_DD.getValue()).format(date);
		}
		return "";
	}

	/**
	 * 格式化指定的时间。
	 * 
	 * @param date
	 *            待格式化的时间
	 * @return 格式化后的时间，时间格式为：HH:MM:SS
	 */
	public static String formatTime(Date date) {
		if (date != null) {
			return getDateFormat(DateStyle.HH_MM_SS.getValue()).format(date);
		}
		return "";
	}

	/**
	 * 格式化指定的时间。
	 * 
	 * @param date
	 *            待格式化的时间
	 * @param formatKey
	 *            时间格式key
	 * @return 格式化后的时间
	 */
	public static String formatDate(Date date, String formatKey) {
		if (date != null) {
			return getDateFormat(formatKey).format(date);
		}
		return "";
	}

	/**
	 * 将指定的日期文本转换成另一格式的日期文本，失败返回null。
	 * 
	 * @param date
	 *            文本内容
	 * @param formatKey
	 *            日期格式key
	 * @return 新格式的日期文本
	 */
	public static String changeFormatDate(String date, String formatKey) {
		return changeFormatDate(date, null, formatKey);
	}

	/**
	 * 将指定的日期文本转换成另一格式的日期文本，失败返回null。
	 * 
	 * @param date
	 *            文本内容
	 * @param oldFormatKey
	 *            旧日期格式key
	 * @param newFormatKey
	 *            新日期格式key
	 * @return 新格式的日期文本
	 */
	public static String changeFormatDate(String date, String oldFormatKey, String newFormatKey) {
		String dateString = null;
		if (oldFormatKey == null) {
			DateStyle style = getDateStyle(date);
			if (style != null) {
				Date myDate = parseDate(date, style.getValue());
				dateString = formatDate(myDate, newFormatKey);
			}
		} else {
			Date myDate = parseDate(date, oldFormatKey);
			dateString = formatDate(myDate, newFormatKey);
		}
		return dateString;
	}

	/**
	 * 增加日期的年份，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加年份后的日期
	 */
	public static String addYear(String date, int amount) {
		return getNextDate(date, Calendar.YEAR, amount);
	}

	/**
	 * 增加日期的年份，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加年份后的日期
	 */
	public static Date addYear(Date date, int amount) {
		return getNextDate(date, Calendar.YEAR, amount);
	}

	/**
	 * 增加日期的月份，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加月份后的日期
	 */
	public static String addMonth(String date, int amount) {
		return getNextDate(date, Calendar.MONTH, amount);
	}

	/**
	 * 增加日期的月份，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加月份后的日期
	 */
	public static Date addMonth(Date date, int amount) {
		return getNextDate(date, Calendar.MONTH, amount);
	}

	/**
	 * 增加日期的天数，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加天数后的日期
	 */
	public static String addDay(String date, int amount) {
		return getNextDate(date, Calendar.DATE, amount);
	}

	/**
	 * 增加日期的天数，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加天数后的日期
	 */
	public static Date addDay(Date date, int amount) {
		return getNextDate(date, Calendar.DATE, amount);
	}

	/**
	 * 增加日期的小时，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加小时后的日期
	 */
	public static String addHour(String date, int amount) {
		return getNextDate(date, Calendar.HOUR_OF_DAY, amount);
	}

	/**
	 * 增加日期的小时，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加小时后的日期
	 */
	public static Date addHour(Date date, int amount) {
		return getNextDate(date, Calendar.HOUR_OF_DAY, amount);
	}

	/**
	 * 增加日期的分钟，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加分钟后的日期
	 */
	public static String addMinute(String date, int amount) {
		return getNextDate(date, Calendar.MINUTE, amount);
	}

	/**
	 * 增加日期的分钟，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加分钟后的日期
	 */
	public static Date addMinute(Date date, int amount) {
		return getNextDate(date, Calendar.MINUTE, amount);
	}

	/**
	 * 增加日期的秒数，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加秒数后的日期
	 */
	public static String addSecond(String date, int amount) {
		return getNextDate(date, Calendar.SECOND, amount);
	}

	/**
	 * 增加日期的秒数，失败返回null。
	 * 
	 * @param date
	 *            基准日期
	 * @param amount
	 *            增量
	 * @return 增加秒数后的日期
	 */
	public static Date addSecond(Date date, int amount) {
		return getNextDate(date, Calendar.SECOND, amount);
	}

	/**
	 * 获取日期的年份，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return 年份
	 */
	public static int getYear(String date) {
		return getYear(parseDate(date));
	}

	/**
	 * 获取日期的年份，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return 年份
	 */
	public static int getYear(Date date) {
		return getCalendarField(date, Calendar.YEAR);
	}

	/**
	 * 获取日期的月份，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return 月份
	 */
	public static int getMonth(String date) {
		return getMonth(parseDate(date));
	}

	/**
	 * 获取日期的月份，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return 月份
	 */
	public static int getMonth(Date date) {
		return getCalendarField(date, Calendar.MONTH);
	}

	/**
	 * 获取日期的天数，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return 天
	 */
	public static int getDay(String date) {
		return getDay(parseDate(date));
	}

	/**
	 * 获取日期的天数，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return 天
	 */
	public static int getDay(Date date) {
		return getCalendarField(date, Calendar.DATE);
	}

	/**
	 * 获取日期的小时，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return 小时
	 */
	public static int getHour(String date) {
		return getHour(parseDate(date));
	}

	/**
	 * 获取日期的小时，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return 小时，24小时模式
	 */
	public static int getHour(Date date) {
		return getCalendarField(date, Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取日期的分钟，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return 分钟
	 */
	public static int getMinute(String date) {
		return getMinute(parseDate(date));
	}

	/**
	 * 获取日期的分钟，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return 分钟
	 */
	public static int getMinute(Date date) {
		return getCalendarField(date, Calendar.MINUTE);
	}

	/**
	 * 获取日期的second字段，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return second字段
	 */
	public static int getSecond(String date) {
		return getSecond(parseDate(date));
	}

	/**
	 * 获取日期的second字段，失败返回0。
	 * 
	 * @param date
	 *            日期对象
	 * @return second字段
	 */
	public static int getSecond(Date date) {
		return getCalendarField(date, Calendar.SECOND);
	}

	/**
	 * 获取日期的星期。失败返回null。
	 * 
	 * @param date
	 *            日期对象
	 * @return 星期
	 */
	public static Week getWeek(String date) {
		Week week = null;
		DateStyle dateStyle = getDateStyle(date);
		if (dateStyle != null) {
			Date myDate = parseDate(date, dateStyle.getValue());
			week = getWeek(myDate);
		}
		return week;
	}

	/**
	 * 获取日期的星期。失败返回null。
	 * 
	 * @param date
	 *            日期对象
	 * @return 星期
	 */
	public static Week getWeek(Date date) {
		Week week = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		switch (weekNumber) {
		case 0:
			week = Week.SUNDAY;
			break;
		case 1:
			week = Week.MONDAY;
			break;
		case 2:
			week = Week.TUESDAY;
			break;
		case 3:
			week = Week.WEDNESDAY;
			break;
		case 4:
			week = Week.THURSDAY;
			break;
		case 5:
			week = Week.FRIDAY;
			break;
		case 6:
			week = Week.SATURDAY;
			break;
		}
		return week;
	}

	/**
	 * 获取两个日期相差的天数。
	 * 
	 * @param date1
	 *            日期对象1
	 * @param date2
	 *            日期对象2
	 * @return 相差天数
	 */
	public static int getIntervalDays(String date1, String date2) {
		return getIntervalDays(parseDate(date1), parseDate(date2));
	}

	/**
	 * 获取两个日期相差的天数。
	 * 
	 * @param date1
	 *            日期对象1
	 * @param date2
	 *            日期对象2
	 * @return 相差天数
	 */
	public static int getIntervalDays(Date date1, Date date2) {
		long time = Math.abs(date1.getTime() - date2.getTime());
		return (int) (time / (24 * 60 * 60 * 1000));
	}

	/**
	 * 获取两个日期相差的天数,相对上边的方法，该方法不关心分，秒
	 * 
	 * @param fDate
	 *            开始时间
	 * @param oDate
	 *            截止时间
	 * @return 相差天数
	 */
	public static int daysOfTwo(Date fDate, Date oDate) {
		if (!oDate.after(fDate)) {
			return 0;
		}

		Calendar d1 = new GregorianCalendar();
		d1.setTime(fDate);

		Calendar d2 = new GregorianCalendar();
		d2.setTime(oDate);

		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);

		// 计算年
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);// 得到当年的实际天数
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}

		return days;
	}

	/**
	 * 比较两个日期大小
	 * 
	 * @param time1
	 *            日期
	 * @param time2
	 *            日期
	 * @return 整数 正数：time1 > time2 ， 负数:time1 < time2, 0: time1 = time2
	 */
	public static int compareDate(Date time1, Date time2) {
		if (time1 == null) {
			if (time2 == null) {
				return 0;
			} else {
				return -1;
			}
		} else if (time2 == null) {
			return 1;
		} else {
			return new Long(time1.getTime() - time2.getTime()).intValue();
		}
	}

	/**
	 * 获取某月的最后一天
	 * 
	 * @Title:getLastDayOfMonth @Description: @param:@param year @param:@param
	 *                          month @param:@return @return:String @throws
	 */
	public static Date getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year); // 设置年份
		cal.set(Calendar.MONTH, month - 1); // 设置月份
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取某月最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay); // 设置日历中月份的最大天数
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

		return cal.getTime();
	}

	/**
	 * 获取某月的第一天
	 * 
	 * @Title:getLastDayOfMonth @Description: @param:@param year @param:@param
	 *                          month @param:@return @return:String @throws
	 */
	public static Date getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year); // 设置年份
		cal.set(Calendar.MONTH, month - 1); // 设置月份
		int lastDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH); // 获取某月第一天
		cal.set(Calendar.DAY_OF_MONTH, lastDay); // 设置日历中月份的最小天数
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		return cal.getTime();
	}

	/**
	 * 获取某月的最后一天
	 * 
	 * @Title:getLastDayOfMonth @Description: @param:@param year @param:@param
	 *                          month @param:@return @return:String @throws
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

		// int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		// if (dayOfWeek > 0){
		//
		// }

		// cal.set(Calendar.YEAR, year); // 设置年份
		// cal.set(Calendar.MONTH, month - 1); // 设置月份
		// int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //
		// 获取某月最大天数
		// cal.set(Calendar.DAY_OF_MONTH, lastDay); // 设置日历中月份的最大天数
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

		return cal.getTime();
	}

	/**
	 * 获取某月的第一天
	 * 
	 * @Title:getLastDayOfMonth @Description: @param:@param year @param:@param
	 *                          month @param:@return @return:String @throws
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		// cal.set(Calendar.YEAR, year); // 设置年份
		// cal.set(Calendar.MONTH, month - 1); // 设置月份
		// int lastDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH); // 获取某月第一天
		// cal.set(Calendar.DAY_OF_MONTH, lastDay); // 设置日历中月份的最小天数
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		return cal.getTime();
	}

	public static Date getBeginOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static int[] getDateLength(Date fromDate, Date toDate) {
		Calendar c1 = getCal(fromDate);
		Calendar c2 = getCal(toDate);
		int[] p1 = { c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DAY_OF_MONTH) };
		int[] p2 = { c2.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH) };
		return new int[] { p2[0] - p1[0], p2[0] * 12 + p2[1] - p1[0] * 12 - p1[1],
				(int) ((c2.getTimeInMillis() - c1.getTimeInMillis()) / (24 * 3600 * 1000)) };
	}

	public static Calendar getCal(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(getYear(date), getMonth(date), getDay(date));
		return cal;
	}

	public static String getDate(Date date) {
		return dateToString(date, DateStyle.YYYY_MM_DD);
	}

	public static Date getEndOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static String dateToString(Date date, DateStyle dateStyle) {
		String dateString = null;
		if (dateStyle != null) {
			dateString = dateToString(date, dateStyle.getValue());
		}
		return dateString;
	}

	public static String dateToString(Date date, String parttern) {
		String dateString = null;
		if (date != null) {
			try {
				dateString = getDateFormat(parttern).format(date);
			} catch (Exception e) {
			}
		}
		return dateString;
	}

	public static Date setTimeBefore(Date time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		return cal.getTime();
	}

	/**
	 * 
	 * getValueByDate:(这里用一句话描述这个方法的作用). <br/>
	 *
	 * @param time
	 * @param pattern
	 * @return
	 */
	public static String getValueByDate(Date time, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(time);
	}

	public static Date setTimeEnd(Date time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

		return cal.getTime();
	}

	/**
	 * 
	 * strToTime:(string转java.sql.Time). <br/>
	 *
	 * @param timeStr
	 * @return
	 */
	public static Time strToTime(String timeStr) {

		return Time.valueOf(timeStr);
	}

	public static boolean isSameDayOfYear(Date day1, Date day2) {
		return getCalendarField(day1, Calendar.MONTH) == getCalendarField(day2, Calendar.MONTH)
				&& getCalendarField(day1, Calendar.DAY_OF_MONTH) == getCalendarField(day2, Calendar.DAY_OF_MONTH);
	}

	public static void main(String args[]) throws IOException {

		Date time = new Date();
		String pattern = "HH";
		System.err.println(getValueByDate(time, pattern));
		time = DateUtil.parseDate("2017-06-22 00:00");
		System.out.println(time);
		// System.out.println(addDay(getDate(new Date()), -1));
		//
		// System.out.println("毫秒：" + System.currentTimeMillis());
		// System.out.println("毫秒1：" + addHour(new Date(), -1).getTime());
		//
		// DateFormat dateFormat =
		// getDateFormat(DateStyle.YYYY_MM_DD_HH_MM_SS_SSS
		// .getValue());
		// System.out.println("毫秒转成时间：" + dateFormat.format(1421078400894L));
		// System.out.println("毫秒转成时间：" + dateFormat.format(1421164799895L));
		//
		// Date startDate1 = DateUtil.parseDate("2015-01-13 00:00:00",
		// DateStyle.YYYY_MM_DD_HH_MM_SS.getValue());
		// Date endDate1 = DateUtil.parseDate("2015-01-13 23:59:59",
		// DateStyle.YYYY_MM_DD_HH_MM_SS.getValue());
		// System.out.println("时间比较：" + endDate1.after(startDate1));
		//
		// Date now = new Date();
		// Date endDate = addDay(now, 1);
		// Date endDateAddHour = addHour(now, 1);
		// Date tDate = addMonth(now, 9);
		// int[] ret = getDateLength(now, tDate);
		// System.out.println("隔几个月：" + ret[1]);
		//
		// // System.out.println("日期："+endDate);
		// int between = getIntervalDays(now, endDate);
		// System.out.println("endDate is before now："
		// + now.before(endDateAddHour));
		// System.out.println("和当前时间相差几天：" + between);
		// int days = daysOfTwo(now, endDate);
		// System.out.println("相差几天：" + days);
		// System.out.println("月份：" + getMonth(now));
		// System.out.println("加月份：" + formatDateTime(addMonth(now, -3)));
		//
		// System.out.println("截止时间：" + addDay(new Date(), 1));
		// // System.out.println("今天和今天"+daysOfTwo(new Date(),new Date()));
		//
		// System.out.println("获取月份的最后一天："
		// + formatDateTime(getLastDayOfMonth(2014, 2)));
		// System.out.println("获取月份的第一天："
		// + formatDateTime(getFirstDayOfMonth(2014, 2)));
		//
		// System.out.println(DateUtil.getCurrentDate("yyyyMMddHHmmss") + "_"
		// + System.currentTimeMillis());

		// 20140922101010_1111s434
		// 20141203192941
	}

	public static boolean isSameDay(Date beginDate, Date date) {
		return beginDate.getYear() == date.getYear() && beginDate.getMonth() == date.getMonth()
				&& beginDate.getDate() == date.getDate();
	}

	public static Date getFirstDayOfMonth(Date now) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		int lastDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH); // 获取某月第一天
		cal.set(Calendar.DAY_OF_MONTH, lastDay); // 设置日历中月份的最小天数
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		return cal.getTime();
	}

	public static Date getLastDayOfMonth(Date now) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(now); //
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取某月最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay); // 设置日历中月份的最大天数
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

		return cal.getTime();
	}

	public static Date getFirstDayOfSeason(Date now) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(now); //
		int month = cal.get(Calendar.MONTH);
		int firstMonth = month - (month % 3);

		cal.set(Calendar.MONTH, firstMonth);
		int lastDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH); // 获取某月第一天
		cal.set(Calendar.DAY_OF_MONTH, lastDay); // 设置日历中月份的最小天数
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);

		return cal.getTime();
	}

	public static Date parseChineseDate(String cnDateStr) {
		Date now = new Date();
		try {
			DateFormat df = new SimpleDateFormat("MM月dd日");
			Date a = df.parse(cnDateStr);
			a.setYear(now.getYear());
			return a;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	public static Date getLastDayOfSeason(Date now) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(now); //
		int month = cal.get(Calendar.MONTH);
		int firstMonth = month - (month % 3) + 2;

		cal.set(Calendar.MONTH, firstMonth);
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 获取某月最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay); // 设置日历中月份的最大天数
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);

		return cal.getTime();
	}
}