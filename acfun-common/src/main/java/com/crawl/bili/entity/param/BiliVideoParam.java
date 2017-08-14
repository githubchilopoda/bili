package com.crawl.bili.entity.param;



/**
 * 
 * 参数
 * 
 */
public class BiliVideoParam extends BaseParam{


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

	private String picFuzzy;

	/**
	 * 
	 */
	private String subtitle;

	private String subtitleFuzzy;

	/**
	 * 
	 */
	private String description;

	private String descriptionFuzzy;

	/**
	 * 
	 */
	private String copyright;

	private String copyrightFuzzy;

	/**
	 * 
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 
	 */
	private Integer review;

	/**
	 * 
	 */
	private String author;

	private String authorFuzzy;

	/**
	 * 
	 */
	private Integer mid;

	/**
	 * 
	 */
	private java.util.Date created;

	private String createdStart;

	private String createdEnd;

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

	private String crawlDateStart;

	private String crawlDateEnd;

	/**
	 * 
	 */
	private java.util.Date lastUpdate;

	private String lastUpdateStart;

	private String lastUpdateEnd;


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

	public void setPicFuzzy(String picFuzzy){
		this.picFuzzy = picFuzzy;
	}

	public String getPicFuzzy(){
		return this.picFuzzy;
	}

	public void setSubtitle(String subtitle){
		this.subtitle = subtitle;
	}

	public String getSubtitle(){
		return this.subtitle;
	}

	public void setSubtitleFuzzy(String subtitleFuzzy){
		this.subtitleFuzzy = subtitleFuzzy;
	}

	public String getSubtitleFuzzy(){
		return this.subtitleFuzzy;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDescriptionFuzzy(String descriptionFuzzy){
		this.descriptionFuzzy = descriptionFuzzy;
	}

	public String getDescriptionFuzzy(){
		return this.descriptionFuzzy;
	}

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}

	public String getCopyright(){
		return this.copyright;
	}

	public void setCopyrightFuzzy(String copyrightFuzzy){
		this.copyrightFuzzy = copyrightFuzzy;
	}

	public String getCopyrightFuzzy(){
		return this.copyrightFuzzy;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitleFuzzy(String titleFuzzy){
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy(){
		return this.titleFuzzy;
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

	public void setAuthorFuzzy(String authorFuzzy){
		this.authorFuzzy = authorFuzzy;
	}

	public String getAuthorFuzzy(){
		return this.authorFuzzy;
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

	public void setCreatedStart(String createdStart){
		this.createdStart = createdStart;
	}

	public String getCreatedStart(){
		return this.createdStart;
	}
	public void setCreatedEnd(String createdEnd){
		this.createdEnd = createdEnd;
	}

	public String getCreatedEnd(){
		return this.createdEnd;
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

	public void setCrawlDateStart(String crawlDateStart){
		this.crawlDateStart = crawlDateStart;
	}

	public String getCrawlDateStart(){
		return this.crawlDateStart;
	}
	public void setCrawlDateEnd(String crawlDateEnd){
		this.crawlDateEnd = crawlDateEnd;
	}

	public String getCrawlDateEnd(){
		return this.crawlDateEnd;
	}

	public void setLastUpdate(java.util.Date lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public java.util.Date getLastUpdate(){
		return this.lastUpdate;
	}

	public void setLastUpdateStart(String lastUpdateStart){
		this.lastUpdateStart = lastUpdateStart;
	}

	public String getLastUpdateStart(){
		return this.lastUpdateStart;
	}
	public void setLastUpdateEnd(String lastUpdateEnd){
		this.lastUpdateEnd = lastUpdateEnd;
	}

	public String getLastUpdateEnd(){
		return this.lastUpdateEnd;
	}

	public java.util.Map<String, Object> toMap(){
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("aid", this.aid);
		dataMap.put("comment", this.comment);
		dataMap.put("typeid", this.typeid);
		dataMap.put("play", this.play);
		dataMap.put("pic", this.pic);
		dataMap.put("picFuzzy", this.picFuzzy);
		dataMap.put("subtitle", this.subtitle);
		dataMap.put("subtitleFuzzy", this.subtitleFuzzy);
		dataMap.put("description", this.description);
		dataMap.put("descriptionFuzzy", this.descriptionFuzzy);
		dataMap.put("copyright", this.copyright);
		dataMap.put("copyrightFuzzy", this.copyrightFuzzy);
		dataMap.put("title", this.title);
		dataMap.put("titleFuzzy", this.titleFuzzy);
		dataMap.put("review", this.review);
		dataMap.put("author", this.author);
		dataMap.put("authorFuzzy", this.authorFuzzy);
		dataMap.put("mid", this.mid);
		dataMap.put("created", this.created);
		dataMap.put("createdStart", this.createdStart);
		dataMap.put("createdEnd", this.createdEnd);
		dataMap.put("length", this.length);
		dataMap.put("videoReview", this.videoReview);
		dataMap.put("favorites", this.favorites);
		dataMap.put("hideClick", this.hideClick);
		dataMap.put("crawlDate", this.crawlDate);
		dataMap.put("crawlDateStart", this.crawlDateStart);
		dataMap.put("crawlDateEnd", this.crawlDateEnd);
		dataMap.put("lastUpdate", this.lastUpdate);
		dataMap.put("lastUpdateStart", this.lastUpdateStart);
		dataMap.put("lastUpdateEnd", this.lastUpdateEnd);
		return dataMap;
	}
}
