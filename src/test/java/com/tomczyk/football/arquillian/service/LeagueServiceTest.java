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
import com.tomczyk.football.service.impl.LeagueServiceImpl;

@RunWith(Arquillian.class)
public class LeagueServiceTest {
    
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
     * cannot be LeagueService interface as we need a concrete implementations
     * 
     * putting interface here will cause "Unsatisfied dependency..." errors
     */
    @Inject
    private LeagueServiceImpl leagueService;
    
    @Test
    public void canWeFetchAllAvailableLeagues() {
        
    	List<League> allLeagues = leagueService.getAvailableLeagues();
    	
    	assertNotNull(allLeagues);
        assertEquals(2, allLeagues.size());
        assertEquals("Premiership", allLeagues.get(0).getName());
        assertEquals("Bundesliga", allLeagues.get(1).getName());
    }
    
}
