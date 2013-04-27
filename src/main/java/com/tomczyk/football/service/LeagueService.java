package com.tomczyk.football.service;

import java.util.List;

import com.tomczyk.football.model.League;

public interface LeagueService {

	public List<League> getAvailableLeagues();
	
	public League getLeague(String leagueName);
	
	public League getLeague(Long id);
	
}
