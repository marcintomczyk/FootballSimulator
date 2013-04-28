package com.tomczyk.football.view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tomczyk.football.model.League;
import com.tomczyk.football.model.Team;

@Named("teamsSelectionBean")
@SessionScoped
public class TeamsSelectionBean implements Serializable {

	private static final long serialVersionUID = -3474481804953347152L;

	private League selectedLeague1;
	private League selectedLeague2;

	private Team selectedTeam1;
	private Team selectedTeam2;

	public League getSelectedLeague1() {
		return selectedLeague1;
	}

	public void setSelectedLeague1(League selectedLeague1) {
		this.selectedLeague1 = selectedLeague1;
	}

	public League getSelectedLeague2() {
		return selectedLeague2;
	}

	public void setSelectedLeague2(League selectedLeague2) {
		this.selectedLeague2 = selectedLeague2;
	}

	public Team getSelectedTeam1() {
		return selectedTeam1;
	}

	public void setSelectedTeam1(Team selectedTeam1) {
		this.selectedTeam1 = selectedTeam1;
	}

	public Team getSelectedTeam2() {
		return selectedTeam2;
	}

	public void setSelectedTeam2(Team selectedTeam2) {
		this.selectedTeam2 = selectedTeam2;
	}

}