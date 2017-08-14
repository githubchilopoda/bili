package com.crawl.bili.entity.po;

import java.io.Serializable;
import org.json.JSONObject;

import com.crawl.util.DateUtil;



/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class BiliVideo implements Serializable {


	/**
	 * 
	 */
	private Integer aid;

	/**
	 * 
	 */
	private Integer comment;

	/**
	 * 
	 */
	private Integer typeid;

	/**
	 * 
	 */
	private Integer play;

	/**
	 * 
	 */
	private String pic;

	/**
	 * 
	 */
	private String subtitle;

	/**
	 * 
	 */
	private String description;

	/**
	 * 
	 */
	private String copyright;

	/**
	 * 
	 */
	private String title;

	/**
	 * 
	 */
	private Integer review;

	/**
	 * 
	 */
	private String author;

	/**
	 * 
	 */
	private Integer mid;

	/**
	 * 
	 */
	private java.util.Date created;

	/**
	 * 
	 */
	private Integer length;

	/**
	 * 
	 */
	private Integer videoReview;

	/**
	 * 
	 */
	private Integer favorites;

	/**
	 * 
	 */
	private Integer hideClick;

	/**
	 * 
	 */
	private java.util.Date crawlDate;

	/**
	 * 
	 */
	private java.util.Date lastUpdate;


	public void setAid(Integer aid){
		this.aid = aid;
	}

	public Integer getAid(){
		return this.aid;
	}

	public void setComment(Integer comment){
		this.comment = comment;
	}

	public Integer getComment(){
		return this.comment;
	}

	public void setTypeid(Integer typeid){
		this.typeid = typeid;
	}

	public Integer getTypeid(){
		return this.typeid;
	}

	public void setPlay(Integer play){
		this.play = play;
	}

	public Integer getPlay(){
		return this.play;
	}

	public void setPic(String pic){
		this.pic = pic;
	}

	public String getPic(){
		return this.pic;
	}

	public void setSubtitle(String subtitle){
		this.subtitle = subtitle;
	}

	public String getSubtitle(){
		return this.subtitle;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}

	public String getCopyright(){
		return this.copyright;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setReview(Integer review){
		this.review = review;
	}

	public Integer getReview(){
		return this.review;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return this.author;
	}

	public void setMid(Integer mid){
		this.mid = mid;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setCreated(java.util.Date created){
		this.created = created;
	}

	public java.util.Date getCreated(){
		return this.created;
	}

	public void setLength(Integer length){
		this.length = length;
	}

	public Integer getLength(){
		return this.length;
	}

	public void setVideoReview(Integer videoReview){
		this.videoReview = videoReview;
	}

	public Integer getVideoReview(){
		return this.videoReview;
	}

	public void setFavorites(Integer favorites){
		this.favorites = favorites;
	}

	public Integer getFavorites(){
		return this.favorites;
	}

	public void setHideClick(Integer hideClick){
		this.hideClick = hideClick;
	}

	public Integer getHideClick(){
		return this.hideClick;
	}

	public void setCrawlDate(java.util.Date crawlDate){
		this.crawlDate = crawlDate;
	}

	public java.util.Date getCrawlDate(){
		return this.crawlDate;
	}

	public void setLastUpdate(java.util.Date lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public java.util.Date getLastUpdate(){
		return this.lastUpdate;
	}

	public BiliVideo clone(){
		BiliVideo copied = new BiliVideo();
		copied.aid = this.aid;
		copied.comment = this.comment;
		copied.typeid = this.typeid;
		copied.play = this.play;
		copied.pic = this.pic;
		copied.subtitle = this.subtitle;
		copied.description = this.description;
		copied.copyright = this.copyright;
		copied.title = this.title;
		copied.review = this.review;
		copied.author = this.author;
		copied.mid = this.mid;
		copied.created = this.created;
		copied.length = this.length;
		copied.videoReview = this.videoReview;
		copied.favorites = this.favorites;
		copied.hideClick = this.hideClick;
		copied.crawlDate = this.crawlDate;
		copied.lastUpdate = this.lastUpdate;
		return copied;
	}
	public static BiliVideo fromJson(JSONObject data){
		BiliVideo copied = new BiliVideo();
		copied.aid = data.optInt("aid");
		copied.comment = data.optInt("comment");
		copied.typeid = data.optInt("typeid");
		copied.play = data.optInt("play");
		copied.pic = data.optString("pic");
		copied.subtitle = data.optString("subtitle");
		copied.description = data.optString("description");
		copied.copyright = data.optString("copyright");
		copied.title = data.optString("title");
		copied.review = data.optInt("review");
		copied.author = data.optString("author");
		copied.mid = data.optInt("mid");
		copied.created = DateUtil.parseDateTime(data.optString("created"));
		copied.length = data.optInt("length");
		copied.videoReview = data.optInt("video_review");
		copied.favorites = data.optInt("favorites");
		copied.hideClick = data.optBoolean("hide_click")?1:0;
		//copied.crawlDate = DateUtil.parseDateTime(data.optString("crawlDate"));
		//copied.lastUpdate = DateUtil.parseDateTime(data.optString("lastUpdate"));
		return copied;
	}
	public java.util.Map<String, Object> toMap(){
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("aid", this.aid);
		dataMap.put("comment", this.comment);
		dataMap.put("typeid", this.typeid);
		dataMap.put("play", this.play);
		dataMap.put("pic", this.pic);
		dataMap.put("subtitle", this.subtitle);
		dataMap.put("description", this.description);
		dataMap.put("copyright", this.copyright);
		dataMap.put("title", this.title);
		dataMap.put("review", this.review);
		dataMap.put("author", this.author);
		dataMap.put("mid", this.mid);
		dataMap.put("created", this.created);
		dataMap.put("length", this.length);
		dataMap.put("videoReview", this.videoReview);
		dataMap.put("favorites", this.favorites);
		dataMap.put("hideClick", this.hideClick);
		dataMap.put("crawlDate", this.crawlDate);
		dataMap.put("lastUpdate", this.lastUpdate);
		return dataMap;
	}
}
