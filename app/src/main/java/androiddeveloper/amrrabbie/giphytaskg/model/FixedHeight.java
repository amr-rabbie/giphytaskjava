package androiddeveloper.amrrabbie.giphytaskg.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FixedHeight implements Serializable {

	@SerializedName("mp4")
	private String mp4;

	@SerializedName("size")
	private String size;

	@SerializedName("width")
	private String width;

	@SerializedName("mp4_size")
	private String mp4Size;

	@SerializedName("webp")
	private String webp;

	@SerializedName("webp_size")
	private String webpSize;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private String height;

	public void setMp4(String mp4){
		this.mp4 = mp4;
	}

	public String getMp4(){
		return mp4;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setWidth(String width){
		this.width = width;
	}

	public String getWidth(){
		return width;
	}

	public void setMp4Size(String mp4Size){
		this.mp4Size = mp4Size;
	}

	public String getMp4Size(){
		return mp4Size;
	}

	public void setWebp(String webp){
		this.webp = webp;
	}

	public String getWebp(){
		return webp;
	}

	public void setWebpSize(String webpSize){
		this.webpSize = webpSize;
	}

	public String getWebpSize(){
		return webpSize;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(String height){
		this.height = height;
	}

	public String getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"FixedHeight{" + 
			"mp4 = '" + mp4 + '\'' + 
			",size = '" + size + '\'' + 
			",width = '" + width + '\'' + 
			",mp4_size = '" + mp4Size + '\'' + 
			",webp = '" + webp + '\'' + 
			",webp_size = '" + webpSize + '\'' + 
			",url = '" + url + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}