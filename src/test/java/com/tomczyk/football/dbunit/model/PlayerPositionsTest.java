package com.tomczyk.football.dbunit.model;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.tomczyk.football.dbunit.base.FootballBase;
import com.tomczyk.football.model.Player;
import com.tomczyk.football.model.Position;
import com.tomczyk.football.model.dictionary.PositionType;

/**
 * Nothing special here, just checking if we can get players with defined positions
 * 
 * @see football-datasets.xml
 */
public class PlayerPositionsTest extends FootballBase {

	
	/*
	 * Player "1" was defined as a goalkeeper
	 */
	@Test
	public void isPlayerOneAGoalkeeper() {
		
		em.getTransaction().begin();
		
		//we need to get a player first
		Query queryPlayer = em.createQuery("select p from Player p where p.id=:playerId");
				
		Long playerId = new Long(1) ;
		queryPlayer.setParameter("playerId", playerId);
		
		Player player = (Player) queryPlayer.getSingleResult();
				
		em.getTransaction().commit();
				
		assertNotNull(player);
		
		assertNotNull(player.getPositions());
		
		List<Position> positions = player.getPositions();
	
		/*
		 * just for simplicity we check only few values
		 */
		
		Position goalkeeper = positions.get(0);
		
		PositionType goalkeeperType = goalkeeper.getPositionType();
		
		assertEquals("Goalkeeper", goalkeeperType.getName());
		
		assertTrue(goalkeeper.isPreferred());
		
	}	

	/*
	 * Player "3" was defined as a Forward by default (preferred position)
	 */
	@Test
	public void isPlayerThreeAForwardByDefault() {
		
		em.getTransaction().begin();
		
		//we need to get a player first
		Query queryPlayer = em.createQuery("select p from Player p where p.id=:playerId");
				
		Long playerId = new Long(3) ;
		queryPlayer.setParameter("playerId", playerId);
		
		Player player = (Player) queryPlayer.getSingleResult();
				
		em.getTransaction().commit();
				
		assertNotNull(player);
		
		assertNotNull(player.getPositions());
		
		List<Position> positions = player.getPositions();
	
		/*
		 * just for simplicity we check only few values
		 */
		
		Position forward = positions.get(0);
		
		PositionType forwardType = forward.getPositionType();
		
		assertEquals("Forward", forwardType.getName());
		
		assertTrue(forward.isPreferred());
		
	}
	
	/*
	 * For player "3" we defined additional position the player can play on.
	 * It is a midfielder role, however this role is not preferred for this player
	 */
	@Test
	public void canPlayerThreePlayAsMidfielderToo() {
		
		em.getTransaction().begin();
		
		//we need to get a player first
		Query queryPlayer = em.createQuery("select p from Player p where p.id=:playerId");
				
		Long playerId = new Long(3) ;
		queryPlayer.setParameter("playerId", playerId);
		
		Player player = (Player) queryPlayer.getSingleResult();
				
		em.getTransaction().commit();
				
		assertNotNull(player);
		
		assertNotNull(player.getPositions());
		
		List<Position> positions = player.getPositions();
	
		/*
		 * just for simplicity we check only few values
		 */
		
		Position midfielder = positions.get(1);
		
		PositionType midfielderType = midfielder.getPositionType();
		
		assertEquals("Midfielder", midfielderType.getName());
		
		//position is available, but is should not be set as preferred
		assertFalse(midfielder.isPreferred());
		
	}
	
}