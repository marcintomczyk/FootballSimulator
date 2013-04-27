package com.tomczyk.football.view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tomczyk.football.model.League;

@Named("teamsSelectionBean")
@SessionScoped
public class TeamsSelectionBean implements Serializable {
	
	private static final long serialVersionUID = -1643101356057503953L;
	
	private League selectedLeague;

	public League getSelectedLeague() {
		
		return selectedLeague;
	}

	public void setSelectedLeague(League selectedLeague) {
		
		this.selectedLeague = selectedLeague;
		
	}

}