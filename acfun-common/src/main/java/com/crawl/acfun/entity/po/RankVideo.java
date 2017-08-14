package com.crawl.acfun.entity.po;

import java.io.Serializable;
import org.json.JSONObject;

import com.crawl.acfun.util.DateUtil;


/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class RankVideo implements Serializable {


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
	private String title;

	/**
	 * 
	 */
	private String titleImg;

	/**
	 * 
	 */
	private Integer channelId;

	/**
	 * 
	 */
	private String url;

	/**
	 * 
	 */
	private String username;

	/**
	 * 
	 */
	private Integer userId;

	/**
	 * 
	 */
	private String userImg;

	/**
	 * 
	 */
	private String signature;

	/**
	 * 
	 */
	private Integer contributes;

	/**
	 * 
	 */
	private Integer followedCount;

	/**
	 * 
	 */
	private java.util.Date releaseDate;

	/**
	 * 
	 */
	private Integer views;

	/**
	 * 
	 */
	private Integer comments;

	/**
	 * 
	 */
	private Integer verified;

	/**
	 * 
	 */
	private String verifiedText;

	/**
	 * 
	 */
	private String description;

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

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitleImg(String titleImg){
		this.titleImg = titleImg;
	}

	public String getTitleImg(){
		return this.titleImg;
	}

	public void setChannelId(Integer channelId){
		this.channelId = channelId;
	}

	public Integer getChannelId(){
		return this.channelId;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return this.url;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setUserImg(String userImg){
		this.userImg = userImg;
	}

	public String getUserImg(){
		return this.userImg;
	}

	public void setSignature(String signature){
		this.signature = signature;
	}

	public String getSignature(){
		return this.signature;
	}

	public void setContributes(Integer contributes){
		this.contributes = contributes;
	}

	public Integer getContributes(){
		return this.contributes;
	}

	public void setFollowedCount(Integer followedCount){
		this.followedCount = followedCount;
	}

	public Integer getFollowedCount(){
		return this.followedCount;
	}

	public void setReleaseDate(java.util.Date releaseDate){
		this.releaseDate = releaseDate;
	}

	public java.util.Date getReleaseDate(){
		return this.releaseDate;
	}

	public void setViews(Integer views){
		this.views = views;
	}

	public Integer getViews(){
		return this.views;
	}

	public void setComments(Integer comments){
		this.comments = comments;
	}

	public Integer getComments(){
		return this.comments;
	}

	public void setVerified(Integer verified){
		this.verified = verified;
	}

	public Integer getVerified(){
		return this.verified;
	}

	public void setVerifiedText(String verifiedText){
		this.verifiedText = verifiedText;
	}

	public String getVerifiedText(){
		return this.verifiedText;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setLastUpdateTime(java.util.Date lastUpdateTime){
		this.lastUpdateTime = lastUpdateTime;
	}

	public java.util.Date getLastUpdateTime(){
		return this.lastUpdateTime;
	}

	public RankVideo clone(){
		RankVideo copied = new RankVideo();
		copied.id = this.id;
		copied.webId = this.webId;
		copied.title = this.title;
		copied.titleImg = this.titleImg;
		copied.channelId = this.channelId;
		copied.url = this.url;
		copied.username = this.username;
		copied.userId = this.userId;
		copied.userImg = this.userImg;
		copied.signature = this.signature;
		copied.contributes = this.contributes;
		copied.followedCount = this.followedCount;
		copied.releaseDate = this.releaseDate;
		copied.views = this.views;
		copied.comments = this.comments;
		copied.verified = this.verified;
		copied.verifiedText = this.verifiedText;
		copied.description = this.description;
		copied.lastUpdateTime = this.lastUpdateTime;
		return copied;
	}
	public static RankVideo fromJson(JSONObject data){
		RankVideo copied = new RankVideo();
		copied.id = data.optInt("id");
		copied.webId = data.optInt("webId");
		copied.title = data.optString("title");
		copied.titleImg = data.optString("titleImg");
		copied.channelId = data.optInt("channelId");
		copied.url = data.optString("url");
		copied.username = data.optString("username");
		copied.userId = data.optInt("userId");
		copied.userImg = data.optString("userImg");
		copied.signature = data.optString("signature");
		copied.contributes = data.optInt("contributes");
		copied.followedCount = data.optInt("followedCount");
		copied.releaseDate = DateUtil.parseDateTime(data.optString("releaseDate"));
		copied.views = data.optInt("views");
		copied.comments = data.optInt("comments");
		copied.verified = data.optInt("verified");
		copied.verifiedText = data.optString("verifiedText");
		copied.description = data.optString("description");
		//copied.lastUpdateTime = DateUtil.parseDateTime(data.optString("lastUpdateTime"));
		
		if (copied.id <= 0){
			copied.id = Integer.parseInt(copied.url.substring("/v/ac".length()));
		}
		//"/v/ac3839391",
		
		return copied;
	}
}
