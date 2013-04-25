package com.tomczyk.football.dbunit.model;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.tomczyk.football.dbunit.base.FootballBase;
import com.tomczyk.football.model.League;
import com.tomczyk.football.model.Team;

/**
 * Nothing special here, just creating sample leagues 
 */
public class ConstructingLeaguesViaRealEntityManagerTest extends FootballBase {

	@Test
	public void canALeagueBeConstructed() {
		
		/*
		 * we did not define a league with this name in a dataset so this will be ok
		 */
		League league = new League();
		league.setName("Primera Division");
		
		et.begin();
		em.persist(league);
		et.commit();

		Long id = league.getId();
		et.begin();
		League foundLeague = em.find(League.class, id);
		et.commit();

		assertEquals(league.getId(), foundLeague.getId());
		assertEquals("Primera Division", foundLeague.getName());
		
	}
	
	@Test
	public void canALeageWithTeamsBeCreated() {
		
		/*
		 * TODO some refactoring: move the code responsible for creating objects
		 * to a factory class
		 */
		League league = new League();
		league.setName("Primera Division");
		
		Team team1 = new Team();
		team1.setName("Barcelona");
		
		Team team2 = new Team();
		team2.setName("Real Madrid");

		team1.setLeague(league);
		team2.setLeague(league);
		
		List<Team> teams = new LinkedList<Team>();
		teams.add(team1);
		teams.add(team2);
		
		league.setTeams(teams);
		et.begin();
		em.persist(league);
		et.commit();

		//getting a league from db
		Long id = league.getId();
		et.begin();
		League foundLeague = em.find(League.class, id);
		
		/*
		 * very simple assertions
		 */
		assertEquals("Primera Division", foundLeague.getName());
		assertEquals(2, foundLeague.getTeams().size());
		assertEquals("Primera Division", foundLeague.getTeams().get(0).getLeague().getName());
		
		et.commit();

	}

}