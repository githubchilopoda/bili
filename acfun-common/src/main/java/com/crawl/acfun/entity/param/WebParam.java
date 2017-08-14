package com.crawl.acfun.entity.param;



/**
 * 
 * 参数
 * 
 */
public class WebParam extends BaseParam{


	/**
	 * 
	 */
	private Integer webId;

	/**
	 * 
	 */
	private String name;

	private String nameFuzzy;

	/**
	 * 
	 */
	private String url;

	private String urlFuzzy;


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

	public void setNameFuzzy(String nameFuzzy){
		this.nameFuzzy = nameFuzzy;
	}

	public String getNameFuzzy(){
		return this.nameFuzzy;
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

}
