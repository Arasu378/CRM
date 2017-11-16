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
		StoredProcedureQuery query=em.createNamedStoredProcedureQuery("`Settings.Language_InsertLanguage`");
			query.setParameter("languageCultureName", "test1");
			query.setParameter("languageName", "test2");
		boolean value=query.execute();
		  System.out.println("boolean value : "+value);
		  em.getTransaction().commit();
		  em.close();
	}
	

}
