package com.crawl.webchat.entity.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class WeiboWeekRank implements Serializable {

	/**
	 * 
	 */
	private Integer rank;

	/**
	 * 1 personal, 2 authority, 3 未认证
	 */
	private Integer type;

	/**
	 * 
	 */
	private java.util.Date dayBegin;

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
	private String icon;

	/**
	 * 
	 */
	private Integer fansNumber;

	/**
	 * 
	 */
	private Integer publishNumber;

	/**
	 * 
	 */
	private Integer starNumber;

	/**
	 * 
	 */
	private Integer commentNumber;

	/**
	 * 
	 */
	private Integer forwardNumber;

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

	public void setDayBegin(java.util.Date dayBegin) {
		this.dayBegin = dayBegin;
	}

	public java.util.Date getDayBegin() {
		return this.dayBegin;
	}

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

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setFansNumber(Integer fansNumber) {
		this.fansNumber = fansNumber;
	}

	public Integer getFansNumber() {
		return this.fansNumber;
	}

	public void setPublishNumber(Integer publishNumber) {
		this.publishNumber = publishNumber;
	}

	public Integer getPublishNumber() {
		return this.publishNumber;
	}

	public void setStarNumber(Integer starNumber) {
		this.starNumber = starNumber;
	}

	public Integer getStarNumber() {
		return this.starNumber;
	}

	public void setCommentNumber(Integer commentNumber) {
		this.commentNumber = commentNumber;
	}

	public Integer getCommentNumber() {
		return this.commentNumber;
	}

	public void setForwardNumber(Integer forwardNumber) {
		this.forwardNumber = forwardNumber;
	}

	public Integer getForwardNumber() {
		return this.forwardNumber;
	}

	public WeiboWeekRank clone() {
		WeiboWeekRank copied = new WeiboWeekRank();
		copied.rank = this.rank;
		copied.type = this.type;
		copied.dayBegin = this.dayBegin;
		copied.account = this.account;
		copied.accountName = this.accountName;
		copied.icon = this.icon;
		copied.fansNumber = this.fansNumber;
		copied.publishNumber = this.publishNumber;
		copied.starNumber = this.starNumber;
		copied.commentNumber = this.commentNumber;
		copied.forwardNumber = this.forwardNumber;
		return copied;
	}

	public java.util.Map<String, Object> toMap() {
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("rank", this.rank);
		dataMap.put("type", this.type);
		dataMap.put("dayBegin", this.dayBegin);
		dataMap.put("account", this.account);
		dataMap.put("accountName", this.accountName);
		dataMap.put("icon", this.icon);
		dataMap.put("fansNumber", this.fansNumber);
		dataMap.put("publishNumber", this.publishNumber);
		dataMap.put("starNumber", this.starNumber);
		dataMap.put("commentNumber", this.commentNumber);
		dataMap.put("forwardNumber", this.forwardNumber);
		return dataMap;
	}
}
