package com.tomczyk.football.view;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import com.tomczyk.football.model.League;


@Named("teamsSelection")
@SessionScoped
public class TeamsSelectionBean {
	
	private League selectedLeague;

	public League getSelectedLeague() {
		return selectedLeague;
	}

	public void setSelectedLeague(League selectedLeague) {
		this.selectedLeague = selectedLeague;
	}

}
