package com.crawl.bili.entity.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.json.JSONObject;

import com.crawl.util.DateUtil;


/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class BiliUser implements Serializable {


	/**
	 * 
	 */
	private Integer mid;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private Integer approve;

	/**
	 * 
	 */
	private Integer sex;

	/**
	 * 
	 */
	private Integer rank;

	/**
	 * 
	 */
	private String face;

	/**
	 * 
	 */
	private Integer coins;

	/**
	 * 
	 */
	private Integer displayRank;

	/**
	 * 
	 */
	private java.util.Date regtime;

	/**
	 * 
	 */
	private Integer spacesta;

	/**
	 * 
	 */
	private String place;

	/**
	 * 
	 */
	private java.util.Date birthday;

	/**
	 * 
	 */
	private String sign;

	/**
	 * 
	 */
	private String description;

	/**
	 * 
	 */
	private Integer article;

	/**
	 * 
	 */
	private String levelInfo;

	/**
	 * 
	 */
	private String pendant;

	/**
	 * 
	 */
	private String nameplate;

	/**
	 * 
	 */
	private String officialVerify;

	/**
	 * 
	 */
	private String toutu;

	/**
	 * 
	 */
	private Integer toutuId;

	/**
	 * 
	 */
	private String theme;

	/**
	 * 
	 */
	private String themePreview;

	/**
	 * 
	 */
	private String im9Sign;

	/**
	 * 
	 */
	private Integer playNum;

	/**
	 * 
	 */
	private Integer fansBadge;

	/**
	 * 
	 */
	private java.util.Date crawlTime;

	/**
	 * 
	 */
	private java.util.Date lastUpdateTime;


	public void setMid(Integer mid){
		this.mid = mid;
	}

	public Integer getMid(){
		return this.mid;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setApprove(Integer approve){
		this.approve = approve;
	}

	public Integer getApprove(){
		return this.approve;
	}

	public void setSex(Integer sex){
		this.sex = sex;
	}

	public Integer getSex(){
		return this.sex;
	}

	public void setRank(Integer rank){
		this.rank = rank;
	}

	public Integer getRank(){
		return this.rank;
	}

	public void setFace(String face){
		this.face = face;
	}

	public String getFace(){
		return this.face;
	}

	public void setCoins(Integer coins){
		this.coins = coins;
	}

	public Integer getCoins(){
		return this.coins;
	}

	public void setDisplayRank(Integer displayRank){
		this.displayRank = displayRank;
	}

	public Integer getDisplayRank(){
		return this.displayRank;
	}

	public void setRegtime(java.util.Date regtime){
		this.regtime = regtime;
	}

	public java.util.Date getRegtime(){
		return this.regtime;
	}

	public void setSpacesta(Integer spacesta){
		this.spacesta = spacesta;
	}

	public Integer getSpacesta(){
		return this.spacesta;
	}

	public void setPlace(String place){
		this.place = place;
	}

	public String getPlace(){
		return this.place;
	}

	public void setBirthday(java.util.Date birthday){
		this.birthday = birthday;
	}

	public java.util.Date getBirthday(){
		return this.birthday;
	}

	public void setSign(String sign){
		this.sign = sign;
	}

	public String getSign(){
		return this.sign;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setArticle(Integer article){
		this.article = article;
	}

	public Integer getArticle(){
		return this.article;
	}

	public void setLevelInfo(String levelInfo){
		this.levelInfo = levelInfo;
	}

	public String getLevelInfo(){
		return this.levelInfo;
	}

	public void setPendant(String pendant){
		this.pendant = pendant;
	}

	public String getPendant(){
		return this.pendant;
	}

	public void setNameplate(String nameplate){
		this.nameplate = nameplate;
	}

	public String getNameplate(){
		return this.nameplate;
	}

	public void setOfficialVerify(String officialVerify){
		this.officialVerify = officialVerify;
	}

	public String getOfficialVerify(){
		return this.officialVerify;
	}

	public void setToutu(String toutu){
		this.toutu = toutu;
	}

	public String getToutu(){
		return this.toutu;
	}

	public void setToutuId(Integer toutuId){
		this.toutuId = toutuId;
	}

	public Integer getToutuId(){
		return this.toutuId;
	}

	public void setTheme(String theme){
		this.theme = theme;
	}

	public String getTheme(){
		return this.theme;
	}

	public void setThemePreview(String themePreview){
		this.themePreview = themePreview;
	}

	public String getThemePreview(){
		return this.themePreview;
	}

	public void setIm9Sign(String im9Sign){
		this.im9Sign = im9Sign;
	}

	public String getIm9Sign(){
		return this.im9Sign;
	}

	public void setPlayNum(Integer playNum){
		this.playNum = playNum;
	}

	public Integer getPlayNum(){
		return this.playNum;
	}

	public void setFansBadge(Integer fansBadge){
		this.fansBadge = fansBadge;
	}

	public Integer getFansBadge(){
		return this.fansBadge;
	}

	public void setCrawlTime(java.util.Date crawlTime){
		this.crawlTime = crawlTime;
	}

	public java.util.Date getCrawlTime(){
		return this.crawlTime;
	}

	public void setLastUpdateTime(java.util.Date lastUpdateTime){
		this.lastUpdateTime = lastUpdateTime;
	}

	public java.util.Date getLastUpdateTime(){
		return this.lastUpdateTime;
	}

	public BiliUser clone(){
		BiliUser copied = new BiliUser();
		copied.mid = this.mid;
		copied.name = this.name;
		copied.approve = this.approve;
		copied.sex = this.sex;
		copied.rank = this.rank;
		copied.face = this.face;
		copied.coins = this.coins;
		copied.displayRank = this.displayRank;
		copied.regtime = this.regtime;
		copied.spacesta = this.spacesta;
		copied.place = this.place;
		copied.birthday = this.birthday;
		copied.sign = this.sign;
		copied.description = this.description;
		copied.article = this.article;
		copied.levelInfo = this.levelInfo;
		copied.pendant = this.pendant;
		copied.nameplate = this.nameplate;
		copied.officialVerify = this.officialVerify;
		copied.toutu = this.toutu;
		copied.toutuId = this.toutuId;
		copied.theme = this.theme;
		copied.themePreview = this.themePreview;
		copied.im9Sign = this.im9Sign;
		copied.playNum = this.playNum;
		copied.fansBadge = this.fansBadge;
		copied.crawlTime = this.crawlTime;
		copied.lastUpdateTime = this.lastUpdateTime;
		return copied;
	}
	public static BiliUser fromJson(JSONObject data){
		BiliUser copied = new BiliUser();
		copied.mid = data.optInt("mid");
		copied.name = data.optString("name");
		copied.approve = data.optBoolean("approve")?1:0;
		if (data.optString("sex").equals("男")){
			copied.sex = 1;
		}else if (data.optString("sex").equals("女")){
			copied.sex = 2;
		}		
		copied.rank = data.optInt("rank");
		copied.face = data.optString("face");
		copied.coins = data.optInt("coins");
		copied.displayRank = data.optInt("DisplayRank");
		copied.regtime = new Date(data.optInt("regtime") * 1000L);
		copied.spacesta = data.optInt("spacesta");
		copied.place = data.optString("place");
		copied.birthday = DateUtil.parseDate(data.optString("birthday"));
		copied.sign = data.optString("sign");
		copied.description = data.optString("description");
		copied.article = data.optInt("article");
		copied.levelInfo = data.getJSONObject("level_info").toString();
		copied.pendant = data.getJSONObject("pendant").toString();
		copied.nameplate = data.getJSONObject("nameplate").toString();
		copied.officialVerify = data.getJSONObject("official_verify").toString();
		copied.toutu = data.optString("toutu");
		copied.toutuId = data.optInt("toutuId");
		copied.theme = data.optString("theme");
		copied.themePreview = data.optString("theme_preview");
		copied.im9Sign = data.optString("im9_sign");
		copied.playNum = data.optInt("playNum");
		copied.fansBadge = data.optInt("fans_badge");
		copied.crawlTime = new Date(); //DateUtil.parseDateTime(data.optString("crawlTime"));
		copied.lastUpdateTime = new Date(); //DateUtil.parseDateTime(data.optString("lastUpdateTime"));
		return copied;
	}
	public java.util.Map<String, Object> toMap(){
		java.util.Map<String, Object> dataMap = new java.util.HashMap<String, Object>();
		dataMap.put("mid", this.mid);
		dataMap.put("name", this.name);
		dataMap.put("approve", this.approve);
		dataMap.put("sex", this.sex);
		dataMap.put("rank", this.rank);
		dataMap.put("face", this.face);
		dataMap.put("coins", this.coins);
		dataMap.put("displayRank", this.displayRank);
		dataMap.put("regtime", this.regtime);
		dataMap.put("spacesta", this.spacesta);
		dataMap.put("place", this.place);
		dataMap.put("birthday", this.birthday);
		dataMap.put("sign", this.sign);
		dataMap.put("description", this.description);
		dataMap.put("article", this.article);
		dataMap.put("levelInfo", this.levelInfo);
		dataMap.put("pendant", this.pendant);
		dataMap.put("nameplate", this.nameplate);
		dataMap.put("officialVerify", this.officialVerify);
		dataMap.put("toutu", this.toutu);
		dataMap.put("toutuId", this.toutuId);
		dataMap.put("theme", this.theme);
		dataMap.put("themePreview", this.themePreview);
		dataMap.put("im9Sign", this.im9Sign);
		dataMap.put("playNum", this.playNum);
		dataMap.put("fansBadge", this.fansBadge);
		dataMap.put("crawlTime", this.crawlTime);
		dataMap.put("lastUpdateTime", this.lastUpdateTime);
		return dataMap;
	}
}
