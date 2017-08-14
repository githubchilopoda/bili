package com.crawl.acfun.entity.po;

import java.io.Serializable;
import org.json.JSONObject;


/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class Category implements Serializable {


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


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setChannel(String channel){
		this.channel = channel;
	}

	public String getChannel(){
		return this.channel;
	}

	public void setPid(Integer pid){
		this.pid = pid;
	}

	public Integer getPid(){
		return this.pid;
	}

	public Category clone(){
		Category copied = new Category();
		copied.id = this.id;
		copied.name = this.name;
		copied.channel = this.channel;
		copied.pid = this.pid;
		return copied;
	}
	public static Category fromJson(JSONObject data){
		Category copied = new Category();
		copied.id = data.optInt("id");
		copied.name = data.optString("name");
		copied.channel = data.optString("channel");
		copied.pid = data.optInt("pid");
		return copied;
	}
}
