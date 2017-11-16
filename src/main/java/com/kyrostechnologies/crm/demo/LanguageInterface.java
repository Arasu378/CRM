package com.kyrostechnologies.crm.demo;

import java.util.List;

import javax.xml.transform.Result;

import org.carrot2.util.attribute.Input;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface LanguageInterface {
	//@Procedure('LanguageModel.get_users')
public List<LanguageModel>getLanguageList();
@Procedure(name = "`Settings.Language_InsertLanguage`")
public LanguageResponse InsertLanguage(@Param("languageCultureName") String inParam1,@Param("languageName") String inParam2);
public List<LanguageModel>getTempLanguageList();
}
