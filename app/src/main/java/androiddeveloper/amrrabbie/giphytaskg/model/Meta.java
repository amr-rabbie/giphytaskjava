package androiddeveloper.amrrabbie.giphytaskg.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Meta implements Serializable {

	@SerializedName("msg")
	private String msg;

	@SerializedName("response_id")
	private String responseId;

	@SerializedName("status")
	private int status;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setResponseId(String responseId){
		this.responseId = responseId;
	}

	public String getResponseId(){
		return responseId;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"msg = '" + msg + '\'' + 
			",response_id = '" + responseId + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}