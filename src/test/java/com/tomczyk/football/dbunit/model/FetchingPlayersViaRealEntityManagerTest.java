package com.tomczyk.football.dbunit.model;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.tomczyk.football.dbunit.base.FootballBase;
import com.tomczyk.football.model.Player;
import com.tomczyk.football.model.Team;

/**
 * Nothing special here, just checking if we can get players
 * or if there is a correct relationship with a concrete team
 * 
 * @see football-datasets.xml
 */
public class FetchingPlayersViaRealEntityManagerTest extends FootballBase {

	
	/**
	 * Arsenal was saved with id=1
	 */
	@Test
	public void canArsenalPlayersBeFetched() {
		
		em.getTransaction().begin();
		
		//I do not want to get a team from db
		Team team = new Team();
		team.setId(new Long(1));
		
		Query query = em.createQuery("select p from Player p where p.team=:team");
		query.setParameter("team", team);

		@SuppressWarnings("unchecked")
		List<Player> players = query.getResultList();
		  
		em.getTransaction().commit();
		
		assertEquals("Wojciech", players.get(0).getFirstName());
		assertEquals("Szczęsny", players.get(0).getLastName());
		assertEquals(new Integer(23), Integer.valueOf(players.get(0).getAge()));
		
		assertEquals("Łukasz", players.get(1).getFirstName());
		assertEquals("Fabiański", players.get(1).getLastName());
		assertEquals(new Integer(28), Integer.valueOf(players.get(1).getAge()));		
	}
	
	/**
	 * The first player in dataset is Wojciech Szczesny - Arsenal
	 */
	@Test
	public void isPlayerAssignedToATeam() {
		
		em.getTransaction().begin();
		
		//we need to get a player first
		Query queryPlayer = em.createQuery("select p from Player p where p.id=:playerId");
		
		Long playerId = new Long(1) ;
		queryPlayer.setParameter("playerId", playerId);
		
		Player player = (Player) queryPlayer.getSingleResult();
		
		em.getTransaction().commit();
		
		assertNotNull(player);
		
		//we have a player, let's see if the player has a team
		//but first we check if the firstName and lastName is ok
		
		assertEquals("Wojciech", player.getFirstName());
		assertEquals("Szczęsny", player.getLastName());
		assertEquals(new Integer(23), Integer.valueOf(player.getAge()));
		
		assertNotNull(player.getTeam());
		
		Team playerTeam = player.getTeam();
		
		assertEquals("Arsenal", playerTeam.getName());		
	}
	
}