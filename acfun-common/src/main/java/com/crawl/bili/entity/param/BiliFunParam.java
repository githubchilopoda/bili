package com.crawl.bili.entity.param;



/**
 * 
 * 参数
 * 
 */
public class BiliFunParam extends BaseParam{


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

	private String tnameFuzzy;

	/**
	 * 
	 */
	private Integer copyright;

	/**
	 * 
	 */
	private String pic;

	private String picFuzzy;

	/**
	 * 
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 
	 */
	private Integer attribute;

	/**
	 * 
	 */
	private String tags;

	private String tagsFuzzy;

	/**
	 * 
	 */
	private Integer duration;

	/**
	 * 
	 */
	private String rights;

	private String rightsFuzzy;

	/**
	 * 
	 */
	private String stat;

	private String statFuzzy;

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

	private String createStart;

	private String createEnd;

	/**
	 * 
	 */
	private String description;

	private String descriptionFuzzy;

	/**
	 * 
	 */
	private Integer mid;

	/**
	 * 
	 */
	private String author;

	private String authorFuzzy;

	/**
	 * 
	 */
	private String face;

	private String faceFuzzy;

	/**
	 * 
	 */
	private java.util.Date crawlTime;

	private String crawlTimeStart;

	private String crawlTimeEnd;


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

	public void setTnameFuzzy(String tnameFuzzy){
		this.tnameFuzzy = tnameFuzzy;
	}

	public String getTnameFuzzy(){
		return this.tnameFuzzy;
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

	public void setPicFuzzy(String picFuzzy){
		this.picFuzzy = picFuzzy;
	}

	public String getPicFuzzy(){
		return this.picFuzzy;
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

	public void setTagsFuzzy(String tagsFuzzy){
		this.tagsFuzzy = tagsFuzzy;
	}

	public String getTagsFuzzy(){
		return this.tagsFuzzy;
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

	public void setRightsFuzzy(String rightsFuzzy){
		this.rightsFuzzy = rightsFuzzy;
	}

	public String getRightsFuzzy(){
		return this.rightsFuzzy;
	}

	public void setStat(String stat){
		this.stat = stat;
	}

	public String getStat(){
		return this.stat;
	}

	public void setStatFuzzy(String statFuzzy){
		this.statFuzzy = statFuzzy;
	}

	public String getStatFuzzy(){
		return this.statFuzzy;
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

	public void setCreateStart(String createStart){
		this.createStart = createStart;
	}

	public String getCreateStart(){
		return this.createStart;
	}
	public void setCreateEnd(String createEnd){
		this.createEnd = createEnd;
	}

	public String getCreateEnd(){
		return this.createEnd;
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

	public void setAuthorFuzzy(String authorFuzzy){
		this.authorFuzzy = authorFuzzy;
	}

	public String getAuthorFuzzy(){
		return this.authorFuzzy;
	}

	public void setFace(String face){
		this.face = face;
	}

	public String getFace(){
		return this.face;
	}

	public void setFaceFuzzy(String faceFuzzy){
		this.faceFuzzy = faceFuzzy;
	}

	public String getFaceFuzzy(){
		return this.faceFuzzy;
	}

	public void setCrawlTime(java.util.Date crawlTime){
		this.crawlTime = crawlTime;
	}

	public java.util.Date getCrawlTime(){
		return this.crawlTime;
	}

	public void setCrawlTimeStart(String crawlTimeStart){
		this.crawlTimeStart = crawlTimeStart;
	}

	public String getCrawlTimeStart(){
		return this.crawlTimeStart;
	}
	public void setCrawlTimeEnd(String crawlTimeEnd){
		this.crawlTimeEnd = crawlTimeEnd;
	}

	public String getCrawlTimeEnd(){
		return this.crawlTimeEnd;
	}

	public java.util.Map<String, Object> toMap(){
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("aid", this.aid);
		dataMap.put("videos", this.videos);
		dataMap.put("tid", this.tid);
		dataMap.put("tname", this.tname);
		dataMap.put("tnameFuzzy", this.tnameFuzzy);
		dataMap.put("copyright", this.copyright);
		dataMap.put("pic", this.pic);
		dataMap.put("picFuzzy", this.picFuzzy);
		dataMap.put("title", this.title);
		dataMap.put("titleFuzzy", this.titleFuzzy);
		dataMap.put("attribute", this.attribute);
		dataMap.put("tags", this.tags);
		dataMap.put("tagsFuzzy", this.tagsFuzzy);
		dataMap.put("duration", this.duration);
		dataMap.put("rights", this.rights);
		dataMap.put("rightsFuzzy", this.rightsFuzzy);
		dataMap.put("stat", this.stat);
		dataMap.put("statFuzzy", this.statFuzzy);
		dataMap.put("play", this.play);
		dataMap.put("favorites", this.favorites);
		dataMap.put("videoReview", this.videoReview);
		dataMap.put("createTime", this.createTime);
		dataMap.put("createStart", this.createStart);
		dataMap.put("createEnd", this.createEnd);
		dataMap.put("description", this.description);
		dataMap.put("descriptionFuzzy", this.descriptionFuzzy);
		dataMap.put("mid", this.mid);
		dataMap.put("author", this.author);
		dataMap.put("authorFuzzy", this.authorFuzzy);
		dataMap.put("face", this.face);
		dataMap.put("faceFuzzy", this.faceFuzzy);
		dataMap.put("crawlTime", this.crawlTime);
		dataMap.put("crawlTimeStart", this.crawlTimeStart);
		dataMap.put("crawlTimeEnd", this.crawlTimeEnd);
		return dataMap;
	}
}
