package com.tomczyk.football.arquillian.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tomczyk.football.arquillian.base.RestDeployment;
import com.tomczyk.football.model.Player;
import com.tomczyk.football.model.Team;
import com.tomczyk.football.service.impl.PlayerServiceImpl;

/**
 * Remember: we are using here data from import.sql not from football-datasets.xml
 */
@RunWith(Arquillian.class)
public class PlayerServiceTest {
    
	/*
	 * There is too little code to define different *Deployment classes
	 * 
	 * TODO: if necessary create a class for example "NoRestDeployment"
	 * to return a war containing only classess for a "pure" logic.
	 * 
	 * "Pure" - I mean "classical" logic. These are classes which operate
	 * on EntityManager and return "standard" results such as arrays etc.
	 * 
	 * This application contains also some logic which operate on EntityManager too
	 * but return data in JSON format ("rest" package)
	 */
   @Deployment
    public static WebArchive deployment() {
        return RestDeployment.deployment();
    }
   
    /*
     * cannot be PlayerService interface as we need a concrete implementation
     * 
     * putting interface here will cause "Unsatisfied dependency..." errors
     */
    @Inject
    private PlayerServiceImpl playerService;
    
    @Test
    public void canWeGetAllPlayersForTheTeam() {
        
    	//1 - Arsenal
    	Team arsenal = new Team();
    	arsenal.setId(new Long(1));
    	
    	List<Player> arsenalPlayers = playerService.getPlayers(arsenal);
    	
    	Player p1 = arsenalPlayers.get(0);
    	Player p2 = arsenalPlayers.get(1);
    	
    	//assertEquals("Szcz\u0119sny", p1.getLastName());
    	assertEquals("Szczęsny", p1.getLastName());
        assertEquals("Fabiański", p2.getLastName());
    	
    }
    
    @Test
    public void canWeGetAPlayerByName() {
    	
    	Player player1 = playerService.getPlayer("Szczęsny");
    	Player player2 = playerService.getPlayer("Fabiański");
    	
    	assertNotNull(player1);
    	assertNotNull(player2);
    	
    	assertEquals("Szczęsny", player1.getLastName());
    	assertEquals("Fabiański", player2.getLastName());
    	
    }
    
    
    @Test
    public void canWeGetAPlayerById() {
        
    	Player player5 = playerService.getPlayer(new Long(5));
    	
    	assertNotNull(player5);
    	
    	assertEquals("Piszczek", player5.getLastName());
    	assertEquals(new Integer(28), player5.getAge());
        
    }

    
}
