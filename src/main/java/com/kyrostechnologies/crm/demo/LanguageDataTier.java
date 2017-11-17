package com.kyrostechnologies.crm.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;


@Repository
public class LanguageDataTier  implements LanguageInterface{
	private SimpleJdbcCall createUserProc;
	 
			NamedParameterJdbcTemplate namedParameterJdbcTemplate;
			@Autowired
			public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException{
				this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
			}
			
			@PersistenceContext
			private EntityManager entityManager;
			 @Autowired
			    public void setDataSource(DataSource dataSource) {
			       this.createUserProc = new SimpleJdbcCall(dataSource).withProcedureName("create_user").withReturnValue();
			    }
//			@Autowired
//			TestInterface testInterface;
	@Override
	public List<LanguageModel> getLanguageList() {
//		  StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("`Settings.Language_GetLanguage`");
//		List<LanguageModel> list =(List<LanguageModel>) storedProcedure.getResultList();
	
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
		LanguageResponse response=new LanguageResponse();

//        Session session = getSession();
//        
//        session.doWork(new Work() {
//			
//			@Override
//			public void execute(Connection connection) throws SQLException {
//				CallableStatement cs = null;
//				
//				  try {
//	                    cs = connection.prepareCall("{CALL `Settings.Language_InsertLanguage`(?, ?)}");
//	                    cs.setString(1, inParam1);
//	                    cs.setString(2, inParam2);
//	                  boolean value=  cs.execute();
//	              	
//	              	if(value) {
//	              		response.setIsSuccess(true);
//	              		response.setLanguageList(getLanguageList());
//	              		response.setMessage("data successfully inserted");
//	              		
//	              	}else {
//	              		response.setIsSuccess(false);
//	              		response.setLanguageList(null);
//	              		response.setMessage("data is not inserted");
//	              		
//	              	}
//	                 
//	                   
//	                    cs.close();
//	                    
//
//	                } finally {
//	                    // close cs
//	                	try {
//	                		if(connection!=null) {
//	                			connection.close();
//	                		}
//	                	}catch(Exception e) {
//	                		e.printStackTrace();
//	                	}
//	                }
//			}
//		});
		
		
		
		
		
		
//		 StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("`Settings.Language_InsertLanguage`");
//			System.out.println("value insert : "+inParam1+"/ /"+inParam2);
//			storedProcedure.setParameter("LanguageCultureName", inParam1);
//			storedProcedure.setParameter("LanguageName", inParam2);
//			boolean value=storedProcedure.execute();
//			
//			
//		// TODO Auto-generated method stub
//		LanguageResponse response=new LanguageResponse();
//		
//	if(value) {
//		response.setIsSuccess(true);
//		response.setLanguageList(getLanguageList());
//		response.setMessage("data successfully inserted");
//		
//	}else {
//		response.setIsSuccess(false);
//		response.setLanguageList(null);
//		response.setMessage("data is not inserted");
//		
//	}
		return response;
	}
	@Override
	public List<LanguageModel> getTempLanguageList() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private Session getSession() {
//        // get session from entitymanager. Assuming hibernate
//        return entityManager.unwrap(org.hibernate.Session.class);
//    }
	@Override
	public void inserttestLanguage(LanguageModel model) {
		SqlParameterSource inParams = new MapSqlParameterSource()
				.addValue("LanguageCultureName", model.getLanguageCultureName())
				.addValue("LanguageName", model.getLanguageName());
				
    	
		Map result = createUserProc.execute(inParams);
		
		
	}

}
