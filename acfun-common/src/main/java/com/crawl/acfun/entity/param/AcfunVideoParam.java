package com.crawl.acfun.entity.param;



/**
 * 
 * 参数
 * 
 */
public class AcfunVideoParam extends BaseParam{


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

	private String coverHorizontalFuzzy;

	/**
	 * 
	 */
	private String coverVertical;

	private String coverVerticalFuzzy;

	/**
	 * 
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 
	 */
	private String lastVideoName;

	private String lastVideoNameFuzzy;

	/**
	 * 
	 */
	private String cover;

	private String coverFuzzy;

	/**
	 * 
	 */
	private String intro;

	private String introFuzzy;

	/**
	 * 
	 */
	private Integer visibleLevel;

	/**
	 * 
	 */
	private java.util.Date lastUpdateTime;

	private String lastUpdateTimeStart;

	private String lastUpdateTimeEnd;


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

	public Double getHeat() {
		return heat;
	}

	public void setHeat(Double heat) {
		this.heat = heat;
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

	public void setCoverHorizontalFuzzy(String coverHorizontalFuzzy){
		this.coverHorizontalFuzzy = coverHorizontalFuzzy;
	}

	public String getCoverHorizontalFuzzy(){
		return this.coverHorizontalFuzzy;
	}

	public void setCoverVertical(String coverVertical){
		this.coverVertical = coverVertical;
	}

	public String getCoverVertical(){
		return this.coverVertical;
	}

	public void setCoverVerticalFuzzy(String coverVerticalFuzzy){
		this.coverVerticalFuzzy = coverVerticalFuzzy;
	}

	public String getCoverVerticalFuzzy(){
		return this.coverVerticalFuzzy;
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

	public void setLastVideoName(String lastVideoName){
		this.lastVideoName = lastVideoName;
	}

	public String getLastVideoName(){
		return this.lastVideoName;
	}

	public void setLastVideoNameFuzzy(String lastVideoNameFuzzy){
		this.lastVideoNameFuzzy = lastVideoNameFuzzy;
	}

	public String getLastVideoNameFuzzy(){
		return this.lastVideoNameFuzzy;
	}

	public void setCover(String cover){
		this.cover = cover;
	}

	public String getCover(){
		return this.cover;
	}

	public void setCoverFuzzy(String coverFuzzy){
		this.coverFuzzy = coverFuzzy;
	}

	public String getCoverFuzzy(){
		return this.coverFuzzy;
	}

	public void setIntro(String intro){
		this.intro = intro;
	}

	public String getIntro(){
		return this.intro;
	}

	public void setIntroFuzzy(String introFuzzy){
		this.introFuzzy = introFuzzy;
	}

	public String getIntroFuzzy(){
		return this.introFuzzy;
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

	public void setLastUpdateTimeStart(String lastUpdateTimeStart){
		this.lastUpdateTimeStart = lastUpdateTimeStart;
	}

	public String getLastUpdateTimeStart(){
		return this.lastUpdateTimeStart;
	}
	public void setLastUpdateTimeEnd(String lastUpdateTimeEnd){
		this.lastUpdateTimeEnd = lastUpdateTimeEnd;
	}

	public String getLastUpdateTimeEnd(){
		return this.lastUpdateTimeEnd;
	}

}
