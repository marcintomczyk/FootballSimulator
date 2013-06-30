package com.tomczyk.football.dbunit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.tomczyk.football.dbunit.base.FootballBase;
import com.tomczyk.football.model.Player;
import com.tomczyk.football.model.Skill;
import com.tomczyk.football.model.dictionary.SkillType;

/**
 * Nothing special here, just checking if we can get players with skills
 * 
 * @see football-datasets.xml
 */
public class PlayerSkillsTest extends FootballBase {

	
	@Test
	public void hasPlayerSkills() {
		
		em.getTransaction().begin();
		
		//we need to get a player first
		Query queryPlayer = em.createQuery("select p from Player p where p.id=:playerId");
				
		Long playerId = new Long(1) ;
		queryPlayer.setParameter("playerId", playerId);
		
		Player player = (Player) queryPlayer.getSingleResult();
				
		em.getTransaction().commit();
				
		assertNotNull(player);
		
		assertNotNull(player.getSkills());
		
		List<Skill> skills = player.getSkills();
	
		/*
		 * just for simplicity we check only few values
		 */
		
		Skill passing = skills.get(0);
		Skill aggression = skills.get(5);
		
		SkillType passingType = passing.getSkillType();
		SkillType aggressionType = aggression.getSkillType();
		
		assertEquals("Passing", passingType.getName());
		assertEquals("Aggression", aggressionType.getName());
		
		assertEquals(new Integer(5), passing.getLevel());
		assertEquals(new Integer(4), aggression.getLevel());
		
	}	
	
}