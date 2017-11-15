package com.kyrostechnologies.crm.demo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class LanguageResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("LanguageList")
private List<LanguageModel>languageList=new ArrayList<LanguageModel>();
public LanguageResponse(){
	
}
public boolean getIsSuccess() {
	return isSuccess;
}
public void setIsSuccess(boolean isSuccess) {
	this.isSuccess = isSuccess;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public List<LanguageModel> getLanguageList() {
	return languageList;
}
public void setLanguageList(List<LanguageModel> languageList) {
	this.languageList = languageList;
}


}
