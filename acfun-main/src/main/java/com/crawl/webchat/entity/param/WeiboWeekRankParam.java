package com.crawl.webchat.entity.param;



/**
 * 
 * 参数
 * 
 */
public class WeiboWeekRankParam extends BaseParam{


	/**
	 * 
	 */
	private Integer rank;

	/**
	 * 1 personal, 2 authority, 3 未认证
	 */
	private Integer type;

	/**
	 * 
	 */
	private java.util.Date dayBegin;

	private String dayBeginStart;

	private String dayBeginEnd;

	/**
	 * 
	 */
	private String account;

	private String accountFuzzy;

	/**
	 * 
	 */
	private String accountName;

	private String accountNameFuzzy;

	/**
	 * 
	 */
	private String icon;

	private String iconFuzzy;

	/**
	 * 
	 */
	private Integer fansNumber;

	/**
	 * 
	 */
	private Integer publishNumber;

	/**
	 * 
	 */
	private Integer starNumber;

	/**
	 * 
	 */
	private Integer commentNumber;

	/**
	 * 
	 */
	private Integer forwardNumber;


	public void setRank(Integer rank){
		this.rank = rank;
	}

	public Integer getRank(){
		return this.rank;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public Integer getType(){
		return this.type;
	}

	public void setDayBegin(java.util.Date dayBegin){
		this.dayBegin = dayBegin;
	}

	public java.util.Date getDayBegin(){
		return this.dayBegin;
	}

	public void setDayBeginStart(String dayBeginStart){
		this.dayBeginStart = dayBeginStart;
	}

	public String getDayBeginStart(){
		return this.dayBeginStart;
	}
	public void setDayBeginEnd(String dayBeginEnd){
		this.dayBeginEnd = dayBeginEnd;
	}

	public String getDayBeginEnd(){
		return this.dayBeginEnd;
	}

	public void setAccount(String account){
		this.account = account;
	}

	public String getAccount(){
		return this.account;
	}

	public void setAccountFuzzy(String accountFuzzy){
		this.accountFuzzy = accountFuzzy;
	}

	public String getAccountFuzzy(){
		return this.accountFuzzy;
	}

	public void setAccountName(String accountName){
		this.accountName = accountName;
	}

	public String getAccountName(){
		return this.accountName;
	}

	public void setAccountNameFuzzy(String accountNameFuzzy){
		this.accountNameFuzzy = accountNameFuzzy;
	}

	public String getAccountNameFuzzy(){
		return this.accountNameFuzzy;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return this.icon;
	}

	public void setIconFuzzy(String iconFuzzy){
		this.iconFuzzy = iconFuzzy;
	}

	public String getIconFuzzy(){
		return this.iconFuzzy;
	}

	public void setFansNumber(Integer fansNumber){
		this.fansNumber = fansNumber;
	}

	public Integer getFansNumber(){
		return this.fansNumber;
	}

	public void setPublishNumber(Integer publishNumber){
		this.publishNumber = publishNumber;
	}

	public Integer getPublishNumber(){
		return this.publishNumber;
	}

	public void setStarNumber(Integer starNumber){
		this.starNumber = starNumber;
	}

	public Integer getStarNumber(){
		return this.starNumber;
	}

	public void setCommentNumber(Integer commentNumber){
		this.commentNumber = commentNumber;
	}

	public Integer getCommentNumber(){
		return this.commentNumber;
	}

	public void setForwardNumber(Integer forwardNumber){
		this.forwardNumber = forwardNumber;
	}

	public Integer getForwardNumber(){
		return this.forwardNumber;
	}

	public java.util.Map<String, Object> toMap(){
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("rank", this.rank);
		dataMap.put("type", this.type);
		dataMap.put("dayBegin", this.dayBegin);
		dataMap.put("dayBeginStart", this.dayBeginStart);
		dataMap.put("dayBeginEnd", this.dayBeginEnd);
		dataMap.put("account", this.account);
		dataMap.put("accountFuzzy", this.accountFuzzy);
		dataMap.put("accountName", this.accountName);
		dataMap.put("accountNameFuzzy", this.accountNameFuzzy);
		dataMap.put("icon", this.icon);
		dataMap.put("iconFuzzy", this.iconFuzzy);
		dataMap.put("fansNumber", this.fansNumber);
		dataMap.put("publishNumber", this.publishNumber);
		dataMap.put("starNumber", this.starNumber);
		dataMap.put("commentNumber", this.commentNumber);
		dataMap.put("forwardNumber", this.forwardNumber);
		return dataMap;
	}
}
