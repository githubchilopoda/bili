package com.crawl.webchat.entity.po;

import java.io.Serializable;

/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class BiliCategory implements Serializable {

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String channel;

	/**
	 * 
	 */
	private Integer pid;

	/**
	 * 
	 */
	private String url;

	/**
	 * 
	 */
	private String enName;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getEnName() {
		return this.enName;
	}

	public BiliCategory clone() {
		BiliCategory copied = new BiliCategory();
		copied.id = this.id;
		copied.name = this.name;
		copied.channel = this.channel;
		copied.pid = this.pid;
		copied.url = this.url;
		copied.enName = this.enName;
		return copied;
	}

	public java.util.Map<String, Object> toMap() {
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("id", this.id);
		dataMap.put("name", this.name);
		dataMap.put("channel", this.channel);
		dataMap.put("pid", this.pid);
		dataMap.put("url", this.url);
		dataMap.put("enName", this.enName);
		return dataMap;
	}
}
