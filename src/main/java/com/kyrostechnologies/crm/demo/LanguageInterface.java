package com.kyrostechnologies.crm.demo;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface LanguageInterface {
	//@Procedure('LanguageModel.get_users')
public List<LanguageModel>getLanguageList();
@Procedure(name = "in_only_test")
public LanguageResponse InsertLanguage(@Param("LanguageCultureName") String inParam1,@Param("LanguageName") String inParam2);
}
