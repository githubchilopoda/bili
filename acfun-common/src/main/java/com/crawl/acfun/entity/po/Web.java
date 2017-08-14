package com.crawl.acfun.entity.po;

import java.io.Serializable;
import org.json.JSONObject;


/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class Web implements Serializable {


	/**
	 * 
	 */
	private Integer webId;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String url;


	public void setWebId(Integer webId){
		this.webId = webId;
	}

	public Integer getWebId(){
		return this.webId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return this.url;
	}

	public Web clone(){
		Web copied = new Web();
		copied.webId = this.webId;
		copied.name = this.name;
		copied.url = this.url;
		return copied;
	}
	public static Web fromJson(JSONObject data){
		Web copied = new Web();
		copied.webId = data.optInt("webId");
		copied.name = data.optString("name");
		copied.url = data.optString("url");
		return copied;
	}
}
