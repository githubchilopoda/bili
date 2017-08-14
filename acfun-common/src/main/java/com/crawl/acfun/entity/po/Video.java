package com.crawl.acfun.entity.po;

import java.io.Serializable;
import org.json.JSONObject;


/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class Video implements Serializable {


	/**
	 * 
	 */
	private Integer vid;

	/**
	 * 
	 */
	private Integer webId;

	/**
	 * 
	 */
	private String url;

	/**
	 * 
	 */
	private String title;

	/**
	 * 
	 */
	private String source;

	/**
	 * 
	 */
	private String img;

	/**
	 * 
	 */
	private Integer views;

	/**
	 * 
	 */
	private Integer danmu;

	/**
	 * 
	 */
	private String remark;


	public void setVid(Integer vid){
		this.vid = vid;
	}

	public Integer getVid(){
		return this.vid;
	}

	public void setWebId(Integer webId){
		this.webId = webId;
	}

	public Integer getWebId(){
		return this.webId;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return this.url;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return this.source;
	}

	public void setImg(String img){
		this.img = img;
	}

	public String getImg(){
		return this.img;
	}

	public void setViews(Integer views){
		this.views = views;
	}

	public Integer getViews(){
		return this.views;
	}

	public void setDanmu(Integer danmu){
		this.danmu = danmu;
	}

	public Integer getDanmu(){
		return this.danmu;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public Video clone(){
		Video copied = new Video();
		copied.vid = this.vid;
		copied.webId = this.webId;
		copied.url = this.url;
		copied.title = this.title;
		copied.source = this.source;
		copied.img = this.img;
		copied.views = this.views;
		copied.danmu = this.danmu;
		copied.remark = this.remark;
		return copied;
	}
	public static Video fromJson(JSONObject data){
		Video copied = new Video();
		copied.vid = data.optInt("vid");
		copied.webId = data.optInt("webId");
		copied.url = data.optString("url");
		copied.title = data.optString("title");
		copied.source = data.optString("source");
		copied.img = data.optString("img");
		copied.views = data.optInt("views");
		copied.danmu = data.optInt("danmu");
		copied.remark = data.optString("remark");
		return copied;
	}
}
