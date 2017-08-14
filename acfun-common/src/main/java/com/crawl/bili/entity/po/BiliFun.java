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
public class BiliFun implements Serializable {


	/**
	 * 
	 */
	private Integer aid;

	/**
	 * 
	 */
	private Integer videos;

	/**
	 * 
	 */
	private Integer tid;

	/**
	 * 
	 */
	private String tname;

	/**
	 * 
	 */
	private Integer copyright;

	/**
	 * 
	 */
	private String pic;

	/**
	 * 
	 */
	private String title;

	/**
	 * 
	 */
	private Integer attribute;

	/**
	 * 
	 */
	private String tags;

	/**
	 * 
	 */
	private Integer duration;

	/**
	 * 
	 */
	private String rights;

	/**
	 * 
	 */
	private String stat;

	/**
	 * 
	 */
	private Integer play;

	/**
	 * 
	 */
	private Integer favorites;

	/**
	 * 
	 */
	private Integer videoReview;

	/**
	 * 
	 */
	private java.util.Date createTime;

	/**
	 * 
	 */
	private String description;

	/**
	 * 
	 */
	private Integer mid;

	/**
	 * 
	 */
	private String author;

	/**
	 * 
	 */
	private String face;

	/**
	 * 
	 */
	private java.util.Date crawlTime;


	public void setAid(Integer aid){
		this.aid = aid;
	}

	public Integer getAid(){
		return this.aid;
	}

	public void setVideos(Integer videos){
		this.videos = videos;
	}

	public Integer getVideos(){
		return this.videos;
	}

	public void setTid(Integer tid){
		this.tid = tid;
	}

	public Integer getTid(){
		return this.tid;
	}

	public void setTname(String tname){
		this.tname = tname;
	}

	public String getTname(){
		return this.tname;
	}

	public void setCopyright(Integer copyright){
		this.copyright = copyright;
	}

	public Integer getCopyright(){
		return this.copyright;
	}

	public void setPic(String pic){
		this.pic = pic;
	}

	public String getPic(){
		return this.pic;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setAttribute(Integer attribute){
		this.attribute = attribute;
	}

	public Integer getAttribute(){
		return this.attribute;
	}

	public void setTags(String tags){
		this.tags = tags;
	}

	public String getTags(){
		return this.tags;
	}

	public void setDuration(Integer duration){
		this.duration = duration;
	}

	public Integer getDuration(){
		return this.duration;
	}

	public void setRights(String rights){
		this.rights = rights;
	}

	public String getRights(){
		return this.rights;
	}

	public void setStat(String stat){
		this.stat = stat;
	}

	public String getStat(){
		return this.stat;
	}

	public void setPlay(Integer play){
		this.play = play;
	}

	public Integer getPlay(){
		return this.play;
	}

	public void setFavorites(Integer favorites){
		this.favorites = favorites;
	}

	public Integer getFavorites(){
		return this.favorites;
	}

	public void setVideoReview(Integer videoReview){
		this.videoReview = videoReview;
	}

	public Integer getVideoReview(){
		return this.videoReview;
	}	

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setMid(Integer mid){
		this.mid = mid;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return this.author;
	}

	public void setFace(String face){
		this.face = face;
	}

	public String getFace(){
		return this.face;
	}

	public void setCrawlTime(java.util.Date crawlTime){
		this.crawlTime = crawlTime;
	}

	public java.util.Date getCrawlTime(){
		return this.crawlTime;
	}

	public BiliFun clone(){
		BiliFun copied = new BiliFun();
		copied.aid = this.aid;
		copied.videos = this.videos;
		copied.tid = this.tid;
		copied.tname = this.tname;
		copied.copyright = this.copyright;
		copied.pic = this.pic;
		copied.title = this.title;
		copied.attribute = this.attribute;
		copied.tags = this.tags;
		copied.duration = this.duration;
		copied.rights = this.rights;
		copied.stat = this.stat;
		copied.play = this.play;
		copied.favorites = this.favorites;
		copied.videoReview = this.videoReview;
		copied.createTime = this.createTime;
		copied.description = this.description;
		copied.mid = this.mid;
		copied.author = this.author;
		copied.face = this.face;
		copied.crawlTime = this.crawlTime;
		return copied;
	}
	public static BiliFun fromJson(JSONObject data){
		BiliFun copied = new BiliFun();
		copied.aid = data.optInt("aid");
		copied.videos = data.optInt("videos");
		copied.tid = data.optInt("tid");
		copied.tname = data.optString("tname");
		copied.copyright = data.optInt("copyright");
		copied.pic = data.optString("pic");
		copied.title = data.optString("title");
		copied.attribute = data.optInt("attribute");
		copied.tags = data.getJSONArray("tags").toString();
		copied.duration = data.optInt("duration");
		copied.rights = data.getJSONObject("rights").toString();
		copied.stat = data.optJSONObject("stat").toString();
		copied.play = data.optInt("play");
		copied.favorites = data.optInt("favorites");
		copied.videoReview = data.optInt("video_review");
		copied.createTime = DateUtil.parseDateTime(data.optString("create"));
		copied.description = data.optString("description");
		copied.mid = data.optInt("mid");
		copied.author = data.optString("author");
		copied.face = data.optString("face");
		copied.crawlTime = DateUtil.parseDateTime(data.optString("crawlTime"));
		return copied;
	}
	public java.util.Map<String, Object> toMap(){
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("aid", this.aid);
		dataMap.put("videos", this.videos);
		dataMap.put("tid", this.tid);
		dataMap.put("tname", this.tname);
		dataMap.put("copyright", this.copyright);
		dataMap.put("pic", this.pic);
		dataMap.put("title", this.title);
		dataMap.put("attribute", this.attribute);
		dataMap.put("tags", this.tags);
		dataMap.put("duration", this.duration);
		dataMap.put("rights", this.rights);
		dataMap.put("stat", this.stat);
		dataMap.put("play", this.play);
		dataMap.put("favorites", this.favorites);
		dataMap.put("videoReview", this.videoReview);
		dataMap.put("createTime", this.createTime);
		dataMap.put("description", this.description);
		dataMap.put("mid", this.mid);
		dataMap.put("author", this.author);
		dataMap.put("face", this.face);
		dataMap.put("crawlTime", this.crawlTime);
		return dataMap;
	}

	@Override
	public String toString() {
		return "BiliFun [aid=" + aid + ", videos=" + videos + ", tid=" + tid + ", tname=" + tname + ", copyright="
				+ copyright + ", pic=" + pic + ", title=" + title + ", attribute=" + attribute + ", tags=" + tags
				+ ", duration=" + duration + ", rights=" + rights + ", stat=" + stat + ", play=" + play + ", favorites="
				+ favorites + ", videoReview=" + videoReview + ", createTime=" + createTime + ", description=" + description
				+ ", mid=" + mid + ", author=" + author + ", face=" + face + ", crawlTime=" + crawlTime + "]";
	}
	
}
