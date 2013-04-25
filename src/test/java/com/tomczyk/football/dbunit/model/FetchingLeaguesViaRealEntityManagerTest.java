package com.tomczyk.football.dbunit.model;

import static org.junit.Assert.assertEquals;

import javax.persistence.Query;

import org.junit.Test;

import com.tomczyk.football.dbunit.base.FootballBase;
import com.tomczyk.football.model.League;

/**
 * Nothing special here, just checking if we can get leagues 
 * 
 * In real projects the simple tests like these could be a overkill as
 * we probably be rather interested in testing logic layer or dao (if available)
 * 
 * These tests are rather for demonstrational purposes :)
 * They give the possibilities of test something quite quickly by the way :)
 * 
 * To be honest we test here how dbunit works, notice that we have not defined
 * data we try to get (Premiership, Bundesliga) as the data should be populated
 * by dbunit.
 * 
 */
public class FetchingLeaguesViaRealEntityManagerTest extends FootballBase {

	@Test
	public void isPremiershipAvailable() {
	
		em.getTransaction().begin();

		Query query = em.createQuery("select l from League l where l.name=:name");
	    query.setParameter("name", "Premiership");

		League league = (League) query.getSingleResult();
		
		em.getTransaction().commit();
		
		assertEquals("Premiership", league.getName());
		
	}
	
	@Test
	public void isBundesligaAvailable() {
	
		em.getTransaction().begin();

		Query query = em.createQuery("select l from League l where l.name=:name");
	    query.setParameter("name", "Bundesliga");

		League league = (League) query.getSingleResult();
		
		em.getTransaction().commit();
		
		assertEquals("Bundesliga", league.getName());
		
	}
	
}