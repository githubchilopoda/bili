package com.crawl.bili.entity.param;



/**
 * 
 * 参数
 * 
 */
public class BiliCategoryParam extends BaseParam{


	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private String name;

	private String nameFuzzy;

	/**
	 * 
	 */
	private String channel;

	private String channelFuzzy;

	/**
	 * 
	 */
	private Integer pid;

	/**
	 * 
	 */
	private String url;

	private String urlFuzzy;

	/**
	 * 
	 */
	private String enName;

	private String enNameFuzzy;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
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

	public void setChannel(String channel){
		this.channel = channel;
	}

	public String getChannel(){
		return this.channel;
	}

	public void setChannelFuzzy(String channelFuzzy){
		this.channelFuzzy = channelFuzzy;
	}

	public String getChannelFuzzy(){
		return this.channelFuzzy;
	}

	public void setPid(Integer pid){
		this.pid = pid;
	}

	public Integer getPid(){
		return this.pid;
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

	public void setEnName(String enName){
		this.enName = enName;
	}

	public String getEnName(){
		return this.enName;
	}

	public void setEnNameFuzzy(String enNameFuzzy){
		this.enNameFuzzy = enNameFuzzy;
	}

	public String getEnNameFuzzy(){
		return this.enNameFuzzy;
	}

	public java.util.Map<String, Object> toMap(){
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("id", this.id);
		dataMap.put("name", this.name);
		dataMap.put("nameFuzzy", this.nameFuzzy);
		dataMap.put("channel", this.channel);
		dataMap.put("channelFuzzy", this.channelFuzzy);
		dataMap.put("pid", this.pid);
		dataMap.put("url", this.url);
		dataMap.put("urlFuzzy", this.urlFuzzy);
		dataMap.put("enName", this.enName);
		dataMap.put("enNameFuzzy", this.enNameFuzzy);
		return dataMap;
	}
}
