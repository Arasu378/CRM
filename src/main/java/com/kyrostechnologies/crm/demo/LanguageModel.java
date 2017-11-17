package com.kyrostechnologies.crm.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "settings.language")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name="`Settings.Language_GetLanguage`",
								procedureName="`Settings.Language_GetLanguage`",
								resultClasses = { LanguageModel.class },
								parameters = {
		                                 @StoredProcedureParameter(mode = ParameterMode.OUT, name = "list", type = LanguageModel.class)
		                                 
		                              })
		,
	   @NamedStoredProcedureQuery(name = "`Settings.Language_InsertLanguage`", 
	                              procedureName = "`Settings.Language_InsertLanguage`",
	                              parameters = {
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "LanguageCultureName", type = String.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "LanguageName", type = String.class)
	                              })
//	   @NamedStoredProcedureQuery(name = "in_and_out_test", 
//	                              procedureName = "test_pkg.in_and_out_test",
//	                              parameters = {
//	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
//	                                 @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam1", type =  String.class)
//	                              })
//	   ,
//	   @NamedStoredProcedureQuery(
//			    name="getUsers", 
//			    procedureName="get_users", resultClass=User.class, parameters={
//			        @StoredProcedureParameter(queryParameter="data", name="data", direction=Direction.OUT_CURSOR)
//			    }
//			)
	})
public class LanguageModel implements Serializable{
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@JsonProperty("LanguageId")
@Column(name="LanguageId")
private int languageId;
@JsonProperty("LanguageCultureName")
@Column(name="LanguageCultureName")
private String languageCultureName;
@JsonProperty("LanguageName")
@Column(name="LanguageName")
private String languageName;
@JsonProperty("IsActive")
@Column(name="IsActive")
private boolean isActive;
@JsonProperty("CreatedDate")
@Column(name="CreatedDate")
private String createdDate;
@JsonProperty("ModifiedDate")
@Column(name="ModifiedDate")
private String modifiedDate;
public LanguageModel(){
	
}
public int getLanguageId() {
	return languageId;
}
public void setLanguageId(int languageId) {
	this.languageId = languageId;
}
public String getLanguageCultureName() {
	return languageCultureName;
}
public void setLanguageCultureName(String languageCultureName) {
	this.languageCultureName = languageCultureName;
}
public String getLanguageName() {
	return languageName;
}
public void setLanguageName(String languageName) {
	this.languageName = languageName;
}
public boolean getIsActive() {
	return isActive;
}
public void setIsActive(boolean isActive) {
	this.isActive = isActive;
}
public String getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
}
public String getModifiedDate() {
	return modifiedDate;
}
public void setModifiedDate(String modifiedDate) {
	this.modifiedDate = modifiedDate;
}

}
