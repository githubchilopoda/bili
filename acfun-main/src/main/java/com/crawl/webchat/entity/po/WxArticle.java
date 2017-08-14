package com.crawl.webchat.entity.po;

import java.io.Serializable;

/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class WxArticle implements Serializable {

	/**
	 * 
	 */
	private Long mid;

	/**
	 * 
	 */
	private Integer idx;

	/**
	 * 
	 */
	private String sn;

	/**
	 * 
	 */
	private String author;

	/**
	 * 
	 */
	private String biz;

	/**
	 * 
	 */
	private String bizDecoded;

	/**
	 * 
	 */
	private String title;

	/**
	 * 
	 */
	private String description;

	/**
	 * 
	 */
	private Integer viewNumber;

	/**
	 * 
	 */
	private Integer starNumber;

	/**
	 * 
	 */
	private java.util.Date publishTime;

	/**
	 * 
	 */
	private Integer level;

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Long getMid() {
		return this.mid;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Integer getIdx() {
		return this.idx;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getSn() {
		return this.sn;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setBiz(String biz) {
		this.biz = biz;
	}

	public String getBiz() {
		return this.biz;
	}

	public void setBizDecoded(String bizDecoded) {
		this.bizDecoded = bizDecoded;
	}

	public String getBizDecoded() {
		return this.bizDecoded;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setViewNumber(Integer viewNumber) {
		this.viewNumber = viewNumber;
	}

	public Integer getViewNumber() {
		return this.viewNumber;
	}

	public void setStarNumber(Integer starNumber) {
		this.starNumber = starNumber;
	}

	public Integer getStarNumber() {
		return this.starNumber;
	}

	public void setPublishTime(java.util.Date publishTime) {
		this.publishTime = publishTime;
	}

	public java.util.Date getPublishTime() {
		return this.publishTime;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLevel() {
		return this.level;
	}

	public WxArticle clone() {
		WxArticle copied = new WxArticle();
		copied.mid = this.mid;
		copied.idx = this.idx;
		copied.sn = this.sn;
		copied.author = this.author;
		copied.biz = this.biz;
		copied.bizDecoded = this.bizDecoded;
		copied.title = this.title;
		copied.description = this.description;
		copied.viewNumber = this.viewNumber;
		copied.starNumber = this.starNumber;
		copied.publishTime = this.publishTime;
		copied.level = this.level;
		return copied;
	}

	public java.util.Map<String, Object> toMap() {
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("mid", this.mid);
		dataMap.put("idx", this.idx);
		dataMap.put("sn", this.sn);
		dataMap.put("author", this.author);
		dataMap.put("biz", this.biz);
		dataMap.put("bizDecoded", this.bizDecoded);
		dataMap.put("title", this.title);
		dataMap.put("description", this.description);
		dataMap.put("viewNumber", this.viewNumber);
		dataMap.put("starNumber", this.starNumber);
		dataMap.put("publishTime", this.publishTime);
		dataMap.put("level", this.level);
		return dataMap;
	}

	@Override
	public String toString() {
		return "WxArticle [mid=" + mid + ", idx=" + idx + ", sn=" + sn + ", author=" + author + ", biz=" + biz
				+ ", bizDecoded=" + bizDecoded + ", title=" + title + ", description=" + description + ", viewNumber="
				+ viewNumber + ", starNumber=" + starNumber + ", publishTime=" + publishTime + ", level=" + level + "]";
	}
}
