package androiddeveloper.amrrabbie.giphytaskg.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataItem implements Serializable {

	@SerializedName("import_datetime")
	private String importDatetime;

	@SerializedName("images")
	private Images images;

	@SerializedName("embed_url")
	private String embedUrl;

	@SerializedName("trending_datetime")
	private String trendingDatetime;

	@SerializedName("bitly_url")
	private String bitlyUrl;

	@SerializedName("rating")
	private String rating;

	@SerializedName("is_sticker")
	private int isSticker;

	@SerializedName("source")
	private String source;

	@SerializedName("type")
	private String type;

	@SerializedName("bitly_gif_url")
	private String bitlyGifUrl;

	@SerializedName("title")
	private String title;

	@SerializedName("source_tld")
	private String sourceTld;

	@SerializedName("url")
	private String url;

	@SerializedName("analytics_response_payload")
	private String analyticsResponsePayload;

	@SerializedName("analytics")
	private Analytics analytics;

	@SerializedName("source_post_url")
	private String sourcePostUrl;

	@SerializedName("content_url")
	private String contentUrl;

	@SerializedName("id")
	private String id;

	@SerializedName("user")
	private User user;

	@SerializedName("slug")
	private String slug;

	@SerializedName("username")
	private String username;

	public void setImportDatetime(String importDatetime){
		this.importDatetime = importDatetime;
	}

	public String getImportDatetime(){
		return importDatetime;
	}

	public void setImages(Images images){
		this.images = images;
	}

	public Images getImages(){
		return images;
	}

	public void setEmbedUrl(String embedUrl){
		this.embedUrl = embedUrl;
	}

	public String getEmbedUrl(){
		return embedUrl;
	}

	public void setTrendingDatetime(String trendingDatetime){
		this.trendingDatetime = trendingDatetime;
	}

	public String getTrendingDatetime(){
		return trendingDatetime;
	}

	public void setBitlyUrl(String bitlyUrl){
		this.bitlyUrl = bitlyUrl;
	}

	public String getBitlyUrl(){
		return bitlyUrl;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setIsSticker(int isSticker){
		this.isSticker = isSticker;
	}

	public int getIsSticker(){
		return isSticker;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setBitlyGifUrl(String bitlyGifUrl){
		this.bitlyGifUrl = bitlyGifUrl;
	}

	public String getBitlyGifUrl(){
		return bitlyGifUrl;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setSourceTld(String sourceTld){
		this.sourceTld = sourceTld;
	}

	public String getSourceTld(){
		return sourceTld;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setAnalyticsResponsePayload(String analyticsResponsePayload){
		this.analyticsResponsePayload = analyticsResponsePayload;
	}

	public String getAnalyticsResponsePayload(){
		return analyticsResponsePayload;
	}

	public void setAnalytics(Analytics analytics){
		this.analytics = analytics;
	}

	public Analytics getAnalytics(){
		return analytics;
	}

	public void setSourcePostUrl(String sourcePostUrl){
		this.sourcePostUrl = sourcePostUrl;
	}

	public String getSourcePostUrl(){
		return sourcePostUrl;
	}

	public void setContentUrl(String contentUrl){
		this.contentUrl = contentUrl;
	}

	public String getContentUrl(){
		return contentUrl;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
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
			"DataItem{" + 
			"import_datetime = '" + importDatetime + '\'' + 
			",images = '" + images + '\'' + 
			",embed_url = '" + embedUrl + '\'' + 
			",trending_datetime = '" + trendingDatetime + '\'' + 
			",bitly_url = '" + bitlyUrl + '\'' + 
			",rating = '" + rating + '\'' + 
			",is_sticker = '" + isSticker + '\'' + 
			",source = '" + source + '\'' + 
			",type = '" + type + '\'' + 
			",bitly_gif_url = '" + bitlyGifUrl + '\'' + 
			",title = '" + title + '\'' + 
			",source_tld = '" + sourceTld + '\'' + 
			",url = '" + url + '\'' + 
			",analytics_response_payload = '" + analyticsResponsePayload + '\'' + 
			",analytics = '" + analytics + '\'' + 
			",source_post_url = '" + sourcePostUrl + '\'' + 
			",content_url = '" + contentUrl + '\'' + 
			",id = '" + id + '\'' + 
			",user = '" + user + '\'' + 
			",slug = '" + slug + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}