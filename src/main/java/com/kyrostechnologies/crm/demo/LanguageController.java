package com.kyrostechnologies.crm.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "*")
//@RequestMapping(path="/demo")
public class LanguageController {
	@Autowired
	private LanguageDataTier languageModel;
	
	@GetMapping(path="/language")
	public @ResponseBody List<LanguageModel> getAllLanguages() {
		return languageModel.getLanguageList();
	}
	@RequestMapping(method=RequestMethod.POST,value="/language")
	public   LanguageResponse insertLanguage(@RequestBody LanguageModel model) {
		System.out.println("APi input : "+model.getLanguageCultureName()+" / /"+model.getLanguageName());
	    return languageModel.InsertLanguage(model.getLanguageCultureName(),model.getLanguageName());
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/languagetest")
	public   void insertLanguageTest(@RequestBody LanguageModel model) {
		System.out.println("APi input : "+model.getLanguageCultureName()+" / /"+model.getLanguageName());
	   languageModel.inserttestLanguage(model);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/languagenext")
	public   void insertLanguageNext(@RequestBody LanguageModel model) {
		System.out.println("APi input : "+model.getLanguageCultureName()+" / /"+model.getLanguageName());
	   languageModel.insertLanguageNext(model.getLanguageCultureName(), model.getLanguageName());
		
	}
}
