package com.tomczyk.football.dbunit.model;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.tomczyk.football.dbunit.base.FootballBase;
import com.tomczyk.football.model.League;
import com.tomczyk.football.model.Team;

/**
 * Nothing special here, just checking if we can get teams belonging to specific league
 * 
 * @see football-datasets.xml
 */
public class FetchingTeamsViaRealEntityManagerTest extends FootballBase {

	
	/**
	 * Premiership was saved with id=1
	 */
	@Test
	public void canPremiershipTeamsBeFetched() {
		
		em.getTransaction().begin();
		
		//I do not want to get a league from db
		League league = new League();
		league.setId(new Long(1));
		
		Query query = em.createQuery("select t from Team t where t.league=:league");
		query.setParameter("league", league);

		@SuppressWarnings("unchecked")
		List<Team> teams = query.getResultList();
		  
		em.getTransaction().commit();
		
		assertEquals("Arsenal", teams.get(0).getName());
		assertEquals("Tottenham", teams.get(1).getName());
				
	}
	
	
	/**
	 * Bundesliga was saved with id=2
	 */
	@Test
	public void canBundesligaTeamsBeFetched() {
		
		em.getTransaction().begin();
		
		//I do not want to get a league from db
		League league = new League();
		league.setId(new Long(2));
		
		Query query = em.createQuery("select t from Team t where t.league=:league");
		query.setParameter("league", league);

		@SuppressWarnings("unchecked")
		List<Team> teams = query.getResultList();
		  
		em.getTransaction().commit();
		
		assertEquals("Bayern Munchen", teams.get(0).getName());
		assertEquals("HSV", teams.get(1).getName());
				
	}

	
	
}