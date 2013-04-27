package com.tomczyk.football.service.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.tomczyk.football.model.Team;
import com.tomczyk.football.service.TeamService;

@ApplicationScoped
public class TeamServiceImpl implements TeamService {
	
	@Inject
    EntityManager entityManager;
		
	@Override
	public Team getTeam(Long id) {
		
		Team team = entityManager.find(Team.class, id);
		
		return team;
	}	

}
