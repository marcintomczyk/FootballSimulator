package com.tomczyk.football.view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tomczyk.football.model.League;
import com.tomczyk.football.model.Team;

@Named("teamsSelectionBean")
@SessionScoped
public class TeamsSelectionBean implements Serializable {

	private static final long serialVersionUID = -1643101356057503953L;

	private League selectedLeague;

	private Team selectedTeam;

	public League getSelectedLeague() {

		return selectedLeague;
	}

	public void setSelectedLeague(League selectedLeague) {

		this.selectedLeague = selectedLeague;

	}

	public Team getSelectedTeam() {
		
		return selectedTeam;
		
	}

	public void setSelectedTeam(Team selectedTeam) {
		
		this.selectedTeam = selectedTeam;
		
	}

}