package com.crawl.webchat.entity.po;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class PgcWeekRank implements Serializable {

	/**
	 * 
	 */
	private Integer rank;

	/**
	 * 
	 */
	private Integer categoryId;

	/**
	 * 
	 */
	private String categoryName;

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
	private Integer youku;

	/**
	 * 
	 */
	private Integer tecent;

	/**
	 * 
	 */
	private Integer iqiyi;

	/**
	 * 
	 */
	private Integer toutiao;

	/**
	 * 
	 */
	private Integer miaopai;

	/**
	 * 
	 */
	private Integer meipai;

	/**
	 * 
	 */
	private Double point;

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return this.categoryName;
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

	public void setYouku(Integer youku) {
		this.youku = youku;
	}

	public Integer getYouku() {
		return this.youku;
	}

	public void setTecent(Integer tecent) {
		this.tecent = tecent;
	}

	public Integer getTecent() {
		return this.tecent;
	}

	public void setIqiyi(Integer iqiyi) {
		this.iqiyi = iqiyi;
	}

	public Integer getIqiyi() {
		return this.iqiyi;
	}

	public void setToutiao(Integer toutiao) {
		this.toutiao = toutiao;
	}

	public Integer getToutiao() {
		return this.toutiao;
	}

	public void setMiaopai(Integer miaopai) {
		this.miaopai = miaopai;
	}

	public Integer getMiaopai() {
		return this.miaopai;
	}

	public void setMeipai(Integer meipai) {
		this.meipai = meipai;
	}

	public Integer getMeipai() {
		return this.meipai;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public Double getPoint() {
		return this.point;
	}

	public PgcWeekRank clone() {
		PgcWeekRank copied = new PgcWeekRank();
		copied.rank = this.rank;
		copied.categoryId = this.categoryId;
		copied.categoryName = this.categoryName;
		copied.dayBegin = this.dayBegin;
		copied.account = this.account;
		copied.accountName = this.accountName;
		copied.icon = this.icon;
		copied.youku = this.youku;
		copied.tecent = this.tecent;
		copied.iqiyi = this.iqiyi;
		copied.toutiao = this.toutiao;
		copied.miaopai = this.miaopai;
		copied.meipai = this.meipai;
		copied.point = this.point;
		return copied;
	}

	public java.util.Map<String, Object> toMap() {
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("rank", this.rank);
		dataMap.put("categoryId", this.categoryId);
		dataMap.put("categoryName", this.categoryName);
		dataMap.put("dayBegin", this.dayBegin);
		dataMap.put("account", this.account);
		dataMap.put("accountName", this.accountName);
		dataMap.put("icon", this.icon);
		dataMap.put("youku", this.youku);
		dataMap.put("tecent", this.tecent);
		dataMap.put("iqiyi", this.iqiyi);
		dataMap.put("toutiao", this.toutiao);
		dataMap.put("miaopai", this.miaopai);
		dataMap.put("meipai", this.meipai);
		dataMap.put("point", this.point);
		return dataMap;
	}
}
