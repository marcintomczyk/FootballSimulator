package com.tomczyk.football.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tomczyk.football.model.League;
import com.tomczyk.football.model.Team;
import com.tomczyk.football.service.TeamService;

@Named("teamConverter")
public class TeamConverter implements Converter {

	static final Logger log = LoggerFactory.getLogger(TeamConverter.class);
	
	@Inject
	private TeamService teamService;
	
	public TeamConverter() {
	}

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
				
		Team team = null;
        try {
            team = teamService.getTeam(Long.parseLong(value));
            
        }catch(Throwable ex) {
        
        	/*
        	 * TODO add resourcebundle like below, just make it working
        	 */
        	
        	//ResourceBundle bundle = ResourceBundle.getBundle("messages");
            //FacesMessage msg = new FacesMessage(bundle.getString("league_convertion_message"));
            //msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            //throw new ConverterException(msg);
        	log.error("ex: " + ex);
        }
        
        return team;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		String val = null;
        
		try {
            Team team = (Team) value;
            val = Long.toString(team.getId());
            
        }catch(Throwable ex) {
            
        	/*
        	 * TODO add resourcebundle like below, just make it working
        	 */
        	
        	//ResourceBundle bundle = ResourceBundle.getBundle("messages");
            //FacesMessage msg = new FacesMessage(bundle.getString("league_convertion_message"));
            //msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            //throw new ConverterException(msg);
        	log.error("ex: " + ex);
        }
		
        return val;
	}

}