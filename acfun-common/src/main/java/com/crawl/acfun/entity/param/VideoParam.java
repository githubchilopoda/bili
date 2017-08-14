package com.crawl.acfun.entity.param;



/**
 * 
 * 参数
 * 
 */
public class VideoParam extends BaseParam{


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

	private String urlFuzzy;

	/**
	 * 
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 
	 */
	private String source;

	private String sourceFuzzy;

	/**
	 * 
	 */
	private String img;

	private String imgFuzzy;

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

	private String remarkFuzzy;


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

	public void setUrlFuzzy(String urlFuzzy){
		this.urlFuzzy = urlFuzzy;
	}

	public String getUrlFuzzy(){
		return this.urlFuzzy;
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

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return this.source;
	}

	public void setSourceFuzzy(String sourceFuzzy){
		this.sourceFuzzy = sourceFuzzy;
	}

	public String getSourceFuzzy(){
		return this.sourceFuzzy;
	}

	public void setImg(String img){
		this.img = img;
	}

	public String getImg(){
		return this.img;
	}

	public void setImgFuzzy(String imgFuzzy){
		this.imgFuzzy = imgFuzzy;
	}

	public String getImgFuzzy(){
		return this.imgFuzzy;
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

	public void setRemarkFuzzy(String remarkFuzzy){
		this.remarkFuzzy = remarkFuzzy;
	}

	public String getRemarkFuzzy(){
		return this.remarkFuzzy;
	}

}
