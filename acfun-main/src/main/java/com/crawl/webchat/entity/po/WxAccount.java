package com.crawl.webchat.entity.po;

import java.io.Serializable;

/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class WxAccount implements Serializable {

	/**
	 * 
	 */
	private String account;

	/**
	 * 
	 */
	private String accountName;

	/**
	 * 
	 */
	private String authority;

	/**
	 * 
	 */
	private String introduction;

	/**
	 * 
	 */
	private Integer fanNum;

	/**
	 * 
	 */
	private String categoryName;

	/**
	 * 
	 */
	private String tags;

	/**
	 * 
	 */
	private java.util.Date joinAt;

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

	/**
	 * 
	 */
	private Integer topZhishu;

	/**
	 * 
	 */
	private java.util.Date topZhishuDay;

	/**
	 * 
	 */
	private Integer topRank;

	/**
	 * 
	 */
	private java.util.Date topRankDay;

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setFanNum(Integer fanNum) {
		this.fanNum = fanNum;
	}

	public Integer getFanNum() {
		return this.fanNum;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTags() {
		return this.tags;
	}

	public void setJoinAt(java.util.Date joinAt) {
		this.joinAt = joinAt;
	}

	public java.util.Date getJoinAt() {
		return this.joinAt;
	}

	public void setZhishu(Integer zhishu) {
		this.zhishu = zhishu;
	}

	public Integer getZhishu() {
		return this.zhishu;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRankDay(java.util.Date rankDay) {
		this.rankDay = rankDay;
	}

	public java.util.Date getRankDay() {
		return this.rankDay;
	}

	public void setTopZhishu(Integer topZhishu) {
		this.topZhishu = topZhishu;
	}

	public Integer getTopZhishu() {
		return this.topZhishu;
	}

	public void setTopZhishuDay(java.util.Date topZhishuDay) {
		this.topZhishuDay = topZhishuDay;
	}

	public java.util.Date getTopZhishuDay() {
		return this.topZhishuDay;
	}

	public void setTopRank(Integer topRank) {
		this.topRank = topRank;
	}

	public Integer getTopRank() {
		return this.topRank;
	}

	public void setTopRankDay(java.util.Date topRankDay) {
		this.topRankDay = topRankDay;
	}

	public java.util.Date getTopRankDay() {
		return this.topRankDay;
	}

	public WxAccount clone() {
		WxAccount copied = new WxAccount();
		copied.account = this.account;
		copied.accountName = this.accountName;
		copied.authority = this.authority;
		copied.introduction = this.introduction;
		copied.fanNum = this.fanNum;
		copied.categoryName = this.categoryName;
		copied.tags = this.tags;
		copied.joinAt = this.joinAt;
		copied.zhishu = this.zhishu;
		copied.rank = this.rank;
		copied.rankDay = this.rankDay;
		copied.topZhishu = this.topZhishu;
		copied.topZhishuDay = this.topZhishuDay;
		copied.topRank = this.topRank;
		copied.topRankDay = this.topRankDay;
		return copied;
	}

	public java.util.Map<String, Object> toMap() {
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("account", this.account);
		dataMap.put("accountName", this.accountName);
		dataMap.put("authority", this.authority);
		dataMap.put("introduction", this.introduction);
		dataMap.put("fanNum", this.fanNum);
		dataMap.put("categoryName", this.categoryName);
		dataMap.put("tags", this.tags);
		dataMap.put("joinAt", this.joinAt);
		dataMap.put("zhishu", this.zhishu);
		dataMap.put("rank", this.rank);
		dataMap.put("rankDay", this.rankDay);
		dataMap.put("topZhishu", this.topZhishu);
		dataMap.put("topZhishuDay", this.topZhishuDay);
		dataMap.put("topRank", this.topRank);
		dataMap.put("topRankDay", this.topRankDay);
		return dataMap;
	}

	@Override
	public String toString() {
		return "WxAccount [account=" + account + ", accountName=" + accountName + ", authority=" + authority
				+ ", introduction=" + introduction + ", fanNum=" + fanNum + ", categoryName=" + categoryName + ", tags="
				+ tags + ", joinAt=" + joinAt + ", zhishu=" + zhishu + ", rank=" + rank + ", rankDay=" + rankDay
				+ ", topZhishu=" + topZhishu + ", topZhishuDay=" + topZhishuDay + ", topRank=" + topRank
				+ ", topRankDay=" + topRankDay + "]";
	}
}
