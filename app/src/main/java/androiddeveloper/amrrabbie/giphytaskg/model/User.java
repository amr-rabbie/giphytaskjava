package androiddeveloper.amrrabbie.giphytaskg.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

	@SerializedName("avatar_url")
	private String avatarUrl;

	@SerializedName("instagram_url")
	private String instagramUrl;

	@SerializedName("website_url")
	private String websiteUrl;

	@SerializedName("profile_url")
	private String profileUrl;

	@SerializedName("description")
	private String description;

	@SerializedName("banner_url")
	private String bannerUrl;

	@SerializedName("banner_image")
	private String bannerImage;

	@SerializedName("display_name")
	private String displayName;

	@SerializedName("is_verified")
	private boolean isVerified;

	@SerializedName("username")
	private String username;

	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public void setInstagramUrl(String instagramUrl){
		this.instagramUrl = instagramUrl;
	}

	public String getInstagramUrl(){
		return instagramUrl;
	}

	public void setWebsiteUrl(String websiteUrl){
		this.websiteUrl = websiteUrl;
	}

	public String getWebsiteUrl(){
		return websiteUrl;
	}

	public void setProfileUrl(String profileUrl){
		this.profileUrl = profileUrl;
	}

	public String getProfileUrl(){
		return profileUrl;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setBannerUrl(String bannerUrl){
		this.bannerUrl = bannerUrl;
	}

	public String getBannerUrl(){
		return bannerUrl;
	}

	public void setBannerImage(String bannerImage){
		this.bannerImage = bannerImage;
	}

	public String getBannerImage(){
		return bannerImage;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setIsVerified(boolean isVerified){
		this.isVerified = isVerified;
	}

	public boolean isIsVerified(){
		return isVerified;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"User{" + 
			"avatar_url = '" + avatarUrl + '\'' + 
			",instagram_url = '" + instagramUrl + '\'' + 
			",website_url = '" + websiteUrl + '\'' + 
			",profile_url = '" + profileUrl + '\'' + 
			",description = '" + description + '\'' + 
			",banner_url = '" + bannerUrl + '\'' + 
			",banner_image = '" + bannerImage + '\'' + 
			",display_name = '" + displayName + '\'' + 
			",is_verified = '" + isVerified + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}