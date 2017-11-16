package com.kyrostechnologies.crm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kyrostechnologies.crm.demo.LanguageModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
	private EntityManagerFactory emf;

	
	@Before
	public void init() {
		emf=Persistence.createEntityManagerFactory("my-persistence-unit");
	}
	@After
	public void close() {
		emf.close();
	}
	@Test
	public void getLanguage() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		StoredProcedureQuery query=em.createNamedStoredProcedureQuery("getLanguageQuery");
		query.execute();
		LanguageModel model=(LanguageModel)query.getOutputParameterValue("lists");
		  System.out.println("Model : "+model.getLanguageName());
		  em.getTransaction().commit();
		  em.close();
	}
	

}
