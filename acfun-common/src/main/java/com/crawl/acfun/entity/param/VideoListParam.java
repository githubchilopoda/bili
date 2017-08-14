package com.crawl.acfun.entity.param;



/**
 * 
 * 参数
 * 
 */
public class VideoListParam extends BaseParam{


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

	private String channelPathFuzzy;

	/**
	 * 
	 */
	private Integer commentCount;

	/**
	 * 
	 */
	private java.util.Date contributeTime;

	private String contributeTimeStart;

	private String contributeTimeEnd;

	/**
	 * 
	 */
	private String coverImage;

	private String coverImageFuzzy;

	/**
	 * 
	 */
	private Integer danmuSize;

	/**
	 * 
	 */
	private String description;

	private String descriptionFuzzy;

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

	private String latestCommentTimeStart;

	private String latestCommentTimeEnd;

	/**
	 * 
	 */
	private Integer parentChannelId;

	/**
	 * 
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 
	 */
	private String userAvatar;

	private String userAvatarFuzzy;

	/**
	 * 
	 */
	private Integer userId;

	/**
	 * 
	 */
	private String link;

	private String linkFuzzy;

	/**
	 * 
	 */
	private String username;

	private String usernameFuzzy;

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

	public void setChannelPathFuzzy(String channelPathFuzzy){
		this.channelPathFuzzy = channelPathFuzzy;
	}

	public String getChannelPathFuzzy(){
		return this.channelPathFuzzy;
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

	public void setContributeTimeStart(String contributeTimeStart){
		this.contributeTimeStart = contributeTimeStart;
	}

	public String getContributeTimeStart(){
		return this.contributeTimeStart;
	}
	public void setContributeTimeEnd(String contributeTimeEnd){
		this.contributeTimeEnd = contributeTimeEnd;
	}

	public String getContributeTimeEnd(){
		return this.contributeTimeEnd;
	}

	public void setCoverImage(String coverImage){
		this.coverImage = coverImage;
	}

	public String getCoverImage(){
		return this.coverImage;
	}

	public void setCoverImageFuzzy(String coverImageFuzzy){
		this.coverImageFuzzy = coverImageFuzzy;
	}

	public String getCoverImageFuzzy(){
		return this.coverImageFuzzy;
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

	public void setDescriptionFuzzy(String descriptionFuzzy){
		this.descriptionFuzzy = descriptionFuzzy;
	}

	public String getDescriptionFuzzy(){
		return this.descriptionFuzzy;
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

	public void setLatestCommentTimeStart(String latestCommentTimeStart){
		this.latestCommentTimeStart = latestCommentTimeStart;
	}

	public String getLatestCommentTimeStart(){
		return this.latestCommentTimeStart;
	}
	public void setLatestCommentTimeEnd(String latestCommentTimeEnd){
		this.latestCommentTimeEnd = latestCommentTimeEnd;
	}

	public String getLatestCommentTimeEnd(){
		return this.latestCommentTimeEnd;
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

	public void setTitleFuzzy(String titleFuzzy){
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy(){
		return this.titleFuzzy;
	}

	public void setUserAvatar(String userAvatar){
		this.userAvatar = userAvatar;
	}

	public String getUserAvatar(){
		return this.userAvatar;
	}

	public void setUserAvatarFuzzy(String userAvatarFuzzy){
		this.userAvatarFuzzy = userAvatarFuzzy;
	}

	public String getUserAvatarFuzzy(){
		return this.userAvatarFuzzy;
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

	public void setLinkFuzzy(String linkFuzzy){
		this.linkFuzzy = linkFuzzy;
	}

	public String getLinkFuzzy(){
		return this.linkFuzzy;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setUsernameFuzzy(String usernameFuzzy){
		this.usernameFuzzy = usernameFuzzy;
	}

	public String getUsernameFuzzy(){
		return this.usernameFuzzy;
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

}
