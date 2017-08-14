package com.crawl.acfun.entity.po;

import java.io.Serializable;
import org.json.JSONObject;


/**
 * 
 * 
 * 
 */
@SuppressWarnings("serial")
public class Uploader implements Serializable {


	/**
	 * 平台用户id
	 */
	private Integer uid;

	/**
	 * 网站id
	 */
	private Integer webId;

	/**
	 * 
	 */
	private String username;

	/**
	 * 
	 */
	private Integer gender;

	/**
	 * 
	 */
	private Integer verified;

	/**
	 * 
	 */
	private Integer isDisabled;

	/**
	 * 
	 */
	private Integer video;

	/**
	 * 
	 */
	private Integer article;

	/**
	 * 
	 */
	private Integer collection;

	/**
	 * 
	 */
	private Integer followedCount;

	/**
	 * 
	 */
	private Integer followingCount;

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
	private String verifiedText;

	/**
	 * 
	 */
	private String spaceImage;

	/**
	 * 
	 */
	private java.util.Date createDate;

	/**
	 * 
	 */
	private java.util.Date lastGrabDate;


	public void setUid(Integer uid){
		this.uid = uid;
	}

	public Integer getUid(){
		return this.uid;
	}

	public void setWebId(Integer webId){
		this.webId = webId;
	}

	public Integer getWebId(){
		return this.webId;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setGender(Integer gender){
		this.gender = gender;
	}

	public Integer getGender(){
		return this.gender;
	}

	public void setVerified(Integer verified){
		this.verified = verified;
	}

	public Integer getVerified(){
		return this.verified;
	}

	public void setIsDisabled(Integer isDisabled){
		this.isDisabled = isDisabled;
	}

	public Integer getIsDisabled(){
		return this.isDisabled;
	}

	public void setVideo(Integer video){
		this.video = video;
	}

	public Integer getVideo(){
		return this.video;
	}

	public void setArticle(Integer article){
		this.article = article;
	}

	public Integer getArticle(){
		return this.article;
	}

	public void setCollection(Integer collection){
		this.collection = collection;
	}

	public Integer getCollection(){
		return this.collection;
	}

	public void setFollowedCount(Integer followedCount){
		this.followedCount = followedCount;
	}

	public Integer getFollowedCount(){
		return this.followedCount;
	}

	public void setFollowingCount(Integer followingCount){
		this.followingCount = followingCount;
	}

	public Integer getFollowingCount(){
		return this.followingCount;
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

	public void setVerifiedText(String verifiedText){
		this.verifiedText = verifiedText;
	}

	public String getVerifiedText(){
		return this.verifiedText;
	}

	public void setSpaceImage(String spaceImage){
		this.spaceImage = spaceImage;
	}

	public String getSpaceImage(){
		return this.spaceImage;
	}

	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}

	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	public void setLastGrabDate(java.util.Date lastGrabDate){
		this.lastGrabDate = lastGrabDate;
	}

	public java.util.Date getLastGrabDate(){
		return this.lastGrabDate;
	}

	public Uploader clone(){
		Uploader copied = new Uploader();
		copied.uid = this.uid;
		copied.webId = this.webId;
		copied.username = this.username;
		copied.gender = this.gender;
		copied.verified = this.verified;
		copied.isDisabled = this.isDisabled;
		copied.video = this.video;
		copied.article = this.article;
		copied.collection = this.collection;
		copied.followedCount = this.followedCount;
		copied.followingCount = this.followingCount;
		copied.userImg = this.userImg;
		copied.signature = this.signature;
		copied.verifiedText = this.verifiedText;
		copied.spaceImage = this.spaceImage;
		copied.createDate = this.createDate;
		copied.lastGrabDate = this.lastGrabDate;
		return copied;
	}
	public static Uploader fromJson(JSONObject data){
		Uploader copied = new Uploader();
		copied.uid = data.optInt("uid");
		copied.webId = data.optInt("webId");
		copied.username = data.optString("username");
		copied.gender = data.optInt("gender");
		copied.verified = data.optInt("verified");
		copied.isDisabled = data.optInt("isDisabled");
		copied.video = data.optInt("video");
		copied.article = data.optInt("article");
		copied.collection = data.optInt("collection");
		copied.followedCount = data.optInt("followedCount");
		copied.followingCount = data.optInt("followingCount");
		copied.userImg = data.optString("userImg");
		copied.signature = data.optString("signature");
		copied.verifiedText = data.optString("verifiedText");
		copied.spaceImage = data.optString("spaceImage");
		//copied.createDate = DateUtil.parseDateTime(data.optString("createDate"));
		//copied.lastGrabDate = DateUtil.parseDateTime(data.optString("lastGrabDate"));
		return copied;
	}
}
