package com.crawl.util;


/**
 * 星期名称枚举类。
 * 
 * @author wangguolin
 * @version 1.0
 * Created on 2014-4-29, 19:53:22
 */
public enum Week {

	MONDAY("一", "星期一", "Monday", "Mon.", 1), 
	TUESDAY("二", "星期二", "Tuesday", "Tues.", 2), 
	WEDNESDAY("三", "星期三", "Wednesday", "Wed.", 3), 
	THURSDAY("四", "星期四", "Thursday", "Thur.", 4), 
	FRIDAY("五", "星期五", "Friday", "Fri.", 5), 
	SATURDAY("六", "星期六", "Saturday", "Sat.", 6), 
	SUNDAY("日", "星期日", "Sunday", "Sun.", 7);

	String cn_number;
	String name_cn;
	String name_en;
	String name_enShort;
	int number;

	Week(String cn_number, String name_cn, String name_en, String name_enShort, int number)
	{
		this.cn_number = cn_number;
		this.name_cn = name_cn;
		this.name_en = name_en;
		this.name_enShort = name_enShort;
		this.number = number;
	}
	
	public String getCnNumber(){
		return cn_number;
	}
	
	public static Week getByValue(int val){
		for (Week week: values()){
			if (week.getNumber() == val){
				return week;
			}
		}
		return null;
	}

	public String getChineseName()
	{
		return name_cn;
	}

	public String getName()
	{
		return name_en;
	}

	public String getShortName()
	{
		return name_enShort;
	}

	public int getNumber()
	{
		return number;
	}
}