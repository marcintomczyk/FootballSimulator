package com.tomczyk.football.service;

import java.util.List;

import com.tomczyk.football.model.Player;
import com.tomczyk.football.model.Team;

public interface PlayerService {

	public List<Player> getPlayers(Team team);

	public Player getPlayer(String lastName);

	public Player getPlayer(Long id);

}
