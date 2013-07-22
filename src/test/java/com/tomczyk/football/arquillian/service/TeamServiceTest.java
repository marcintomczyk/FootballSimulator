package com.tomczyk.football.arquillian.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tomczyk.football.arquillian.base.RestDeployment;
import com.tomczyk.football.model.League;
import com.tomczyk.football.model.Team;
import com.tomczyk.football.service.impl.TeamServiceImpl;

/**
 * Remember: we are using here data from import.sql not from football-datasets.xml
 */
@RunWith(Arquillian.class)
public class TeamServiceTest {
    
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
     * cannot be TeamService interface as we need a concrete implementation
     * 
     * putting interface here will cause "Unsatisfied dependency..." errors
     */
    @Inject
    private TeamServiceImpl teamService;
    
    @Test
    public void canWeFetchTeamById() {
        
    	Team team1 = teamService.getTeam(new Long(1));
    	Team team2 = teamService.getTeam(new Long(2));
    	Team team3 = teamService.getTeam(new Long(3));
    	
    	assertNotNull(team1);
        assertEquals("Arsenal", team1.getName());
        
        assertNotNull(team2);
        assertEquals("Tottenham", team2.getName());
        
        assertNotNull(team3);
        assertEquals("Chelsea", team3.getName());
        
    }
    
}
