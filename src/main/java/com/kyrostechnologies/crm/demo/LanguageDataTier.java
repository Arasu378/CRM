package com.kyrostechnologies.crm.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.xml.transform.Result;

import org.carrot2.util.attribute.Input;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import net.sf.ehcache.hibernate.HibernateUtil;

@Repository
public class LanguageDataTier  implements LanguageInterface{
			NamedParameterJdbcTemplate namedParameterJdbcTemplate;
			@Autowired
			public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException{
				this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
			}
			
			@PersistenceContext
			private EntityManager entityManager;
			//private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
			
	@SuppressWarnings("unchecked")
	@Override
	public List<LanguageModel> getLanguageList() {
//		  StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("`Settings.Language_GetLanguage`");
//		List<LanguageModel> storedProcedureResults =(List<LanguageModel>) storedProcedure.getResultList();
//		List<LanguageModel>ls=new ArrayList<>();	
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
		 StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("`Settings.Language_InsertLanguage`");
			System.out.println("value insert : "+inParam1+"/ /"+inParam2);
			storedProcedure.setParameter("languageCultureName", inParam1);
			storedProcedure.setParameter("languageName", inParam2);
			boolean value=storedProcedure.execute();
			
			
		// TODO Auto-generated method stub
		LanguageResponse response=new LanguageResponse();
		
	if(value) {
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
	@Override
	public List<LanguageModel> getTempLanguageList() {
		// TODO Auto-generated method stub
		return null;
	}


}
