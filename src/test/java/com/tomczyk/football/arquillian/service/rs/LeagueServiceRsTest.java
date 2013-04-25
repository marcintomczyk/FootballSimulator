package com.tomczyk.football.arquillian.service.rs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tomczyk.football.arquillian.base.RestDeployment;
import com.tomczyk.football.model.League;
import com.tomczyk.football.service.rest.LeagueServiceRs;
import com.tomczyk.football.util.MultivaluedHashMap;

@RunWith(Arquillian.class)
public class LeagueServiceRsTest {
    
    @Deployment
    public static WebArchive deployment() {
        return RestDeployment.deployment();
    }
   
    @Inject
    private LeagueServiceRs leagueService;
    
    @Test
    public void canWeFetchAllAvailableLeagues() {
        
    	MultivaluedMap<String, String> queryParameters = new MultivaluedHashMap<String, String>();

        queryParameters.add("first", "1");
        queryParameters.add("maxResults", "2");
    	
    	
    	List<League> allLeagues = leagueService.getAll(queryParameters);
    	
    	assertNotNull(allLeagues);
        assertEquals(2, allLeagues.size());
        assertEquals("Premiership", allLeagues.get(0).getName());
        assertEquals("Bundesliga", allLeagues.get(1).getName());
    }
    
}
