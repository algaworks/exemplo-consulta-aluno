package com.algaworks.exemplo;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

public class AjudaIntersys {

private JIntegrity helper;
	
	private EntityManager manager;
	
	@Before
	public void init() {
		helper = new JIntegrity();
		helper.useMySQL();
		
		helper.cleanAndInsert();
		
		this.manager = JPAHelper.currentEntityManager();
	}
	
	@Test
	public void consulta() {
		
	}
	
}
