package com.tomczyk.football.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.tomczyk.football.model.Player;
import com.tomczyk.football.model.Team;
import com.tomczyk.football.service.PlayerService;

@ApplicationScoped
public class PlayerServiceImpl implements PlayerService {
	
	@Inject
    EntityManager entityManager;
	
	@Override
	public List<Player> getPlayers(Team team) {
		
		Query teamPlayersQuery = entityManager.createQuery(
                "select p from Player p where p.team=:team");
		
		teamPlayersQuery.setParameter("team", team);
		
        return teamPlayersQuery.getResultList();
	}

	@Override
	public Player getPlayer(String lastName) {
		
		Player player = null;
		
		Query query = entityManager.createQuery("select p from Player p where p.lastName=:lastName");
	    query.setParameter("lastName", lastName);

	    //there can be more than one player with the same name - for now we return the first record
	    List<Player> players = query.getResultList();
	    
	    if(!players.isEmpty()) {
	    	player = players.get(0);	
	    }
				
		return player;
	}
	
	@Override
	public Player getPlayer(Long id) {
		
		Player player = entityManager.find(Player.class, id);
		
		return player;
	}	

}
