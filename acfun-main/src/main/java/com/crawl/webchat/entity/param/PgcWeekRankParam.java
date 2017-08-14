package com.crawl.webchat.entity.param;



/**
 * 
 * 参数
 * 
 */
public class PgcWeekRankParam extends BaseParam{


	/**
	 * 
	 */
	private Integer rank;

	/**
	 * 
	 */
	private Integer categoryId;

	/**
	 * 
	 */
	private String categoryName;

	private String categoryNameFuzzy;

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
	private Integer youku;

	/**
	 * 
	 */
	private Integer tecent;

	/**
	 * 
	 */
	private Integer iqiyi;

	/**
	 * 
	 */
	private Integer toutiao;

	/**
	 * 
	 */
	private Integer miaopai;

	/**
	 * 
	 */
	private Integer meipai;

	/**
	 * 
	 */
	private Double point;


	public void setRank(Integer rank){
		this.rank = rank;
	}

	public Integer getRank(){
		return this.rank;
	}

	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}

	public Integer getCategoryId(){
		return this.categoryId;
	}

	public void setCategoryName(String categoryName){
		this.categoryName = categoryName;
	}

	public String getCategoryName(){
		return this.categoryName;
	}

	public void setCategoryNameFuzzy(String categoryNameFuzzy){
		this.categoryNameFuzzy = categoryNameFuzzy;
	}

	public String getCategoryNameFuzzy(){
		return this.categoryNameFuzzy;
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

	public void setYouku(Integer youku){
		this.youku = youku;
	}

	public Integer getYouku(){
		return this.youku;
	}

	public void setTecent(Integer tecent){
		this.tecent = tecent;
	}

	public Integer getTecent(){
		return this.tecent;
	}

	public void setIqiyi(Integer iqiyi){
		this.iqiyi = iqiyi;
	}

	public Integer getIqiyi(){
		return this.iqiyi;
	}

	public void setToutiao(Integer toutiao){
		this.toutiao = toutiao;
	}

	public Integer getToutiao(){
		return this.toutiao;
	}

	public void setMiaopai(Integer miaopai){
		this.miaopai = miaopai;
	}

	public Integer getMiaopai(){
		return this.miaopai;
	}

	public void setMeipai(Integer meipai){
		this.meipai = meipai;
	}

	public Integer getMeipai(){
		return this.meipai;
	}

	public void setPoint(Double point){
		this.point = point;
	}

	public Double getPoint(){
		return this.point;
	}

	public java.util.Map<String, Object> toMap(){
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("rank", this.rank);
		dataMap.put("categoryId", this.categoryId);
		dataMap.put("categoryName", this.categoryName);
		dataMap.put("categoryNameFuzzy", this.categoryNameFuzzy);
		dataMap.put("dayBegin", this.dayBegin);
		dataMap.put("dayBeginStart", this.dayBeginStart);
		dataMap.put("dayBeginEnd", this.dayBeginEnd);
		dataMap.put("account", this.account);
		dataMap.put("accountFuzzy", this.accountFuzzy);
		dataMap.put("accountName", this.accountName);
		dataMap.put("accountNameFuzzy", this.accountNameFuzzy);
		dataMap.put("icon", this.icon);
		dataMap.put("iconFuzzy", this.iconFuzzy);
		dataMap.put("youku", this.youku);
		dataMap.put("tecent", this.tecent);
		dataMap.put("iqiyi", this.iqiyi);
		dataMap.put("toutiao", this.toutiao);
		dataMap.put("miaopai", this.miaopai);
		dataMap.put("meipai", this.meipai);
		dataMap.put("point", this.point);
		return dataMap;
	}
}
