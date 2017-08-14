package com.crawl.webchat.entity.param;



/**
 * 
 * 参数
 * 
 */
public class WxArticleParam extends BaseParam{


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

	private String snFuzzy;

	/**
	 * 
	 */
	private String author;

	private String authorFuzzy;

	/**
	 * 
	 */
	private String biz;

	private String bizFuzzy;

	/**
	 * 
	 */
	private Integer bizDecoded;

	/**
	 * 
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 
	 */
	private String description;

	private String descriptionFuzzy;

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

	private String publishTimeStart;

	private String publishTimeEnd;

	/**
	 * 
	 */
	private Integer level;


	public void setMid(Long mid){
		this.mid = mid;
	}

	public Long getMid(){
		return this.mid;
	}

	public void setIdx(Integer idx){
		this.idx = idx;
	}

	public Integer getIdx(){
		return this.idx;
	}

	public void setSn(String sn){
		this.sn = sn;
	}

	public String getSn(){
		return this.sn;
	}

	public void setSnFuzzy(String snFuzzy){
		this.snFuzzy = snFuzzy;
	}

	public String getSnFuzzy(){
		return this.snFuzzy;
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

	public void setBiz(String biz){
		this.biz = biz;
	}

	public String getBiz(){
		return this.biz;
	}

	public void setBizFuzzy(String bizFuzzy){
		this.bizFuzzy = bizFuzzy;
	}

	public String getBizFuzzy(){
		return this.bizFuzzy;
	}

	public void setBizDecoded(Integer bizDecoded){
		this.bizDecoded = bizDecoded;
	}

	public Integer getBizDecoded(){
		return this.bizDecoded;
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

	public void setViewNumber(Integer viewNumber){
		this.viewNumber = viewNumber;
	}

	public Integer getViewNumber(){
		return this.viewNumber;
	}

	public void setStarNumber(Integer starNumber){
		this.starNumber = starNumber;
	}

	public Integer getStarNumber(){
		return this.starNumber;
	}

	public void setPublishTime(java.util.Date publishTime){
		this.publishTime = publishTime;
	}

	public java.util.Date getPublishTime(){
		return this.publishTime;
	}

	public void setPublishTimeStart(String publishTimeStart){
		this.publishTimeStart = publishTimeStart;
	}

	public String getPublishTimeStart(){
		return this.publishTimeStart;
	}
	public void setPublishTimeEnd(String publishTimeEnd){
		this.publishTimeEnd = publishTimeEnd;
	}

	public String getPublishTimeEnd(){
		return this.publishTimeEnd;
	}

	public void setLevel(Integer level){
		this.level = level;
	}

	public Integer getLevel(){
		return this.level;
	}

	public java.util.Map<String, Object> toMap(){
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("mid", this.mid);
		dataMap.put("idx", this.idx);
		dataMap.put("sn", this.sn);
		dataMap.put("snFuzzy", this.snFuzzy);
		dataMap.put("author", this.author);
		dataMap.put("authorFuzzy", this.authorFuzzy);
		dataMap.put("biz", this.biz);
		dataMap.put("bizFuzzy", this.bizFuzzy);
		dataMap.put("bizDecoded", this.bizDecoded);
		dataMap.put("title", this.title);
		dataMap.put("titleFuzzy", this.titleFuzzy);
		dataMap.put("description", this.description);
		dataMap.put("descriptionFuzzy", this.descriptionFuzzy);
		dataMap.put("viewNumber", this.viewNumber);
		dataMap.put("starNumber", this.starNumber);
		dataMap.put("publishTime", this.publishTime);
		dataMap.put("publishTimeStart", this.publishTimeStart);
		dataMap.put("publishTimeEnd", this.publishTimeEnd);
		dataMap.put("level", this.level);
		return dataMap;
	}
}
