package com.crawl.acfun.entity.po;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;


/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class AcfunVideo implements Serializable {


	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private Integer webId;

	/**
	 * 
	 */
	private Integer type;

	/**
	 * 
	 */
	private Integer status;

	/**
	 * 
	 */
	private Integer views;

	/**
	 * 
	 */
	private Integer stows;

	/**
	 * 
	 */
	private Double heat;

	/**
	 * 
	 */
	private Integer week;

	/**
	 * 
	 */
	private String coverHorizontal;

	/**
	 * 
	 */
	private String coverVertical;

	/**
	 * 
	 */
	private String title;

	/**
	 * 
	 */
	private String lastVideoName;

	/**
	 * 
	 */
	private String cover;

	/**
	 * 
	 */
	private String intro;

	/**
	 * 
	 */
	private Integer visibleLevel;

	/**
	 * 
	 */
	private java.util.Date lastUpdateTime;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setWebId(Integer webId){
		this.webId = webId;
	}

	public Integer getWebId(){
		return this.webId;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public Integer getType(){
		return this.type;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setViews(Integer views){
		this.views = views;
	}

	public Integer getViews(){
		return this.views;
	}

	public void setStows(Integer stows){
		this.stows = stows;
	}

	public Integer getStows(){
		return this.stows;
	}

	public void setHeat(Double heat){
		this.heat = heat;
	}

	public Double getHeat(){
		return this.heat;
	}

	public void setWeek(Integer week){
		this.week = week;
	}

	public Integer getWeek(){
		return this.week;
	}

	public void setCoverHorizontal(String coverHorizontal){
		this.coverHorizontal = coverHorizontal;
	}

	public String getCoverHorizontal(){
		return this.coverHorizontal;
	}

	public void setCoverVertical(String coverVertical){
		this.coverVertical = coverVertical;
	}

	public String getCoverVertical(){
		return this.coverVertical;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setLastVideoName(String lastVideoName){
		this.lastVideoName = lastVideoName;
	}

	public String getLastVideoName(){
		return this.lastVideoName;
	}

	public void setCover(String cover){
		this.cover = cover;
	}

	public String getCover(){
		return this.cover;
	}

	public void setIntro(String intro){
		this.intro = intro;
	}

	public String getIntro(){
		return this.intro;
	}

	public void setVisibleLevel(Integer visibleLevel){
		this.visibleLevel = visibleLevel;
	}

	public Integer getVisibleLevel(){
		return this.visibleLevel;
	}

	public void setLastUpdateTime(java.util.Date lastUpdateTime){
		this.lastUpdateTime = lastUpdateTime;
	}

	public java.util.Date getLastUpdateTime(){
		return this.lastUpdateTime;
	}

	public AcfunVideo clone(){
		AcfunVideo copied = new AcfunVideo();
		copied.id = this.id;
		copied.webId = this.webId;
		copied.type = this.type;
		copied.status = this.status;
		copied.views = this.views;
		copied.stows = this.stows;
		copied.heat = this.heat;
		copied.week = this.week;
		copied.coverHorizontal = this.coverHorizontal;
		copied.coverVertical = this.coverVertical;
		copied.title = this.title;
		copied.lastVideoName = this.lastVideoName;
		copied.cover = this.cover;
		copied.intro = this.intro;
		copied.visibleLevel = this.visibleLevel;
		copied.lastUpdateTime = this.lastUpdateTime;
		return copied;
	}
	public static AcfunVideo fromJson(JSONObject data){
		AcfunVideo copied = new AcfunVideo();
		copied.id = data.optInt("id");
		copied.webId = data.optInt("webId");
		copied.type = data.optInt("type");
		copied.status = data.optInt("status");
		copied.views = data.optInt("views");
		copied.stows = data.optInt("stows");
		copied.heat = data.optDouble("heat");

		copied.week = data.optInt("week");
		copied.coverHorizontal = data.optString("coverHorizontal");
		copied.coverVertical = data.optString("coverVertical");
		copied.title = data.optString("title");
		copied.lastVideoName = data.optString("lastVideoName");
		copied.cover = data.optString("cover");
		copied.intro = data.optString("intro");
		copied.visibleLevel = data.optInt("visibleLevel");
		copied.lastUpdateTime = new Date(data.optLong("lastUpdateTime"));
		return copied;
	}

	@Override
	public String toString() {
		return "AcfunVideo [id=" + id + ", webId=" + webId + ", type=" + type + ", status=" + status + ", views="
				+ views + ", stows=" + stows + ", heat=" + heat + ", week=" + week + ", coverHorizontal="
				+ coverHorizontal + ", coverVertical=" + coverVertical + ", title=" + title + ", lastVideoName="
				+ lastVideoName + ", cover=" + cover + ", intro=" + intro + ", visibleLevel=" + visibleLevel
				+ ", lastUpdateTime=" + lastUpdateTime + "]";
	}	
}
