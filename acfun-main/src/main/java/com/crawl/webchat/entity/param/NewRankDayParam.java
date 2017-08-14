package com.crawl.webchat.entity.param;



/**
 * 
 * 参数
 * 
 */
public class NewRankDayParam extends BaseParam{


	/**
	 * 
	 */
	private Integer rank;

	/**
	 * 
	 */
	private String categoryName;

	private String categoryNameFuzzy;

	/**
	 * 
	 */
	private java.util.Date day;

	private String dayStart;

	private String dayEnd;

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
	private Integer fabu1;

	/**
	 * 
	 */
	private Integer fabu2;

	/**
	 * 
	 */
	private Integer zongyuedu;

	/**
	 * 
	 */
	private Integer toutiao;

	/**
	 * 
	 */
	private Integer pingjun;

	/**
	 * 
	 */
	private Integer zuigao;

	/**
	 * 
	 */
	private Integer dianzhan;

	/**
	 * 
	 */
	private Double zishu;


	public void setRank(Integer rank){
		this.rank = rank;
	}

	public Integer getRank(){
		return this.rank;
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

	public void setDay(java.util.Date day){
		this.day = day;
	}

	public java.util.Date getDay(){
		return this.day;
	}

	public void setDayStart(String dayStart){
		this.dayStart = dayStart;
	}

	public String getDayStart(){
		return this.dayStart;
	}
	public void setDayEnd(String dayEnd){
		this.dayEnd = dayEnd;
	}

	public String getDayEnd(){
		return this.dayEnd;
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

	public void setFabu1(Integer fabu1){
		this.fabu1 = fabu1;
	}

	public Integer getFabu1(){
		return this.fabu1;
	}

	public void setFabu2(Integer fabu2){
		this.fabu2 = fabu2;
	}

	public Integer getFabu2(){
		return this.fabu2;
	}

	public void setZongyuedu(Integer zongyuedu){
		this.zongyuedu = zongyuedu;
	}

	public Integer getZongyuedu(){
		return this.zongyuedu;
	}

	public void setToutiao(Integer toutiao){
		this.toutiao = toutiao;
	}

	public Integer getToutiao(){
		return this.toutiao;
	}

	public void setPingjun(Integer pingjun){
		this.pingjun = pingjun;
	}

	public Integer getPingjun(){
		return this.pingjun;
	}

	public void setZuigao(Integer zuigao){
		this.zuigao = zuigao;
	}

	public Integer getZuigao(){
		return this.zuigao;
	}

	public void setDianzhan(Integer dianzhan){
		this.dianzhan = dianzhan;
	}

	public Integer getDianzhan(){
		return this.dianzhan;
	}

	public void setZishu(Double zishu){
		this.zishu = zishu;
	}

	public Double getZishu(){
		return this.zishu;
	}

	public java.util.Map<String, Object> toMap(){
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("rank", this.rank);
		dataMap.put("categoryName", this.categoryName);
		dataMap.put("categoryNameFuzzy", this.categoryNameFuzzy);
		dataMap.put("day", this.day);
		dataMap.put("dayStart", this.dayStart);
		dataMap.put("dayEnd", this.dayEnd);
		dataMap.put("account", this.account);
		dataMap.put("accountFuzzy", this.accountFuzzy);
		dataMap.put("accountName", this.accountName);
		dataMap.put("accountNameFuzzy", this.accountNameFuzzy);
		dataMap.put("fabu1", this.fabu1);
		dataMap.put("fabu2", this.fabu2);
		dataMap.put("zongyuedu", this.zongyuedu);
		dataMap.put("toutiao", this.toutiao);
		dataMap.put("pingjun", this.pingjun);
		dataMap.put("zuigao", this.zuigao);
		dataMap.put("dianzhan", this.dianzhan);
		dataMap.put("zishu", this.zishu);
		return dataMap;
	}
}
