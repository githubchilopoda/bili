package com.crawl.webchat.entity.po;

import java.io.Serializable;

/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class NewRankDay implements Serializable {

	/**
	 * 
	 */
	private Integer rank;

	/**
	 * 
	 */
	private String categoryName;

	/**
	 * 
	 */
	private java.util.Date day;

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
	private Integer fabu1;

	/**
	 * 
	 */
	private Integer fabu2;

	/**
	 * 
	 */
	private Integer zongyuedu;

	/**
	 * 
	 */
	private Integer toutiao;

	/**
	 * 
	 */
	private Integer pingjun;

	/**
	 * 
	 */
	private Integer zuigao;

	/**
	 * 
	 */
	private Integer dianzhan;

	/**
	 * 
	 */
	private Double zishu;

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setDay(java.util.Date day) {
		this.day = day;
	}

	public java.util.Date getDay() {
		return this.day;
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

	public void setFabu1(Integer fabu1) {
		this.fabu1 = fabu1;
	}

	public Integer getFabu1() {
		return this.fabu1;
	}

	public void setFabu2(Integer fabu2) {
		this.fabu2 = fabu2;
	}

	public Integer getFabu2() {
		return this.fabu2;
	}

	public void setZongyuedu(Integer zongyuedu) {
		this.zongyuedu = zongyuedu;
	}

	public Integer getZongyuedu() {
		return this.zongyuedu;
	}

	public void setToutiao(Integer toutiao) {
		this.toutiao = toutiao;
	}

	public Integer getToutiao() {
		return this.toutiao;
	}

	public void setPingjun(Integer pingjun) {
		this.pingjun = pingjun;
	}

	public Integer getPingjun() {
		return this.pingjun;
	}

	public void setZuigao(Integer zuigao) {
		this.zuigao = zuigao;
	}

	public Integer getZuigao() {
		return this.zuigao;
	}

	public void setDianzhan(Integer dianzhan) {
		this.dianzhan = dianzhan;
	}

	public Integer getDianzhan() {
		return this.dianzhan;
	}

	public void setZishu(Double zishu) {
		this.zishu = zishu;
	}

	public Double getZishu() {
		return this.zishu;
	}

	public NewRankDay clone() {
		NewRankDay copied = new NewRankDay();
		copied.rank = this.rank;
		copied.categoryName = this.categoryName;
		copied.day = this.day;
		copied.account = this.account;
		copied.accountName = this.accountName;
		copied.fabu1 = this.fabu1;
		copied.fabu2 = this.fabu2;
		copied.zongyuedu = this.zongyuedu;
		copied.toutiao = this.toutiao;
		copied.pingjun = this.pingjun;
		copied.zuigao = this.zuigao;
		copied.dianzhan = this.dianzhan;
		copied.zishu = this.zishu;
		return copied;
	}

	public java.util.Map<String, Object> toMap() {
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("rank", this.rank);
		dataMap.put("categoryName", this.categoryName);
		dataMap.put("day", this.day);
		dataMap.put("account", this.account);
		dataMap.put("accountName", this.accountName);
		dataMap.put("fabu1", this.fabu1);
		dataMap.put("fabu2", this.fabu2);
		dataMap.put("zongyuedu", this.zongyuedu);
		dataMap.put("toutiao", this.toutiao);
		dataMap.put("pingjun", this.pingjun);
		dataMap.put("zuigao", this.zuigao);
		dataMap.put("dianzhan", this.dianzhan);
		dataMap.put("zishu", this.zishu);
		return dataMap;
	}

	@Override
	public String toString() {
		return "NewRankDay [rank=" + rank + ", categoryName=" + categoryName + ", day=" + day + ", account=" + account
				+ ", accountName=" + accountName + ", fabu1=" + fabu1 + ", fabu2=" + fabu2 + ", zongyuedu=" + zongyuedu
				+ ", toutiao=" + toutiao + ", pingjun=" + pingjun + ", zuigao=" + zuigao + ", dianzhan=" + dianzhan
				+ ", zishu=" + zishu + "]";
	}
}
