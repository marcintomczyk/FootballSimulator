package com.tomczyk.football.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tomczyk.football.model.League;
import com.tomczyk.football.service.LeagueService;

@ApplicationScoped
public class LeagueServiceImpl implements LeagueService {
	
	@Inject
    EntityManager entityManager;
	
	@Override
	public List<League> getAvailableLeagues() {
		
		Query allLeaguesQuery = entityManager.createQuery(
                "select league from League league");
        return allLeaguesQuery.getResultList();
	}

	@Override
	public League getLeague(String leagueName) {
		
		Query query = entityManager.createQuery("select l from League l where l.name=:name");
	    query.setParameter("name", leagueName);

		League league = (League) query.getSingleResult();
		
		return league;
	}
	
	@Override
	public League getLeague(Long id) {
		
		League league = entityManager.find(League.class, id);
		
		return league;
	}	

}
