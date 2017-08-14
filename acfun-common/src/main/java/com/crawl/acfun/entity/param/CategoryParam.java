package com.crawl.acfun.entity.param;



/**
 * 
 * 参数
 * 
 */
public class CategoryParam extends BaseParam{


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

}
