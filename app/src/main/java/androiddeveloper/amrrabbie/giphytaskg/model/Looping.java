package androiddeveloper.amrrabbie.giphytaskg.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Looping implements Serializable {

	@SerializedName("mp4")
	private String mp4;

	@SerializedName("mp4_size")
	private String mp4Size;

	public void setMp4(String mp4){
		this.mp4 = mp4;
	}

	public String getMp4(){
		return mp4;
	}

	public void setMp4Size(String mp4Size){
		this.mp4Size = mp4Size;
	}

	public String getMp4Size(){
		return mp4Size;
	}

	@Override
 	public String toString(){
		return 
			"Looping{" + 
			"mp4 = '" + mp4 + '\'' + 
			",mp4_size = '" + mp4Size + '\'' + 
			"}";
		}
}