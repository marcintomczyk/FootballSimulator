package com.tomczyk.football.arquillian.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.hibernate.LazyInitializationException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tomczyk.football.arquillian.base.RestDeployment;
import com.tomczyk.football.model.Team;
import com.tomczyk.football.service.impl.TeamServiceImpl;

/**
 * Remember: we are using here data from import.sql not from football-datasets.xml
 * 
 * This class tests fetching players using TeamService, so we first get a team and check what
 * players do we have in 'players' property of the 'team' object.
 * 
 * - very useful for testing how the collection is fetched, we can change some settings in the team class
 * and see what hibernate really does
 */
@RunWith(Arquillian.class)
public class TeamPlayersTest {
    
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
    public void doesATeamHasPlayers_omitLazyInitializationException() {
        
    	Team team1 = teamService.getTeamByIdWithJoinFetch(new Long(1));
    	
    	assertNotNull(team1);
        assertEquals("Arsenal", team1.getName());
        
        assertEquals(2,team1.getPlayers().size());
        
        
    }
    
    @Test(expected=LazyInitializationException.class)
    public void doesATeamHasPlayers_lazyInitializationException() {
        
    	Team team1 = teamService.getTeam(new Long(1));
    	
    	assertNotNull(team1);
        assertEquals("Arsenal", team1.getName());
        
        assertEquals(2,team1.getPlayers().size());
        
        
    }
    
}
