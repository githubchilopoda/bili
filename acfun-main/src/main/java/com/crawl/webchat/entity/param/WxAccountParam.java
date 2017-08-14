package com.crawl.webchat.entity.param;



/**
 * 
 * 参数
 * 
 */
public class WxAccountParam extends BaseParam{


	/**
	 * 
	 */
	private String account;

	private String accountFuzzy;

	/**
	 * 
	 */
	private String accountName;

	private String accountNameFuzzy;

	/**
	 * 
	 */
	private String authority;

	private String authorityFuzzy;

	/**
	 * 
	 */
	private String introduction;

	private String introductionFuzzy;

	/**
	 * 
	 */
	private Integer fanNum;

	/**
	 * 
	 */
	private String categoryName;

	private String categoryNameFuzzy;

	/**
	 * 
	 */
	private String tags;

	private String tagsFuzzy;

	/**
	 * 
	 */
	private java.util.Date joinAt;

	private String joinAtStart;

	private String joinAtEnd;

	/**
	 * 
	 */
	private Integer zhishu;

	/**
	 * 
	 */
	private Integer rank;

	/**
	 * 
	 */
	private java.util.Date rankDay;

	private String rankDayStart;

	private String rankDayEnd;

	/**
	 * 
	 */
	private Integer topZhishu;

	/**
	 * 
	 */
	private java.util.Date topZhishuDay;

	private String topZhishuDayStart;

	private String topZhishuDayEnd;

	/**
	 * 
	 */
	private Integer topRank;

	/**
	 * 
	 */
	private java.util.Date topRankDay;

	private String topRankDayStart;

	private String topRankDayEnd;


	public void setAccount(String account){
		this.account = account;
	}

	public String getAccount(){
		return this.account;
	}

	public void setAccountFuzzy(String accountFuzzy){
		this.accountFuzzy = accountFuzzy;
	}

	public String getAccountFuzzy(){
		return this.accountFuzzy;
	}

	public void setAccountName(String accountName){
		this.accountName = accountName;
	}

	public String getAccountName(){
		return this.accountName;
	}

	public void setAccountNameFuzzy(String accountNameFuzzy){
		this.accountNameFuzzy = accountNameFuzzy;
	}

	public String getAccountNameFuzzy(){
		return this.accountNameFuzzy;
	}

	public void setAuthority(String authority){
		this.authority = authority;
	}

	public String getAuthority(){
		return this.authority;
	}

	public void setAuthorityFuzzy(String authorityFuzzy){
		this.authorityFuzzy = authorityFuzzy;
	}

	public String getAuthorityFuzzy(){
		return this.authorityFuzzy;
	}

	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}

	public String getIntroduction(){
		return this.introduction;
	}

	public void setIntroductionFuzzy(String introductionFuzzy){
		this.introductionFuzzy = introductionFuzzy;
	}

	public String getIntroductionFuzzy(){
		return this.introductionFuzzy;
	}

	public void setFanNum(Integer fanNum){
		this.fanNum = fanNum;
	}

	public Integer getFanNum(){
		return this.fanNum;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return this.categoryName;
	}

	public void setCategoryNameFuzzy(String categoryNameFuzzy){
		this.categoryNameFuzzy = categoryNameFuzzy;
	}

	public String getCategoryNameFuzzy(){
		return this.categoryNameFuzzy;
	}

	public void setTags(String tags){
		this.tags = tags;
	}

	public String getTags(){
		return this.tags;
	}

	public void setTagsFuzzy(String tagsFuzzy){
		this.tagsFuzzy = tagsFuzzy;
	}

	public String getTagsFuzzy(){
		return this.tagsFuzzy;
	}

	public void setJoinAt(java.util.Date joinAt){
		this.joinAt = joinAt;
	}

	public java.util.Date getJoinAt(){
		return this.joinAt;
	}

	public void setJoinAtStart(String joinAtStart){
		this.joinAtStart = joinAtStart;
	}

	public String getJoinAtStart(){
		return this.joinAtStart;
	}
	public void setJoinAtEnd(String joinAtEnd){
		this.joinAtEnd = joinAtEnd;
	}

	public String getJoinAtEnd(){
		return this.joinAtEnd;
	}

	public void setZhishu(Integer zhishu){
		this.zhishu = zhishu;
	}

	public Integer getZhishu(){
		return this.zhishu;
	}

	public void setRank(Integer rank){
		this.rank = rank;
	}

	public Integer getRank(){
		return this.rank;
	}

	public void setRankDay(java.util.Date rankDay){
		this.rankDay = rankDay;
	}

	public java.util.Date getRankDay(){
		return this.rankDay;
	}

	public void setRankDayStart(String rankDayStart){
		this.rankDayStart = rankDayStart;
	}

	public String getRankDayStart(){
		return this.rankDayStart;
	}
	public void setRankDayEnd(String rankDayEnd){
		this.rankDayEnd = rankDayEnd;
	}

	public String getRankDayEnd(){
		return this.rankDayEnd;
	}

	public void setTopZhishu(Integer topZhishu){
		this.topZhishu = topZhishu;
	}

	public Integer getTopZhishu(){
		return this.topZhishu;
	}

	public void setTopZhishuDay(java.util.Date topZhishuDay){
		this.topZhishuDay = topZhishuDay;
	}

	public java.util.Date getTopZhishuDay(){
		return this.topZhishuDay;
	}

	public void setTopZhishuDayStart(String topZhishuDayStart){
		this.topZhishuDayStart = topZhishuDayStart;
	}

	public String getTopZhishuDayStart(){
		return this.topZhishuDayStart;
	}
	public void setTopZhishuDayEnd(String topZhishuDayEnd){
		this.topZhishuDayEnd = topZhishuDayEnd;
	}

	public String getTopZhishuDayEnd(){
		return this.topZhishuDayEnd;
	}

	public void setTopRank(Integer topRank){
		this.topRank = topRank;
	}

	public Integer getTopRank(){
		return this.topRank;
	}

	public void setTopRankDay(java.util.Date topRankDay){
		this.topRankDay = topRankDay;
	}

	public java.util.Date getTopRankDay(){
		return this.topRankDay;
	}

	public void setTopRankDayStart(String topRankDayStart){
		this.topRankDayStart = topRankDayStart;
	}

	public String getTopRankDayStart(){
		return this.topRankDayStart;
	}
	public void setTopRankDayEnd(String topRankDayEnd){
		this.topRankDayEnd = topRankDayEnd;
	}

	public String getTopRankDayEnd(){
		return this.topRankDayEnd;
	}

	public java.util.Map<String, Object> toMap(){
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("account", this.account);
		dataMap.put("accountFuzzy", this.accountFuzzy);
		dataMap.put("accountName", this.accountName);
		dataMap.put("accountNameFuzzy", this.accountNameFuzzy);
		dataMap.put("authority", this.authority);
		dataMap.put("authorityFuzzy", this.authorityFuzzy);
		dataMap.put("introduction", this.introduction);
		dataMap.put("introductionFuzzy", this.introductionFuzzy);
		dataMap.put("fanNum", this.fanNum);
		dataMap.put("categoryName", this.categoryName);
		dataMap.put("categoryNameFuzzy", this.categoryNameFuzzy);
		dataMap.put("tags", this.tags);
		dataMap.put("tagsFuzzy", this.tagsFuzzy);
		dataMap.put("joinAt", this.joinAt);
		dataMap.put("joinAtStart", this.joinAtStart);
		dataMap.put("joinAtEnd", this.joinAtEnd);
		dataMap.put("zhishu", this.zhishu);
		dataMap.put("rank", this.rank);
		dataMap.put("rankDay", this.rankDay);
		dataMap.put("rankDayStart", this.rankDayStart);
		dataMap.put("rankDayEnd", this.rankDayEnd);
		dataMap.put("topZhishu", this.topZhishu);
		dataMap.put("topZhishuDay", this.topZhishuDay);
		dataMap.put("topZhishuDayStart", this.topZhishuDayStart);
		dataMap.put("topZhishuDayEnd", this.topZhishuDayEnd);
		dataMap.put("topRank", this.topRank);
		dataMap.put("topRankDay", this.topRankDay);
		dataMap.put("topRankDayStart", this.topRankDayStart);
		dataMap.put("topRankDayEnd", this.topRankDayEnd);
		return dataMap;
	}
}
