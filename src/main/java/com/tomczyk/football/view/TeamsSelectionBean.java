package com.tomczyk.football.view;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "teamsSelection")
public class TeamsSelectionBean {
	
	private String league;

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

}
