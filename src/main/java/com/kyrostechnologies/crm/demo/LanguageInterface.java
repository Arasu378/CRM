package com.kyrostechnologies.crm.demo;

import java.util.List;

import javax.xml.transform.Result;

import org.carrot2.util.attribute.Input;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface LanguageInterface {
	//@Procedure('LanguageModel.get_users')
public List<LanguageModel>getLanguageList();
@Procedure(name = "`Settings.Language_GetLanguage`")
public LanguageResponse InsertLanguage(@Param("LanguageCultureName") String inParam1,@Param("LanguageName") String inParam2);
public List<LanguageModel>getTempLanguageList();
@Procedure(name="`Settings.Language_GetLanguage`")
public void inserttestLanguage(LanguageModel model);
}
