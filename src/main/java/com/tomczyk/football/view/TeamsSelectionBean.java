package com.tomczyk.football.view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tomczyk.football.model.League;
import com.tomczyk.football.model.Player;
import com.tomczyk.football.model.Team;
import com.tomczyk.football.service.TeamService;

@Named("teamsSelectionBean")
@SessionScoped
public class TeamsSelectionBean implements Serializable {

	private static final long serialVersionUID = -3474481804953347152L;

	@Inject
	TeamService teamService;

	private League selectedLeague1;
	private League selectedLeague2;

	private Team selectedTeam1;
	private Team selectedTeam2;

	private Player selectedPlayer1;
	private Player selectedPlayer2;

	/*
	 * Using this method we omit the 'LazyInitializationException'
	 */
	public Team getTeam1ByQuery() {

		if (selectedTeam1 != null) {

			return teamService.getTeamByIdWithJoinFetch(selectedTeam1.getId());
		}

		return null;
	}

	public Team getTeam2ByQuery() {
		if (selectedTeam2 != null) {

			return teamService.getTeamByIdWithJoinFetch(selectedTeam2.getId());
		}

		return null;
	}

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

	public Player getSelectedPlayer1() {
		return selectedPlayer1;
	}

	public void setSelectedPlayer1(Player selectedPlayer1) {
		this.selectedPlayer1 = selectedPlayer1;
	}

	public Player getSelectedPlayer2() {
		return selectedPlayer2;
	}

	public void setSelectedPlayer2(Player selectedPlayer2) {
		this.selectedPlayer2 = selectedPlayer2;
	}

	public TeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

}