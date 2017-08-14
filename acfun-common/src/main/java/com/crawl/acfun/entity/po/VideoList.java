package com.crawl.acfun.entity.po;

import java.io.Serializable;
import java.util.Date;

import org.json.JSONObject;


/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class VideoList implements Serializable {


	/**
	 * 
	 */
	private Integer id;

	/**
	 * 
	 */
	private Integer bananaCount;

	/**
	 * 
	 */
	private Integer channelId;

	/**
	 * 
	 */
	private String channelPath;

	/**
	 * 
	 */
	private Integer commentCount;

	/**
	 * 
	 */
	private java.util.Date contributeTime;

	/**
	 * 
	 */
	private String coverImage;

	/**
	 * 
	 */
	private Integer danmuSize;

	/**
	 * 
	 */
	private String description;

	/**
	 * 
	 */
	private Integer duration;

	/**
	 * 
	 */
	private Integer favoriteCount;

	/**
	 * 
	 */
	private Integer isTopLevel;

	/**
	 * 
	 */
	private Integer isTudouDomain;

	/**
	 * 
	 */
	private java.util.Date latestCommentTime;

	/**
	 * 
	 */
	private Integer parentChannelId;

	/**
	 * 
	 */
	private String title;

	/**
	 * 
	 */
	private String userAvatar;

	/**
	 * 
	 */
	private Integer userId;

	/**
	 * 
	 */
	private String link;

	/**
	 * 
	 */
	private String username;

	/**
	 * 
	 */
	private Integer verified;

	/**
	 * 
	 */
	private Integer videoId;

	/**
	 * 
	 */
	private Integer viewCount;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setBananaCount(Integer bananaCount){
		this.bananaCount = bananaCount;
	}

	public Integer getBananaCount(){
		return this.bananaCount;
	}

	public void setChannelId(Integer channelId){
		this.channelId = channelId;
	}

	public Integer getChannelId(){
		return this.channelId;
	}

	public void setChannelPath(String channelPath){
		this.channelPath = channelPath;
	}

	public String getChannelPath(){
		return this.channelPath;
	}

	public void setCommentCount(Integer commentCount){
		this.commentCount = commentCount;
	}

	public Integer getCommentCount(){
		return this.commentCount;
	}

	public void setContributeTime(java.util.Date contributeTime){
		this.contributeTime = contributeTime;
	}

	public java.util.Date getContributeTime(){
		return this.contributeTime;
	}

	public void setCoverImage(String coverImage){
		this.coverImage = coverImage;
	}

	public String getCoverImage(){
		return this.coverImage;
	}

	public void setDanmuSize(Integer danmuSize){
		this.danmuSize = danmuSize;
	}

	public Integer getDanmuSize(){
		return this.danmuSize;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDuration(Integer duration){
		this.duration = duration;
	}

	public Integer getDuration(){
		return this.duration;
	}

	public void setFavoriteCount(Integer favoriteCount){
		this.favoriteCount = favoriteCount;
	}

	public Integer getFavoriteCount(){
		return this.favoriteCount;
	}

	public void setIsTopLevel(Integer isTopLevel){
		this.isTopLevel = isTopLevel;
	}

	public Integer getIsTopLevel(){
		return this.isTopLevel;
	}

	public void setIsTudouDomain(Integer isTudouDomain){
		this.isTudouDomain = isTudouDomain;
	}

	public Integer getIsTudouDomain(){
		return this.isTudouDomain;
	}

	public void setLatestCommentTime(java.util.Date latestCommentTime){
		this.latestCommentTime = latestCommentTime;
	}

	public java.util.Date getLatestCommentTime(){
		return this.latestCommentTime;
	}

	public void setParentChannelId(Integer parentChannelId){
		this.parentChannelId = parentChannelId;
	}

	public Integer getParentChannelId(){
		return this.parentChannelId;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setUserAvatar(String userAvatar){
		this.userAvatar = userAvatar;
	}

	public String getUserAvatar(){
		return this.userAvatar;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return this.link;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setVerified(Integer verified){
		this.verified = verified;
	}

	public Integer getVerified(){
		return this.verified;
	}

	public void setVideoId(Integer videoId){
		this.videoId = videoId;
	}

	public Integer getVideoId(){
		return this.videoId;
	}

	public void setViewCount(Integer viewCount){
		this.viewCount = viewCount;
	}

	public Integer getViewCount(){
		return this.viewCount;
	}

	public VideoList clone(){
		VideoList copied = new VideoList();
		copied.id = this.id;
		copied.bananaCount = this.bananaCount;
		copied.channelId = this.channelId;
		copied.channelPath = this.channelPath;
		copied.commentCount = this.commentCount;
		copied.contributeTime = this.contributeTime;
		copied.coverImage = this.coverImage;
		copied.danmuSize = this.danmuSize;
		copied.description = this.description;
		copied.duration = this.duration;
		copied.favoriteCount = this.favoriteCount;
		copied.isTopLevel = this.isTopLevel;
		copied.isTudouDomain = this.isTudouDomain;
		copied.latestCommentTime = this.latestCommentTime;
		copied.parentChannelId = this.parentChannelId;
		copied.title = this.title;
		copied.userAvatar = this.userAvatar;
		copied.userId = this.userId;
		copied.link = this.link;
		copied.username = this.username;
		copied.verified = this.verified;
		copied.videoId = this.videoId;
		copied.viewCount = this.viewCount;
		return copied;
	}
	public static VideoList fromJson(JSONObject data){
		VideoList copied = new VideoList();
		copied.id = data.optInt("id");
		copied.bananaCount = data.optInt("bananaCount");
		copied.channelId = data.optInt("channelId");
		copied.channelPath = data.optString("channelPath");
		copied.commentCount = data.optInt("commentCount");
		copied.contributeTime = new Date(data.optLong("contributeTime"));
		copied.coverImage = data.optString("coverImage");
		copied.danmuSize = data.optInt("danmuSize");
		copied.description = data.optString("description");
		copied.duration = data.optInt("duration");
		copied.favoriteCount = data.optInt("favoriteCount");
		copied.isTopLevel = data.optBoolean("isTopLevel")?1:0;
		copied.isTudouDomain = data.optBoolean("isTudouDomain")?1:0;
		copied.latestCommentTime = new Date(data.optLong("latestCommentTime"));
		copied.parentChannelId = data.optInt("parentChannelId");
		copied.title = data.optString("title");
		copied.userAvatar = data.optString("userAvatar");
		copied.userId = data.optInt("userId");
		copied.link = data.optString("link");
		copied.username = data.optString("username");
		copied.verified = data.optInt("verified");
		copied.videoId = data.optInt("videoId");
		copied.viewCount = data.optInt("viewCount");
		return copied;
	}
}
