package com.kyrostechnologies.crm.demo;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
@Repository
public class LanguageDataTier  implements LanguageInterface{
			NamedParameterJdbcTemplate namedParameterJdbcTemplate;
			@Autowired
			public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException{
				this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
			}
			
			
	@Override
	public List<LanguageModel> getLanguageList() {
		
		String query="CALL `Settings.Language_GetLanguage`();";
		List<LanguageModel>list=namedParameterJdbcTemplate.query(query, getSqlParameterSource(null),new GetLanguageBusinnessLogicMapper());
		return list;
	}
	private SqlParameterSource getSqlParameterSource(LanguageModel model) {
		MapSqlParameterSource paramSource=new MapSqlParameterSource();
		return paramSource;
	}
	@SuppressWarnings("unused")
	private SqlParameterSource insertSqlParameterSource(LanguageModel model) {
		MapSqlParameterSource paramSource=new MapSqlParameterSource();
		if(model!=null) {
			System.out.println("LanguageName : "+model.getLanguageName());
			System.out.println("LanguageCultureName : "+model.getLanguageCultureName());
			paramSource.addValue(LanguageDBConstants.LANGUAGE_NAME, model.getLanguageName());
			paramSource.addValue(LanguageDBConstants.LANGUAGE_CULTURE_NAME, model.getLanguageCultureName());
		}
		return paramSource;
	}
	

	@Override
	public LanguageResponse InsertLanguage(String inParam1, String inParam2) {
		// TODO Auto-generated method stub
		LanguageResponse response=new LanguageResponse();
		int value=0;
	if(value!=0) {
		response.setIsSuccess(true);
		response.setLanguageList(getLanguageList());
		response.setMessage("data successfully inserted");
		
	}else {
		response.setIsSuccess(false);
		response.setLanguageList(null);
		response.setMessage("data is not inserted");
		
	}
		return response;
	}
	

}
