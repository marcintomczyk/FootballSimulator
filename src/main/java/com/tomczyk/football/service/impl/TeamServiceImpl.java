package com.tomczyk.football.service.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
	
	@Override
	public Team getTeamByIdWithJoinFetch(Long teamId) {
		 Query query = entityManager.createQuery("select t from Team t join fetch t.players where t.id = :id");
		 query.setParameter("id", teamId);

		 Team team = null;
		 try {
		  team = (Team) query.getSingleResult();
		 } catch (NoResultException e) {
		  // no result found
		 }

		 return team;
		}

}
