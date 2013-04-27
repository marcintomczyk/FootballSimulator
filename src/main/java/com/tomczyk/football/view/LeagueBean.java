package com.tomczyk.football.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tomczyk.football.model.League;
import com.tomczyk.football.service.LeagueService;

@Named("leagueBean")
@ApplicationScoped
public class LeagueBean implements Serializable {
	
	private static final long serialVersionUID = 4610447129049302941L;
	
	@Inject
	LeagueService leagueService;
	
	List<League> leagues = new ArrayList<League>();

	public LeagueBean() {
	}
	
	//initializing the leagues
	@PostConstruct
	private void init() {
		leagues = leagueService.getAvailableLeagues();
	}
	
	public LeagueService getLeagueService() {
		return leagueService;
	}

	public void setLeagueService(LeagueService leagueService) {
		this.leagueService = leagueService;
	}

	public List<League> getLeagues() {
		
		return leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}	

}