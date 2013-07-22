package com.tomczyk.football.dbunit.model;

import static org.junit.Assert.assertNotNull;

import java.util.Set;

import javax.persistence.Query;

import org.junit.Test;

import com.tomczyk.football.dbunit.base.FootballBase;
import com.tomczyk.football.model.League;
import com.tomczyk.football.model.Player;
import com.tomczyk.football.model.Team;

/**
 * We want to check players but directly via the team object
 * 
 * At start, we get a team and check what
 * players do we have in 'players' property of the 'team' object.
 * 
 * This test is rather useful:
 *  - if we want to observe how hibernate behaves (fetching collection as an example),
 * 		we can change some settings in Team class and we see different behaviors
 *  - if we need to test different queries
 * 
 * @see football-datasets.xml
 */
public class PlayersViaTeamTest extends FootballBase {

	
	@Test
	public void doesATeamHasPlayers_queryOnlyATeam() {
		
		em.getTransaction().begin();
		
		//we need to get a player first
		Query queryTeam = em.createQuery("select t from Team t where t.id=:teamId");
				
		Long teamId = new Long(1) ;
		queryTeam.setParameter("teamId", teamId);
		
		Team team = (Team) queryTeam.getSingleResult();
				
		em.getTransaction().commit();
				
		assertNotNull(team);
		
		assertNotNull(team.getPlayers());
		
	}	
	
	/*
	 * Tested query is used in a method 'getTeamByIdWithJoinFetch' of the 'TeamServiceImpl' class
	 */
	@Test
	public void doesATeamHasPlayers_queryATeamWithAJoin() {
		
		em.getTransaction().begin();
		
		//we need to get a player first
		Query queryTeam = em.createQuery("select t from Team t join fetch t.players where t.id = :id");
				
		Long teamId = new Long(1) ;
		queryTeam.setParameter("id", teamId);
		
		Team team = (Team) queryTeam.getSingleResult();
				
		em.getTransaction().commit();
				
		assertNotNull(team);
		
		assertNotNull(team.getPlayers());
		
	}	
	
	
}